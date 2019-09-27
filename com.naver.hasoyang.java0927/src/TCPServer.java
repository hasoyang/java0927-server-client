


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

	public static void main(String[] args) {
		
		try {
			ServerSocket ss = new ServerSocket(9000);
			while(true)
			{
				System.out.printf("서버 대기 중....\n");
				//클라이언트 요청 대기 중
				Socket socket = ss.accept();
				System.out.printf("접속자 : %s\n", socket.toString());
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				while(true)
				{
					String line = br.readLine();
					if(line == null)
					{
						break;
					}
					System.out.printf("전송한 내용 :%s\n", line);
				}
				br.close();
				socket.close();
			}
		}catch(Exception e)
		{
			System.out.printf("%s\n",e.getMessage());
		}

	}

}
