package com.springexample.aop;

import org.springframework.stereotype.Component;

@Component("testB")
public class TestB {
	
	public void doSomething1() {
		System.out.println("TestB.doSomething1");
	}	
	public void doSomething2() {
		System.out.println("TestB.doSomething2");
	}
	public void doAnother1() {
		System.out.println("TestB.doAnother1");
	}
	public void doAnother2() {
		System.out.println("TestB.doAnother2");
		int x = 10 / 0;
	}

}