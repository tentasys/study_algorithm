import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		int arr[] = new int[42];
		String result[] = new String[T];
		
		arr[0] = arr[2] = 1;
		arr[1] = 0;
		
		for(int i=3; i<42; i++)
		{
			arr[i] = arr[i-1] + arr[i-2];
		}
		
		for(int i=0; i<T; i++)
		{
			int n = Integer.parseInt(br.readLine().trim());
			result[i] = Integer.toString(arr[n]) + " " + Integer.toString(arr[n+1]);
		}
		
		for(int i=0; i<T; i++)
			System.out.println(result[i]);
	}

}
