import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		while(true)
		{			
			System.out.print(str);
			str = br.readLine();
			
			if(str == null)
				break;
			if(str.length() == 0)		//�ܼ� �Է� �׽�Ʈ��
				break;
			
			System.out.println();
		}
		
		br.close();
	}
}