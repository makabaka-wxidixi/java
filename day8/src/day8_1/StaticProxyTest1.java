package day8_1;
/*
 * 接口的应用：代理模式
 * 创建一个代理类，向代理类传的方法是被代理类，通过代理类去实现被代理类的方法
 */
public class StaticProxyTest1 {
	public static void main(String[] args) {
		ProxyServer p=new ProxyServer(new Server());
		p.browse();
	}
}

interface NetWork{	
	
	public void browse();//浏览的功能
}

//定义服务器，被代理类
class Server implements NetWork{

	@Override
	public void browse() {
		System.out.println("真实的服务器来访问网络");
	}
	
}


class ProxyServer implements NetWork{

	private NetWork work;//接口的多态性
	public ProxyServer(NetWork work) {//创建一个真实的网络
		this.work=work;
	}
		
	public void check() {
		System.out.println("联网之前的检查工作");
	}
	@Override
	public void browse() {
		// TODO Auto-generated method stub
		this.check();
		this.work.browse();
	}
	
}