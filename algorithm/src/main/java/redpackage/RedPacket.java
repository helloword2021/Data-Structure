package redpackage;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Author : helloworld
 * @Desc : 红包算法应该遵循的规则
 * 1.所有人抢到的金额之和要等于红包金额， 不能多也不能少。
 * 2. 每个人至少抢到1分钱。
 * 3. 要保证红包拆分的金额尽可能分布均衡， 不要出现两极分化太严重的情况。
 * 算法 二倍均值法 假设剩余红包金额为m元， 剩余人数为n， 那么有如下公式。
 * 每次抢到的金额 = 随机区间 [0.01， m /n × 2 - 0.01]元
 * @Date: Created in 2021/1/27 16:41
 **/
public class RedPacket {

    /**
     * 分红包算法
     * @param totalAmount 总的金额
     * @param totalPeopleNum  拆红包人数
     * @return
     */
    public static List<Integer> divideRedPackage(Integer totalAmount, Integer totalPeopleNum){
        ArrayList<Integer> amountList = new ArrayList<>();
        Integer restAmount = totalAmount;
        Integer restPeopleNum = totalPeopleNum;
        Random random = new Random();
        for(int i = 0 ;i < totalPeopleNum-1;i++){
            //随机范围 随机范围： [1， 剩余人均金额的2倍-1] 分
            int amount = random.nextInt(restAmount / restPeopleNum * 2 - 1) + 1;
            restAmount -= amount;
            restPeopleNum--;
            amountList.add(amount);
        }
        amountList.add(restAmount);
        return  amountList;
    }

    public static void main(String[] args) {
        List<Integer> amountList = divideRedPackage(100, 5);
        for(Integer integer : amountList) {
            System.out.println("抢到的金额:"+new BigDecimal(integer));
        }
    }


}
