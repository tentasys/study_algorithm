//참고 : https://mathbang.net/101
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x[] = new int[3];
			int y[] = new int[3];
			
			x[0] = Integer.parseInt(st.nextToken());
			x[1] = Integer.parseInt(st.nextToken());
			x[2] = Integer.parseInt(st.nextToken());
			
			y[0] = Integer.parseInt(st.nextToken());
			y[1] = Integer.parseInt(st.nextToken());
			y[2] = Integer.parseInt(st.nextToken());
			
			double add = x[2] + y[2];
			double sub = Math.abs(x[2]-y[2]);		
			double dist = Math.sqrt(Math.pow(x[0]-y[0], 2)+Math.pow(x[1]-y[1], 2));
			
			if(dist == 0) {
				if(x[2] == y[2])
					System.out.println(-1);
				else
					System.out.println(0);
			}
			else {
				//외접 
				if(sub < dist && dist < add)
					System.out.println(2);
				//내접 
				else if(sub == dist || add == dist)
					System.out.println(1);
				else 
					System.out.println(0);
			}				
		}
	}
}