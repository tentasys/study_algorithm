import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		int arr[] = new int[10];
		int input[] = new int[n+1];
		
		for(int i=1; i<n+1; i++)
			input[i] = Integer.parseInt(br.readLine().trim());
		
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 4;
		
		for(int i=3; i<10; i++)
			arr[i] = arr[i-1] + arr[i-2] + arr[i-3];
		
		for(int i=1; i<n+1; i++)
			System.out.println(arr[input[i]-1]);
	}

}
