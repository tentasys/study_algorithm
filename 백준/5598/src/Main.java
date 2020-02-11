import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder after = new StringBuilder();
		String before = br.readLine();
		
		for(int i=0; i<before.length(); i++)
		{
			char ch = before.charAt(i);
			if(ch < 'D')
			{
				after.append((char)(ch+23));
			}
			else
				after.append((char)(ch-3));
		}
		
		System.out.print(after);
	}

}