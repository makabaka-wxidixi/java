package domain;

/**
 * @author liu
 * @create 2021-08-20 11:54
 */
public class Designer extends Programmer{
    private double bonus;//奖金

    //构造器
    public Designer() {
        super();
    }

    public Designer(int id, String name, int age, double salary, Equipment equipment, double bonus) {
        super(id, name, age, salary, equipment);
        this.bonus = bonus;
    }

    //方法

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return getEmployee()+"\t\t设计师\t\t"+getStatus()+"\t\t"+bonus+"\t\t\t\t"+getEquipment().getDescription();
    }

    public String toStringTeam(){
        //TID/ID	姓名	年龄	工资	职位	奖金	股票
        return getMemberId()+"/"+getId()+"\t\t"+getName()+"\t\t"+getAge()+"\t\t"+getSalary()+"\t\t设计师\t\t"+bonus;
    }
}
