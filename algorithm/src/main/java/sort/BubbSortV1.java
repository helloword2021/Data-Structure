package sort;

import java.util.Arrays;

/**
 * @Author : helloworld
 * @Desc :冒泡排序 version1
 * 1.每一次排序,靠右边能确定一位有序,
 * 我们可以在每一轮排序后， 记录下
 * 来最后一次元素交换的位置， 该位置即为无序数列的边界， 再往后就是
 * 有序区了,后面的数据就不用排序了
 * @Date: Created in 2021/1/26 17:45
 **/
public class BubbSortV1 {


    public static void sort(int[] arr) {
        //记录最后一次交换的位置
        int lastExchangeIndex = 0;
        int sortBorder = arr.length - 1;
        for (int i = 0; i < arr.length - 1; i++) {
            //有序排序
            boolean isSorted = true;
            // j 只比较 最后一次改动的索引
            for (int j = 0; j < sortBorder; j++) {
                int tmp = 0;
                if (arr[j] > arr[j + 1]) {
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    //因为有元素进行交换， 所以不是有序的， 标记变为false
                    isSorted = false;
                    // 更新为最后一次交换元素的位置
                    lastExchangeIndex = j;
                }
            }
            sortBorder = lastExchangeIndex;
            if (isSorted) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 5, 3, 8, 1, 9};
        sort(arr);
        System.out.println(Arrays.toString(arr));

    }
}
