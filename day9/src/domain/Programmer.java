package domain;


import service.Status;

/**
 * @author liu
 * @create 2021-08-20 11:31
 */
public class Programmer extends Employee {
    private int memberId;//开发团队当中的ID
    private Status status = Status.FREE;
    private Equipment equipment;
    //构造器

    public Programmer() {
        super();
    }

    public Programmer(int id, String name, int age, double salary, Equipment equipment) {
        super(id, name, age, salary);
        this.equipment = equipment;
    }
    //方法

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    @Override
    public String toString() {
        return getEmployee() + "\t\t程序员\t\t" + status + "\t\t\t\t\t\t\t" + equipment.getDescription();
    }

    public String toStringTeam(){
        //TID/ID	姓名	年龄	工资	职位	奖金	股票
        return memberId+"/"+getId()+"\t\t\t"+getName()+"\t\t"+getAge()+"\t\t"+getSalary()+"\t\t程序员"	;
    }
}
