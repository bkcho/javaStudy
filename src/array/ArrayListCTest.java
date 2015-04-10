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
		ArrayList arrayList = new ArrayList();  // �Ķ���� �ʱ�ȭ�� ���� �ʾƵ� ��.		
		arrayList.add(new String("String"));
		arrayList.add(new Integer(10));
		arrayList.add(new Double(10.5));
		
		// ������ �޵��� ���� �ϴ� ��� <Integer> �� ������ ��.
		ArrayList<Integer> arrayList2 = new ArrayList<Integer>();		
		arrayList2.add(new Integer(5));
		arrayList2.add(new Integer(3));
		arrayList2.add(new Integer(7));
		arrayList2.add(new Integer(1));
		//arrayList2.add(new String("aa")); �����߻� Integer�� �ƴϱ� ������.
				
		print(arrayList, arrayList2);
		
		// �����ϴ� ���. ( ���ڸ� ����ֱ� �빮�� ���� )
		Collections.sort(arrayList2);
			
		// forech ���� ������ �Ʒ��� ���� ����Ѵ�.
		for (Object obj : arrayList) {
			System.out.println(obj);
		}
		
		ArrayList<Item> arrayList3 = new ArrayList<Item>();		
		arrayList3.add(new Item("������", 34));
		arrayList3.add(new Item("�־ƿ�", 32));
		arrayList3.add(new Item("������", 31));
		
		
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
