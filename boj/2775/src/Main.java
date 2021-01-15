import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		int arr[][] = new int[15][15];
		
		for(int i=0; i<=14; i++) {
			arr[0][i] = i;
			arr[i][1] = 1;
		}
		
		//층 
		for(int i=1; i<=14; i++) {
			//호 
			for(int j=2; j<=14; j++) {
				arr[i][j] = arr[i-1][j] + arr[i][j-1]; 
			}
		}
		
		for(int ii=0; ii<tc; ii++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			
			System.out.println(arr[k][n]);
		}
	}

}
