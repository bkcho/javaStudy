package com.ppusari.sample;

public class InstanceTv extends Tv {
//	private InstanceTv instanceTv  = new InstanceTv();
	private static int count = 0;
	private InstanceTv(){ }
	
	// ��ü ���� ���� �����ϴ� ��� ( ����ũ�� �ν���Ʈ ������ )
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
