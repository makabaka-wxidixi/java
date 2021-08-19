package day8_1;

public class StaticProxyTest {
	public static void main(String[] args) {
		RealStar wuyifan=new RealStar();
		Proxy s=new Proxy(wuyifan);
		s.confer();
		s.signContract();
		s.bookTicket();
		s.sing();
		s.collectMoney();
	}
}

interface Star{
	void confer();//面谈
	
	void signContract();//签合同
	
	void bookTicket();//订票
	
	void sing();//唱歌
	
	void collectMoney();//收钱
}

class RealStar implements Star{
	public void confer() {
		
	}

	@Override
	public void signContract() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void bookTicket() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sing() {
		// TODO Auto-generated method stub
		System.out.println("明星：唱歌");
	}

	@Override
	public void collectMoney() {
		// TODO Auto-generated method stub
		
	}
}

class Proxy implements Star{
	private Star real;//接口多态
	public Proxy(Star real) {//传入一个真正的被代理类
		this.real=real;
	}
	@Override
	public void confer() {
		// TODO Auto-generated method stub
		System.out.println("经纪人：面谈");
	}
	@Override
	public void signContract() {
		// TODO Auto-generated method stub
		System.out.println("经纪人：签合同");
	}
	@Override
	public void bookTicket() {
		// TODO Auto-generated method stub
		System.out.println("经纪人：订票");
	}
	@Override
	public void sing() {
		// TODO Auto-generated method stub
		this.real.sing();
	}
	@Override
	public void collectMoney() {
		// TODO Auto-generated method stub
		System.out.println("经纪人：收钱");
	}
	
}
