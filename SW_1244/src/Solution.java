import java.io.*;
import java.util.*;

public class Solution {

	static int min;
	static int max_value[];
	static ArrayList<Point> Combination = new ArrayList<Point>();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		//0~5사이에서 2가지를 고르는 조합의 수 구하기
		int temp_arr[] = new int[2];
		Cal_Combination(temp_arr, 0, 0);
		
		for(int ii=1; ii<=T; ii++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine())
			
			//숫자를 배열에 저장
			String tmp = st.nextToken();
			int arr[] = new int[tmp.length()];
			max_value = new int[tmp.length()];
			
			for(int i=0; i<tmp.length(); i++)
			{
				arr[i] = tmp.charAt(i)-'0';		//숫자화
				max_value[i] = arr[i];
			}			
			//----입력 끝
			QuickSort(max_value, 0, tmp.length()-1);	//최대값 구해놓기
			
			for(int i=0; i<Integer.parseInt(st.nextToken()); i++)
			{
				Function(arr);
			}
			
			//--출력 시작
			System.out.print("#"+ii+" "+toInteger(arr));

		}
		
		br.close();
	}

	static void Cal_Combination(int[] arr, int idx, int n)
	{
		if(idx == 2)
		{
			Combination.add(new Point(arr[0], arr[1]));
			return;
		}	
		for(int i=n; i<6; i++)
		{
			arr[idx] = i;
			Cal_Combination(arr, idx+1, i+1);
		}
	}
	
	static void Function(int[] arr) {
		
		
	}
	
	static int toInteger(int[] arr)
	{
		int result = 0;
		for(int i=0; i<arr.length; i++)
			result += (int)Math.pow(10, i)*arr[arr.length-1-i];
		
		return result;
	}
	
	static void QuickSort(int[] arr, int pivot, int last)
	{
		if(pivot < last)
		{
			int mid = Pivot(arr, pivot, last);
			QuickSort(arr, pivot, mid);
			QuickSort(arr, mid+1, last);
		}
	}
	
	static int Pivot(int[] arr, int pivot, int last) {
		int temp = arr[pivot];
		int p = pivot;
		int swap;
		
		for(int i=pivot; i<=last; i++)
		{
			if(arr[i] < temp)
			{
				p++;
				swap = arr[p];
				arr[p] = arr[i];
				arr[i] = swap;
			}
		}
		
		temp = arr[pivot];
		arr[pivot] = arr[p];
		arr[p] = temp;
		
		return p;
	}
}

class Point{
	int x;	int y;
	Point(int x, int y){this.x = x;	this.y = y;}
}
