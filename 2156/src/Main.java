import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int arr[] = new int[10000];
		int dp[] = new int[10000];
		
		for(int i=0; i<N; i++)
			arr[i] = Integer.parseInt(br.readLine());
		
		//1, 2, 3�϶� ����ó�� ����!
		dp[0] = arr[0];
		dp[1] = arr[1]+arr[0];
		dp[2] = Math.max(dp[1], Math.max(arr[1]+arr[2], arr[0]+arr[2]));	
		
		for(int i=3; i<N; i++)
		{
			//���� �����ָ� �����ϴ� ��� : ���簪  + ������(����-1) + ����-2(����-3)�� �ִ밪
			//���� �����ָ� �������� �ʴ� ��� : ���簪 + ����-2�� �ִ밪
			//�ڽ��� �������� �ʴ� ��� : �������� �ִ밪
			dp[i] = Math.max(arr[i]+arr[i-1]+dp[i-3], Math.max(arr[i]+dp[i-2], dp[i-1]));
		}
		
		System.out.print(dp[N-1]);
	}

}