package lesson6;

/**
 * Maria_L
 */

import java.util.ArrayList;
import java.util.Arrays;

public class Lesson6MainClass {

    public static void main(String[] args) {
        int[] arr = {1,2,3,7,5,6};
        array(arr);
    }

    //1. Написать метод, которому в качестве аргумента передается не пустой одномерный
    // целочисленный массив, метод должен вернуть новый массив, который получен путем
    // вытаскивания элементов из исходного массива, идущих после последней четверки.
    // Входной массив должен содержать хотя бы одну четверку, в противном случае в методе
    // необходимо выбросить RuntimeException.
    public static ArrayList array(int[] arr){
        ArrayList newArr = new ArrayList<>();
        ArrayList fourArr = new ArrayList();
        int j=0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 4) {
                fourArr.add(arr[i]);
                j = i;
            } else {
                continue;
            }
        }
        if (fourArr.size() == 0) {
            throw new RuntimeException();
        }
        for (int i = j+1; i < arr.length; i++) {
            newArr.add(arr[i]);
        }
        System.out.println(Arrays.asList(fourArr));
        System.out.println(Arrays.asList(newArr));
        return newArr;
    }
}
