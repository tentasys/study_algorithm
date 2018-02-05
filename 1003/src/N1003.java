import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class N1003 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		ArrayList <Integer> arr = new ArrayList<Integer>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Integer n = Integer.parseInt(br.readLine().trim());
		
		for(int i=0; i!=n; i++)
		{
			int num = Integer.parseInt(br.readLine().trim());
			arr.add(num);
		}
		
		for(Integer calc : arr)
		{
			if(calc == 0)
				System.out.print("1" + " ");
			else
				System.out.print(f(calc-1) + " ");
			System.out.println(f(calc)+" ");
		}
	}
	
	public static int f(int num)
	{
		if (num == 0)
	        return 0;
	    else if (num == 1)
	        return 1;
	    else
	        return f(num-1) + f(num-2);
	}

}
