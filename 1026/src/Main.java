import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int A[] = new int[N];
		int B[] = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//A�� B �б�
		for(int i=0; i<N; i++)
			A[i] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++)
			B[i] = Integer.parseInt(st.nextToken());
		
		//�� �迭 ����
		QuickSortDesc(A, 0, N-1);	//��������
		QuickSortAsc(B, 0, N-1);	//��������
		
		//���� �� ���ϱ�
		int S = 0;
		
		for(int i=0; i<N; i++)
			S = A[i]*B[i];
		
		//System.out.print(S);
		
		for(int a: A)
			System.out.print(a+" ");
		System.out.println();
		for(int a: B)
			System.out.print(a+" ");
	}	

	static void QuickSortAsc(int[] arr, int pivot, int last) {
		if(pivot < last)
		{
			int mid = Asc(arr, pivot, last);
			QuickSortAsc(arr, pivot, mid);
			QuickSortAsc(arr, mid+1, last);
		}
	}
	
	static void QuickSortDesc(int[] arr, int pivot, int last) {
		if(pivot < last)
		{
			int mid = Desc(arr, pivot, last);
			QuickSortDesc(arr, pivot, mid);
			QuickSortDesc(arr, mid+1, last);
		}
	}
	
	static int Asc(int[] arr, int p, int last){
		
		int temp = arr[p];
		int pivot = p;
		
		for(int j=p+1; j<=last; j++)
		{
			if(arr[j] <= temp)
			{
				pivot++;
				
				//swap
				arr[j] = arr[j]+arr[pivot];
				arr[pivot] = arr[j]-arr[pivot];
				arr[j] = arr[j]-arr[pivot];
			}
		}
		
		temp = arr[p];
		arr[p] = arr[pivot];
		arr[pivot] = temp;
		
		return pivot;
		
	}
	
	static int Desc(int[] arr, int p, int last) {
		
		int temp = arr[p];
		int pivot = p;
		
		for(int j=p+1; j<=last; j++)
		{
			if(arr[j] >= temp)
			{
				pivot++;
				
				//swap
				arr[j] = arr[j]+arr[pivot];
				arr[pivot] = arr[j]-arr[pivot];
				arr[j] = arr[j]-arr[pivot];
			}
		}
		
		temp = arr[p];
		arr[p] = arr[pivot];
		arr[pivot] = temp;
		
		return pivot;
	}
}
