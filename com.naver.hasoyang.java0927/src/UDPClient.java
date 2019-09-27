import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPClient {

	public static void main(String[] args) {
		try
		{
			//입력받는 스캐너
			Scanner sc = new Scanner(System.in);
			while(true)
			{
				//Thread.sleep(3000);
				System.out.print("전송할 내용 : ");
				String msg = sc.nextLine();//"안녕 클레오 파트라 세상에서 제일 가는 포테이토칩";
				//전송할 소켓 생성
				DatagramSocket socket = new DatagramSocket();
				//전송할 데이터 생성
				DatagramPacket dp = new DatagramPacket(msg.getBytes()
						, msg.getBytes().length
						, InetAddress.getByName("192.168.0.151"),7777);
				
				//데이터 전송
				socket.send(dp);
				socket.close();
				System.out.printf("전송성공\n");
				
				
			}
			
		}
		catch(Exception e)
		{
			System.out.printf("%s\n", e.getMessage());
			e.printStackTrace();
		}

	}

}
