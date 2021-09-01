package java3_hw5;

import java.util.concurrent.CyclicBarrier;

public class Service {
    private final CyclicBarrier barrier;
    private Finish finish;

    public Service(int countCar, Finish finish, Runnable afterStartAction) {
        this.barrier = new CyclicBarrier(countCar + 1, afterStartAction);
        this.finish = finish;
    }

    public Car createCar(Race race, int speed) {
        return new Car(race, speed, barrier, finish);
    }

    public void awaitCarsStarted() {
        try {
            barrier.await();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
