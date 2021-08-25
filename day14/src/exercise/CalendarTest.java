package exercise;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Calendar是抽象类，需要考虑用子类进行实例化
 *
 * @Author mkbk
 * @Description
 * @Create 2021-08-24 20:56
 */
public class CalendarTest {
    @Test
    public void Test1() throws ParseException {
        /*
        实例化
        方式一：创建其子类（GergorianCalendar）的对象
        方式二：调用其静态方法getInstance
         */
        //get()
        Calendar calendar = Calendar.getInstance();
        Date time = calendar.getTime();
        System.out.println(time);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(day);
        int days = calendar.get(Calendar.DAY_OF_YEAR);
        System.out.println(days);
        //set()
        calendar.set(Calendar.DAY_OF_MONTH, 12);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(day);
        //add()
        calendar.add(Calendar.DAY_OF_MONTH, 12);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(day);
        //getTime()
        Date date = new Date();
        date = calendar.getTime();//获取当前日历的时间
        System.out.println(date);
        //setTime()
        Date date1 = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat();
        String str = "2020/03/28 下午9:23";
        System.out.println(sdf.parse(str));//解析
        //2021/8/24 下午9:24
//        String format = sdf.format(date1.getTime());
//        System.out.println(format);
        calendar.setTime(sdf.parse(str));//以当前时间设置日历
        int i = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(i);
        calendar.setTime(date1);
        int j=calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(j);

    }
}
