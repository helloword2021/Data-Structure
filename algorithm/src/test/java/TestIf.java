import org.junit.Test;

/**
 * @Author : xy
 * @Description :
 * @Result:
 * @Date: Created in 2020/02/22 上午 10:37
 **/
public class TestIf {


    /**
     * @Desc:
     * @out:
     */
    @Test
    public void test_If() throws Exception {
        int a = 1;
        if(a == 2){
            System.out.println(2);
        }
        if(a == 4) {
            System.out.println();
        }
        else if (a == 3){
            System.out.println(3);
        }else{
            System.out.println(4);
        }
    }


}
