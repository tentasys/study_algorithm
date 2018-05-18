package test;

import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class Main {

	public static void main(String[] args) {
		int[][] table = { {1,2,3,4,5,6,7,8,9,10},
                {2,3,4,5,6,7,8,9,10,1},
                {3,4,5,6,7,8,9,10,1,2},
                {4,5,6,7,8,9,10,1,2,3},
                {5,6,7,8,9,10,1,2,3,4} };
		System.out.println(table[0].toString());
	}

}