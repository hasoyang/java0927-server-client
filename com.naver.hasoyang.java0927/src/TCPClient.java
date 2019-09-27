

import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient {

	public static void main(String[] args) {
		
		
		try 
		{
			InetAddress serverIp = InetAddress.getByName("192.168.0.151");
			Socket socket = new Socket(serverIp,9000);
			
			PrintWriter pw = new PrintWriter(socket.getOutputStream());
			
			//메시지 입력받기
			Scanner sc = new Scanner(System.in);
			System.out.printf("전송할 메시지 : ");
			String msg = sc.nextLine();
			
			//메시지 전송
			pw.println(msg);
			pw.flush();
			
			//사용이 끝나서 종료
			sc.close();
			pw.close();
			socket.close();
		}
		catch(Exception e)
		{
			System.out.printf("%s\n", e.getMessage());
			e.printStackTrace();
		}

	}

}
