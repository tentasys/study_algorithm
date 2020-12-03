import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int H = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int nM = M-45;
		int nH = H;
		
		if(nM < 0) {
			nM += 60;
			nH--;
		}
		if(nH < 0) {
			nH += 24;
		}
		
		System.out.println(nH+" "+nM);
	}
}