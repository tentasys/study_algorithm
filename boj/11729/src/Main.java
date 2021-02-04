import java.io.*;
public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		hanoi(N, 1, 3, 2);
	}
	public static void hanoi(int n, int from, int dest, int via) {
		if(n == 1) {
			move(n, from, dest);
		}
		else {
			hanoi(n-1, from, via, dest);
			move(n, from, dest);
			hanoi(n-1, via, from, dest);
		}
	}
	
	public static void move(int n, int from, int dest) {
		System.out.println(n+"번째 원반 : "+from+"->"+dest);
	}
}