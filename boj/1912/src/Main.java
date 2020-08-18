import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		int dp[] = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++)			//�迭�� ���ֱ�
			arr[i] = Integer.parseInt(st.nextToken());
		
		int max = dp[0] = arr[0];		//���� �ִ밪
		
		for(int i=1; i<N; i++)
		{
			if(dp[i-1] < 0)		//���� ����
				dp[i] = arr[i];
			else
				dp[i] = dp[i-1] + arr[i];
			max = Math.max(max, dp[i]);
		}
		System.out.print(max);
	}
}
