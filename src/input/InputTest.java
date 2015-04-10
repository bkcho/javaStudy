package input;
import java.util.Random;
import java.util.Scanner;

public class InputTest {
	public static void main(String[] args)
	{
		// �Է¹��� ��ü�� �����Ѵ�.
		Scanner scanner = new Scanner(System.in);
		
		//-------------------------------------------------------------------------------------------
		// �Է¹��� �ޱ�.
		//-------------------------------------------------------------------------------------------		
		try
		{
			System.out.println("What is your name?");
			String name = scanner.nextLine(); 		 // ���ڸ� �Է¹޴� ��.
			System.out.println("What is your age?");
			int age = scanner.nextInt();		
			System.out.println("your name is " + name + " and your age is " + age);		 	
		}catch(Exception exp)
		{
			System.out.println(exp.toString());		
		}
		
		
		
		//-------------------------------------------------------------------------------------------
		// ���� ������ ����.
		//-------------------------------------------------------------------------------------------
		Random rand = new Random();
		int flag;
		
		do
		{
			int computerHand = rand.nextInt(3); // 0~2				
			
			System.out.println("� ���� ���ðڽ��ϱ�? (����=0, ����=1, ��=2)");
			int yourHand = scanner.nextInt();
			 	
			switch (computerHand)
			{
			case 0:  // ��ǻ�Ͱ� ������ ����. 
				if (yourHand == 0)
					System.out.println("�����ϴ�.");
				else if ( yourHand == 1)
					System.out.println("���� �̱�");
				else if ( yourHand == 2)
					System.out.println("���� ����.");
				break;
			case 1:  // ��ǻ�Ͱ� ������ ����. 
				if (yourHand == 0)
					System.out.println("���� ����.");
				else if ( yourHand == 1)
					System.out.println("�����ϴ�.");
				else if ( yourHand == 2)
					System.out.println("���� �̱�.");
				break;
			case 2:  // ��ǻ�Ͱ� ���� ����. 
				if (yourHand == 0)
					System.out.println("���� �̱�");
				else if ( yourHand == 1)
					System.out.println("���� ����.");
				else if ( yourHand == 2)
					System.out.println("�����ϴ�.");
				break;		
			}
			
			System.out.println("��� �Ͻðڽ��ϱ�?");
			flag = scanner.nextInt();			 
			
		} while (flag != 0);
 
	}

}
 