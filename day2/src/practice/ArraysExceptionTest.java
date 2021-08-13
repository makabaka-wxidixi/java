package practice;
/*
 * 数组中的常见异常：
 * 1，数组角标越界的异常：ArraysIndexOutOfBoundsException
 * 
 * 2，空指针异常：NullPointerException 
 */
public class ArraysExceptionTest {
	public static void main(String[] args) {
//		1，数组数组角标越界的常见异常
		int[] arr = new int[] {1,2,3,4,5,6};
		for(int i=0;i<=arr.length;i++) {
			System.out.println(arr[i]);
		}
		
		System.out.println(arr[-1]);
//		2，空指针异常
//		情况1；
		int[] arr1=new int[] {1,2,3};
		arr1=null;
		System.out.println(arr1[0]);
		
//		情况2:
		int[][] arr2=new int[4][];
		System.out.println(arr2[0][0]);
		
//		情况3：
		String[] arr3=new String[] {"a","b","c"};
		arr3[1]=null;
		System.out.println(arr3[1].toString());
	}
}
