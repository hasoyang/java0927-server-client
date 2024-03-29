package serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;

public class Main {

	public static void main(String[] args) {
		DTO dto = new DTO(1, "hasoyang", "!234", "ji");
		
		//객체를 저장하는 스트림 -ObjectOutputStream
		//try()안에서 생성한 객체는 close를 호출하지 않아도
		//사용이 끝나면 자동으로 close()
		/*
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("./oos.txt")))
		{
			//객체를 파일에 기록
			//write나 print는버퍼에 기록
			//Serializable 인터페이스를 implements하지 않으면
			//ClassCastException 발생
			oos.writeObject(dto);
			//버퍼의 내용을 출력 - 기록을 할 때는 마지막에 flush
			oos.flush();
		}
		catch(Exception e)
		{
			System.out.printf("%s\n", e.getMessage());
			e.printStackTrace();
		}
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("./oos.txt")))
		{
			DTO obj = (DTO)ois.readObject();

			System.out.printf("%s\n", obj.getName());
			System.out.printf("%s\n", obj.getId());
			System.out.printf("%s\n", obj.getPw());
			System.out.printf("%d\n", obj.getNum());
		}
		catch(Exception e)
		{
			
		}
		*/
		try(RandomAccessFile f = new RandomAccessFile("./random.txt", "rw"))
		{
			//문자열을 바이트 배열로 변환해서 기록
			f.write("Hrllo World".getBytes());
			//파일 포인터 이동
			f.seek(6);
			//5바이트 읽기
			byte [] b = new byte[5];
			f.read(b);
			//문자열로 변환해서 출력
			String str = new String(b);
			System.out.printf("%s\n", str);
		}
		catch(Exception e)
		{
			System.out.printf("%s\n", e.getMessage());
		}
	}
	

}
