package com.ppusari.sample;

abstract  class Tv extends Object {  // ��� �ϴ� �����  extends Ű���带 ����Ѵ�.
	String color;
	boolean power;
	int channel;
	
	Tv() {
		color = null;
		power = false;
		channel = 1;
	}
	
	void power() { power = !power; }
	public void channelUp() { ++channel; } // public �̶����� �ٸ� ��Ű�� ������ ��밡��.
	void channelDown() { --channel; }
	
	abstract void test(); // �߻�Ŭ����.	
}