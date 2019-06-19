import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		StringBuilder star = new StringBuilder();
		StringBuilder space = new StringBuilder();
		StringBuilder result = new StringBuilder();
		
		for(int i=0; i<num; i++)
			space.append(" ");
		
		//char[]�� stringó�� ����� �����ϴ�! �迭ó�� ���� ������
		
		for(int i=1; i<=num; i++)
		{
			star.append("*");
			if(space.length() > 0)
				space.deleteCharAt(0);
			result.append(space).append(star).append("\n");
		}
		
		System.out.print(result);
		
		br.close();
	}

}