// ������� �;��� �� package > import > class

package com.ppusari.sample;

import com.ppusari.core.Monitor;
//import com.mobileleader.core.*; // ���� ������ import �Ҷ� ����ϴ� ���

class CaptionTv extends Tv {
	
	public int channel;
	Monitor monitor = new Monitor();
	
	String caption;
	CaptionTv()	{
		super(); // ���ص� �����ϳ� ���������δ� �θ� �����ڸ� ȣ���ϰ� �ȴ�.
		caption = "";
	}
	
	void displayCaption() {
		System.out.println(caption);
	}
	
	// overwridding.
	public void channelUp(){
		super.channelUp(); // ++channel; ���� �ǹ̰� ��.		
		caption = "";
	}
 
	
	void channelDown() 	{
		--channel;
		caption = "";
	}
	
	// overloading.
	void channelUp(int count){
		channel += count;
		caption = "";
	}
	
	// �߻� Ŭ�������� �����Ѱ��� ��ӹ��������� �ݵ��� �����ؾ���.
	void test(){
		
	}
}
