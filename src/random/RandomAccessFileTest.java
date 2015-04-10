package random;

import java.io.RandomAccessFile;

public class RandomAccessFileTest {
	public static void main(String[] args) {
		
		try{
			RandomAccessFile file = new RandomAccessFile("random.dat", "rw");
			
			// write
			System.out.println("Filepos = " + file.getFilePointer());
			file.writeInt(100);
			System.out.println("Filepos = " + file.getFilePointer());
			file.writeLong(88889999L);
			System.out.println("Filepos = " + file.getFilePointer());
			
			// read.
			file.seek(0);  // �������� ��ġ  ( ��������  ó�� 0���� )
			int intValue = file.readInt();
			System.out.println(intValue);
			System.out.println("Filepos = " + file.getFilePointer());
			
			file.skipBytes(4); // ������� ��ġ ( �������� filePointer�� ����ġ�� ��ġ )
			System.out.println("Filepos = " + file.getFilePointer());
			
			System.out.println("totle file length = " + file.length());
			
		}catch (Exception e) {}
	}
}
