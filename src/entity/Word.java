package entity;

public class Word implements TextPart {
    private String word;

    public Word(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("word='").append(word).append('\'');
        return sb.toString();
    }
}
