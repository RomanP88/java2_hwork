import java.util.Arrays;

public class MainThroo {
    static final int SIZE = 1000000;

    static final int HALF = SIZE/2;

    public static void main(String[] args) throws InterruptedException {
        System.out.println();
        float [] arr = new float[SIZE];
        fillArr(arr);
        formula1(arr);

        fillArr(arr);
        formula2(arr);
    }


    public static void fillArr(float [] arr){
        Arrays.fill(arr,1);
    }

    public static void formula1(float [] arr){
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {

            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
        System.out.println(arr[HALF]);
    }
    public static void formula2(float [] arr) throws InterruptedException {
        long startTime = System.currentTimeMillis();

        float[] a1 = new float[HALF];
        float[] a2 = new float[HALF];
        System.arraycopy(arr,0, a1, 0, HALF);
        System.arraycopy(arr, HALF, a2, 0, HALF);



        Thread thread1 = new Thread(()->{
            for (int i = 0; i < a1.length; i++) {
                a1[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));

            }
        });


        Thread thread2 = new Thread(()->{
            for (int i = 0; i < a2.length; i++) {
                a2[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i/ 5) * Math.cos(0.4f + i / 2));

            }
        });


        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();

        System.arraycopy(a1,0, arr, 0, HALF);
        System.arraycopy(a2, 0, arr, HALF, HALF);
        System.out.println(endTime - startTime);
        System.out.println(arr[HALF]);
        System.out.println();
    }

}
