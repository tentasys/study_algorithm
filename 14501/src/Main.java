import java.util.*;
import java.io.*;

//46분 44초
public class Main {
	
	static int T[];
	static int P[];
	static int N;
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		T = new int[N];		//상담
		P = new int[N];		//금액
		
		for(int i=0; i<N; i++)
		{
			st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		//---입력받기 끝
		
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
			if(i+T[i] <= N)			//시간값을 인덱스로 줄 수 있다
				Function(i+T[i], sum+P[i]);
			else
				Function(i+T[i], sum);
		}
	}
}
