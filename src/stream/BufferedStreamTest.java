package stream;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class BufferedStreamTest {
	public static void main(String[] args){
		
		FileOutputStream fileOutputStream = null;
		try {
			
			// ��� ��Ʈ��
			fileOutputStream = new FileOutputStream("buffer_test.txt");
			
			// ���� ��Ʈ�� ( �ݵ�� ��� ��Ʈ���� �����ؾ��� )
			BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream, 5);
			
			for (int i=0 ; i< 9; i++) {
				bufferedOutputStream.write('1' + i);
			}
			
			// ��� ��Ʈ������ �������� 
			bufferedOutputStream.flush();  // �÷��� ���ϸ� �����Ͱ� ������ ��� �ȵȴ�.
			fileOutputStream.close();
			
			//bufferedOutputStream.close();
			
			
		}
		catch (Exception e) {}
		
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream("buffer_test.txt");
			
			int data = 0;
			
			while((data = fileInputStream.read()) != -1)
			{
				System.out.print((char)data);			
			}
			System.out.println();
			fileInputStream.close();
			
		}catch (Exception e){}
		
		
	}

}
