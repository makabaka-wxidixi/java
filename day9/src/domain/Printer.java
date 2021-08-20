package domain;

/**
 * @author liu
 * @create 2021-08-20 11:21
 */
public class Printer implements Equipment {
    private String name;//机器型号
    private String type;//机器类型
    //构造器

    public Printer() {
    }

    public Printer(String name, String type) {
        this.name = name;
        this.type = type;
    }
    //方法

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getDescription() {
        return name + "(" + type + ")";
    }
}
