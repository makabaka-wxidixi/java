package String;

import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * @Author mkbk
 * @Description
 * @Create 2021-08-24 9:30
 */
public class StringTest1 {


    @Test
    public void Test1() {
        String str1 = "123";//在方法区
        int num = Integer.parseInt(str1);
        String str2 = num + "";//在堆中
        System.out.println(str1.equals(str2));
        String str3 = String.valueOf(num);
        System.out.println(str3);
    }

    @Test
    public void Test2() {
        String str1 = "asdf1234";
        char[] ch1 = str1.toCharArray();
        for (int i = 0; i < ch1.length; i++) {
            System.out.print(ch1[i]);
        }
        char[] arr = new char[]{'h', 'e', 'l', 'l', 'o'};
        String str2 = new String(arr);
        System.out.println(str2);
    }

    @Test
    public void Test3() {
        String str1 = "123asd亚索";
        byte[] bytes = str1.getBytes(StandardCharsets.UTF_8);
        System.out.println(Arrays.toString(bytes));

        String str2 = new String(bytes);
        System.out.println(str2);
    }
}
