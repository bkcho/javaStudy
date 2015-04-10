package com.ppusari.sample;

public class InstanceTv extends Tv {
//	private InstanceTv instanceTv  = new InstanceTv();
	private static int count = 0;
	private InstanceTv(){ }
	
	// 객체 생성 개수 제한하는 방법 ( 유니크한 인스던트 추출방법 )
	public static InstanceTv getInstance() {
		if (count > 5)
			return null;
		else {
			count++;
			return (new InstanceTv());
		}					
	}
	
	void test(){
		
	}

}
