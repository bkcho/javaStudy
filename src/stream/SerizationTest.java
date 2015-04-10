
// �̰� ���� �ڵ� ������ ���� �ȵ�.

package stream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

//ArrayList �� ��� �־���� ArrayList �� �ø���������̼� �ϸ� �ȴ�.

public class SerizationTest {
	public static void main(String[] args)
	{	
		try { // write
			FileOutputStream fileOutputStream = new FileOutputStream("userInfo.ser");
			BufferedOutputStream bufferdInputStream = new BufferedOutputStream(fileOutputStream);
			ObjectOutputStream outputStream = new ObjectOutputStream(bufferdInputStream);
			
			UserInfo userInfo1 = new UserInfo("ȫ�浿", "1234", 30);
			UserInfo userInfo2 = new UserInfo("hHong gil dong", "4321", 25);
			
			// Vactor ���� ArrayList�� ���°� �ߴ�.
			ArrayList arrayList = new ArrayList();
			arrayList.add(userInfo1);
			arrayList.add(userInfo2); 
			
			 outputStream.writeObject(userInfo1);
			 outputStream.writeObject(userInfo2);
			 outputStream.writeObject(arrayList);
			 outputStream.close(); // ���� ������ ��ü�� close �ϸ� ������ ��� �ݰ� ��.
			 
		}catch(Exception e) {}
		
		try {
			FileInputStream fileInputStream = new FileInputStream("UserInfo.ser");
			BufferedInputStream bufferdInputStream = new BufferedInputStream(fileInputStream);
			ObjectInputStream inputStream = new ObjectInputStream(bufferdInputStream);
			
			UserInfo userInfo1 = (UserInfo)inputStream.readObject();
			UserInfo userInfo2 = (UserInfo)inputStream.readObject();
			ArrayList arrayList = (ArrayList)inputStream.readObject();
			
			System.out.println("userinfo: " + userInfo1);
			System.out.println("userinfo: " + userInfo2);
			System.out.println("userinfo: " + arrayList);
			inputStream.close();			
			
		}catch(Exception e) {}  
	}
}

class UserInfo extends SuperUserinfo implements Serializable { // Serializable �� ������ �� ���� ����ȭ�� ��.
	String name;
	String password;
	int age;
	transient Object object = new Object(); // ����ȭ ���Ѵٰ� ����ϴ� ��  transient.
	Object object2 = new String("ABC");	 // Object �� ����ȭ�� �ȵ����� String�� ����ȭ�� ��.
	
	public UserInfo(String name, String password, int age) {
		super(1); // �̳��� ����ȭ�� �ȵǰ� �ִ� ���̴� �׷��� �Ʒ� writeObject(), readObject() �� ����ؼ� �ذᰡ���ϴ�.
		this.name = name;
		this.password = password;
		this.age = age;
	}
	
	public UserInfo(){  this("Unknow", "1111", 0); }
	public String toString() { return "name:" + name + "password:" + password + "age:" + age; };
	
	private void writeObject(ObjectOutputStream outputStream) {
		try {
			outputStream.writeInt(id);  // ����ȭ�� �ȵ� ���� �ǰ� ���ִ� ��.
			outputStream.defaultWriteObject();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	private void readObject(ObjectInputStream inputStream) {
		
		try {
			id = inputStream.readInt();
			try {
				inputStream.defaultReadObject();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class ChildUserInfo extends UserInfo {
	boolean isPersion;	
}

class SuperUserinfo {
	int  id;
	SuperUserinfo(int id) { this.id = id; }
	
}