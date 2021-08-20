package domain;

/**
 * @author liu
 * @create 2021-08-20 11:08
 */
public class PC implements Equipment{
    private String model;//机器型号
    private String display;//显示器名称
    //构造器
    public PC(String model, String display) {
        this.model = model;
        this.display = display;
    }

    //方法
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    @Override
    public String getDescription() {
        return model+"("+display+")";
    }
}
