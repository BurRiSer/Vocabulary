package entity;

public class Line {
    private String line;

    public Line(String line) {
        this.line = line;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("line='").append(line).append('\'');
        return sb.toString();
    }
}

