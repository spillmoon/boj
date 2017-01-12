import java.util.Scanner;

public class BOJ1912 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		
		int[] arr = new int[size];
		int[] result = new int[size];
		
		BOJ1912 test = new BOJ1912();
		
		for(int i=0; i<size; i++){
			arr[i] = sc.nextInt();
			result[i] = 0;
		}
		
		System.out.println(test.findMaxSum(arr, result));

	}
	
	public int findMaxSum(int[] arr, int[] result){
		result[0] = arr[0];
		int max = result[0];
		
		for(int i=1; i<arr.length; i++){
			result[i] = Math.max(arr[i], arr[i]+result[i-1]);
            max = Math.max(max, result[i]);
		}
		return max;
	}
}
