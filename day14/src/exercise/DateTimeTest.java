package exercise;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 格式化：是将默认格式转化为本地的格式(format)
 * 解析：是将本地的格式转化为系统默认的格式(parse)二者都是非静态方法，需要考虑实例化
 * @Author mkbk
 * @Description
 * @Create 2021-08-24 18:27
 */
public class DateTimeTest {
    @Test
    public void Test1(){
        SimpleDateFormat sdf1 =new SimpleDateFormat();
        Date date1 = new Date();
        System.out.println(date1);

        String str="2021/8/24 下午6:38";
        Date date2= null;
        try {
            date2 = sdf1.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(date2);

        String format1=sdf1.format(date1);
        System.out.println("format"+format1);

        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String format2=sdf2.format(date1);
        System.out.println(format2);


    }
    /*
    将"2020-09-08"转化为java.sql.Date
     */
    @Test
    public void Test2(){
        //解析
        String birth="2020-09-08";
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date date= null;
        try {
            date = sdf.parse(birth);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        java.sql.Date date1=new java.sql.Date(date.getTime());
        System.out.println(date1);
    }
}
