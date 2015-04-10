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
			//thread.interrupt(); // Sleep() ���� �ڰ� �ִ� ���� ��� �����.
			TestThread.interrupted(); // join() �Լ��� ������� ���� �����.  
		}
		
		// ---------------------
		try {
			thread.sleep(10);	// �ν���Ʈ�� Sleep() �� �����°� �ƴϰ� �� �ڽ��� Sleep() �� �ȴ�.
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		System.out.println("���α׷� ����!");
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

		// while ���� ���� ������ �־��  ���� �ڵ���� ����� �� �մ�. 
		System.out.println("Run ������ ����!");
	}
	
	public void autoSave() {
		System.out.println("�ڵ� ���� �Ϸ�!");
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
			DaemonThreadTest.printThread.join(); // ���ͷ�Ʈ�� �̿��Ͽ� ������ �ߴ��� �� �ִ�.	
		}catch (Exception e) {}
		
		
		for (int i=0; i<300; i++) {
			System.out.print("|");
		}
		
		System.out.println("");
	}
}
