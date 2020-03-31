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

        int totalNumber = 100;
        int[] arr = new int[totalNumber];
        for (int i = 0; i < totalNumber; i++) {
            arr[i] = new Random().nextInt(totalNumber);

        }

        long bubbleStart = System.currentTimeMillis();
        BubbleSort(arr);
        System.out.println("BubbleSort cost millisecond===>" + (System.currentTimeMillis() - bubbleStart));
    }

    /**
     * bubble sort
     * Time complexity :n2
     * Spatial complexity :1
     *
     * @param arr array
     */
    private static void BubbleSort(int[] arr) {

        int temp;
        int len = arr.length;

        for (int i = 0; i < len; i++) {

            for (int j = 0; j < len - i - 1; j++) {

                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

}
