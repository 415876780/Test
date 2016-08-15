package com.duotai;

import java.util.List;

public class Test {
	public static void main(String[] args) {
		A a = new B();
		a.move();
		System.out.println(a.name);
	}
}
class A{
	public String name="A";
	public void move(){
		System.out.println("A move");
	}
}
class B extends A{
	public String name="B";
	public void move(){
		System.out.println("B move");
	}
}
