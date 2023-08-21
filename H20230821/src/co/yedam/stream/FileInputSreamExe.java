package co.yedam.stream;

import java.io.FileInputStream;
import java.io.IOException;

//FileInputStream : 바이트 기반 파일 입력 스트림
public class FileInputSreamExe {
	public static void main(String[] args) {
		
		try {
			
			FileInputStream fis = new FileInputStream(
					"src/co/yedam/stream/data.txt");
			
			while (true) {
				int val = fis.read();
				if (val == -1) {
					break;
				}
				System.out.println(val);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
