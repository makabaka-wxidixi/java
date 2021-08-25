package exercise;

import org.junit.Test;

/**
 * @Author mkbk
 * @Description
 * @Create 2021-08-24 14:59
 */
public class StringDemo1 {
    public String reverse1(String str, int startIndex, int endIndex) {
        if (str != null) {
            char[] ch1 = str.toCharArray();
            for (int i = startIndex, j = endIndex; i < j; i++, j--) {
                char tmp = ch1[i];
                ch1[i] = ch1[j];
                ch1[j] = tmp;
            }
            return new String(ch1);
        }
        return null;
    }

    public String reverse2(String str, int startIndex, int endIndex) {
        if (str != null) {
            String str1 = new String();
            //第一部分
            str1 = str.substring(0, startIndex);
            //第二部分
            for (int i = endIndex; i >= startIndex; i--) {
                str1 += str.charAt(i);
            }
            //第三部分
            str1 += str.substring(endIndex + 1);
            return str1;
        }
        return null;
    }

    public String reverse3(String str, int startIndex, int endIndex) {
        if (str != null) {
            StringBuffer str1 = new StringBuffer(str.length());
            //第一部分
            str1.append(str.substring(0, startIndex));
            //第二部分
            for (int i = endIndex; i >= startIndex; i--) {
                str1.append(str.charAt(i));
            }
            //第三部分
            str1.append(str.substring(endIndex + 1));
            return str1.toString();
        }
        return null;
    }

    @Test
    public void Test1() {
        String str1 = "abcdefg";
        String str2 = reverse1(str1, 2, 5);
        System.out.println("方法一：" + str2);
        String str3 = reverse2(str1, 2, 5);
        System.out.println("方法二：" + str3);
        String str4 = reverse3(str1, 2, 5);
        System.out.println("方法三：" + str4);
    }
}
