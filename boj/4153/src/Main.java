import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			if(A == 0 && B == 0 && C == 0)
				break;
			
			int max = Math.max(A, Math.max(B, C));
			int x, y, z;
			
			if(max == A)
			{
				x = B;	y = C;	z = A;
			}
			else if(max == B) {
				x = A;	y = C;	z = B;
			}
			else{
				x = A;	y = B;	z = C; 
			}
			
			if(Math.pow(x, 2)+Math.pow(y, 2) == Math.pow(z, 2))
				System.out.println("right");
			else
				System.out.println("wrong");
		}
	}
}