package stage1.Task1_2.Task5;

public class Word {
    private char[] symbols;

    public Word(String word) {
        if (word == null || word.equals("")) {
            throw new IllegalArgumentException("Строка не может быть пустой");
        }
        this.symbols = word.toCharArray();
    }

    public int getSymbolsCount() {
        return symbols.length;
    }

    public String getOriginalWord() {
        return String.valueOf(symbols);
    }
}
