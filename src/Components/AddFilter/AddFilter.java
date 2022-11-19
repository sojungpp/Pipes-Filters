package Components.AddFilter;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;

import Framework.CommonFilterImpl;

public class AddFilter extends CommonFilterImpl{
    @Override
    public boolean specificComputationForFilter() throws IOException {
    	int checkBlank = 5; 
        int numOfBlank = 0;
        int idx = 0;
        byte[] buffer = new byte[1000];
        boolean isCS = false;    
        int byte_read = 0;
        ArrayList<Integer> coursesList = new ArrayList<Integer>(Arrays.asList(12345, 23456));
        
        while(true) {
        	while(byte_read != '\n' && byte_read != -1) {
        		byte_read = in.read();
        		buffer[idx++] = (byte)byte_read;
        		if(byte_read == ' ') numOfBlank++;
        		if(numOfBlank >= checkBlank && buffer[idx-6] == '1' && buffer[idx-5] == '2' && buffer[idx-4] == '3' && buffer[idx-3] == '4' && buffer[idx-2] == '5') isCS = true;
//        		if(numOfBlank >= checkBlank)
//        			for(int i=0; i<coursesList.size(); i++) {
//        				byte[] courses = intToByte(coursesList.get(i));
//        				if(buffer[idx-6]==courses[0] && buffer[idx-5]==courses[1] && buffer[idx-4]==courses[2] && buffer[idx-3]==courses[3] && buffer[idx-2]==courses[4]) isCS = true;
//        			}		
        	} 
            if(isCS == true) {
                for(int i = 0; i<idx; i++) 
                    out.write((char)buffer[i]);
                isCS = false;
            }
            if (byte_read == -1) return true;
            idx = 0;
            numOfBlank = 0;
            byte_read = '\0';
        }
    }  
    
    private static byte[] intToByte(int num) {
		ByteBuffer buff = ByteBuffer.allocate(Integer.SIZE / 8);
		ByteOrder order = ByteOrder.LITTLE_ENDIAN;
		buff.order(order);

		buff.putInt(num);
		return buff.array();
	}
}
