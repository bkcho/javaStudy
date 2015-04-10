package array;

import java.util.ArrayList;
import java.util.Collections;


class Item {
	int id;
	String name;
	long price;
	static int counter = 0;
	
	Item(String name, long price) {
		id = counter++;
		this.name = name;
		this.price = price;				
	}
	
	public String toString()
	{
		return String.format("id: %d, name: %s, prive: %d", id, name, price);		
	}
}

public class ArrayListCTest {
	public static void main(String[] args)
	{
		ArrayList arrayList = new ArrayList();  // 파라미터 초기화를 하지 않아도 됨.		
		arrayList.add(new String("String"));
		arrayList.add(new Integer(10));
		arrayList.add(new Double(10.5));
		
		// 정수만 받도록 제한 하는 방법 <Integer> 을 넣으면 됨.
		ArrayList<Integer> arrayList2 = new ArrayList<Integer>();		
		arrayList2.add(new Integer(5));
		arrayList2.add(new Integer(3));
		arrayList2.add(new Integer(7));
		arrayList2.add(new Integer(1));
		//arrayList2.add(new String("aa")); 에러발생 Integer가 아니기 때문에.
				
		print(arrayList, arrayList2);
		
		// 정렬하는 방법. ( 숫자만 들어있기 대문에 가능 )
		Collections.sort(arrayList2);
			
		// forech 같은 문구는 아래와 같이 사용한다.
		for (Object obj : arrayList) {
			System.out.println(obj);
		}
		
		ArrayList<Item> arrayList3 = new ArrayList<Item>();		
		arrayList3.add(new Item("조병국", 34));
		arrayList3.add(new Item("최아연", 32));
		arrayList3.add(new Item("김종관", 31));
		
		
		for (Item item : arrayList3)
		{
			System.out.println(item.toString());
		}
		
	}
	
	static void print(ArrayList list1, ArrayList list2)
	{
		System.out.println("list1:" + list1);
		System.out.println("list2:" + list2);
		System.out.println();
	}
	

}
