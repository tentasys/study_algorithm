//중복순열 
import java.io.*;

public class Main { 
	static StringBuilder result = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);
		
		f(N, M, 0);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(result.toString());
		bw.flush();
	}

	static StringBuilder sb = new StringBuilder();
	public static void f(int N, int M, int count) throws Exception{
		if(count == M) {
			result.append(sb+"\n");
			return;
		}
		for(int i=1; i<=N; i++) {
			sb.append(i+" ");
			f(N, M, count+1);
			sb.deleteCharAt(sb.length()-1);
			sb.deleteCharAt(sb.length()-1);
		}
	}
}
