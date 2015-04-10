package thread;

public class ThreadValueTest {
	public static void main(String[]  args){ 
		
		// implements 로 만들어서 객체를 넣어보자.
		Runnable runnable = new TestThread1();
		Thread thread1 = new Thread(runnable);
		Thread thread2 = new Thread(runnable);		
		thread1.start();
		thread2.start();

		Data data =  new Data();		
		TestThread2 thread3 = new TestThread2(data);
		TestThread2 thread4 = new TestThread2(data);
		thread3.start();		
		try { thread3.join();} catch (Exception e) {}		
		thread4.start(); 
	} 
}

class Data { int instanceValue = 0; }

class TestThread2 extends Thread {
	int instanceValue = 0;
	
	Data data;	
	public TestThread2(Data data) {
		this.data = data;

	}
	public void run() {
		int localValue = 0;
		String name = getName(); 
		
		while (localValue < 3)
		{
			System.out.println( name + " Local Value:" + (++localValue));
			System.out.println( name + " Instance Value:" + (++instanceValue));
			System.out.println( name + " Data Instance Value:" + (++data.instanceValue));			
			System.out.println();			
		}			
		
	}
}

class TestThread1 implements Runnable {

	int instanceValue = 0;
	
	@Override
	public void run() {	
		int localValue = 0;
		String name = Thread.currentThread().getName();
		
		while (localValue < 3)
		{
			System.out.println( name + " Local Value:" + (++localValue));
			System.out.println( name + " Instance Value:" + (++instanceValue));
			System.out.println();			
		}		
	}
	
}
