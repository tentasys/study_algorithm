import java.util.*;
import java.io.*;

//46�� 44��
public class Main {
	
	static int T[];
	static int P[];
	static int N;
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		T = new int[N];		//���
		P = new int[N];		//�ݾ�
		
		for(int i=0; i<N; i++)
		{
			st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		//---�Է¹ޱ� ��
		
		Function(0, 0);
		
		System.out.println(max);
	}

	static void Function(int idx, int sum) {
		if(idx >= N)
		{
			max = Math.max(sum, max);
			return;
		}
		for(int i=idx; i<N; i++)
		{
			if(i+T[i] <= N)			//�ð����� �ε����� �� �� �ִ�
				Function(i+T[i], sum+P[i]);
			else
				Function(i+T[i], sum);
		}
	}
}
