package knowledge;

public class ArrayUtilTest {
	public static void main(String[] args) {
		int[] arr= {3,2,5,7,1,22,45,12,42,22};
		ArrayUtil util=new ArrayUtil();//类的实例化
		
		util.print(arr);//打印数组
		
		int max=util.maxNumber(arr);
		System.out.println("数组最大值为："+max);
		
		int min=util.minNumber(arr);
		System.out.println("数组最小值为："+min);
		
		util.flipArray(arr);//反转数组
		util.print(arr);//打印翻转之后的数组
		
		util.sortArray(arr);//排序数组
		util.print(arr);//打印排序之后的数组
		
		int add=util.add(arr);//找和
		System.out.println("数组总和为："+add);
		
		double average=util.averageValue(arr);
		System.out.println("平均数为："+average);
		
		util.print(arr);//打印数组
		int ret=util.search(arr, 20);
		if(ret>0)
			System.out.println("找到了，索引为："+ret);
		else 
			System.out.println("未找到");
	}
}
