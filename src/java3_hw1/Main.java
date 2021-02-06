package java3_hw1;

import java3_hw1.fruits.Apple;
import java3_hw1.fruits.Box;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {






    }



    public static <T> ArrayList<T> arrayToList(T[] arr){
        return  new ArrayList<>(Arrays.asList(arr));
    }



    public static void swap (Object[] arr, int ind1, int ind2){
        Object object = arr[ind1];
        arr[ind1] = arr[ind2];
        arr[ind1] = object;
    }

    public static <T> void swap2(T[] arr, int ind1, int ind2){
        T object = arr[ind1];
        arr[ind1] = arr[ind2];
        arr[ind1] = object;
    }
}
