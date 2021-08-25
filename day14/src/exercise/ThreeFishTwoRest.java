package exercise;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 三天打鱼两天晒网
 * 1990-1-1  开始算起
 *
 * @Author mkbk
 * @Description
 * @Create 2021-08-24 19:11
 */
public class ThreeFishTwoRest {
    public boolean ThreeFishTwoRest(String currentTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = new Date();//获取当前时间微秒数
        System.out.println(date1.getTime());
        Date date2 = null;
//        String str = "1990-01-01";
        try {
            date2 = sdf.parse(currentTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //得到时间差
        long ret = date1.getTime() - date2.getTime();
        int day = (int) ((ret / 1000 / 60 / 60 / 24) + 1);//总共这么些天
        if(day%5==1||day%5==2||day%5==3){
            return true;
        }else{
            return false;
        }
    }

    @Test
    public void Test1() throws ParseException {
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String str=sdf.format(date.getTime());
        System.out.println(str);
        System.out.println(ThreeFishTwoRest(str));
        System.out.println(sdf.parse(str));

    }
}
