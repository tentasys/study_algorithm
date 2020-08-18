import java.io.*;

//StringBuilder로 처리한다음에 출력하는것이 그냥 생짜로 출력하는것보다 훨씬 빠르다!
//->출력은 굉장히 느린 연산

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i=1; i<=N; i++)
			sb.append(i+"\n");
		
		System.out.print(sb);
		br.close();
	}

}
