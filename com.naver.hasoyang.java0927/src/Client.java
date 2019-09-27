import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static void main(String[] args)
	{
		try
		{
			//클라이언트 만들기 - 접속 
			Socket socket = new Socket(InetAddress.getByName("192.168.0.13"),8000);
			//전송할 메시지 입력
			Scanner sc = new Scanner(System.in);
			
			System.out.print("메시지 : ");
			String msg = sc.nextLine();
			
			//메시지 보내기
			PrintWriter pw = new PrintWriter(socket.getOutputStream());
			pw.println(msg);
			pw.flush();
			
			//서버가 보낸 메시지 읽기
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			msg = br.readLine();
			System.out.printf("서버가 보낸 메시지 :%s\n", msg);
			
			br.close();
			socket.close();
			sc.close();
			pw.close();
		}
		catch(Exception e)
		{
			System.out.printf("%s\n", e.getMessage());
			e.printStackTrace();
		}
	}
}
