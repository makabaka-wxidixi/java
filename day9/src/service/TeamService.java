package service;

import domain.Architect;
import domain.Designer;
import domain.Employee;
import domain.Programmer;

/**
 * @Author mkbk
 * @Description 关于开发团队成员的管理：添加、删除等
 * @Create 2021-08-20 16:47
 */
public class TeamService {
    private static int counter = 1;//给memberId赋值使用
    private final int MAX_MEMBER = 5;//限制开发团队人数
    private Programmer[] team = new Programmer[MAX_MEMBER];//保存开发团队
    private int total;//用于记录开发团队中实际的人数

    //构造器
    public TeamService() {
    }

    //方法

    /**
     * @description 获取开发团队的所有成员
     * @return
     */
    public Programmer[] getTeam(){
        Programmer[] team = new Programmer[total];
        for(int i=0;i<team.length;i++){
            team[i]=this.team[i];
        }
        return team;
    }

    /**
     * @description 将指定员工加入到开发团队中
     * @param e
     */
    public void addMember(Employee e) throws TeamException {
        //成员已满
        if(total>=MAX_MEMBER){
            throw new TeamException("成员已满，无法添加");
        }
        //该员工不是开发人员，无法添加
        if(!(e instanceof Programmer)){
            throw new TeamException("该员工不是开发人员，无法添加");
        }
        //该员工已经在团队中
        if(isExist(e)){
            throw new TeamException("该员工已经在团队中");
        }
        //成员不能是BUSY VOCATION
        Programmer p=(Programmer) e;//此时一定不会出现ClassCastException
        if("BUSY".equals(p.getStatus().getNAME())){
            throw new TeamException("该成员已经是某团队成员");
        }else if("VOCATION".equalsIgnoreCase(p.getStatus().getNAME())){
            throw new TeamException("该成员在度假");
        }
        //团队中最多一个架构师
        //团队中最多两个设计师
        //团队中最多三个程序员
        int numOfArch=0,numOfDes=0,numOfPro=0;
        for(int i=0;i<total;i++){
            if(team[i] instanceof Architect){
                numOfArch++;
            }else if(team[i] instanceof Designer){
                numOfDes++;
            }else
                numOfPro++;
        }
        if(p instanceof Architect){
            if(numOfArch>=1){
                throw new TeamException("架构师人数已够");
            }
        }else if(p instanceof Designer){
            if(numOfDes>=2){
                throw new TeamException("设计师人数已够");
            }
        }else{
            if(numOfPro>=3){
                throw new TeamException("程序员人数已满");
            }
        }

        team[total++]=p;
        p.setStatus(Status.BUSY);
        p.setMemberId(counter++);
    }

    /**
     * @Description 判断成员是否已经在开发团队中
     * @param e
     * @return
     */
    private boolean isExist(Employee e) {
        for(int i=0;i<total;i++){
            if(team[i].getId()==e.getId()) {
                return true;
            }
        }
        return false;
    }

    /**
     * @Description 删除团队中的成员
     * @param memberId
     */
    public void removeMember(int memberId) throws TeamException {
        int i=0;
        for(i=0;i<total;i++){
            if(team[i].getMemberId()==memberId){
                team[i].setStatus(Status.FREE);
                break;
            }
        }
        if(total==i){
            throw new TeamException("找不到指定成员");
        }
        for(int j=i;j<total-1;j++){
            team[j]=team[j+1];
        }
        team[--total]=null;
    }
}
