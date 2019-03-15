import java.util.*;
import java.io.*;

public class Main {

	static int visit[];
	static int N, M;
	static ArrayList<Integer> arr = new ArrayList<Integer>();;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		visit = new int[N+1];
		
		f(0);
	}

	static void f(int n) {
		if(arr.size() == M)
		{
			for(int x : arr)
				System.out.print(x + " ");
			System.out.println();
			return;
		}
		for(int i=n+1; i<=N; i++)	//순열과 다른 부분
		{
			if(visit[i] == 0)
			{
				visit[i] = 1;
				arr.add(i);
				f(i);
				arr.remove(arr.size()-1);
				visit[i] = 0;
			}
		}
	}
}
