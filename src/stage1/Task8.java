package stage1;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Task8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expr = scanner.nextLine();
        List<Symbol> symbols = symAnalyze(expr);
        SymbolBuffer symbolBuffer = new SymbolBuffer(symbols);
        System.out.println(expr(symbolBuffer));
    }

    public enum SymbolType {

        OP_PLUS, OP_MINUS, OP_MUL, OP_DIV,
        NUMBER,
        EOF;
    }

    public static class Symbol {
        SymbolType type;
        String value;

        public Symbol(SymbolType type, String value) {
            this.type = type;
            this.value = value;
        }

        public Symbol(SymbolType type, Character value) {
            this.type = type;
            this.value = value.toString();
        }

        @Override
        public String toString() {
            return "Symbol{" +
                    "type=" + type +
                    ", value='" + value + '\'' +
                    '}';
        }
    }

    public static class SymbolBuffer {
        private int pos;

        public List<Symbol> symbols;

        public SymbolBuffer(List<Symbol> symbols) {
            this.symbols = symbols;
        }

        public Symbol next() {
            return symbols.get(pos++);
        }

        public void back() {
            pos--;
        }

        public int getPos() {
            return pos;
        }
    }

    public static List<Symbol> symAnalyze(String expText) {
        ArrayList<Symbol> symbols = new ArrayList<>();
        int pos = 0;
        while (pos< expText.length()) {
            char c = expText.charAt(pos);
            switch (c) {
                case '+':
                    symbols.add(new Symbol(SymbolType.OP_PLUS, c));
                    pos++;
                    continue;
                case '-':
                    symbols.add(new Symbol(SymbolType.OP_MINUS, c));
                    pos++;
                    continue;
                case '*':
                    symbols.add(new Symbol(SymbolType.OP_MUL, c));
                    pos++;
                    continue;
                case '/':
                    symbols.add(new Symbol(SymbolType.OP_DIV, c));
                    pos++;
                    continue;
                default:
                    if (c <= '9' && c >= '0') {
                        StringBuilder sb = new StringBuilder();
                        do {
                            sb.append(c);
                            pos++;
                            if (pos >= expText.length()) {
                                break;
                            }
                            c = expText.charAt(pos);
                        } while (c <= '9' && c >= '0');
                        symbols.add(new Symbol(SymbolType.NUMBER, sb.toString()));
                    } else {
                        if (c != ' ') {
                            throw new RuntimeException("Unexpected character: " + c);
                        }
                        pos++;
                    }
            }
        }
        symbols.add(new Symbol(SymbolType.EOF, ""));
        return symbols;
    }

    public static int expr(SymbolBuffer symbols) {
        Symbol symbol = symbols.next();
        if (symbol.type == SymbolType.EOF) {
            return 0;
        } else {
            symbols.back();
            return plusminus(symbols);
        }
    }

    public static int plusminus(SymbolBuffer symbols) {
        int value = multdiv(symbols);
        while (true) {
            Symbol symbol = symbols.next();
            switch (symbol.type) {
                case OP_PLUS:
                    value += multdiv(symbols);
                    break;
                case OP_MINUS:
                    value -= multdiv(symbols);
                    break;
                case EOF:
                    return value;
                default:
                    throw new RuntimeException("Unexpected token: " + symbol.value
                            + " at position: " + symbols.getPos());
            }
        }
    }

    public static int multdiv(SymbolBuffer symbols) {
        int value = factor(symbols);
        while (true) {
            Symbol symbol = symbols.next();
            switch (symbol.type) {
                case OP_MUL:
                    value *= factor(symbols);
                    break;
                case OP_DIV:
                    value /= factor(symbols);
                    break;
                case EOF:
                case OP_PLUS:
                case OP_MINUS:
                    symbols.back();
                    return value;
                default:
                    throw new RuntimeException("Unexpected token: " + symbol.value
                            + " at position: " + symbols.getPos());
            }
        }
    }

    public static int factor(SymbolBuffer symbols) {
        Symbol symbol = symbols.next();
        switch (symbol.type) {
            case NUMBER:
                return Integer.parseInt(symbol.value);
            default:
                throw new RuntimeException("Unexpected token: " + symbol.value
                        + " at position: " + symbols.getPos());
        }
    }

}