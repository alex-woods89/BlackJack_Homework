public enum SuitType {
    SPADES(4),
    HEARTS(3),
    CLUBS(2),
    DIAMONDS(1);

    private final int value;

    SuitType(int value){ this.value = value; }

    public int getValue(){
        return this.value;
    }

}
