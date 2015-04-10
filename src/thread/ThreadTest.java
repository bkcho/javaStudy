package thread;


public class ThreadTest {
	
	public static long startTime = 0; 
	
	public static void main(String[] args)
	{ 
		threadTest1(); 
	//	threadTest2();
//		threadTest3(); 
	}
	
	static void threadTest3()
	{
		TimieThread timeThread = new TimieThread();
		timeThread.start();
		startTime = System.currentTimeMillis();	
	}
	
	static void threadTest2()
	{
		long startTime = System.currentTimeMillis();
		for (int i=0; i<300; i++) {
			System.out.print("-");			
		}
		System.out.println("�ҿ�ð�1:" + (System.currentTimeMillis() - startTime));
		
		for (int i=0; i<300; i++) {
			System.out.print("|");			
		}
		System.out.println("�ҿ�ð�2:" + (System.currentTimeMillis() - startTime));
				
	
	}
	
	static void threadTest1()
	{
		// 1��° ���
		MyThread myThread = new MyThread();
		myThread.start();
		
		// 2��° ���.
		Runnable runnable = new MyThread2();
		Thread myThread2 = new Thread(runnable);
		myThread2.start();
		
		// 3��° ���.
		MyThread myThread3 = new MyThread(); 
		myThread3.run(); // �̰� ����ȭ ������ ���ư���  �� �������� ���� �������� �ѰŰ�.

		myThread.setPriority(10);
		myThread2.setPriority(1);
		
		// (���ٷ� ����� �� ��)
		Thread myThread4 = new Thread(new MyThread2());
		myThread4.start();

		
		//myThread2.start(); �ѹ� ����Ѱ��� �� ����� �� ����. �Ʒ�ó�� �� �ʱ�ȭ �ؾ���.
		myThread2 = new Thread(runnable);
		myThread2.start();
		
		System.out.println("end");
		
		// main �����尡  �׾ ������ ������ thread�� ����ִ�.  
	}
} 

//1��° ������ ����.
class MyThread extends Thread {
	public void run() {
		for (int i=0; i<100; i++) {
			System.out.println(getName());				
		}
		
		System.out.println("");
	}
}

// 2��° ������ �����.
// �ٸ� Ŭ������ ��ӹޱ����� �̷��� �������̽��� ����ϴ� ����� ����ϴ°� ����.
class MyThread2 implements Runnable {
	public void run(){
		for (int i=0; i<100; i++) {
			System.out.println(Thread.currentThread().getName());
		}			
	}
}

class TimieThread extends Thread {
	public void run(){
		for (int i=0; i<300; i++){
			System.out.print("|");	
		}						
	}
	
	//System.out.print("�ҿ�ð�2:" + (System.currentTimeMillis() - startTime));		
}
	
	
	
	