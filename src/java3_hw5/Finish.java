package java3_hw5;

import java.util.concurrent.CountDownLatch;

public class Finish {
    private final CountDownLatch cdl;

    public Finish(int countCar) {
        this.cdl = new CountDownLatch(countCar);
    }

    public void waitCarsFinished() {
        try {
            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void notifyCarsFinished() {
        cdl.countDown();
    }
}
