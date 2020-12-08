import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String str = br.readLine();
		StringBuilder sb = new StringBuilder();

		while(str != null) {
			try {
				st = new StringTokenizer(str);
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				
				sb.append(A+B);
				sb.append("\n");
				str = br.readLine();
				
			}catch(Exception e)
			{
				break;
			}
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		bw.flush();
	}
}