public class BowlingShot {
    private int firstPins;
    private int secondPins;
    private Integer[] extras;
    public BowlingShot(int firstPins) {
        this.firstPins = firstPins;
    }

    public Integer getTwoSumPins(){
        return firstPins+secondPins;
    }
    public boolean isStrike(){
        return firstPins==10;
    }

    public boolean isSpare(){
        return firstPins!=10&&(firstPins+secondPins)==10;
    }

    public BowlingShot(int firstPins, int secondPins) {
        this.firstPins = firstPins;
        this.secondPins = secondPins;
    }

    public Integer[] getExtras() {
        return extras;
    }

    public void setExtras(Integer[] extras) {
        this.extras = extras;
    }

    public int getFirstPins() {
        return firstPins;
    }

    public void setFirstPins(int firstPins) {
        this.firstPins = firstPins;
    }

    public int getSecondPins() {
        return secondPins;
    }

    public void setSecondPins(int secondPins) {
        this.secondPins = secondPins;
    }
}
