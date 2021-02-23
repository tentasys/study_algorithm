import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Node> list = new ArrayList<Node>();
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			list.add(new Node(x, y));
		}
		
		Collections.sort(list);
		
		StringBuilder sb = new StringBuilder();
		
		for(Node a : list) {
			sb.append(a.x+" "+a.y+"\n");
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		bw.flush();
	}

}

class Node implements Comparable<Node>{
	int x;	int y;

	Node(int x, int y){
		this.x = x;	this.y = y;
	}
	
	@Override
	public int compareTo(Node o) {
		if(this.y == o.y)
			return this.x-o.x;
		else
			return this.y-o.y;
	}
}