import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		
		int [] arr = new int[3];
		arr[0] = (int)Math.pow(2, n-1);
		arr[1] = n >= 2 ? (int)Math.pow(2, n-2) : 0;
		arr[2] = n > 3 ? ((int)Math.pow(2, n-3))-1 : 0;
		
		
		System.out.println((int)(Math.pow(2, n) - (arr[0]+arr[1]+arr[2])));
	}

}
