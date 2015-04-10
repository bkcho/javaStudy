package base;


public class Starcraft {
	public static void main(String[] args)
	{
		Tank tank = new Tank();
		Marine marine = new Marine();
		Dropship dropship = new Dropship();
		SCV scv = new SCV();
		SCV scv2 = new SCV();
		Medic medic = new Medic();
		Medic medic2 = new Medic();
		
		tank.hitPoint -= 30;
		marine.hitPoint -= 10;
		dropship.hitPoint -= 35;
		
		scv.repair(tank); // �����ִ� �Ķ����ʹ� ������ �޴� �ʿ����� ���� ���ϴ� instanceof �� ����ؼ� �� �� ����. 
		//scv.marine(marine); ���Ұ�  scv�� implements Repairable �� ������� �ʾƼ�..
		
		scv.repair(dropship);
		scv2.hitPoint -= 5;
		scv.repair(scv2);		
		
		marine.hitPoint -= 10;
		medic2.hitPoint -= 40;
		medic.cure(marine);
		medic.cure(medic2);
		medic.cure(scv);
		//medic.cure(dropship); // ���Ұ�.	
		
	 
	}
}

class Unit{
	int hitPoint;
	final int MAX_HP;	// ����� �ʱ⿡ �ʱ�ȭ ���� �ʰ� �����ڿ��� �ʱ�ȭ �� �� �ִ�.
	
	Unit(int hp) {
		MAX_HP = hp;
	}	
}

interface Repairable {} // ��ġ�� �������̽�
interface Curable {} // ġ���ϴ� �������̽�

class GroundUnit extends Unit {

	GroundUnit(int hp) {
		super(hp);
		// TODO Auto-generated constructor stub
	}	
}

class AirUnit extends Unit {

	AirUnit(int hp) {
		super(hp);
		// TODO Auto-generated constructor stub
	}
	
}

class Tank extends GroundUnit implements Repairable {

	Tank() {
		super(150);
		hitPoint = MAX_HP;
		// TODO Auto-generated constructor stub
	}
	public String toString() {
		return "Tank";
	}
	
}

class Marine extends GroundUnit implements Curable {
	Marine() { super(125);
	hitPoint = MAX_HP;
	}

	public String toString() { return "Marine"; }		
}

class SCV extends GroundUnit implements Repairable, Curable {
	SCV() {
		super(60);
		hitPoint = MAX_HP;		
	}
	
	public String toString() { return "SVC"; 	}
		
	
	void repair(Repairable repairable) {
		Unit unit = (Unit)repairable;
		
		while (unit.hitPoint != unit.MAX_HP) 		{
			unit.hitPoint++;
		}
		
		System.out.println(unit.toString() + "�� ������ �������ϴ�.");		
	}
}

class Dropship extends AirUnit implements Repairable {
	Dropship() { 
		super(60);
		hitPoint = MAX_HP;
	}	
	
	public String toString() { return "Dropship";  }
}

class Medic extends GroundUnit implements Curable {

	Medic() {		
		super(100);
		hitPoint = MAX_HP;	
	}
	
	public String toString() { return "Medic";  }
	
	void cure(Curable curable){
		Unit unit = (Unit)curable;
	
		
		if (unit instanceof Marine){
			
		}
		
		
		while (unit.hitPoint != unit.MAX_HP) {
			unit.hitPoint++;
		}
		System.out.println(unit.toString() + "�� ġ�ᰡ �������ϴ�.");
	}
}
