import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());	//�� ũ��
		int M = Integer.parseInt(st.nextToken());	//�ʱ� ���� ��
		int K = Integer.parseInt(st.nextToken());	//�� ��
		
		int A[][] = new int[N][N];			//������ ���
		int map[][] = new int[N][N];		//������ ������
		
		//��� �Է¹ޱ�
		for(int i=0; i<N; i++)
		{
			st = new StringTokenizer(br.readLine());
			Arrays.fill(map[i], 5); 		//����� ó���� 5�� �ʱ�ȭ�Ǿ��ִ�
			
			for(int j=0; j<N; j++)			//������� �Է�
				A[i][j] = Integer.parseInt(st.nextToken());
		}
		
		//���� �Է¹ޱ�
		ArrayList<Tree> temp_list = new ArrayList<Tree>();
		
		for(int i=0; i<M; i++)
		{
			st = new StringTokenizer(br.readLine());

			int temp_r = Integer.parseInt(st.nextToken())-1;
			int temp_c = Integer.parseInt(st.nextToken())-1;
			int temp_age = Integer.parseInt(st.nextToken());
			
			temp_list.add(new Tree(temp_r, temp_c, temp_age));
		}
		//----�Է� ��	
		
		//���̼� ����
		Collections.sort(temp_list, new Ascending());
		
		Deque<Tree> list = new LinkedList<Tree>();		//��
		for(Tree t : temp_list)
		{
			list.addLast(t);
		}
		
		//�ùķ��̼� ����
		int years = 0;
		while(years < K)
		{	
			Deque<Tree> next_list = new LinkedList<Tree>();		//���߿� �����ϱ� ����
			Queue<Tree> drop_list = new LinkedList<Tree>();
			
			//��
			while(!list.isEmpty())
			{
				Tree temp = list.pollFirst();	//���� ����� ����
				
				if(map[temp.r][temp.c] < temp.age)		//���� ���� ����� ���̺��� ���ٸ�
				{
					drop_list.add(temp);	//���� ����Ʈ�� ����
				}
				else
				{
					map[temp.r][temp.c] -= temp.age;	//��� ����
					temp.age++;
					next_list.addLast(temp); 			//Ʈ�� ����Ʈ�� �߰�
				}
			}
			////////////////////////////////////////////////////////////////////////////////////
			//����
			while(!drop_list.isEmpty())
			{
				Tree temp = drop_list.poll();		//������	
				map[temp.r][temp.c] += temp.age/2;	//��� �߰�
			}
			
			////////////////////////////////////////////////////////////////////////////////////
			//����
			
			int dr[] = {-1, -1, -1, 0, 0, 1, 1, 1};
			int dc[] = {-1, 0, 1, -1, 1, -1, 0, 1};

			while(!next_list.isEmpty())
			{
				Tree cur = next_list.pollFirst();
				
				if(cur.age %5 == 0)	//5�� ����̸� ����
				{
					for(int j=0; j<8; j++)	//8�������� ����
					{
						int dest_r = cur.r+dr[j];
						int dest_c = cur.c+dc[j];
						
						if(dest_r < 0 || dest_c < 0 || dest_r >= N || dest_c >= N)
							continue;
						
						list.addFirst(new Tree(dest_r, dest_c, 1));		//���� �߰�
					}
				}
				
				list.addLast(cur); 		//�׳� ������ �ǵڿ��ٰ� �ִ´�
 			}
			
			////////////////////////////////////////////////////////////////////////////////////
			//�ܿ�
			for(int i=0; i<N; i++)
			{
				for(int j=0; j<N; j++)
					map[i][j] += A[i][j];		//������ ��� �߰�
			}
			
			years++;
		}
		
		System.out.println(list.size());
	}

}

class Tree implements Comparable<Tree>{
	int r;	int c;	int age;
	Tree(){};
	Tree(int r, int c, int age)
	{
		this.r = r;	this.c = c;	this.age = age;
	}
	
	@Override
	public int compareTo(Tree o)
	{
		return this.age-o.age;
	}
}

//���̼����� ����
class Ascending implements Comparator<Tree>{

	@Override
	public int compare(Tree arg0, Tree arg1) {
		return arg0.compareTo(arg1);
	}
}