package thread;

public class AccountTest {
	public static void main(String[] args){
		
		Runnable runnable = new AccountThread();
		Thread thread1 = new Thread(runnable);
		Thread thread2 = new Thread(runnable);
		thread1.start();
		thread2.start(); 
	}
}

class Account {
	private int balance = 1000;
	
	// 락을 걸수 있는 메소드가 됨.
	public synchronized void withdraw(int money){

		while (balance < money)
		{
			try {
				System.out.println(Thread.currentThread().getName() + " WAIT");
				wait();					
			} catch(Exception e) {}			
		}
		
		balance -=money;	
	}
	
	public synchronized void deposit(int money) {
		balance += money;
		notify(); 
		System.out.println(Thread.currentThread().getName() + " NOTIFY");
	}
	
	public synchronized int getBalance() { return this.balance; }
}

class AccountThread implements Runnable {
	
	Account account = new Account();
	
	public void run(){ 
		
		while (account.getBalance() > 0)
		{		
			int money = (int)(Math.random()*3+1)*100;
			if (Math.random() < 0.5)
				account.withdraw(money);
			else
				account.deposit(money);
			
			System.out.println(Thread.currentThread().getName() + "balance: " + account.getBalance());
		}
		
	}
}