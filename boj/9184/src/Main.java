import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int arr[][][] = new int[51][51][51];	

		for(int i=0; i<51; i++) {
			for(int j=0; j<51; j++) {
				for(int k=0; k<51; k++) {
					if(i == 0 || j == 0 || k == 0) {
						arr[i][j][k] = 1;
						continue;
					}
					else if(i < j && j < k) {
						arr[i][j][k] = arr[i][j][k-1] + arr[i][j-1][k-1] - arr[i][j-1][k];
					}
					else {
						arr[i][j][k] = arr[i-1][j][k] + arr[i-1][j-1][k] + arr[i-1][j][k-1] - arr[i-1][j-1][k-1];
						//System.out.println(arr[i][j][k]);
					}
				}
			}
		}
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if(a == -1 && b == -1 && c == -1)
				break;
			
			StringBuilder sb = new StringBuilder("w("+a+", "+b+", "+c+") = ");
			
			if(a <= 0 || b <= 0 || c <= 0)
				sb.append(1);
			else 
				sb.append(arr[a][b][c]);
			sb.append("\n");
			
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			bw.write(sb.toString());
			bw.flush();
		}
	}

}
