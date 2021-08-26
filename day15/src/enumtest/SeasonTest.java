package enumtest;

import org.junit.Test;

/**
 * @Author mkbk
 * @Description
 * @Create 2021-08-25 16:44
 */
public class SeasonTest {
    @Test
    public void Test1(){
        Season season=Season.SPRING;
        System.out.println(season.getSeasonName());
        System.out.println(season.getSeasonDescrible());
        System.out.println(season.toString());
    }

    /*
    enum类继承与java.lang.Enum类
     */
    @Test
    public void Test2(){
        Season1 season=Season1.SPRING;
        System.out.println(season);
        System.out.println(season.toString());
        System.out.println(season.getSeason1Name());
        System.out.println(season.getSeasonDescrible());
        System.out.println(Season1.class.getSuperclass());

        Season1[] values=Season1.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
        }

        Thread.State[] values1=Thread.State.values();
        for (int i = 0; i < values1.length; i++) {
            System.out.println(values1[i]);
        }
//        返回指定名字的对象，如果没有就抛出异常
        Season1 summer = Season1.valueOf("SUMMER");
        System.out.println(summer);
    }

}

//enum枚举类
enum Season1{
    SPRING("春天","出暖花开"),
    SUMMER("夏天","夏日炎炎"),
    ANTUMN("秋天","秋高气爽"),
    WINTER("冬天","冰天雪地");

    private final String seasonName;
    private final String seasonDescrible;

    private Season1(String seasonName, String seasonDescrible) {
        this.seasonName = seasonName;
        this.seasonDescrible = seasonDescrible;
    }


    public String getSeason1Name() {
        return seasonName;
    }

    public String getSeasonDescrible() {
        return seasonDescrible;
    }

}


//自定义枚举类
class Season{
    private final String seasonName;
    private final String seasonDescrible;

    private Season(String seasonName, String seasonDescrible) {
        this.seasonName = seasonName;
        this.seasonDescrible = seasonDescrible;
    }

    public static final Season SPRING=new Season("春天","出暖花开");
    public static final Season SUMMER=new Season("夏天","夏日炎炎");
    public static final Season ANTUMN=new Season("秋天","秋高气爽");
    public static final Season WINTER=new Season("冬天","冰天雪地");

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDescrible() {
        return seasonDescrible;
    }

    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDescrible='" + seasonDescrible + '\'' +
                '}';
    }
}
