package String;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author mkbk
 * @Description
 * @Create 2021-08-24 10:23
 */
public class ExericeTest {
    @Test
    public void Test1() {
        String str1 = "     123 sfa   323   43     ";
        System.out.println(str1);//取出首尾空格
        String str2 = str1.replaceAll("^\\ +|\\ +$", "");
        System.out.println(str2);
    }

    @Test
    //将abcdefg反转为abedcfg
    public void Test2() {
        String str1 = "abcdefg";
        char[] ch1 = str1.toCharArray();
        int left = 2;
        int right = ch1.length - 3;
        while (left < right) {
            char tmp = ch1[left];
            ch1[left] = ch1[right];
            ch1[right] = tmp;
            left++;
            right--;
        }
        System.out.println(Arrays.toString(ch1));
        str1 = new String(ch1);
        System.out.println(str1);
    }

    @Test
    //获取一个字符串在另一个字符中出现的次数
    public void Test3() {
        String str1 = "";
        String str2 = "absdfgn mba bs fejoabwfdsab";//三次
        if(str1.length()<=0){
            System.out.println("数据错误");
            return;
        }
        int count = 0;
        int index = 0;//ab ab ab ab ab ab
        while (true) {
            if (str2.indexOf(str1, index)>=0) {
                count++;
                index = str2.indexOf(str1, index) + str1.length();
            } else {
                break;
            }
        }
        System.out.println("出现次数" + count);
    }

    @Test
    public void Test4(){
        String str1="aqwersaffewweasd";
        char[] ch1 = str1.toCharArray();
        System.out.println(Arrays.toString(ch1));
        Arrays.sort(ch1);
        System.out.println(Arrays.toString(ch1));
        str1=new String(ch1);
        System.out.println(str1);
    }

}

