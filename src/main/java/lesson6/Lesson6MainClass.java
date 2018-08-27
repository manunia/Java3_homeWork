package lesson6;

/**
 * Maria_L
 */

import java.util.ArrayList;
import java.util.Arrays;

public class Lesson6MainClass {

    public static void main(String[] args) {
//        Lesson6MainClass mainClass = new Lesson6MainClass();
//        int[] arr = {0,2,4,7,5,6};
//        //mainClass.array(arr);
//        System.out.println(mainClass.composition(arr));

    }

    //1. Написать метод, которому в качестве аргумента передается не пустой одномерный
    // целочисленный массив, метод должен вернуть новый массив, который получен путем
    // вытаскивания элементов из исходного массива, идущих после последней четверки.
    // Входной массив должен содержать хотя бы одну четверку, в противном случае в методе
    // необходимо выбросить RuntimeException.
    public int[] array(int[] arr){
        ArrayList<Integer> newArr = new ArrayList<>();
        ArrayList fourArr = new ArrayList();
        int j=0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 4) {
                fourArr.add(arr[i]);
                j = i + 1;
            } else {
                continue;
            }
        }
        if (fourArr.size() == 0) {
            throw new RuntimeException();
        }
        int[] ints = new int[arr.length - j];
        for (int i = j; i < arr.length; i++) {
            newArr.add(arr[i]);
        }
        for (int i = 0; i < ints.length; i++) {
            ints[i] = newArr.get(i);
        }
        System.out.println(Arrays.asList(fourArr));
        System.out.println(Arrays.asList(newArr));
        System.out.println(Arrays.toString(ints));
        return ints;
    }
//    2. Написать метод, который проверяет состав массива из чисел 1 и 4. Если в нем нет хоть одной
//    четверки или единицы, то метод вернет false ; Написать набор тестов для этого метода (по 3-4
//            варианта входных данных).
    public boolean composition(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1 || arr[i] == 4) {
                return true;
            }
        }
        return false;
    }
}
