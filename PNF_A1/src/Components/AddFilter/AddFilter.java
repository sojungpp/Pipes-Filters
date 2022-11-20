package Components.AddFilter;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Framework.CommonFilterImpl;

public class AddFilter extends CommonFilterImpl{
	
	private final static ArrayList<String> compulsoryCourseList = new ArrayList<String>(Arrays.asList("12345", "23456"));
	
    @Override
    public boolean specificComputationForFilter() throws IOException {
    	int checkBlank = 5; 
        int numOfBlank = 0;
        int idx = 0;
        byte[] buffer = new byte[64];
        int byte_read = 0;
        
        while(true) {
        	while(byte_read != '\n' && byte_read != -1) {
        		byte_read = in.read();
        		if(byte_read != 13 && byte_read != 10) buffer[idx++] = (byte)byte_read;
        		if(byte_read == ' ') numOfBlank++;
        	}
        	if(numOfBlank >= checkBlank) checkCourse(idx, buffer);
            if (byte_read == -1) return true;
            idx = 0;
            numOfBlank = 0;
            byte_read = '\0';
        }
    }

    // 필수과목 체크
	private void checkCourse(int idx, byte[] buffer) throws IOException {
		byte[] studentInfo = new byte[idx];
		System.arraycopy(buffer, 0, studentInfo, 0, idx);
		byte[] filteredInfo = filterCourse(compulsoryCourseList, studentInfo);
		for(byte i : filteredInfo) out.write((char)i);
	}
    
    private byte[] filterCourse(List<String> compulsoryCourseList, byte[] studentInfo) {
    	String student = new String(studentInfo);
        for (String course : compulsoryCourseList)
            if(!student.contains(course)) student = addCourse(course, student);
        student += "\n";
        return student.getBytes();
    }
    
    private String addCourse(String course, String student) {
    	student += " "+course;
        return student;
    }

}
