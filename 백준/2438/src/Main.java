import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i=1; i<=num; i++)
		{
			for(int j=0; j<i; j++)
				sb.append("*");		//2������ ���� ��Ʈ�������� �ϳ� �� ���� 1���������� �ذ� �����ϴ�
			sb.append("\n");
		}
		
		System.out.print(sb);
		
		br.close();
	}

}
