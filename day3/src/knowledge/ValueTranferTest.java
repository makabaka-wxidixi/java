package knowledge;
/*
 * 方法的形参的传递机制：值传递
 * 
 * 1.形参：方法定义时，声明的小括号内的参数
 *   实参：方法调用时，实际传递给形参的数据
 *   
 * 2.值传递机制：
 * 如果参数是基本数据类型，此时实参赋给形参的是实参真实存储的数据值
 * 如果参数是引用数据类型，此时实参赋给形参的是实参存储数据的地址值
 * 
 */
public class ValueTranferTest {
	public static void main(String[] args) {
		System.out.println("*********基本数据类型*********");
		int m=10;
		int n=20;
		System.out.println("m="+m+",n="+n);
		
		ValueTranferTest test=new ValueTranferTest();
		test.swap(n,m);
		System.out.println("m="+m+",n="+n);
		System.out.println("*********引用数据类型*********");
		int[] arr= {1,2,3,2,6,3,8,0,3};
		for(int i=0;i<arr.length-1;i++) {
			for(int j=0;j<arr.length-1-i;j++) {
				if(arr[j]<arr[j+1]) {
					test.swap1(arr, j, j+1);//传递参数的时候，传的是实体的地址，直接在实体内进行操作				
				}
			}
		}
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		
	}
	
	public void swap(int n,int m) {
		int tmp=n;
		n=m;
		m=tmp;
	}
	public void swap1(int[] arr,int i,int j) {
		int tmp=arr[i];
		arr[i]=arr[j];
		arr[j]=tmp;
	}
}
