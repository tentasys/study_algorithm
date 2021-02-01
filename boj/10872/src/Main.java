import java.io.*;
public class Main {

	public static int factorial[] = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		bw.write(Integer.toString(factorial[N]));
		bw.flush();
	}

	//팩토리얼 구하는 재귀함수
//	public static int factorial(int N) {
//		if(N == 0)
//			return 1;
//		else
//			return N * factorial(N-1);
//	}
}