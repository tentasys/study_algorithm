package test;


public class Main {

	public static void main(String[] args) {

		int UP[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		
		for(int i=0; i<3; i++)
		{
			for(int j=0; j<3; j++)
				System.out.print(UP[i][j]+" ");
			System.out.println();
		}
		
		//���� ��� ��Ұ� �ð�������� ȸ��
		int temp = UP[0][0];
		//�� 3��
		UP[0][0] = UP[1][0];	UP[1][0] = UP[2][0];	UP[2][0] = UP[2][1];
		//�� 2��
		UP[2][1] = UP[2][2];	UP[2][2] = UP[1][2];
		//�� 2��
		UP[1][2] = UP[0][2];	UP[0][2] = UP[0][1];
		//�� 1��
		UP[0][1] = temp;		
		
		System.out.println();
		for(int i=0; i<3; i++)
		{
			for(int j=0; j<3; j++)
				System.out.print(UP[i][j]+" ");
			System.out.println();
		}
	}


	
}
