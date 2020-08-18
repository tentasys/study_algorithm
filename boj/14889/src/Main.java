import java.util.*;
import java.io.*;

public class Main {
	
	static int S[][];			//�ɷ�ġ ���� ����
	static int N;				//��� ��
	static boolean visit[];		//����Ž���� ���� �湮 ���θ� üũ�� �迭
	static int min = Integer.MAX_VALUE;	//������ �ּҰ��� üũ�� ����

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		//�ʱ�ȭ �� ����
		N = Integer.parseInt(br.readLine());
		S = new int[N][N];
		visit = new boolean[N];
		
		//�Է� �ޱ�
		for(int i=0; i<N; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++)
				S[i][j] = Integer.parseInt(st.nextToken());
		}
		
		ArrayList<Integer> start = new ArrayList<Integer>();
		DFS(0, 0, start);
		
		System.out.print(min);
		br.close();
	}

	//����Ž�� �Լ�
	public static void DFS(int count, int idx, ArrayList<Integer> start)		//n�� N�� �ƴ� ��쿡 ���� �۵�
	{
		//�� ���ϱ�
		if(count == N/2)
		{
			ArrayList<Integer> link = new ArrayList<Integer>();		//��ũ�� �迭 ����
			
			//���鼭 ��ŸƮ�� �ƴѾֵ��� ��ũ���ٰ� �߰�
			for(int i=0; i<N; i++)
			{
				if(visit[i] == false)
					link.add(i);
			}
			
			int start_sum = 0;
			int link_sum = 0;
			
			for(int i=0; i<start.size(); i++)
			{
				for(int j=i+1; j<start.size(); j++)
				{
					start_sum += S[start.get(i)][start.get(j)];
					start_sum += S[start.get(j)][start.get(i)];
					link_sum += S[link.get(i)][link.get(j)];
					link_sum += S[link.get(j)][link.get(i)];
				}
			}
			
			min = Math.min(min, Math.abs(start_sum-link_sum));
			return;
		}
		
		//���� ���ϱ�
		for(int i=idx; i<N; i++)
		{
			if(visit[i] == false)
			{
				visit[i] = true;					//�湮 üũ
				start.add(i);						//��ŸƮ���� �߰�
				DFS(count+1, i+1, start);					//Ž��
				start.remove(start.size()-1);
				visit[i] = false;
			}
		}

	}
}
