import java.util.*;
import java.io.*;

public class Main {

	static int N, M, D;
	static int max;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		int enemy[] = new int[M];	//�ະ ���� ��
		
		for(int i=0; i<N; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++)
			{
				int temp = Integer.parseInt(st.nextToken());
				if(temp == 1)	enemy[j]++;
			}
		}
		
		max = Integer.MIN_VALUE;
		
		Combination(enemy, new int[3], 0, 0);
		System.out.println(max);
		
		br.close();
	}

	public static void Combination(int[] enemy, int[] arr, int idx, int count) {
		if(count == 3)
		{
			boolean clear[] = new boolean[M];	//������ �� �׾����� Ȯ��
			int sum = 0;
			
			for(int i=0; i<3; i++)
			{
				int cur = arr[i];
				//�� ���� �ִ� ���� ������ ���� �� �ִ�
				if(clear[cur] == false)
				{
					sum += enemy[cur];
					clear[cur] = true;
				}
				
				//�¿�� D-1�Ÿ���ŭ�� üũ
				//��
				for(int j=cur-1; j>cur-D; j--)
				{
					if(j < 0)	break;		//�ٿ����
					if(clear[j] == true)	continue;	//üũ�ѵ��� ��湮 ����
					
					clear[j] = true;
					sum += enemy[j];
				}
				
				//��
				for(int j=cur+1; j<cur+D; j++)
				{
					if(j >= M)	break;		//�ٿ����
					if(clear[j] == true)	continue;	//üũ�ѵ��� ��湮 ����
					
					clear[j] = true;
					sum += enemy[j];
				}
			}
			
			max = Math.max(max, sum);
			
			return;
		}
		for(int i=idx; i<M; i++)
		{
			arr[count] = i;
			Combination(enemy, arr, i+1, count+1);
		}
	}
}
