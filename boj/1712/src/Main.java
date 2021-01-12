import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		if(C-B <= 0)
			System.out.println(-1);
		else {
			double num = (double)A/(double)(C-B);
			System.out.println((int)(num+1));
		}
	}
}