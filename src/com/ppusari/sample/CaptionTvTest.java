package com.ppusari.sample;

import java.util.Vector;


// 클래스는 여러게 들어갈 수 있지만 public 는 하나만 있을 수 있다.
// 단일 상속만 가능한다.


public class CaptionTvTest extends Object {  
	
	static void channelUp(Tv tv)
	{
		if (tv instanceof CaptionTv)
		{
			tv.channelUp();			
		}
		else if (tv instanceof InstanceTv)
		{
			tv.channelUp();			
		}
		else if (tv instanceof Tv)
		{
			tv.channelUp();			
		}	
	}
	
	public static void main(String[] args) {
		
		CaptionTv captionTv = new CaptionTv();
		captionTv.monitor.pannel = false;
		captionTv.channel = 10;
		captionTv.channelUp();		
		captionTv.caption = "Hello world";
		
		System.out.println(captionTv.channel);
		captionTv.displayCaption();		
			
		// 같은 인스던트가 들어간다.
		InstanceTv instance1 = InstanceTv.getInstance();
		InstanceTv instance2 = InstanceTv.getInstance();
		InstanceTv instance3 = InstanceTv.getInstance();

		CaptionTv captionTv2 = new CaptionTv();
		InstanceTv instanceTv2 = InstanceTv.getInstance();
		
		Tv[] tvArray = new Tv[10];
		tvArray[0] = new CaptionTv();
		tvArray[1] = InstanceTv.getInstance();	
		
		System.out.println(captionTv2.channel); // CaptionTv 변수 ( 참조변수 , 객체)

		
		// 객체에 따른 처리법 
		channelUp(captionTv);
		channelUp(instance1);
		
		
		Object obj = captionTv;
		((CaptionTv)obj).caption = "object";
		
		
		// 백터 사용방법.
		Vector tvList = new Vector();
		tvList.add(new CaptionTv());
		tvList.add(InstanceTv.getInstance());		
		for (int i = 0; i< tvList.size(); i++){
			((Tv)(tvList.get(i))).power();
		}
		
		
		
		
	}
}
