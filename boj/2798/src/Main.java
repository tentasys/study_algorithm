import java.io.*;
import java.util.*;
public class Main {

	public static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int arr[] = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		go(0, 0, arr, M, 0);
		
		System.out.println(max);
	}
	
	public static void go(int idx, int sum, int[] arr, int M, int count) {
		if(count == 3) {
			if(max <= M)	max = Math.max(sum, max);
			return;
		}
		
		for(int i=idx; i<arr.length; i++) {
			if(sum+arr[i] > M)	continue;
			go(i+1, sum+arr[i], arr, M, count+1);
		}
	}
}