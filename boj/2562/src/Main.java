import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int max = Integer.MIN_VALUE;
		int max_idx = -1;
		
		for(int i=1; i<=9; i++) {
			int n = Integer.parseInt(br.readLine());
			if(max < n) {
				max = n;
				max_idx = i;
			}
		}
		
		System.out.println(max);
		System.out.println(max_idx);
	}

}