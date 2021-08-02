import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true)
		{
			String str = br.readLine();
			if(str.compareTo(".") == 0)
				break;
			
			boolean result = true;
			Stack<Character> stack = new Stack<Character>();
			
			char arr[] = str.toCharArray();
			
			for(char c : arr)
			{
				if(c == '(' || c == '[')
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
				else if(c == ']')
				{
					if(stack.isEmpty() == true)
					{
						result = false;
						break;
					}
					if(stack.pop() != '[')
					{
						result = false;
						break;
					}
				}
			}
			
			if(!stack.isEmpty())	result = false;   //처음에 이부분을 빠뜨렸다. 그래서 ( 이 케이스를 못잡았다. 
			
			if(result == true)	sb.append("yes\n");
			else				sb.append("no\n");
		}
		
		System.out.println(sb.toString());
	}

}
