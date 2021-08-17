package staticTest;

public class AccountTest {
	public static void main(String[] args) {
		Account acct1=new Account();
		Account acct2=new Account("adfasdf",10000);
		System.out.println(acct1.getBalance());
		System.out.println(acct2.getBalance());
		System.out.println(acct1);
		System.out.println(acct2);
		Account.setInterestRate(0.012);
	}
}
