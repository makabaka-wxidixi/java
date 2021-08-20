package view;

import domain.Employee;
import domain.Programmer;
import service.NameListService;
import service.TeamException;
import service.TeamService;

/**
 * @Author mkbk
 * @Description
 * @Create 2021-08-20 18:44
 */
public class TeamView {
    private NameListService listSvc = new NameListService();
    private TeamService teamSvc = new TeamService();

    //方法
    public void enterMainMenu() {
        boolean flag = true;
        char menu = 0;
        while (flag) {
            if (menu != '1') {
                listAllEmployees();//显示所有成员消息
            }
            System.out.println("1-团队列表 2-添加团队成员 3-删除团队成员 4-退出 请选择（1-4）");
            menu = TSUtility.readMenuSelection();//从键盘获取内容
            switch (menu) {
                case '1':
                    getTeam();
                    break;
                case '2':
                    addMember();
                    break;
                case '3':
                    deleteMember();
                    break;
                case '4':
                    System.out.println("确认要退出吗（Y/N）");
                    char isExit = TSUtility.readConfirmSelection();
                    if (isExit == 'Y') {
                        flag = false;
                    }
                    break;
            }
        }
    }

    private void listAllEmployees() {
        System.out.println("//////////////////////////////////////////开发调度软件//////////////////////////////////////////");
        Employee[] employees = listSvc.getAllEmployees();
        if (employees == null || employees.length == 0) {
            System.out.println("公司中没有员工");
        } else {
            System.out.println("ID\t\t姓名\t\t年龄\t\t工资\t\t职位\t\t状态\t\t奖金\t\t股票\t\t领用设备\t\t");
            for (int i = 0; i < employees.length; i++) {
                System.out.println(employees[i]);
            }
            System.out.println("//////////////////////////////////////////////////////////////////////////////////////////////////");
        }
    }

    private void getTeam() {
        System.out.println("////////////////////////////////////////////////开发人员名单//////////////////////////////////////////////////");
        Programmer[] team = teamSvc.getTeam();
        if (team == null || team.length == 0) {
            System.out.println("开发团队目前没有成员");
        } else {
            System.out.println("TID/ID\t\t姓名\t\t年龄\t\t工资2" +
                    "\t\t职位\t\t奖金\t\t股票");
            for (int i = 0; i < team.length; i++) {
                System.out.println(team[i].toStringTeam());
            }
        }
        System.out.println("/////////////////////////////////////////////////////////////////////////////////////////////////////////////");
    }

    private void addMember() {
        System.out.println("********************************添加成员***********************************");
        System.out.print("请输入要添加员工的ID");
        int id = TSUtility.readInt();
        try{
            Employee emp=listSvc.getEmployee(id);
            teamSvc.addMember(emp);
            System.out.println("添加成功");
        }catch (TeamException e){
            System.out.println("添加失败，原因："+e.getMessage());
        }
    }

    private void deleteMember() {
        System.out.println("********************************删除成员***********************************");
        System.out.println("请输入要删除的员工的id");
        int memberId=TSUtility.readInt();
        System.out.println("确认是否要删除（Y/N）");
        char isDelete=TSUtility.readConfirmSelection();
        if(isDelete=='N'){
            return;
        }
        try{
            teamSvc.removeMember(memberId);
            System.out.println("删除成功");
        }catch (TeamException e){
            System.out.println("删除失败，原因："+e.getMessage());
        }
        TSUtility.readReturn();
    }


    //@Override
    public static void main(String[] args) {
        TeamView view = new TeamView();
        view.enterMainMenu();
    }
}
