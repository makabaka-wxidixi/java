package costomer;

public class CustomerTest {
	public static void main(String[] args) {
		Customer cust=new Customer("suo","ya");
		Account acct=new Account(1812341, 10000, 0.0123);
		cust.setAccount(acct);
		cust.getAccount().deposit(100);
		cust.getAccount().withdraw(7000);
		cust.getAccount().withdraw(4000);
		cust.setAccount(acct);
		System.out.println(cust.getFirstName()+" "+cust.getLastName()+"的账户余额为："+cust.getAccount().getBalance()
		+"，年利率为"+acct.getAnnualInterestRate());
	}
}
