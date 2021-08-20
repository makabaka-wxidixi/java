package domain;

/**
 * @author liu
 * @create 2021-08-20 11:58
 */
public class Architect extends Designer{
    private int stock;
    //构造器

    public Architect() {
        super();
    }

    public Architect(int id, String name, int age, double salary, Equipment equipment, double bonus, int stock) {
        super(id, name, age, salary, equipment, bonus);
        this.stock = stock;
    }
    //方法

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return getEmployee()+"\t\t架构师\t\t"+getStatus()+"\t\t"+getBonus()+"\t\t"+stock+
                "\t"+getEquipment().getDescription();
    }

    public String toStringTeam(){
        //TID/ID	姓名	年龄	工资	职位	奖金	股票
        return getMemberId()+"/"+getId()+"\t\t"+getName()+"\t\t"+getAge()+"\t\t"+getSalary()+"\t\t设计师\t\t"+getBonus()+"\t\t"+stock;
    }
}
