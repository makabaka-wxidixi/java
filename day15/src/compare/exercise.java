package compare;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

/**
 * @Author mkbk
 * @Description
 * @Create 2021-08-25 14:26
 */
public class exercise {
    @Test
    public void Test1() {//JDK8之前
        String str = "2017-08-16";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        try {
            date = simpleDateFormat.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        java.sql.Date date1=new java.sql.Date(date.getTime());//long型
        System.out.println(date1);
    }
    @Test
    public void Test2(){
        String str = "2017-08-16";
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("2017-08-16");
        TemporalAccessor parse = dateTimeFormatter.parse(str);
        System.out.println(parse);
        LocalDateTime parse1 = (LocalDateTime) parse;

        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zonedDateTime = localDateTime.atZone(zoneId);
        Instant instant = zonedDateTime.toInstant();
        Date date = Date.from(instant);

        java.sql.Date date1=new java.sql.Date(date.getTime());
        System.out.println(date1);
    }
}
