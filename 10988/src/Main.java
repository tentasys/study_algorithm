import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		int mid = str.length()/2;
		boolean result = true;
		
		for(int i=0; i<mid; i++)
		{
			if(str.charAt(i) != str.charAt(str.length()-1-i))
			{
				result = false;
				break;
			}
		}
		
		if(result == true)
			System.out.print(1);
		else
			System.out.print(0);
	}

}