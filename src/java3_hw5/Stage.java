package java3_hw5;

public abstract class Stage {
    protected int length;
    protected String exposition;

    public String getExposition() {
        return exposition;
    }

    public abstract void go(Car c);
}
