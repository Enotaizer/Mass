package com.amisitysu.gmail;


import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Mass {
    public static void main(String[] args) {

        int[] array = new int[15];
        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100) + 1;
        }

        System.out.println("Початковий вигляд масиву: " + Arrays.toString(array));
        insertionSort(array);
        System.out.println("Відсортований масив буде: " + Arrays.toString(array));


        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть число для пошуку: 1");
        int number = scanner.nextInt();

        int index = binarySearch(array, number);

        if (index != -1) {
            System.out.println("Індекс числа " + number + " у відсортованому масиві: " + index);
        } else {
            System.out.println("Число " + number + " не було знайдено у масиві.");
        }
    }

    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }

    public static int binarySearch(int[] array, int key) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (array[mid] == key) {
                return mid;
            } else if (array[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}