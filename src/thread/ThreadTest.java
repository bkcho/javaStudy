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
		System.out.println("소요시간1:" + (System.currentTimeMillis() - startTime));
		
		for (int i=0; i<300; i++) {
			System.out.print("|");			
		}
		System.out.println("소요시간2:" + (System.currentTimeMillis() - startTime));
				
	
	}
	
	static void threadTest1()
	{
		// 1번째 사용
		MyThread myThread = new MyThread();
		myThread.start();
		
		// 2번째 사용.
		Runnable runnable = new MyThread2();
		Thread myThread2 = new Thread(runnable);
		myThread2.start();
		
		// 3번째 사용.
		MyThread myThread3 = new MyThread(); 
		myThread3.run(); // 이건 동기화 구조로 돌아간다  다 실행한후 다음 라인으로 넘거감.

		myThread.setPriority(10);
		myThread2.setPriority(1);
		
		// (한줄로 사용할 때 ㅋ)
		Thread myThread4 = new Thread(new MyThread2());
		myThread4.start();

		
		//myThread2.start(); 한번 사용한것은 또 사용할 수 없다. 아래처럼 또 초기화 해야함.
		myThread2 = new Thread(runnable);
		myThread2.start();
		
		System.out.println("end");
		
		// main 스레드가  죽어도 그전에 생성한 thread는 살아있다.  
	}
} 

//1번째 스레드 사용법.
class MyThread extends Thread {
	public void run() {
		for (int i=0; i<100; i++) {
			System.out.println(getName());				
		}
		
		System.out.println("");
	}
}

// 2번째 스레드 사용방법.
// 다른 클레스를 상속받기위해 이러한 인터페이스를 사용하는 방법을 사용하는게 좋다.
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
	
	//System.out.print("소요시간2:" + (System.currentTimeMillis() - startTime));		
}
	
	
	
	