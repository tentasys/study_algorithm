import java.io.*;
public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int i = N/5;
		int result = -1;
		
		while(i>=0)	//5kg ������ �ִ�� ��� �ͺ��� ����
		{
			int temp = N;
			temp -= i*5;			//5kg�� ����ִ°͸�ŭ ����
			if(temp%3 == 0)
			{
				result = i+(temp/3);
				break;
			}
			i--;
		}	
		System.out.println(result);
	}
}