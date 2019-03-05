import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Integer N = Integer.parseInt(br.readLine());
		int arr[] = new int[N+1];
		int sum[] = new int[N+1];
		
		for(int i=1; i<=N; i++)
			arr[i] = Integer.parseInt(br.readLine());
		
		sum[1] = arr[1];
		sum[2] = arr[2]+arr[1];
		
		for(int i=3; i<=N; i++)
			sum[i] = Math.max(sum[i-2]+arr[i], sum[i-3]+arr[i-1]+arr[i]);

		System.out.println(sum[N]);
	}

}
