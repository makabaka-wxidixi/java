package staticTest;

public class Account {
	private int id;//账号
	private String pwb="000000";//初始密码
	private double balance;//余额
	
	private static double interestRate;//利率
	private static double minMoney=1.0;//最小余额
	private static int init=1001;
	//构造器
	public Account() {
		id=init++;
	}
	public Account(String pwb,double balance) {
		this();
		this.pwb=pwb;
		this.balance=balance;
	}
	
	//方法
	public String getPwb() {
		return pwb;
	}
	public void setPwb(String pwb) {
		this.pwb = pwb;
	}
	public static double getInterestRate() {
		return interestRate;
	}
	public static void setInterestRate(double interestRate) {
		Account.interestRate = interestRate;
	}
	public static double getMinMoney() {
		return minMoney;
	}
	public static void setMinMoney(double minMoney) {
		Account.minMoney = minMoney;
	}
	public int getId() {
		return id;
	}
	public double getBalance() {
		return balance;
	}
	public String toString() {
		return "Account [id=" + id + ", pwb=" + pwb + ", balance=" + balance + "]";
	}
	
}
