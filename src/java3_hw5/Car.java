package java3_hw5;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicBoolean;

public class Car implements Runnable {

    private static int CARS_COUNT;
    private static AtomicBoolean ab = new AtomicBoolean(false);

    private Race race;
    private int speed;
    private String name;

    private CyclicBarrier barrier;
    private Finish finish;


    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed, CyclicBarrier barrier, Finish finish) {
        this.race = race;
        this.speed = speed;
        this.barrier = barrier;
        this.finish = finish;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    @Override
    public void run() {
        try {
            ready();
            waitCarFinishedPreparing();
        } catch (Exception e) {
            e.printStackTrace();
        }

        startRace();
    }

    private void waitCarFinishedPreparing() throws InterruptedException, BrokenBarrierException {
        barrier.await();
    }

    private void startRace() {
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        listWin();
        finish.notifyCarsFinished();
    }

    private void ready() throws InterruptedException {
        System.out.println(this.name + " готовится");
        doReady();
        System.out.println(this.name + " готов");
    }

    private void doReady() throws InterruptedException {
        Thread.sleep(500 + (int) (Math.random() * 800));
    }

    private void listWin() {
        if ( !ab.getAndSet(true) ) {
            System.out.println(this.name + " - WIN");
        }

    }
}