import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String st = br.readLine();
		String str = st.toUpperCase();
		int alphabet[] = new int[26];
		
		for(int i=0; i<str.length(); i++)
			alphabet[str.charAt(i)-'A']++;
		
		int max = Integer.MIN_VALUE;
		char max_char = '0';
		boolean flag = false;
		
		for(int i=0; i<26; i++)
		{
			if(max < alphabet[i])
			{
				flag = false;
				max = alphabet[i];
				max_char = (char)(i+'A');
			}
			else if(max == alphabet[i])
			{
				flag = true;
			}
		}
		
		if(flag == true)
			System.out.print("?");
		else
			System.out.print(max_char);
	}
}