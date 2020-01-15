package entity;

public class Symbol implements TextPart {
    private char symbol;

    public Symbol(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("symbol='").append(symbol).append('\'');
        return sb.toString();
    }
}
