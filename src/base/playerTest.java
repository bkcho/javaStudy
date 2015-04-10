package base;
 
// �߻�Ŭ���� �̱� ������ �ν��Ͻ�ȭ �� �� ����.
abstract class Player {

	abstract void play(int pos);
	abstract void stop();
	
	int volume = 0;
	void volumeUp() { ++volume; }
	void volumeDown() { --volume; }
}

// �߻�Ŭ������ �޸� �������̴� ���ο� ������ ����� ������ ����.
// �߻�Ŭ����ó�� �ν���Ʈȭ �� �� ����.
interface Playable {
	// ����� �⺻������ �������̽������� public static final �� �߰��ȴ�.
	public static final boolean playing = false; // ���
	public static final int PLAY = 0;	// ���
	public static final int STOP = 1;	// ���

	// �Լ��� �⺻������ �������̽����� public abstract ��  ������ �߰��ȴ�.
	public abstract boolean isPlaying();  // �߻� �޼ҵ�
	public abstract boolean isStop();		// �߻� �޼ҵ�
}

interface Recodable {
	abstract boolean isRecording();  // �߻�޼ҵ�	
}

// Ŭ������ �ϳ��� ����� �� ������ �������̽��� �����Ը� ����� �� �ִ�.
class TapePlayer extends Player implements Playable, Recodable {
	int currentPosition = 0;
	void play(int pos) {}	
	void stop() { }	
	void rewind() {
		currentPosition = 0;
	}
	
	public String toString(){
		return String.format("currentPos:%d", currentPosition);
	}
	
	// public �� ���� ������ 
	public boolean isPlaying() { return true; }
	public boolean isStop() { return true; }
	public boolean isRecording() { return true; }	
}

class CDPlayer extends Player implements Playable {
	int currentTrack = 0;
	int lastTrack = 10;
	void play(int pos) { }	
	void stop() { }
	void previous() {
		if (currentTrack > 0)
			currentTrack--;
	}
	void next() {
		if (currentTrack < lastTrack)
			currentTrack++;
	}
	
	public String toString(){
		return String.format("currentTrack:%d lastTrack:%d", currentTrack, lastTrack);
	}
	
	public boolean isPlaying() { return true; }
	public boolean isStop() { return true; }	
}

class MultimediaPlayer extends Player implements Playable{

	@Override
	public boolean isPlaying() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isStop() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	void play(int pos) {
		// TODO Auto-generated method stub		
	}

	@Override
	void stop() {
		// TODO Auto-generated method stub		
	}
}

public class playerTest {
	public static Playable getPlayable() {
		return new TapePlayer();
	}
	public static void main(String[] args)
	{		
		TapePlayer tapePlayer = new TapePlayer();
		CDPlayer cdPlayer = new CDPlayer();
		Player player = (Player)new TapePlayer();
		Player player2 = (Player)new CDPlayer();
		
		player.play(0);
		Object obj = (Player)new TapePlayer();
		
		// ���� Ŭ����
		//obj.play(0);
		((Player)obj).play(0);
		
		// ���� �������� ������� �Լ��� ����� �� ����.
		Playable playabe = new TapePlayer();
		playabe.isPlaying();
		Playable returnPlayable = getPlayable();
		
		
		
		
		

	}
	

}
