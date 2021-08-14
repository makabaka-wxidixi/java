package knowledge;

public class ArrayUtil {
	//打印数组
	public void print(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
			System.out.println();
	}
	//求数组最大值
	public int maxNumber(int[] arr) {
		if(arr.length==0)	return -999;
		int max=0;
		for(int i=0;i<arr.length;i++) {
			if(i==0)	max=arr[i];
			else {
				if(max<arr[i])
					max=arr[i];
			}
		}
		return max;
	}
	//求数组最小值
	public int minNumber(int[] arr) {
		if(arr.length==0)	return -999;
		int min=0;
		for(int i=0;i<arr.length;i++) {
			if(i==0)	min=arr[i];
			else {
				if(min>arr[i])
					min=arr[i];
			}
		}
		return min;
	}
	//将数组排序
	public void sortArray(int[] arr) {
		if(arr.length==0)	System.out.println("数组长度为0");
		for(int i=0;i<arr.length-1;i++) {
			for(int j=0;j<arr.length-1-i;j++) {
				if(arr[j]<arr[j+1]) {
					int tmp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=tmp;
				}
			}
		}
	}
	
	//求数组平均值
	public double averageValue(int[] arr) {
		int sub=0;
		for(int i=0;i<arr.length;i++) {
			sub+=arr[i];
		}
		return (double)sub/arr.length;
	}
	
	//反转数组
	public void flipArray(int[] arr) {
		for(int i=0;i<arr.length/2;i++) {
			int tmp=arr[i];
			arr[i]=arr[arr.length-1-i];
			arr[arr.length-1-i]=tmp;
		}
	}
	
	//查找指定元素
	public int search(int[] arr,int dest) {
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==dest) {
				return i;
			}
		}
		return -1;//索引，返回负数就是没找到
	}
	
	public int add(int[] arr) {
		int add=0;
		for(int i=0;i<arr.length;i++) {
			add+=arr[i];
		}
		return add;
	}
}
