/**
 * Copyright(c) 2021 All rights reserved by Jungho Kim in Myungji University.
 */
package Components.Major;

import java.io.IOException;

import Commons.StudentData;
import Framework.CommonFilterImpl;

public class MajorFilter extends CommonFilterImpl{
	
	StudentData studentData = new StudentData();
	
    @Override
    public boolean specificComputationForFilter() throws IOException {
        int idx = 0;
        byte[] buffer = new byte[64];  
        int byte_read = 0; 
        while(true) {          
            while(byte_read != '\n' && byte_read != -1) {
            	byte_read = in.read();
                if(byte_read != -1) buffer[idx++] = (byte)byte_read;
            }
            // 학과 필터
            String studentInfo = new String(buffer);
            if(studentData.compareStudentMajor(studentInfo, "EE")) {
            	for(int i = 0; i<idx; i++) 
                    out.write((char)buffer[i]);
            };
            if (byte_read == -1) return true;
            idx = 0;
            byte_read = '\0';
        }
    }  
}
