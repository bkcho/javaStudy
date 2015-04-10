
// 이거 뭔가 코드 에러로 실행 안됨.

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

//ArrayList 에 모두 넣어놓고 ArrayList 만 시리얼라이제이션 하면 된다.

public class SerizationTest {
	public static void main(String[] args)
	{	
		try { // write
			FileOutputStream fileOutputStream = new FileOutputStream("userInfo.ser");
			BufferedOutputStream bufferdInputStream = new BufferedOutputStream(fileOutputStream);
			ObjectOutputStream outputStream = new ObjectOutputStream(bufferdInputStream);
			
			UserInfo userInfo1 = new UserInfo("홍길동", "1234", 30);
			UserInfo userInfo2 = new UserInfo("hHong gil dong", "4321", 25);
			
			// Vactor 보다 ArrayList를 쓰는게 졶다.
			ArrayList arrayList = new ArrayList();
			arrayList.add(userInfo1);
			arrayList.add(userInfo2); 
			
			 outputStream.writeObject(userInfo1);
			 outputStream.writeObject(userInfo2);
			 outputStream.writeObject(arrayList);
			 outputStream.close(); // 가장 최하위 객체를 close 하면 상위를 모두 닫게 함.
			 
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

class UserInfo extends SuperUserinfo implements Serializable { // Serializable 을 선언한 곳 부터 직렬화가 됨.
	String name;
	String password;
	int age;
	transient Object object = new Object(); // 직렬화 안한다고 명시하는 것  transient.
	Object object2 = new String("ABC");	 // Object 는 직렬화가 안되지만 String은 직렬화가 됨.
	
	public UserInfo(String name, String password, int age) {
		super(1); // 이놈은 직렬화가 안되고 있는 놈이다 그래서 아래 writeObject(), readObject() 을 사용해서 해결가능하다.
		this.name = name;
		this.password = password;
		this.age = age;
	}
	
	public UserInfo(){  this("Unknow", "1111", 0); }
	public String toString() { return "name:" + name + "password:" + password + "age:" + age; };
	
	private void writeObject(ObjectOutputStream outputStream) {
		try {
			outputStream.writeInt(id);  // 직렬화가 안된 놈을 되게 해주는 것.
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