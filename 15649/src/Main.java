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
		
		f();
	}

	static void f() {
		if(arr.size() == M)
		{
			for(int x : arr)
				System.out.print(x + " ");
			System.out.println();
			return;
		}
		for(int i=1; i<=N; i++)
		{
			if(visit[i] == 0)
			{
				visit[i] = 1;
				arr.add(i);
				f();
				arr.remove(arr.size()-1);
				visit[i] = 0;
			}
		}
	}
}
