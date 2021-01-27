package array;

/**
 * @Author : helloworld
 * @Description :数组中间插入
 * @Result:
 * @Date: Created in 2020/01/14 上午 11:57
 **/
public class ArryMidInsert {

    private int[] array;
    //数组的实际大小
    private int size;

    public ArryMidInsert(int capacity){
        //构造一个容量为capacity的数组,数组的每个位置上的值为 0
        this.array = new int[capacity];
        size = 0;
    }

    /**
     * @param element 元素
     * @param index 插入元素的位置
     */
    public void insert(int element, int index) throws Exception{
        if(index < 0 || index > size){
            throw  new IndexOutOfBoundsException("超出数组实际范围");
        }

        //数组扩容
        if(size >= array.length){
            resize();
        }

        //数组最后一个元素 ,数据一个个向右边移动
        for(int i = size - 1 ;i >= index;i--){
            array[i+1] = array[i];
        }

        array[index] = element;
        size++;

    }

    private void resize(){
        int[] arrayNew = new int[array.length*2];
        System.arraycopy(array,0,arrayNew,0,array.length);
        //把新的引用地址指向原先数组引用地址
        array = arrayNew;
    }
    public void outPut(){
        for(int i = 0;i < size; i++){
            System.out.println(array[i]);
        }
    }

    public static void main(String[] args)  throws Exception{
        ArryMidInsert arryMidInsert = new ArryMidInsert(2);
        System.out.println(arryMidInsert.array.length);
        arryMidInsert.insert(1,0);
        arryMidInsert.insert(2,1);
        arryMidInsert.insert(3,1);
        arryMidInsert.outPut();
    }


}
