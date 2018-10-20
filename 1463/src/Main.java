import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int MIN = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(bf.readLine());
		
		f(num, 0);
		
		System.out.println(MIN);
	}

	public static void f(int num, int count) {
		if(count >= MIN)
			return;
		if(num == 1)
		{
			if(count < MIN)	MIN = count;
			return;
		}	
		if(num %3 == 0)
			f(num/3, count+1);
		if(num %2 == 0)
			f(num/2, count+1);
		f(num-1, count+1);
	}
}
