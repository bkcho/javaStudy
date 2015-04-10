package exception;

import java.beans.Expression;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Date;
import java.util.Random;

//336�� ����.
// throw�� �߻���Ű�� ���� Ŭ������ ���� try�� ���� �ʰ� �غ���.

class MyException extends Exception {
	
	private final int ERR_CODE;
	
	public MyException(String msg) {
		//super(msg);
		// TODO Auto-generated constructor stub
		this(msg, 100);	// �������� �����ڵ� ���Թ��
	}
	
	public MyException(String msg, int errCode) {
		super(msg);
		ERR_CODE = errCode;
	}
	
	public int getErrCode() {
		return ERR_CODE; 
	}
}

public class ExceptionTest {	
 
	public static void sub() throws Exception { // throws �� ������ ����ϴ� sub������ �ݵ�� try�� ���� �־����.
		
		try {
			throw new MyException("����� ���� ���� �߻�~", 222);			
		} catch (MyException e) {
			System.out.println(e.getErrCode());
		}
		
		PrintStream printStream = null;
		
		try
		{
			//return; // ���� ���Ϲ��� ������ finally�� �����Ѵ�.
			printStream = new PrintStream("error.log");			
			throw new Exception("���� �޼ҵ� ���� �߻�!");
		}
		catch (Exception e)
		{
			e.printStackTrace();			// �μ��� ������ ȭ�鿡 ���		
			e.printStackTrace(printStream);	// PrintStream ��ü�� �Ѱ��ָ� ���Ͽ� ���.
			printStream.println("���� �޼ҵ� ���� �߻�:" + e.toString());
			throw e;
		}
		finally{
			System.out.println("SUB ����!!!");
		}
	}
	
	public static void sub2() {
		PrintStream printStream = null;
		FileOutputStream fileOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream("error2.lob", true);
			printStream = new PrintStream(fileOutputStream);
			System.setErr(printStream);
			
			throw new Exception("����2 �޼ҵ� ���� �߻�!!");			
		} catch (Exception e) {
			System.err.println("-----------------------------------------");
			System.err.println("���� �߻��ð�:" + new Date());
			e.printStackTrace(System.err);
			System.err.println("���ܸ޽���:" + e.getMessage());
			System.err.println("-----------------------------------------");
		}
	}
	
	public static void sub3() throws ArithmeticException, NullPointerException {
		throw new ArithmeticException(); // �������� ���� �߻�!		
	}
	
	
	public static void main(String[] args){
	
		try {
			sub3();
		}
		catch (ArithmeticException e)
		{
			System.out.println(e.toString());
		}
		
		sub2();		
		
		try
		{
			sub(); // �� �Լ��� throws �� �߱⶧���� try�� ���� �־����. try�� ���� �ʰ� ����Ϸ���?
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
	 		
		Random rand = new Random();	
		
		try {
			try {
				int value = 10/0;
				
			} catch ( Exception e) {
				System.out.println(e.toString());				
			}			
			
			for (int i=0; i<10; i++) {
				int result = 100/ (rand.nextInt(5)+1); // 0~4
				System.out.println(i + ": " + result);				
			}		
			
			// ���Ƿ� ���� �߻�!
			Exception exception = new Exception("�̰��� ���Ƿ� �߻��� �����Դϴ�.");
			throw(exception); 
		}
		catch ( ArithmeticException ae)
		{
			System.out.println("ArithmeticExption: " + ae.toString());
		}
		catch (NullPointerException nullE)
		{
			
		}
		catch (ClassCastException classE)
		{
			
		}
		catch ( Exception exception) {			
			System.out.println(exception.toString());
			
			try {	
				throw(exception);				
			} catch ( Exception e) {
				System.out.println("!!!!"+ e.toString());
				System.out.println("!!!!"+ e.getMessage());
				e.printStackTrace();
			}
		}
		finally {			
			System.out.println("��������!!");	
		}
		
		System.out.println("Complete!");
	
	}
}
