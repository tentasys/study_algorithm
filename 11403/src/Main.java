import java.util.StringTokenizer;
import java.util.Queue;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int arr[][] = new int[N][N];
		
		//�迭 �ʱ�ȭ
		for(int i=0; i<N; i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		
		//�� �������� ����Ž��
		for(int i=0; i<N; i++)
		{
			int visit[] = new int[N];
			Queue<Integer> q = new LinkedList<Integer>();
			
			//�ʱ� ������ ���� ť�� ����
			for(int j=0; j<N; j++)
				if(arr[i][j] == 1)	q.offer(j);
			
			//ť ���鼭 BFS ����
			while(!q.isEmpty())
			{
				int temp = q.poll();
				visit[temp] = 1;		//�湮 üũ
				arr[i][temp] = 1;		//���� �ִٰ� üũ
				
				for(int j=0; j<N; j++)
					if((arr[temp][j] == 1) && (visit[j] == 0))	q.offer(j);
				
			}
		}
		
		//��� ���
		for(int i=0; i<N; i++)
		{
			for(int j=0; j<N; j++)
				System.out.print(arr[i][j]+" ");
			System.out.println();
		}
		
		br.close();
	}

}
