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
		
		//배열 초기화
		for(int i=0; i<N; i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		
		//각 정점마다 완전탐색
		for(int i=0; i<N; i++)
		{
			int visit[] = new int[N];
			Queue<Integer> q = new LinkedList<Integer>();
			
			//초기 진입을 위해 큐에 제공
			for(int j=0; j<N; j++)
				if(arr[i][j] == 1)	q.offer(j);
			
			//큐 돌면서 BFS 수행
			while(!q.isEmpty())
			{
				int temp = q.poll();
				visit[temp] = 1;		//방문 체크
				arr[i][temp] = 1;		//길이 있다고 체크
				
				for(int j=0; j<N; j++)
					if((arr[temp][j] == 1) && (visit[j] == 0))	q.offer(j);
				
			}
		}
		
		//결과 출력
		for(int i=0; i<N; i++)
		{
			for(int j=0; j<N; j++)
				System.out.print(arr[i][j]+" ");
			System.out.println();
		}
		
		br.close();
	}

}
