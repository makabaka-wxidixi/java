package String;

import org.junit.Test;

import java.util.Locale;

/**
 * @Author mkbk
 * @Description
 * @Create 2021-08-23 17:54
 */
public class StringMethodTest {

    @Test
    public void Test6() {
        //匹配
        String s1 = "1233456";
        System.out.println(s1.matches("\\d+"));

        String str="hello|world|java";
        String[] strs=str.split("\\|");
        for (int i = 0; i < strs.length; i++) {
            System.out.println(strs[i]);
        }
        String str1="ni.shi.xiao.ke.ai";
        String[] strs1=str1.split("\\.");
        for (int i = 0; i < strs1.length; i++) {
            System.out.println(strs1[i]);
        }
    }

    @Test
    public void Test5() {
        String s1 = "亚索索最怕潘森，亚索也怕诺手";
        System.out.println(s1.replace("亚索", "永恩"));

        String s2 = "12yasuo12312yongen123123zuoyi23314jiansheng1212";
        String s3 = s2.replaceAll("\\d+", ",");
        System.out.println(s2.replaceAll("\\d+", ","));
        System.out.println(s3.replaceAll("^,|,$", "?"));
        System.out.println(s2.replaceFirst("\\d+", "poi"));
    }

    @Test
    public void Test4() {
        String s1 = "abcdefghi";
        System.out.println(s1.lastIndexOf("fghi"));
        System.out.println(s1.lastIndexOf("cd", 2));
        //当indexof和lastindexof的返回值相同时
        //1.只有一个子字符串
        //2.不存在子字符串（返回-1）
    }

    @Test
    public void Test3() {
        String s1 = "我的亚索真的无敌啊";
        String s2 = s1.substring(2);
        String s3 = s1.substring(2, 8);
        //左闭右开
        System.out.println(s2);
        System.out.println(s3);

        boolean b1 = s1.startsWith("亚索", 3);
        System.out.println(b1);
        String s4 = "亚索";
        //s1中是否包含s4
        System.out.println(s1.contains(s4));
        //两种方法返回的都是索引
        System.out.println(s1.indexOf("亚索"));
        System.out.println(s1.indexOf("亚索", 2));

    }

    @Test
    public void Test2() {
        String s1 = "abc";
        String s2 = s1.concat("def");
        System.out.println(s1);
        System.out.println(s2);

        String s3 = "abcd";
        String s4 = "abez";
        System.out.println(s3.compareTo(s4));//涉及到字符串排序
    }

    @Test
    public void Test1() {
        String s1 = "hello";
        System.out.println(s1.length());
        System.out.println(s1.charAt(4));
        System.out.println(s1.isEmpty());
        s1 = "";
        System.out.println(s1.isEmpty());
        s1 = "YaSuo";
        String s2 = s1.toLowerCase(Locale.ROOT);
        System.out.println(s1);//YaSuo，s1是不可变得，仍为原来的字符串
        System.out.println(s2);//yasuo
//        trim()方法是修建字符串首尾的空格
        String s3 = "  asdf asf gad    ";
        String s4 = s3.trim();
        System.out.println(s3);
        System.out.println(s4);

    }
}
