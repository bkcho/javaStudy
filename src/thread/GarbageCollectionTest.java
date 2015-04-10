package thread;

public class GarbageCollectionTest
{	
	public static void main (String[] args) 
	{
		MyGc gcThread = new MyGc();
		gcThread.setDaemon(true);
		gcThread.start();
		
		int requiredMemory = 0;
		for (int i=0; i<20; i++) 
		{	
			//try { Thread.sleep(1000); } catch (Exception e) {}
			
			requiredMemory = (int)(Math.random() * 10) * 20; // random ����ƽ �̱� ������ ���¸����� �ȴ�.
			if (gcThread.freeMemory() < requiredMemory) {
				gcThread.interrupt();
				
				try {
					gcThread.join(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				gcThread.usedMemory += requiredMemory;
				System.out.println("usedMemory: " + gcThread.usedMemory);
			}
		}
	}
}

class MyGc extends Thread  {
	final static int MAX_MEMORY = 1000;
	int usedMemory = 0;
	
	public void run() {
		while (true) {			
			try { 
				Thread.sleep(10000); // Sleep() �� ����� �� Thread�� ���� ������ Thread�� ��� �޾ұ� ������ �����ص� ����� �� ����. 
				} catch (InterruptedException e) {}
			gc();
			System.out.println("Free Memory:" + freeMemory());
		}
	}
	
	public void gc() 
	{
		usedMemory -= 300;
		if (usedMemory < 0) 
			usedMemory = 0;		
	}
	
	public int freeMemory() 
	{
		return MAX_MEMORY - usedMemory;		
	}
	public int totalMemorty() { return MAX_MEMORY; }
	
}
