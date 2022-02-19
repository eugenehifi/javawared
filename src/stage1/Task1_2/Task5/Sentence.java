package stage1.Task1_2.Task5;

import java.util.ArrayList;

public class Sentence {
    private  Word[] words;

    public Sentence(String[] words) {
        ArrayList<Word> list = new ArrayList<>();
        for (String word : words)
            list.add(new Word(word));
        this.words = list.toArray(new Word[words.length]);
    }

    public int getWordsCount() {
        return words.length;
    }

    public Word getWordByPosition(int pos) {
        return words[pos];
    }
    public String getOriginalSentence() {
        String originalSentence = "";
        for (int i = 0; i< words.length; i++) {
            originalSentence += words[i].getOriginalWord() + " ";
        }
        return originalSentence;
    }
}
