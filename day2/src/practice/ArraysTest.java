package practice;

import java.util.Arrays;

/*
 * java.util.Arrays:操作数组的工具类
 */
public class ArraysTest {
	public static void main(String[] args) {
		int[] arr1=new int[] {1,2,3,4,5};
		int[] arr2=new int[] {1,6,3,8,4,9
				};
		boolean isEquals=Arrays.equals(arr1, arr2);
		System.out.println(isEquals);
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));
//		Arrays.fill(arr2, 10);
//		System.out.println(Arrays.toString(arr2));
		Arrays.sort(arr2);
		System.out.println(Arrays.toString(arr2));
		int index=Arrays.binarySearch(arr2,10);
		if(index>=0)
			System.out.println(index);
		else
			System.out.println("没找到");
	}
}
