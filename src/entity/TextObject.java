package entity;

public class TextObject implements TextPart {
    private String textObject;

    public TextObject(String textObject) {
        this.textObject = textObject;
    }

    public String getTextObject() {
        return textObject;
    }

    public void setTextObject(String textObject) {
        this.textObject = textObject;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("textObject='").append(textObject).append('\'');
        return sb.toString();
    }
}
