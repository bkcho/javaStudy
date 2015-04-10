package base;
class Time extends Object {
	int hour;	// ������� ������ public ��.
	private int minute;
	private int second;
	
	// ��� �Է� ���.
	public static final int HOUR = 0;
	public final int MINUTE = 2;
	
	
	Time()
	{
		// �����ڿ��� �ٸ� �����ڸ� ȣ���Ѵ�.
		this(0,0,0);
		
	//	this.MINUTE = 5;
	}
	
	Time(int hour, int minute, int second)
	{
		this.hour = hour;
		this.minute = minute;
		this.second = second;				
	}
			
	int getHour() { return this.hour; }
	int getMinute() { return this.minute; }
	int getSecond() { return this.second; }
	 
	void setHour(int hour) 
	{
		if (hour > 0 && hour < 25)
			this.hour = hour; 
	}
	
	void setMinute(int minute) 
	{
		if (minute > 0 && minute < 60)
			this.minute = minute; 
	}
	
	void setSecond(int second) 
	{
		if (second > 0 && second < 60)
			this.second = second; 
	}	
	
}


public class TimeTest {
	public static void main(String[] args)
	{
		Time time = new Time(); 
		time.setHour(4);
		
		// Ŭ���� �迭�� �Ʒ��� ���� �ʱ�ȭ�� ����� �Ѵ�.
		Time[] timeArray = new Time[10];
		for (int i=0; i<timeArray.length; i++)
		{
			timeArray[i] = new Time();
		}
		
		
		// Ŭ���� �ν���Ʈ�� �迭 �����͸� �Լ��� �ѱ涧�� ������ �������� �Ѿ��.
		
		// ������� �Ҹ���.		
		timeArray = null;
			
		time.hour = 23;
		
		time.hour = 23;
		
	}

}
