import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
	
		for(int ii=0; ii<N; ii++)
		{
			String str = br.readLine();
			
			boolean result = true;
			Stack<Character> stack = new Stack<Character>();
			
			char arr[] = str.toCharArray();
			
			for(char c : arr)
			{
				if(c == '(')
					stack.push(c);
				else if(c == ')')
				{
					if(stack.isEmpty() == true)
					{
						result = false;
						break;
					}
					if(stack.pop() != '(')
					{
						result = false;
						break;
					}
				}
			}
			
			if(!stack.isEmpty())	result = false;
			
			if(result == true)	sb.append("YES\n");
			else				sb.append("NO\n");
		}
		
		System.out.println(sb.toString());
	}

}
