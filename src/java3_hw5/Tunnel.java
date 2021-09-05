package java3_hw5;


import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {
    private final Semaphore smp;

    public Tunnel(int countCars) {
        this.length = 80;
        this.exposition = "Тоннель " + length + " метров";
        this.smp = new Semaphore(countCars / 2, true);
    }

    @Override
    public void go(Car c) {
        try {
            try {
                System.out.println(c.getName() + " готовится к этапу(ждет): " + exposition);
                smp.acquire();
                System.out.println(c.getName() + " начал этап: " + exposition);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " + exposition);
                smp.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}




