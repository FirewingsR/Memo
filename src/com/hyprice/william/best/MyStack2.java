package com.hyprice.william.best;

import java.util.Stack;

public class MyStack2 {

	private Stack<Integer> stackData;
	private Stack<Integer> stackMin;

	MyStack2() {
		this.stackData = new Stack<>();
		this.stackMin = new Stack<>();
	}

	public void push(int newNum) {
		if (this.stackMin.isEmpty()) {
			this.stackMin.push(newNum);
		} else if (newNum < this.getMin()) {
			this.stackMin.push(newNum);
		} else {
			int newMin = this.stackMin.peek();
			this.stackMin.push(newMin);
		}
		this.stackData.push(newNum);
	}

	public int pop() {
		if (this.stackData.isEmpty()) {
			throw new RuntimeException("You stack is empty.");
		}
		this.stackMin.pop();
		return this.stackData.pop();
	}

	private int getMin() {
		if (this.stackMin.isEmpty()) {
			throw new RuntimeException("You stack is empty.");
		}
		return this.stackMin.peek();
	}
	
}
