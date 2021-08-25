package exercise;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;

/**
 * @Author mkbk
 * @Description
 * @Create 2021-08-25 9:30
 */
public class JDK8DateTimeTest {
    /*
    LocalDate/LocalTime/LocalDateTime的使用
     */
    @Test
    public void Test1(){
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();
//        System.out.println(localDate.getClass());

        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);

        /*
        设定指定的年月日时分秒是没有偏移量的
         */
        LocalDateTime localDateTime1 = LocalDateTime.of(2001,3,28,12,12,12);
        System.out.println(localDateTime1);

        /*
        getxxx()
         */
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getMinute());
        System.out.println(localDateTime.getYear());
        /*
        不可变性
        withxxx()设置相关属性
         */
        LocalDateTime localDateTime2 = localDateTime.withYear(2001);
        System.out.println(localDateTime.getYear());
        System.out.println(localDateTime2.getYear());

        LocalDateTime localDateTime3 = localDateTime.plusYears(1);
        System.out.println(localDateTime.getYear());
        System.out.println(localDateTime3.getYear());

        LocalDateTime localDateTime4 = localDateTime.minusYears(2);
        System.out.println(localDateTime.getYear());
        System.out.println(localDateTime4.getYear());
    }

    /*
    Instant的使用
     */
    @Test
    public void Test2(){
        Instant instant = Instant.now();
        System.out.println(instant);//获取本初子午线的时间

        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);

        //获取1970年1月1日0时0分0秒（UTC）开始的毫秒数
        long milli = instant.toEpochMilli();
        System.out.println(milli);

        //给定毫秒数获取实例
        Instant instant1 = Instant.ofEpochMilli(1629857576046L);
        System.out.println(instant1);
    }

    /*
    DateTimeFormatter:格式化或解析日期、时间，用LocalDate/LocalTime/LocalDateTime来传输
    类似于SimpleDateFormat用Date
     */
    @Test
    public void Test3(){
//      方式一：  自定义
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy--MM--dd hh:mm:ss");
        //格式化
        String str=dateTimeFormatter.format(LocalDateTime.now());
        System.out.println(str);
        //解析
        TemporalAccessor parse = dateTimeFormatter.parse("2002--07--08 12:12:12");
        System.out.println(parse);

//        方式二：
        DateTimeFormatter isoLocalDateTime = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        //格式化2021-08-25T10:42:48.4844077
        String format = isoLocalDateTime.format(LocalDateTime.now());
        System.out.println(format);
        //解析
        TemporalAccessor parse1 = isoLocalDateTime.parse("2021-08-25T10:42:48.4844077");
        System.out.println(parse1);
//        方式三：ofLocalizedDateTime()
//        FormateStyle.LONG/FormateStyle.MEDIUM/FormateStyle.SHORT:适用于LocalDateTime
        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        //格式化 ofLocalizedDateTime()
        String format1 = dateTimeFormatter1.format(LocalDateTime.now());
        System.out.println(format1);
        //解析
        TemporalAccessor parse2 = dateTimeFormatter1.parse("2021年8月25日上午10:58:20");
        System.out.println(parse2+"asdfasfas");
        //格式化 ofLocalizedDate()
//        FormatStyle.FULL/FormatStyle.LONG/FormatStyle.MEDIUM/FormatStyle.SHORT:适用于LocadeDate
        DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
        //格式化
        String format2 = dateTimeFormatter2.format(LocalDate.now());
        System.out.println(format2);

    }
}
