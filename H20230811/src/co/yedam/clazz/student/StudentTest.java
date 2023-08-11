package co.yedam.clazz.student;

public class StudentTest {

	public static void main(String[] args) {
	
		Student[] students = new Student[10];
		int stdIdx = 0;
		
		Student std = new Student();
		std.setStdNo(21720987);
		std.setStdName("안우열");
		std.setScore(100);
		students[0] = std; stdIdx++;
		
		students[1] = new Student(21721023, "김륜형", 99); stdIdx++;
		students[2] = new Student(21721024, "배승호", 90); stdIdx++;
		students[3] = new Student(21721025, "김태현", 80); stdIdx++;
		
		String searchName = "김태현";
		
		for (int i = 0; i < stdIdx; i++) {
			if (students[i].getStdName().equals(searchName)) {
				System.out.printf("학번 : %d, 이름 : %s, 점수 : %d",
								  students[i].getStdNo(),
								  students[i].getStdName(),
								  students[i].getScore());
			}
		}
		
		
	}
	
}
