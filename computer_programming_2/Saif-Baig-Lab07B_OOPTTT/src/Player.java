public class Player {
    private String symbol;
    private boolean isHuman;

    public Player(String symbol, boolean isHuman) {
        this.symbol = symbol;
        this.isHuman = isHuman;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public boolean isHuman() {
        return isHuman;
    }

    public void setIsHuman(boolean isHuman) {
        this.isHuman = isHuman;
    }
}
