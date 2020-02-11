import java.io.*;

public class Main {

	static Node root = null;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//Ʈ���� ����
		while(true)
		{
			//�Է¹ޱ�	
			String str = br.readLine();
			if(str == null)
				break;
			if(str.length() == 0)
				break;
			
			int val = Integer.parseInt(str);
			
			//root ����
			if(root == null)
			{
				root = new Node(val);
				continue;
			}
			
			Node cur = root;
			
			//�Է� ������ Ʈ�� ����
			while(true)
			{
				if(val < cur.num)
				{
					if(cur.left == null)
					{
						cur.left = new Node(val);
						break;
					}
					else
						cur = cur.left;
				}
				else
				{
					if(cur.right == null)
					{
						cur.right = new Node(val);
						break;
					}
					else
						cur = cur.right;
				}
			}
		}
		
		Postorder(root);
	}

	static void Postorder(Node cur)
	{	
		if(cur.left != null)
			Postorder(cur.left);
		if(cur.right != null)
			Postorder(cur.right);
		System.out.println(cur.num);
	}
}

class Node
{
	int num;
	Node left;
	Node right;
	
	Node(){};
	Node(int n)
	{
		this.num = n;
		this.left = null;
		this.right = null;
	}
}