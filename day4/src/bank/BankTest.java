package bank;

public class BankTest {
	public static void main(String[] args) {
		Bank bank=new Bank();
		bank.addCustomer("yasuo", "shitou");
		bank.getCustomer(1).setAccount(new Account(10000));
		bank.getCustomer(1).getAccount().withdraw(3000);
		double balance=bank.getCustomer(1).getAccount().getBalance();
		System.out.println("客户"+bank.getCustomer(1).getFirstName()+"的账户"
				+ "余额为："+bank.getCustomer(1).getAccount().getBalance());
	}
}
