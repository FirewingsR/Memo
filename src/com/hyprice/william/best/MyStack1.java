package com.hyprice.william.best;

import java.util.Stack;

public class MyStack1 {

	private Stack<Integer> stackData;
	private Stack<Integer> stackMin;

	MyStack1() {
		this.stackData = new Stack<>();
		this.stackMin = new Stack<>();
	}

	public void push(int newNum) {
		if (this.stackMin.isEmpty()) {
			this.stackMin.push(newNum);
		} else if (newNum <= this.getMin()) {
			this.stackMin.push(newNum);
		}
		this.stackData.push(newNum);
	}

	public int pop() {
		if (this.stackData.isEmpty()) {
			throw new RuntimeException("You stack is empty.");
		}
		int value = this.stackData.pop();
		if (value == this.getMin()) {
			this.stackData.pop();
		}
		return value;
	}

	private int getMin() {
		if (this.stackMin.isEmpty()) {
			throw new RuntimeException("You stack is empty.");
		}
		return this.stackMin.peek();
	}
	
}
