package array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : helloworld
 * @Description :new 数组demo
 * @Result:
 * @Date: Created in 2020/01/14 上午 11:24
 **/
public class NewArray {


    /**
     * @Desc:new数组
     * @out:
     */
    @Test
    public void test_newArray() throws Exception {
        int[] a = new int[]{1,2,4,5};
        //数组下标越界
      //  System.out.println(a[9]);
        System.out.println(a[1]);
        System.out.println(a.length);
    }


    /**
     * @Desc:测试在数组中间插入数据
     * @out:
     */
    @Test
    public void test_midInsertArray() throws Exception {
        int[] a = new int[]{1,2,3,4};
    }


    /**
     * @Desc:测试arrylist扩容  << 向左移动1位 *2  >> 向右移动  1位 /2
     * @out:
     */
    @Test
    public void test_arryListAdd() throws Exception {
        ArrayList list = new ArrayList<String>();
        list.add("a");
        System.out.println(8<<2);
        System.out.println(10<<2);

    }


}
