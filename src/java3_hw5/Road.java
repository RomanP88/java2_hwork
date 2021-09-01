package java3_hw5;

public class Road extends Stage{
    public Road(int length) {
        this.length = length;
        this.exposition = "Дорога " + length + " метров";
    }

    @Override
    public void go(Car c) {
        try {
            System.out.println(c.getName() + " начал этап: " + exposition);
            Thread.sleep(length / c.getSpeed() * 1000);
            System.out.println(c.getName() + " закончил этап: " + exposition);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
