import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		double arr[] = new double[N];
		double max = Double.MIN_VALUE;
		
		for(int i=0; i<N; i++) {
			arr[i] = (double)(Integer.parseInt(st.nextToken()));
			max = Math.max(arr[i], max);
		}
		
		double total = 0;
		for(int i=0; i<N; i++) {
			arr[i] = (arr[i]/max)*100;
			total += arr[i];
		}
		
		System.out.println(total/N);
	}
}