import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int ii=1; ii<T; ii++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			String str = br.readLine();
			
			for(int i=0; i<K; i++)
			{
				char ch = (char) (i + 'a');
				st = new StringTokenizer(br.readLine());
				int temp_insert = Integer.parseInt(st.nextToken());
				int temp_revome = Integer.parseInt(st.nextToken())
				
				 
			}
			
			System.out.println("#"+" "+ii);
		}
		
		br.close();
	}

}

class Alphabet{
	char alpahbet;
	int insert;
	int remove;
	
	Alphabet(char ch, int num, int num1){
		this.alpahbet = ch;
		this.insert = num;
		this.remove = num1;
	}
}