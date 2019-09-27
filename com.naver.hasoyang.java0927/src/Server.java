

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		//파일처리, 네트워크, 데이터베이스는
		//사용을 할 때 반드시 예외처리를 해야 합니다.
		try
		{
			//서버 소켓 만들기
			//8000번 포트로 클라이언트와 통신하도록 생성
			ServerSocket ss = new ServerSocket(8000);
			//무한 반복
			while(true)
			{
				System.out.printf("서버 대기중....\n");
				//클라이언트의 접속 대기
				//클라이언트가 접속하면 소켓을 만들고
				//아래 줄을 실행 시킵니다.
				//접속이 없으면 여기서 계속 대기
				Socket socket = ss.accept();
				
				//클라이언트의 메시지 확인
				System.out.printf("접속:%s\n", socket.toString());
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String line;
				while(true)
				{
					line = br.readLine();
					if(line == null)
					{
						break;
					}
					//가져온 내용이 있으면 출력
					System.out.printf("메시지 : %s\n", line);
				}
				//서버가 클라이언트에게 메시지 보내기 - echo
				PrintWriter pw = new PrintWriter(socket.getOutputStream());
				pw.println("반사 : " + line);
				pw.flush();
				
				//사용한 객체 닫기
				//이 작업이 안되면 다음에 소켓을 사용할 수 없게 됩니다.
				pw.close();
				br.close();
				socket.close();
			}
		}
		catch(Exception e)
		{
			//예외 발생 메시지를 출력
			System.out.printf("%s\n",e.getMessage());
			//예외 발생 위치를 확인하기 위해서 작성
			e.printStackTrace();
		}

	}

}
