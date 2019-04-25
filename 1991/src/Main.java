import java.io.*;
import java.util.*;

public class Main {

	static Node Tree[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Tree = new Node[N];
		for(int i=0; i<N; i++)
		{
			Tree[i] = new Node((char)('A'+i));
		}
		
		for(int i=0; i<N; i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			char name = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			
			Tree[name-'A'].left = left;
			Tree[name-'A'].right = right;
		}
		
		Preorder(Tree[0]);
		System.out.println();
		Inorder(Tree[0]);
		System.out.println();
		Postorder(Tree[0]);
		
		br.close();
	}
	
	static void Preorder(Node cur)
	{
		System.out.print(cur.name);
		
		if(cur.left != '.')
			Preorder(Tree[cur.left-'A']);
		if(cur.right != '.')
			Preorder(Tree[cur.right-'A']);
	}
	
	static void Inorder(Node cur)
	{		
		if(cur.left != '.')
			Inorder(Tree[cur.left-'A']);
		System.out.print(cur.name);
		if(cur.right != '.')
			Inorder(Tree[cur.right-'A']);		
	}
	
	static void Postorder(Node cur)
	{		
		if(cur.left != '.')
			Postorder(Tree[cur.left-'A']);
		if(cur.right != '.')
			Postorder(Tree[cur.right-'A']);	
		System.out.print(cur.name);
	}
}

class Node{
	char name;
	char left;
	char right;
	
	Node(){};
	Node(char name)
	{
		this.name = name;
		this.left = 0;
		this.right = 0;
	}
}