package sort;

import java.util.Arrays;

/**
 * @Author : helloworld
 * @Desc :鸡尾酒排序
 *  鸡尾酒排序的元素比较和交换过程是双向的
 * @Date: Created in 2021/1/26 18:16
 **/
public class BubbSortV2 {

    public static void sort(int array[]) {
        int tmp = 0;
        for (int i = 0; i < array.length / 2; i++) {
            //有序标记， 每一轮的初始值都是true
            boolean isSorted = true;
            //奇数轮， 从左向右比较和交换
            for (int j = i; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    // 有元素交换， 所以不是有序的， 标记变为false
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
            // 在偶数轮之前， 将isSorted重新标记为true
            isSorted = true;
            //偶数轮， 从右向左比较和交换
            for (int j = array.length - i - 1; j > i; j--) {
                if (array[j] < array[j - 1]) {
                    tmp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = tmp;
                    // 因为有元素进行交换， 所以不是有序的， 标记变为
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{2, 3, 4, 5, 6, 7, 8, 1};
        sort(array);
        System.out.println(Arrays.toString(array));
    }
}
