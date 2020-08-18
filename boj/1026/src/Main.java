import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int A[] = new int[N];
		int B[] = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//A와 B 읽기
		for(int i=0; i<N; i++)
			A[i] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++)
			B[i] = Integer.parseInt(st.nextToken());
		
		//두 배열 정렬
		QuickSortAsc(A, 0, N-1);	//내림차순
		QuickSortDesc(B, 0, N-1);	//오름차순
		
		//곱의 합 구하기
		int S = 0;
		
		for(int i=0; i<N; i++)
			S += A[i]*B[i];
		
		System.out.print(S);
		
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
		int swap;
		
		for(int j=p+1; j<=last; j++)
		{
			if(arr[j] < temp)
			{
				pivot++;
				
				//swap
				swap = arr[pivot];
				arr[pivot] = arr[j];
				arr[j] = swap;
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
		int swap;
		
		for(int j=p+1; j<=last; j++)
		{
			if(arr[j] > temp)
			{
				pivot++;
				
				//swap
				swap = arr[pivot];
				arr[pivot] = arr[j];
				arr[j] = swap;
			}
		}
		
		temp = arr[p];
		arr[p] = arr[pivot];
		arr[pivot] = temp;
		
		return pivot;
	}
}
