package test;

import java.util.LinkedList;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Stack<Integer> st = new Stack();
		st.push(1);
		st.push(2);
		st.push(3);
		System.out.println(st.pop());
		System.out.println(st.pop());
		st.push(4);
		System.out.println(st.pop());
		System.out.println(st.peek());
	}

}
