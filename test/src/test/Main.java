package test;

import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) {
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		q.offer(3);
		q.offer(1);
		q.offer(4);
		q.offer(2);
		
		System.out.println(q.poll());
		System.out.println(q.poll());
		System.out.println(q.poll());
		System.out.println(q.poll());
	}

}