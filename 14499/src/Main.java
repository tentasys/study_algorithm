import java.util.*;
import java.io.*;

//49�� 39��
public class Main {

	static int N, M;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int map[][] = new int[N][M];		//����
		
		for(int i=0; i<N; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int op[] = new int[K];	//���
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<K; i++)
			op[i] = Integer.parseInt(st.nextToken());
		//------------�Է� �Ϸ�
		
		Dice dice = new Dice(0, 0, 0, 0, 0, 0);		//�ֻ��� ����� �ʱ�ȭ
		
		//��ɴ��!
		for(int i=0; i<K; i++)
		{
			if(isAble(x, y, op[i]) == false)	continue;	//�Ұ����� ��� ����
			
			dice.roll(op[i]);	//�ֻ��� ������
			
			//��ǥ �̵�(���»��� ��)
			if(op[i] == 1)	y++;	else if(op[i] == 2)	y--;	else if(op[i] == 3)	x--;	else x++;
			
			//�ظ�� ���� ��
			if(map[x][y] == 0)		//�ֻ����� �ٴڸ��� ĭ�� ����
			{
				map[x][y] = dice.down;
			}
			else			//ĭ�� �ִ°� �ֻ����� ����, ĭ 0����
			{
				dice.down = map[x][y];
				map[x][y] = 0;
			}
			
			System.out.println(dice.up); 	//���� ���
		}
		br.close();
	}
	
	//�������� ���°� ������ �������(��ǥ�� �־����� ������ �Ǵ�)
	static boolean isAble(int r, int c, int op)
	{
		boolean result = false;
		
		if(op == 1)		//��� �̵�
		{
			if(c+1 < M)	result = true;
		}
		else if(op == 2)		//�·� �̵�
		{
			if(c-1 >= 0)	result = true;
		}
		else if(op == 3)		//���� �̵�
		{
			if(r-1 >= 0)	result = true;
		}
		else if(op == 4) //�Ʒ��� �̵�
		{
			if(r+1 < N)	result = true;
		}
		return result;
	}
}

class Dice{
	int up, down, front, back, left, right;
	Dice(){};
	Dice(int up, int down, int front, int back, int left, int right){
		this.up = up;	this.down = down;	this.front = front;		this.back = back;	this.left = left;	this.right = right;
	};
	public void roll(int op)
	{
		int temp = this.up;
		
		if(op == 1)		//����(��ȸ��): �յ� �Ȱ��� �����¿찡 �ð�������� ȸ��
		{
			this.up = this.left;
			this.left = this.down;
			this.down = this.right;
			this.right = temp;
		}
		else if(op == 2)	//����(��ȸ��): �յ� �Ȱ��� �����¿찡 �ð�ݴ�������� ȸ��
		{
			this.up = this.right;
			this.right = this.down;
			this.down = this.left;
			this.left = temp;
		}
		else if(op == 3)	//����(�ڷ�): �¿� �Ȱ��� �������İ� ���� ȸ��
		{
			this.up = this.front;
			this.front = this.down;
			this.down = this.back;
			this.back = temp;
		}
		else if(op == 4)	//����(������): �¿� �Ȱ��� �������İ� �Ʒ��� ȸ��
		{
			this.up = this.back;
			this.back = this.down;
			this.down = this.front;
			this.front = temp;
		}
	}
}
