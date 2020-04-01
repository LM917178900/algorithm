package org.lei.algorithm.contoller;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author: leimin
 * @Description: controller
 * @Date: 2020/3/31 17:33
 * @Version: 1.0
 */
public class TestController {


    /**
     * source from next url
     * https://www.cnblogs.com/nankeyimengningchenlun/p/9151701.html
     * <p>
     * target
     * 1.sample of algorithm
     * 2.test the speed of method in sort
     */

    public static void main(String[] args) {

        int totalNumber = 1000;
        int[] arr = new int[totalNumber];
        for (int i = 0; i < totalNumber; i++) {
            arr[i] = new Random().nextInt(totalNumber);

        }

        long bubbleStart = System.currentTimeMillis();
        leiminSort(arr);
        System.out.println("THIS Sort cost millisecond===>" + (System.currentTimeMillis() - bubbleStart));
        System.out.println(Arrays.toString(arr));
    }

    /**
     * leimin sort _03:compare number to new arr one by one
     * Time complexity :less than n2
     * Spatial complexity :2
     *
     * @param arr array
     */
    private static void leiminSort(int[] arr) {


        int start = 0, end, pIndex, temp, middle = 0;

        for (int i = 1; i < arr.length; i++) {

            pIndex = i;
            temp = arr[i];
            end = i;
            // 1.construct a new arr
            // 2.get a number from old arr
            // 3.compare with the middle number in new arr
            int target = getTargetIndex(arr, start, end, temp, middle);

            // 4.get target index
            // 5.replace and fresh new arr
            while (pIndex > target && temp < arr[pIndex - 1]) {
                arr[pIndex] = arr[pIndex - 1];
                pIndex--;
            }
            arr[pIndex] = temp;

        }
    }

    /**
     * get the position of tempNumber in arr
     *
     * @param arr    array
     * @param start  s
     * @param end    e
     * @param temp   tempNumber
     * @param middle middle index
     * @return target index
     */
    private static int getTargetIndex(int[] arr, int start, int end, int temp, int middle) {

        middle = (start + end) >> 1;
        if (arr[middle] > temp) {
            end = middle;
        } else if (arr[middle] < temp) {
            start = middle;
        } else {
            return middle;
        }

        if (start == end - 1 || start == end) {
            return start;
        }
        return getTargetIndex(arr, start, end, temp, middle);
    }

    /**
     * insert sort _03:compare number to new arr one by one
     * Time complexity :less than n2
     * Spatial complexity :2
     *
     * @param arr array
     */
    private static void insertSort_03(int[] arr) {

        int pIndex;
        int temp;
        for (int i = 1; i < arr.length; i++) {

            pIndex = i;
            temp = arr[pIndex];

            // iterator new arr and compare with i_nd
            while (pIndex > 0 && temp < arr[pIndex - 1]) {
                arr[pIndex] = arr[pIndex - 1];
                pIndex--;
            }
            arr[pIndex] = temp;
        }
    }

    /**
     * selection sort：get the smallest one in the rest arr ,and set into new array
     * Time complexity :n2
     * Spatial complexity :1
     *
     * @param arr array
     */
    private static void selectionSort(int[] arr) {

        int temp, indexMin, j;
        int len = arr.length;

        for (int i = 0; i < len - 1; i++) {
            indexMin = i;

            // get index of min number from rest arr which from j to len
            for (j = i + 1; j < len; j++) {

                // get the smaller number
                if (arr[indexMin] > arr[j]) {
                    indexMin = j;
                }
            }

            // change
            temp = arr[i];
            arr[i] = arr[indexMin];
            arr[indexMin] = temp;
        }

    }

    /**
     * bubble sort:get the biggest one in the arr by length times,and construct a new arr
     * Time complexity :1.5*n2
     * Spatial complexity :1
     *
     * @param arr array
     */
    private static void bubbleSort(int[] arr) {

        int temp, j;
        int len = arr.length;

        for (int i = 0; i < len; i++) {

            for (j = 0; j < len - i - 1; j++) {

                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

}
