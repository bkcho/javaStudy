package file;

import java.io.File;
import java.text.SimpleDateFormat;

public class FileTest {
	public static void main(String[] args ) {
		
	//	File file = new File("test.txt"); // ������ �����ϴ°� �ƴϰ� ������ �����ϴ� �ν���Ʈ�� ������Ŵ. (
		File file = new File(".");
		
		if (file.exists()) {
			System.out.println("������ �����մϴ�.");
		}
		else {
			System.out.println("������ ���� ���� �ʽ��ϴ�.");			
		}
		
		if (file.isDirectory()) {
			System.out.println("���丮 �Դϴ�..");
		}
		else {
			System.out.println("���丮 �� �ƴմϴ�.");
		}
		
		// �������� ��ξ��.
		System.out.println(file.getAbsolutePath());
		
		// ���ϸ���Ʈ �ҷ�����.
		File[] files = file.listFiles();		
		for (File obj : files) {
			String fileName = obj.getName();
			SimpleDateFormat dataForamt = new SimpleDateFormat("yyyy-MM-dd HH:mma");
						
			String attribute = "";
			String size = "";
			if (!obj.isDirectory())
			{
				size = String.valueOf(obj.length());
				attribute = file.canRead() ? "R" : "";
				attribute += file.canWrite() ? "W" : "";
				attribute += file.isHidden() ? "H" : "";
			}
			
			System.out.println( (obj.isDirectory() ? "[" + fileName + "]" : fileName));						
			
		}
		
		
			
		
		
		
	}

}
