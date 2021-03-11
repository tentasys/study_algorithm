//중복순열 
import java.io.*;

public class Main {

	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);
		
		f(N, M, 0, new int[M]);
		
		bw.flush();
	}

	public static void f(int N, int M, int count, int[] arr) throws Exception{
		if(count == M) {
			StringBuilder sb = new StringBuilder();
			
			for(int a : arr) {
				sb.append(a+" ");
			}
			
			bw.write(sb.toString()+"\n");
			return;
		}
		for(int i=1; i<=N; i++) {
			arr[count] = i;
			f(N, M, count+1, arr);
		}
	}
}
