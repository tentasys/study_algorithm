import java.io.*;

//StringBuilder�� ó���Ѵ����� ����ϴ°��� �׳� ��¥�� ����ϴ°ͺ��� �ξ� ������!
//->����� ������ ���� ����

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
