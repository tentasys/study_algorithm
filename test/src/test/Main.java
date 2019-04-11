package test;
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		String line = br.readLine();
		StringTokenizer st = new StringTokenizer(line);
		
		while(line != null)
		{
			
			st = new StringTokenizer(line);
			while(st.hasMoreTokens())
			{
				System.out.print(Integer.parseInt(st.nextToken()) + " ");
			}
			
			System.out.println();
			line = br.readLine();
		}
		
		br.close();
	}	
}
