import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		System.out.println(f(n, k));
	}
	
	public static int f(int n, int k)
	{
		Queue<Integer> q = new LinkedList<Integer>();
		boolean visit[] = new boolean [100001];
		int a = n;
		int arr[] = new int[3];
		int dist[] = new int[100001];
		int min = Integer.MAX_VALUE;
		q.offer(a);
		
		visit[a] = true;
		
		if(n == k)	return 0;
		
		//BFS
		while(!q.isEmpty())
		{
			a = q.poll();
			arr[0] = a+1;
			arr[1] = a-1;
			arr[2] = a*2;	
			
			for(int i=0; i<3; i++)
			{
				if(arr[i]<0 || arr[i]>100000 || visit[arr[i]] == true)
					continue;

				q.offer(arr[i]);
				visit[arr[i]] = true;
				dist[arr[i]] = dist[a]+1;
					
				if((arr[i] == k) && (min > dist[arr[i]]))
					min = dist[arr[i]];
			}
		}
		
		return min;
	}

}
