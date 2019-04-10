import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int ii=0; ii<n; ii++)
		{
			int r = Integer.parseInt(br.readLine());	//������ ��
			String op[] = new String[r];				//��� ��� �迭
			
			//����� �迭�� ���
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<r; i++)
				op[i] = st.nextToken();
			
			roll(op);		//ť�� ������
		}
	}

	static public void roll(String[] op)
	{
		Cube cube = new Cube();
		
		for(String s : op)
		{
			if(s.compareTo("F+") == 0)			cube.Front_Clock();
			else if(s.compareTo("F-") == 0)		cube.Front_CounterClock();
			else if(s.compareTo("B+") == 0)		cube.Back_Clock();
			else if(s.compareTo("B-") == 0)		cube.Back_CounterClock();
			else if(s.compareTo("U+") == 0)		cube.Up_Clock();
			else if(s.compareTo("U-") == 0)		cube.Up_CounterClock();
			else if(s.compareTo("D+") == 0)		cube.Down_Clock();
			else if(s.compareTo("D-") == 0)		cube.Down_CounterClock();
			else if(s.compareTo("L+") == 0)		cube.Left_Clock();
			else if(s.compareTo("L-") == 0)		cube.Left_CounterClock();
			else if(s.compareTo("R+") == 0)		cube.Right_Clock();
			else if(s.compareTo("R-") == 0)		cube.Right_CounterClock();
			
//			cube.Print();
//			System.out.println();
		}
		
		cube.Up_Print();
	}
}

class Cube{
	//�麰�� ����
	char UP[][] = {{'w', 'w', 'w'},{'w', 'w', 'w'},{'w', 'w', 'w'}};
	char DOWN[][] = {{'y', 'y', 'y'},{'y', 'y', 'y'},{'y', 'y', 'y'}};
	char LEFT[][] = {{'g', 'g', 'g'},{'g', 'g', 'g'},{'g', 'g', 'g'}};
	char RIGHT[][] = {{'b', 'b', 'b'},{'b', 'b', 'b'},{'b', 'b', 'b'}};
	char FRONT[][] = {{'r', 'r', 'r'},{'r', 'r', 'r'},{'r', 'r', 'r'}};
	char BACK[][] = {{'o', 'o', 'o'},{'o', 'o', 'o'},{'o', 'o', 'o'}};
	
	Cube(){};
	
	public void Up_Clock()		//�����¿� �������� ȸ��
	{
		//�ո� ������ ����
		char temp[] = new char[3];
		temp[0] = FRONT[0][0];
		temp[1] = FRONT[0][1];
		temp[2] = FRONT[0][2];
		
		//���� -> �ո�
		FRONT[0][0] = RIGHT[0][0];		FRONT[0][1] = RIGHT[0][1];		FRONT[0][2] = RIGHT[0][2];
		//�޸� -> ����
		RIGHT[0][0] = BACK[0][0];		RIGHT[0][1] = BACK[0][1];		RIGHT[0][2] = BACK[0][2];
		//���� -> �޸�
		BACK[0][0] = LEFT[0][0];		BACK[0][1] = LEFT[0][1];		BACK[0][2] = LEFT[0][2];
		//�ո�(�ӽù迭) -> ����
		LEFT[0][0] = temp[0];			LEFT[0][1] = temp[1];			LEFT[0][2] = temp[2];
		
		//���� ��� ��Ұ� �ð�������� ȸ��
		//�����ڸ� ȸ��
		temp[0] = UP[0][0];
		UP[0][0] = UP[2][0];	UP[2][0] = UP[2][2];	UP[2][2] = UP[0][2];	UP[0][2] = temp[0];
		//������ ȸ��
		temp[0] = UP[0][1];
		UP[0][1] = UP[1][0];	UP[1][0] = UP[2][1];	UP[2][1] = UP[1][2];	UP[1][2] = temp[0];
		
	}
	
	public void Up_CounterClock()		//�����¿� �������� ȸ��, ���� �ð�ݴ�������� ȸ��
	{
		//�ո� ������ ����
		char temp[] = new char[3];
		temp[0] = FRONT[0][0];
		temp[1] = FRONT[0][1];
		temp[2] = FRONT[0][2];
		
		//���� -> �ո�
		FRONT[0][0] = LEFT[0][0];		FRONT[0][1] = LEFT[0][1];		FRONT[0][2] = LEFT[0][2];
		//�޸� -> ����
		LEFT[0][0] = BACK[0][0];		LEFT[0][1] = BACK[0][1];		LEFT[0][2] = BACK[0][2];		
		//���� -> �޸�
		BACK[0][0] = RIGHT[0][0];		BACK[0][1] = RIGHT[0][1];		BACK[0][2] = RIGHT[0][2];
		//�ո�(�ӽù迭) -> ����
		RIGHT[0][0] = temp[0];			RIGHT[0][1] = temp[1];			RIGHT[0][2] = temp[2];
		
		//���� ��� ��Ұ� �ð�ݴ�������� ȸ��
		//�����ڸ� ȸ��
		temp[0] = UP[0][0];
		UP[0][0] = UP[0][2];	UP[0][2] = UP[2][2];	UP[2][2] = UP[2][0];	UP[2][0] = temp[0];
		//������ ȸ��
		temp[0] = UP[0][1];
		UP[0][1] = UP[1][2];	UP[1][2] = UP[2][1];	UP[2][1] = UP[1][0];	UP[1][0] = temp[0];
	}
	
	public void Down_Clock()		//�����¿� �Ʒ����� ȸ��, �ظ� �ð�������� ȸ��
	{
		//�ո� �ǾƷ��� ����
		char temp[] = new char[3];
		temp[0] = FRONT[2][0];
		temp[1] = FRONT[2][1];
		temp[2] = FRONT[2][2];
		
		//���� -> �ո�
		FRONT[2][0] = LEFT[2][0];		FRONT[2][1] = LEFT[2][1];		FRONT[2][2] = LEFT[2][2];
		//�޸� -> ����
		LEFT[2][0] = BACK[2][0];		LEFT[2][1] = BACK[2][1];		LEFT[2][2] = BACK[2][2];		
		//���� -> �޸�
		BACK[2][0] = RIGHT[2][0];		BACK[2][1] = RIGHT[2][1];		BACK[2][2] = RIGHT[2][2];
		//�ո�(�ӽù迭) -> ����
		RIGHT[2][0] = temp[0];			RIGHT[2][1] = temp[1];			RIGHT[2][2] = temp[2];
		
		//�Ʒ��� ��� ��Ұ� �ð�������� ȸ��
		//�����ڸ� ȸ��
		temp[0] = DOWN[0][0];
		DOWN[0][0] = DOWN[2][0];	DOWN[2][0] = DOWN[2][2];	DOWN[2][2] = DOWN[0][2];	DOWN[0][2] = temp[0];
		//������ ȸ��
		temp[0] = DOWN[0][1];
		DOWN[0][1] = DOWN[1][0];	DOWN[1][0] = DOWN[2][1];	DOWN[2][1] = DOWN[1][2];	DOWN[1][2] = temp[0];
	}
	
	public void Down_CounterClock()	//�������� �Ʒ����� ȸ��, �Ʒ��� �ð�ݴ�������� ȸ��
	{
		//�ո� ������ ����
		char temp[] = new char[3];
		temp[0] = FRONT[2][0];
		temp[1] = FRONT[2][1];
		temp[2] = FRONT[2][2];
		
		//���� -> �ո�
		FRONT[2][0] = RIGHT[2][0];		FRONT[2][1] = RIGHT[2][1];		FRONT[2][2] = RIGHT[2][2];
		//�޸� -> ����
		RIGHT[2][0] = BACK[2][0];		RIGHT[2][1] = BACK[2][1];		RIGHT[2][2] = BACK[2][2];
		//���� -> �޸�
		BACK[2][0] = LEFT[2][0];		BACK[2][1] = LEFT[2][1];		BACK[2][2] = LEFT[2][2];
		//�ո�(�ӽù迭) -> ����
		LEFT[2][0] = temp[0];			LEFT[2][1] = temp[1];			LEFT[2][2] = temp[2];
		
		//�Ʒ��� ��� ��Ұ� �ð�ݴ�������� ȸ��
		//�����ڸ� ȸ��
		temp[0] = DOWN[0][0];
		DOWN[0][0] = DOWN[0][2];	DOWN[0][2] = DOWN[2][2];	DOWN[2][2] = DOWN[2][0];	DOWN[2][0] = temp[0];
		//������ ȸ��
		temp[0] = DOWN[0][1];
		DOWN[0][1] = DOWN[1][2];	DOWN[1][2] = DOWN[2][1];	DOWN[2][1] = DOWN[1][0];	DOWN[1][0] = temp[0];	
	}
	
	public void Front_Clock()		//�����¿� ȸ��, �ո� �ð�������� ȸ��
	{
		//���� �ǾƷ��� ����
		char temp[] = new char[3];
		temp[0] = UP[2][0];
		temp[1] = UP[2][1];
		temp[2] = UP[2][2];
		
		//���� -> ����
		UP[2][0] = LEFT[2][2];			UP[2][1] = LEFT[1][2];			UP[2][2] = LEFT[0][2];
		//�Ʒ��� -> ����
		LEFT[0][2] = DOWN[0][0];		LEFT[1][2] = DOWN[0][1];		LEFT[2][2] = DOWN[0][2];
		//���� -> �Ʒ���
		DOWN[0][0] = RIGHT[2][0];		DOWN[0][1] = RIGHT[1][0];		DOWN[0][2] = RIGHT[0][0];
		//����(�ӽù迭) -> ����
		RIGHT[0][0] = temp[0];			RIGHT[1][0] = temp[1];			RIGHT[2][0] = temp[2];
		
		//�ո� ��� ��Ұ� �ð�������� ȸ��
		//�����ڸ� ȸ��
		temp[0] = FRONT[0][0];
		FRONT[0][0] = FRONT[2][0];	FRONT[2][0] = FRONT[2][2];	FRONT[2][2] = FRONT[0][2];	FRONT[0][2] = temp[0];
		//������ ȸ��
		temp[0] = FRONT[0][1];
		FRONT[0][1] = FRONT[1][0];	FRONT[1][0] = FRONT[2][1];	FRONT[2][1] = FRONT[1][2];	FRONT[1][2] = temp[0];
	}
	
	public void Front_CounterClock()	//�����¿� ȸ��, �ո� �ð�ݴ�������� ȸ��
	{
		//���� �ǾƷ��� ����
		char temp[] = new char[3];
		temp[0] = UP[2][0];
		temp[1] = UP[2][1];
		temp[2] = UP[2][2];
		
		//���� -> ����
		UP[2][0] = RIGHT[0][0];			UP[2][1] = RIGHT[1][0];			UP[2][2] = RIGHT[2][0];
		//�Ʒ��� -> ����
		RIGHT[0][0] = DOWN[0][2];		RIGHT[1][0] = DOWN[0][1];		RIGHT[2][0] = DOWN[0][0];		
		//���� -> �Ʒ���
		DOWN[0][0] = LEFT[0][2];		DOWN[0][1] = LEFT[1][2];		DOWN[0][2] = LEFT[2][2];
		//����(�ӽù迭) -> ����
		LEFT[0][2] = temp[2];			LEFT[1][2] = temp[1];			LEFT[2][2] = temp[0];
		
		//�ո� ��� ��Ұ� �ð�ݴ�������� ȸ��
		//�����ڸ� ȸ��
		temp[0] = FRONT[0][0];
		FRONT[0][0] = FRONT[0][2];	FRONT[0][2] = FRONT[2][2];	FRONT[2][2] = FRONT[2][0];	FRONT[2][0] = temp[0];
		//������ ȸ��
		temp[0] = FRONT[0][1];
		FRONT[0][1] = FRONT[1][2];	FRONT[1][2] = FRONT[2][1];	FRONT[2][1] = FRONT[1][0];	FRONT[1][0] = temp[0];		
	}
	
	public void Back_Clock()		//�����¿� ȸ��, �޸� �ð�������� ȸ��
	{
		//���� ������ ����
		char temp[] = new char[3];
		temp[0] = UP[0][0];
		temp[1] = UP[0][1];
		temp[2] = UP[0][2];
		
		//���� -> ����
		UP[0][0] = RIGHT[0][2];			UP[0][1] = RIGHT[1][2];			UP[0][2] = RIGHT[2][2];
		//�Ʒ��� -> ����
		RIGHT[0][2] = DOWN[2][2];		RIGHT[1][2] = DOWN[2][1];		RIGHT[2][2] = DOWN[2][0];
		//���� -> �Ʒ���
		DOWN[2][2] = LEFT[2][0];		DOWN[2][1] = LEFT[1][0];		DOWN[2][0] = LEFT[0][0];
		//����(�ӽù迭) -> ����
		LEFT[2][0] = temp[0];			LEFT[1][0] = temp[1];			LEFT[0][0] = temp[2];
		
		//�޸� ��� ��Ұ� �ð�������� ȸ��
		//�����ڸ� ȸ��
		temp[0] = BACK[0][0];
		BACK[0][0] = BACK[2][0];	BACK[2][0] = BACK[2][2];	BACK[2][2] = BACK[0][2];	BACK[0][2] = temp[0];
		//������ ȸ��
		temp[0] = BACK[0][1];
		BACK[0][1] = BACK[1][0];	BACK[1][0] = BACK[2][1];	BACK[2][1] = BACK[1][2];	BACK[1][2] = temp[0];
	}
	
	public void Back_CounterClock()		//�����¿� ȸ��, �޸� �ð�ݴ�������� ȸ��
	{
		//���� ������ ����
		char temp[] = new char[3];
		temp[0] = UP[0][0];
		temp[1] = UP[0][1];
		temp[2] = UP[0][2];
		
		//���� -> ����
		UP[0][0] = LEFT[2][0];			UP[0][1] = LEFT[1][0];			UP[0][2] = LEFT[0][0];
		//�Ʒ��� -> ����
		LEFT[2][0] = DOWN[2][2];		LEFT[1][0] = DOWN[2][1];		LEFT[0][0] = DOWN[2][0];		
		//���� -> �Ʒ���
		DOWN[2][0] = RIGHT[2][2];		DOWN[2][1] = RIGHT[1][2];		DOWN[2][2] = RIGHT[0][2];
		//����(�ӽù迭) -> ����
		RIGHT[0][2] = temp[0];			RIGHT[1][2] = temp[1];			RIGHT[2][2] = temp[2];
		
		//�޸� ��� ��Ұ� �ð�ݴ�������� ȸ��
		//�����ڸ� ȸ��
		temp[0] = BACK[0][0];
		BACK[0][0] = BACK[0][2];	BACK[0][2] = BACK[2][2];	BACK[2][2] = BACK[2][0];	BACK[2][0] = temp[0];
		//������ ȸ��
		temp[0] = BACK[0][1];
		BACK[0][1] = BACK[1][2];	BACK[1][2] = BACK[2][1];	BACK[2][1] = BACK[1][0];	BACK[1][0] = temp[0];		
	}
	
	public void Left_Clock()	//�������� ȸ��, ���ʸ� �ð�������� ȸ��
	{
		//���� �ǿ����� ����
		char temp[] = new char[3];
		temp[0] = UP[0][0];
		temp[1] = UP[1][0];
		temp[2] = UP[2][0];
		
		//�޸� -> ����
		UP[0][0] = BACK[2][2];			UP[1][0] = BACK[1][2];			UP[2][0] = BACK[0][2];
		//�Ʒ��� -> �޸�
		BACK[0][2] = DOWN[2][0];		BACK[1][2] = DOWN[1][0];		BACK[2][2] = DOWN[0][0];
		//�ո� -> �Ʒ���
		DOWN[0][0] = FRONT[0][0];		DOWN[1][0] = FRONT[1][0];		DOWN[2][0] = FRONT[2][0];
		//����(�ӽù迭) -> �ո�
		FRONT[0][0] = temp[0];			FRONT[1][0] = temp[1];			FRONT[2][0] = temp[2];
		
		//���ʸ� ��� ��Ұ� �ð�������� ȸ��
		//�����ڸ� ȸ��
		temp[0] = LEFT[0][0];
		LEFT[0][0] = LEFT[2][0];	LEFT[2][0] = LEFT[2][2];	LEFT[2][2] = LEFT[0][2];	LEFT[0][2] = temp[0];
		//������ ȸ��
		temp[0] = LEFT[0][1];
		LEFT[0][1] = LEFT[1][0];	LEFT[1][0] = LEFT[2][1];	LEFT[2][1] = LEFT[1][2];	LEFT[1][2] = temp[0];
	}
	
	public void Left_CounterClock()		//�������� ȸ��, ���ʸ� �ð�ݴ�������� ȸ��
	{
		//���� �ǿ������� ����
		char temp[] = new char[3];
		temp[0] = UP[0][0];
		temp[1] = UP[1][0];
		temp[2] = UP[2][0];
		
		//�ո� -> ����
		UP[0][0] = FRONT[0][0];			UP[1][0] = FRONT[1][0];			UP[2][0] = FRONT[2][0];
		//�Ʒ��� -> �ո�
		FRONT[0][0] = DOWN[0][0];		FRONT[1][0] = DOWN[1][0];		FRONT[2][0] = DOWN[2][0];		
		//�޸� -> �Ʒ���
		DOWN[0][0] = BACK[2][2];		DOWN[1][0] = BACK[1][2];		DOWN[2][0] = BACK[0][2];
		//����(�ӽù迭) -> �޸�
		BACK[0][2] = temp[2];			BACK[1][2] = temp[1];			BACK[2][2] = temp[0];
		
		//���ʸ� ��� ��Ұ� �ð�ݴ�������� ȸ��
		//�����ڸ� ȸ��
		temp[0] = LEFT[0][0];
		LEFT[0][0] = LEFT[0][2];	LEFT[0][2] = LEFT[2][2];	LEFT[2][2] = LEFT[2][0];	LEFT[2][0] = temp[0];
		//������ ȸ��
		temp[0] = LEFT[0][1];
		LEFT[0][1] = LEFT[1][2];	LEFT[1][2] = LEFT[2][1];	LEFT[2][1] = LEFT[1][0];	LEFT[1][0] = temp[0];		
	}
	
	public void Right_Clock()		//�������� ȸ��, �����ʸ� �ð�������� ȸ��
	{
		//���� �ǿ������� ����
		char temp[] = new char[3];
		temp[0] = UP[0][2];
		temp[1] = UP[1][2];
		temp[2] = UP[2][2];
		
		//�ո� -> ����
		UP[0][2] = FRONT[0][2];			UP[1][2] = FRONT[1][2];			UP[2][2] = FRONT[2][2];
		//�Ʒ��� -> �ո�
		FRONT[0][2] = DOWN[0][2];		FRONT[1][2] = DOWN[1][2];		FRONT[2][2] = DOWN[2][2];
		//�޸� -> �Ʒ���
		DOWN[0][2] = BACK[2][0];		DOWN[1][2] = BACK[1][0];		DOWN[2][2] = BACK[0][2];
		//����(�ӽù迭) -> �޸�
		BACK[2][0] = temp[0];			BACK[1][0] = temp[1];			BACK[0][0] = temp[2];
		
		//�����ʸ� ��� ��Ұ� �ð�������� ȸ��
		//�����ڸ� ȸ��
		temp[0] = RIGHT[0][0];
		RIGHT[0][0] = RIGHT[2][0];	RIGHT[2][0] = RIGHT[2][2];	RIGHT[2][2] = RIGHT[0][2];	RIGHT[0][2] = temp[0];
		//������ ȸ��
		temp[0] = RIGHT[0][1];
		RIGHT[0][1] = RIGHT[1][0];	RIGHT[1][0] = RIGHT[2][1];	RIGHT[2][1] = RIGHT[1][2];	RIGHT[1][2] = temp[0];
	}
	
	public void Right_CounterClock()	//�������� ȸ��, �����ʸ� �ð�ݴ�������� ȸ��
	{
		//���� �ǿ������� ����
		char temp[] = new char[3];
		temp[0] = UP[0][2];
		temp[1] = UP[1][2];
		temp[2] = UP[2][2];
		
		//�޸� -> ����
		UP[0][2] = BACK[2][0];			UP[1][2] = BACK[1][0];			UP[2][2] = BACK[0][0];
		//�Ʒ��� -> �޸�
		BACK[0][0] = DOWN[2][2];		BACK[1][0] = DOWN[1][2];		BACK[2][0] = DOWN[0][2];		
		//�ո� -> �Ʒ���
		DOWN[0][2] = FRONT[0][2];		DOWN[1][2] = FRONT[1][2];		DOWN[2][2] = FRONT[2][2];
		//����(�ӽù迭) -> �ո�
		FRONT[0][2] = temp[0];			FRONT[1][2] = temp[1];			FRONT[2][2] = temp[2];
		
		//�����ʸ� ��� ��Ұ� �ð�ݴ�������� ȸ��
		//�����ڸ� ȸ��
		temp[0] = RIGHT[0][0];
		RIGHT[0][0] = RIGHT[0][2];	RIGHT[0][2] = RIGHT[2][2];	RIGHT[2][2] = RIGHT[2][0];	RIGHT[2][0] = temp[0];
		//������ ȸ��
		temp[0] = RIGHT[0][1];
		RIGHT[0][1] = RIGHT[1][2];	RIGHT[1][2] = RIGHT[2][1];	RIGHT[2][1] = RIGHT[1][0];	RIGHT[1][0] = temp[0];		
	}
	
	public void Up_Print()
	{
		System.out.print(UP[0][0]);
		System.out.print(UP[0][1]);
		System.out.print(UP[0][2]);
		System.out.println();
		
		System.out.print(UP[1][0]);
		System.out.print(UP[1][1]);
		System.out.print(UP[1][2]);
		System.out.println();
		
		System.out.print(UP[2][0]);
		System.out.print(UP[2][1]);
		System.out.print(UP[2][2]);
		System.out.println();
	}
	public void Down_Print()
	{
		System.out.print(DOWN[0][0]);
		System.out.print(DOWN[0][1]);
		System.out.print(DOWN[0][2]);
		System.out.println();
		
		System.out.print(DOWN[1][0]);
		System.out.print(DOWN[1][1]);
		System.out.print(DOWN[1][2]);
		System.out.println();
		
		System.out.print(DOWN[2][0]);
		System.out.print(DOWN[2][1]);
		System.out.print(DOWN[2][2]);
		System.out.println();
	}
	public void Left_Print()
	{
		System.out.print(LEFT[0][0]);
		System.out.print(LEFT[0][1]);
		System.out.print(LEFT[0][2]);
		System.out.println();
		
		System.out.print(LEFT[1][0]);
		System.out.print(LEFT[1][1]);
		System.out.print(LEFT[1][2]);
		System.out.println();
		
		System.out.print(LEFT[2][0]);
		System.out.print(LEFT[2][1]);
		System.out.print(LEFT[2][2]);
		System.out.println();
	}
	public void Right_Print()
	{
		System.out.print(RIGHT[0][0]);
		System.out.print(RIGHT[0][1]);
		System.out.print(RIGHT[0][2]);
		System.out.println();
		
		System.out.print(RIGHT[1][0]);
		System.out.print(RIGHT[1][1]);
		System.out.print(RIGHT[1][2]);
		System.out.println();
		
		System.out.print(RIGHT[2][0]);
		System.out.print(RIGHT[2][1]);
		System.out.print(RIGHT[2][2]);
		System.out.println();
	}
	public void Front_Print()
	{
		System.out.print(FRONT[0][0]);
		System.out.print(FRONT[0][1]);
		System.out.print(FRONT[0][2]);
		System.out.println();
		
		System.out.print(FRONT[1][0]);
		System.out.print(FRONT[1][1]);
		System.out.print(FRONT[1][2]);
		System.out.println();
		
		System.out.print(FRONT[2][0]);
		System.out.print(FRONT[2][1]);
		System.out.print(FRONT[2][2]);
		System.out.println();
	}
	public void Back_Print()
	{
		System.out.print(BACK[0][0]);
		System.out.print(BACK[0][1]);
		System.out.print(BACK[0][2]);
		System.out.println();
		
		System.out.print(BACK[1][0]);
		System.out.print(BACK[1][1]);
		System.out.print(BACK[1][2]);
		System.out.println();
		
		System.out.print(BACK[2][0]);
		System.out.print(BACK[2][1]);
		System.out.print(BACK[2][2]);
		System.out.println();
	}
	public void Print() {
		System.out.println("------UP------");
		Up_Print();
		System.out.println("------DOWN------");
		Down_Print();
		System.out.println("------LEFT------");
		Left_Print();
		System.out.println("------RIGHT------");
		Right_Print();
		System.out.println("------FRONT------");
		Front_Print();
		System.out.println("------BACK------");
		Back_Print();
	}
}