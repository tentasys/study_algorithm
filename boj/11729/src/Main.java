//참고 : https://shoark7.github.io/programming/algorithm/tower-of-hanoi
import java.io.*;
public class Main {
	public static int count = 0;
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		sb.append((int)Math.pow(2, N)-1+"\n");
		hanoi(N, 1, 3, 2);
		
		System.out.println(sb);
	}
	public static void hanoi(int n, int from, int dest, int via) {
		if(n == 1) {
			move(n, from, dest);		
		}
		else {
			hanoi(n-1, from, via, dest);
			move(n, from, dest);
			hanoi(n-1, via, dest, from);
		}
	}
	
	public static void move(int n, int from, int dest) {
		String str = from+" "+dest;
		sb.append(str+"\n");
	}
}