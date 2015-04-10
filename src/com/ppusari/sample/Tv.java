package com.ppusari.sample;

abstract  class Tv extends Object {  // 상속 하는 방법은  extends 키워드를 상요한다.
	String color;
	boolean power;
	int channel;
	
	Tv() {
		color = null;
		power = false;
		channel = 1;
	}
	
	void power() { power = !power; }
	public void channelUp() { ++channel; } // public 이라함은 다른 패키지 에서도 사용가능.
	void channelDown() { --channel; }
	
	abstract void test(); // 추상클래스.	
}