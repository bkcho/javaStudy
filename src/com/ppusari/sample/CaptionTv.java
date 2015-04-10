// 순서대로 와야할 것 package > import > class

package com.ppusari.sample;

import com.ppusari.core.Monitor;
//import com.mobileleader.core.*; // 이하 모든것을 import 할때 사용하는 방법

class CaptionTv extends Tv {
	
	public int channel;
	Monitor monitor = new Monitor();
	
	String caption;
	CaptionTv()	{
		super(); // 안해도 무관하나 내부적으로는 부모 생성자를 호출하게 된다.
		caption = "";
	}
	
	void displayCaption() {
		System.out.println(caption);
	}
	
	// overwridding.
	public void channelUp(){
		super.channelUp(); // ++channel; 같은 의미가 됨.		
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
	
	// 추상 클래스에서 정의한것은 상속받은곳에서 반듯이 정의해야함.
	void test(){
		
	}
}
