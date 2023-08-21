package co.yedam.stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImgCopyExe {
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		try {
			FileInputStream fis = new FileInputStream("src/co/yedam/stream/dog.jpg");
			FileOutputStream fos = new FileOutputStream("src/co/yedam/stream/dog_copy.jpg");
			byte[] buf = new byte[100];
			
			System.out.println("복사중...");
			while (true) {
//				int val = fis.read(); // 1Byte 씩 읽음(이미지는 메가바이트 단위이므로 엄청 많이 반복함)
				int val = fis.read(buf); // 100Byte 씩 읽음 -> 성능 향상
				if (val == -1) { 
					break;
				}
				fos.write(buf);
			}
			System.out.println("복사 완료!");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println((end - start) + "ms");
		
	}
}
