package thread;

import java.io.PipedReader;
import java.io.PipedWriter;
import java.io.StringWriter;

public class PipeStreamTest {
	public static void main(String[] args){
		
		InputThread inputThread = new InputThread("InputThread");
		OutputThread outputThread = new OutputThread("OutputThrad");
		
		// ���� ����� �ص� �������.
		inputThread.connect(outputThread.getOutput());
//		outputThread.connect(inputThread.getInput());  // 
		
		inputThread.start();
		outputThread.start();
		
	}
}


// �޴³�.
class InputThread extends Thread {
	
	PipedReader input = new PipedReader();
	StringWriter stringOutput = new StringWriter(); 
	
	public InputThread(String name) { super(); }
	public void run(){
				
		try {
			int data = 0;
			while ((data = input.read()) != -1){
				stringOutput.write(data);				
			}
			
			System.out.println("received:" + stringOutput.toString());
		} 
		catch (Exception e) {}
	}
	
	public PipedReader getInput() { return input; }
	public void connect(PipedWriter output) {
		try {
			input.connect(output);			
		}
		catch (Exception e) {}
	}
	
}

// ��³�
class OutputThread extends Thread {
	
	PipedWriter output = new PipedWriter();
	
	public OutputThread(String name) { super(); }
	public void run() {
		
	try {
		String string = "Hello �ȳ��ϼ���.";
		output.write(string);
		output.close();
		
	}catch (Exception e) {}
		
	}
	
	public PipedWriter getOutput() { return output; }
	public void connect(PipedReader input){
		try
		{
			output.connect(input);
			
			
		}catch (Exception e) {}
	}
	
	
}