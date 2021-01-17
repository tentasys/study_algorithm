import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			
			int floor = N%H;
			int room = N/H + 1;
			
			StringBuilder sb = new StringBuilder();
			if(floor == 0) {
				sb.append(H);
				room--;
			}
			else
				sb.append(floor);
			
			if(room < 10)
				sb.append("0");
			sb.append(room);
			
			System.out.println(sb);
		}
	}
}