import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<String> list = new ArrayList<String>();
		
		for(int i=0; i<N; i++)
		{
			String str = br.readLine();
			if(list.contains(str) == false)
				list.add(str);
		}
		
		Collections.sort(list, new Ascending());
		
		StringBuilder sb = new StringBuilder();
		for(String s : list)
		{
			sb.append(s+"\n");
		}
		
		System.out.println(sb.toString());
	}

}

class Ascending implements Comparator<String>{
	@Override
	public int compare(String arg0, String arg1) {
		if(arg0.length() > arg1.length())
			return 1;
		else if(arg0.length() < arg1.length())
			return -1;
		else
			return arg0.compareTo(arg1);
	}
}
