package thread;

public class DaemonThreadTest {
	
	public static PrintThread printThread = null;
	
	public static void main(String[] args) 
	{
		AutoSaveThread thread  = new AutoSaveThread();
		thread.setDaemon(true);
		thread.start();
		
		/*PrintThread*/ printThread = new PrintThread();
		printThread.start();
			
		
		for (int i = 0; i<10; i++) {			
			try {
				Thread.sleep(1000);
			} catch (Exception e){}
			
			System.out.println(i+1);	
			//thread.interrupt(); // Sleep() 으로 자고 있는 것을 모두 깨운다.
			TestThread.interrupted(); // join() 함수에 대기중인 것을 깨운다.  
		}
		
		// ---------------------
		try {
			thread.sleep(10);	// 인스던트의 Sleep() 이 먹히는게 아니고 내 자신이 Sleep() 이 된다.
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		System.out.println("프로그램 종료!");
	}
}

class AutoSaveThread extends Thread {
	public void run()
	{
		int n = 0;		

		while (true)
		{
			try {
				Thread.sleep(3*1000);	
			}
			catch (Exception e) {}
			
			autoSave();
			
			if (n++ == 100)
				break;						
		}

		// while 문에 종료 조건이 있어야  다음 코드들을 사용할 수 잇다. 
		System.out.println("Run 스레드 종료!");
	}
	
	public void autoSave() {
		System.out.println("자동 저장 완료!");
	}
}

class PrintThread extends Thread {
	public void run() {
		for (int i=0; i<300; i++) {
			System.out.println("");	
		}
		System.out.println();	
	}	
}

class TestThread extends Thread {
	public void run()
	{		
		try {
			DaemonThreadTest.printThread.join(); // 인터럽트를 이용하여 멈춤을 중단할 수 있다.	
		}catch (Exception e) {}
		
		
		for (int i=0; i<300; i++) {
			System.out.print("|");
		}
		
		System.out.println("");
	}
}
