package co.yedam.stream;

import java.io.FileOutputStream;
import java.io.IOException;

// FileOutputStream : 바이트 기반 파일 출력 스트림
public class FileOutputStreamExe {
	public static void main(String[] args) {
		
		try {
			
			FileOutputStream fos = new FileOutputStream(
					"src/co/yedam/stream/data.txt");
			
			fos.write(0);
			fos.write(100);
			fos.write(200);
			fos.write(300); // 바이트단위라서 0~255 까지만 담을 수 있으므로 여기선 오버플로우가 발생함
			
			fos.flush(); // 버퍼의 캐시값을 비움
			fos.close(); // 리소스 반환
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
