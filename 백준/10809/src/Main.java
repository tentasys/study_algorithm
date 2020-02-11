import java.io.*;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		int alphabet[] = new int[26];
		
		Arrays.fill(alphabet, -1);
		for(int i=0; i<str.length(); i++)
		{
			char ch = str.charAt(i);
			if(alphabet[ch-'a'] == -1)
				alphabet[ch-'a'] = i;
		}
		
		for(int a : alphabet)
			System.out.print(a+" ");
	}

}
