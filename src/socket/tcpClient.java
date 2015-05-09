package socket;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class tcpClient {

	public static void main(String[] args) {
		try {
			// 1. ������ IP�� ������ ���� ��Ʈ ��(10001)�� ���ڷ� �־� socket ����
			Socket sock = new Socket("127.0.0.1", 10001);
			BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

			// 2. ������ Socket���κ��� InputStream�� OutputStream�� ����
			OutputStream out = sock.getOutputStream();
			InputStream in = sock.getInputStream();

			// 3. InputStream�� BufferedReader �������� ��ȯ
			// OutputStream�� PrintWriter �������� ��ȯ
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));

			// 4. Ű����κ��� �� �پ� �Է¹޴� BufferedReader ��ü ����
			BufferedReader br = new BufferedReader(new InputStreamReader(in));

			String line = null;

			// 5. Ű����κ��� �� ���� �Է¹���
			while ((line = keyboard.readLine()) != null) {
				if (line.equals("quit"))
					break;

				// 6. PrintWriter�� �ִ� println() �޼ҵ带 �̿��� �������� ����
				pw.println(line);
				pw.flush();

				// 7. ������ �ٽ� ��ȯ�ϴ� ���ڿ��� BufferedReader�� �ִ�
				// readLine()�� �̿��ؼ� �о����
				String echo = br.readLine();
				System.out.println("�����κ��� ���޹��� ���ڿ� :" + echo);
			}

			pw.close();
			br.close();
			sock.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
