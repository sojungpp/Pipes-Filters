package Commons;

public class StudentData {

	public boolean compareStudentYear(String studentInfo, String year) {
		String[] split = studentInfo.split(" ");
		return split[0].substring(0,4).equals(year);
	}

	public boolean compareStudentMajor(String studentInfo, String major) {
		String[] split = studentInfo.split(" ");
		return split[3].equals(major);
	}

}
