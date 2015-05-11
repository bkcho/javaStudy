package callback;

public class MainClass {
	public static void main(String[] args) {
		
		// �ݹ�
		CallbackEvent callbackEvent = new CallbackEvent() {
			
			@Override
			public void callbackMethod() {
				System.out.println("call callback method from callee");
				
			}
		};
		
		EventRegistration eventRegistration = new EventRegistration(callbackEvent);
		eventRegistration.doWork();
	}

}
