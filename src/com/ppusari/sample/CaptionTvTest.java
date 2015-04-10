package com.ppusari.sample;

import java.util.Vector;


// Ŭ������ ������ �� �� ������ public �� �ϳ��� ���� �� �ִ�.
// ���� ��Ӹ� �����Ѵ�.


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
			
		// ���� �ν���Ʈ�� ����.
		InstanceTv instance1 = InstanceTv.getInstance();
		InstanceTv instance2 = InstanceTv.getInstance();
		InstanceTv instance3 = InstanceTv.getInstance();

		CaptionTv captionTv2 = new CaptionTv();
		InstanceTv instanceTv2 = InstanceTv.getInstance();
		
		Tv[] tvArray = new Tv[10];
		tvArray[0] = new CaptionTv();
		tvArray[1] = InstanceTv.getInstance();	
		
		System.out.println(captionTv2.channel); // CaptionTv ���� ( �������� , ��ü)

		
		// ��ü�� ���� ó���� 
		channelUp(captionTv);
		channelUp(instance1);
		
		
		Object obj = captionTv;
		((CaptionTv)obj).caption = "object";
		
		
		// ���� �����.
		Vector tvList = new Vector();
		tvList.add(new CaptionTv());
		tvList.add(InstanceTv.getInstance());		
		for (int i = 0; i< tvList.size(); i++){
			((Tv)(tvList.get(i))).power();
		}
		
		
		
		
	}
}
