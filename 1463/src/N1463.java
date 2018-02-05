import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1463 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		
//		2^n-2^(n-2)-2^(n-4)-2^(n-5)-....-2^0

		System.out.println(n);
	}
	
	public int f(int num)
	{
		return num;
	}

}
