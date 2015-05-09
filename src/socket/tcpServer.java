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

public class tcpServer {

	public static void main(String[] args) {
		try {
			// 1. 10001�� ��Ʈ���� �����ϴ� ServerSocket�� ����
			ServerSocket server = new ServerSocket(10001);
			System.out.println("Wating Connect ..");

			// 2. ServerSocket�� accept() �޼ҵ带 �����ؼ� Ŭ���̾�Ʈ�� ������ ���
			// : Ŭ���̾�Ʈ�� ������ ��� accept() �޼ҵ�� Socket ��ü�� ��ȯ
			Socket sock = server.accept();

			InetAddress inetaddr = sock.getInetAddress();
			System.out.println(inetaddr.getHostAddress() + " �κ��� �����߽��ϴ�.");

			// 3. ��ȯ���� Socket���κ��� InputStream�� OutputStream�� ����
			OutputStream out = sock.getOutputStream();
			InputStream in = sock.getInputStream();

			// 4. InputStream�� BufferedReader �������� ��ȯ
			// OutputStream�� PrintWriter �������� ��ȯ
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));
			BufferedReader br = new BufferedReader(new InputStreamReader(in));

			String line = null;
			// 5. BufferedReader�� readLine() �޼ҵ带 �̿���
			// Ŭ���̾�Ʈ�� ������ ���ڿ� �� ���� �о����
			while ((line = br.readLine()) != null) {
				System.out.println("Ŭ���̾�Ʈ�κ��� ���۹��� ���ڿ� : " + line);
				// 6. PrintWriter�� println�� �̿��� �ٽ� Ŭ���̾�Ʈ�� ����
				pw.println(line);
				pw.flush();
			}
			// 6. IO ��ü�� ������ close() �޼ҵ� ȣ��
			pw.close();
			br.close();
			sock.close();
			server.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
