package day7test1;

/*
 * 接口的使用
 * 1.接口使用上也满足多态性
 * 2.接口，实际上就是定义了一种规范
 * 3.开发中，体会面向接口编程！
 */
public class USBTest {
	public static void main(String[] args) {
		Computer computer=new Computer();
		computer.transferData(new Flash());//实现类的对象
		System.out.println("------------------------");
		Computer computer1=new Computer();
		computer1.transferData(new Printer());
		System.out.println("***************");
		//创建接口的非匿名实现类的非匿名对象
		Flash flash=new Flash();
		computer.transferData(flash);
		//创建接口的非匿名实现类的匿名对象
		System.out.println("***************");
		computer.transferData(new Printer());
		//创建了接口的匿名实现类的非匿名对象
		System.out.println("****************");
		USB phone=new USB(){//创建一个符合USB规范的类，本质还是属于computer内部
			public void start() {
				System.out.println("手机1开始工作");
			}		
			public void stop() {
				System.out.println("手机1停止工作");
			}
		};
		computer.transferData(phone);
		//创建接口的匿名实现类的匿名对象
		System.out.println("***********************");
		computer.transferData(new USB() {
			public void start() {
				System.out.println("手机2开始工作");
			}		
			public void stop() {
				System.out.println("手机2停止工作");
			}
		});
	}
}

interface USB{//定义规范
	void start();
	
	void stop();

}

class Computer{
	public void transferData(USB usb) {//多态
		usb.start();
		
		System.out.println("开始传输数据");
		
		usb.stop();
	}
}

class Flash implements USB{

	@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println("U盘开启工作");
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		System.out.println("U盘结束工作");
	}
	
}

class Printer implements USB{
	@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println("打印机开启工作");
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		System.out.println("打印机结束工作");
	}
}
