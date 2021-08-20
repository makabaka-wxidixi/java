package service;

/**
 * @Author mkbk
 * @Description 自定义异常类
 * @Create 2021-08-20 15:03
 */
public class TeamException extends Exception{
    static final long serialVersionUID =-3123124124214L;
    public TeamException(){
        super();
    }
    public TeamException(String msg){
        super(msg);
    }
}
