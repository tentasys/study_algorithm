import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int C = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < C; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());

			int arr[] = new int[N];
			int sum = 0;

			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				sum += arr[i];
			}
			
			int count = 0;
			double avg = (double)sum / (double)N;
			
			for(int i=0; i<N; i++) {
				if(arr[i] > avg)	count++;
			}
			
			//비율 계산 시작
			double ratio = ((double)count / (double)N)*100;
			ratio *= 1000;		//소수점 셋재짜리까지 출력하기 위함
			long tmp = Math.round(ratio);
		
			String str = String.format("%.3f", (double)tmp/(double)1000);
			System.out.println(str+"%");
		}
	}
}