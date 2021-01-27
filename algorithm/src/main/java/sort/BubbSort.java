package sort;

import java.util.Arrays;

/**
 * @Author : helloworld
 * @Desc : 冒泡排序
 *         如果第1轮完全有序,后面就不用排了 ,因为 第二轮肯定也是完全有序,
 *         每循环一次,在右边 能确定一位有序,
 * @Date: Created in 2021/1/26 17:13
 **/
public class BubbSort {

    public static  void sort(int[] arr){
            for(int i = 0 ;i < arr.length-1;i++){
                //有序标记， 每一轮的初始值都是true
                boolean isSorted = true;
                //每循环一次,确定一位有序,so (arr.length - 1 -i)
                for(int j = 0; j < arr.length - 1 -i ;j++){
                    int tmp = 0;
                    if(arr[j] > arr[j+1]){
                        tmp = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1] = tmp;
                        //因为有元素进行交换， 所以不是有序的， 标记变为false
                        isSorted = false;

                    }
                }

                if(isSorted){
                    break;
                }
            }

    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,5,3,8,1,9};
        sort(arr);
        System.out.println(Arrays.toString(arr));

    }
}
