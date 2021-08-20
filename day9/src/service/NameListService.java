package service;

import domain.*;

/**
 * @CreatNAme
 * @Author liu
 * @Description 负责将Date中的数据封装到Employee[]数组中，同时提供相关Employee[]的方法
 * @Create 2021-08-20 12:23
 */
public class NameListService {

    private Employee[] employees;

    /**
     * 给employees及数组元素进行初始化
     */
    //构造器
    public NameListService() {
        employees = new Employee[Data.EMPLOYEES.length];
        for (int i = 0; i < Data.EMPLOYEES.length; i++) {
            //得到数据库中第一个类型，决定构造哪一种对象
            int type = Integer.parseInt(Data.EMPLOYEES[i][0]);
            //获取四种基本信息
            int id = Integer.parseInt(Data.EMPLOYEES[i][1]);
            String name = Data.EMPLOYEES[i][2];
            int age = Integer.parseInt(Data.EMPLOYEES[i][3]);
            double salary = Double.parseDouble(Data.EMPLOYEES[i][4]);
            //只声明，不处理，真正有设备在进行赋值
            Equipment equipment;
            double bonus;
            switch (type) {
                case Data.EMPLOYEE:
                    employees[i] = new Employee(id, name, age, salary);
                    break;
                case Data.PROGRAMMER:
                    equipment = creatEquipment(i);
                    employees[i] = new Programmer(id, name, age, salary, equipment);
                    break;
                case Data.DESIGNER:
                    equipment = creatEquipment(i);
                    bonus = Double.parseDouble(Data.EMPLOYEES[i][5]);
                    employees[i] = new Designer(id, name, age, salary, equipment, bonus);
                    break;
                case Data.ARCHITECT:
                    equipment = creatEquipment(i);
                    bonus = Double.parseDouble(Data.EMPLOYEES[i][5]);
                    int stock = Integer.parseInt(Data.EMPLOYEES[i][6]);
                    employees[i] = new Architect(id, name, age, salary, equipment, bonus, stock);
                    break;
            }
        }
    }

    /**
     * @param index
     * @return 返回设备类型
     * @describe 获取指定位置上的员工的设备
     */
    private Equipment creatEquipment(int index) {
        //拿到设备代号
        int key = Integer.parseInt(Data.EQUIPMENTS[index][0]);
        //对应设备号进行new对象
        String modelOrname = Data.EQUIPMENTS[index][1];
        switch (key) {
            case Data.PC://21
                String display = Data.EQUIPMENTS[index][2];
                return new PC(modelOrname, display);
            case Data.NOTEBOOK://22
                int price = Integer.parseInt(Data.EQUIPMENTS[index][2]);
                return new NoteBook(modelOrname, price);
            case Data.PRINTER://23
                String type = Data.EQUIPMENTS[index][2];
                return new Printer(modelOrname, type);
        }
        return null;
    }

    /**
     * @return 存放员工的一维数组
     * @Description 返回所有员工信息
     */
    public Employee[] getAllEmployees() {
        return employees;
    }

    /**
     * @param id
     * @return
     */
    public Employee getEmployee(int id) throws TeamException {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getId() == id) {
                return employees[i];
            }
        }
        //如果出问题就抛出来一个错误
        throw new TeamException("找不到指定的员工");
    }

}
