import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=K; i++)
		{
			String s1 = br.readLine();
			String s2 = br.readLine();
			
			if(check(s1, s2) == true)
				System.out.println("Data Set "+ i +": "+"equal");
			else
				System.out.println("Data Set "+ i +": "+"not equal");
			
			if(i != K)
				System.out.println();
		}
	}

	static boolean check(String string1, String string2)
	{
		StringTokenizer st1 = new StringTokenizer(string1);
		StringTokenizer st2 = new StringTokenizer(string2);
		
		String s1 = new String(st1.nextToken());
		String s2 = new String(st2.nextToken());
		
		while(st1.hasMoreTokens() == true)
		{
			String concat1 = st1.nextToken();
			
			char ch1 = s1.charAt(s1.length()-1);	//���� ��Ʈ���� ������ ����	
			//���� ��Ʈ���� �� ������ ���ڰ� Ư�����ڶ�� ���� �����ϰ� �ڿ� ���̱�
			if(ch1 == '(' || ch1 == '[' || ch1 == '{' || ch1 == ')' || ch1 == ']' || ch1 == '}' || ch1 == ',' || ch1 == ';')
				s1 = s1 + concat1;
			//���� ������ �� ó���� Ư���� �ִٸ� ���� �����ϰ� �ڿ� ���̱�
			else if(concat1.startsWith("(") || concat1.startsWith("[") || concat1.startsWith("{") || concat1.startsWith(")") || concat1.startsWith("]") || concat1.startsWith("}") || concat1.startsWith(",") || concat1.startsWith(";") || concat1.startsWith(":"))
				s1 = s1 + concat1;
			else
				s1 = s1 + " " + concat1;
			
		}
		
		while(st2.hasMoreTokens() == true)
		{
			String concat2 = st2.nextToken();
			
			char ch2 = s2.charAt(s2.length()-1);	//���� ��Ʈ���� ������ ����	
			//���� ��Ʈ���� �� ������ ���ڰ� Ư�����ڶ�� ���� �����ϰ� �ڿ� ���̱�
			if(ch2 == '(' || ch2 == '[' || ch2 == '{' || ch2 == ')' || ch2 == ']' || ch2 == '}' || ch2 == ',' || ch2 == ';')
				s2 = s2 + concat2;
			//���� ������ �� ó���� Ư���� �ִٸ� ���� �����ϰ� �ڿ� ���̱�
			else if(concat2.startsWith("(") || concat2.startsWith("[") || concat2.startsWith("{") || concat2.startsWith(")") || concat2.startsWith("]") || concat2.startsWith("}") || concat2.startsWith(",") || concat2.startsWith(";") || concat2.startsWith(":"))
				s2 = s2 + concat2;
			else
				s2 = s2 + " " + concat2;
			
		}
		
		st1 = new StringTokenizer(s1);
		st2 = new StringTokenizer(s2);
		
		while(st1.hasMoreTokens() == true)
		{
			String temp1 = st1.nextToken();
			String temp2 = st2.nextToken();
			
			for(int i=0; i<temp1.length(); i++)
			{
				char ch1 = temp1.charAt(i);
				char ch2 = temp2.charAt(i);
				
				//���°�ȣ
				if(ch1 == '(' || ch1 == '[' || ch1 == '{')
				{
					if(ch2 == '(' || ch2 == '[' || ch2 == '{')
						continue;
					else
						return false;
				}
				//�ݴ°�ȣ
				else if(ch1 == ')' || ch1 == ']' || ch1 == '}')
				{
					if(ch2 == ')' || ch2 == ']' || ch2 == '}')
						continue;
					else
						return false;
				}
				//��ǥ�� �����ݷ�
				else if(ch1 == ',' || ch1 == ';')
				{
					if(ch2 == ',' || ch2 == ';')
						continue;
					else
						return false;
				}
				//���ĺ�
				else if((ch1 >= 'a' && ch1 <= 'z') || (ch1 >= 'A' && ch1 <= 'Z'))
				{
					if(ch1 == ch2)
						continue;
					else if(Math.abs(ch1-ch2) == Math.abs('A'-'a'))
						continue;
					else
						return false;
				}
				//��ħǥ�� �ݷ�, ����
				else
				{
					if(ch1 == ch2)
						continue;
					else
						return false;
				}
			}
		}
		
		return true;
	}
	
}
