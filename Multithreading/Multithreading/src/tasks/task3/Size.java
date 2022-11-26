package tasks.task3;

public enum Size {
    SMALL(10),
    MEDIUM(50),
    BIG(100);

    private int value;

    public int getValue(){
        return value;
    }

    Size(int value){
        this.value = value;
    }
}
