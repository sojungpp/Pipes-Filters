/**
 * Copyright(c) 2021 All rights reserved by Jungho Kim in Myungji University.
 */
package Framework;

import java.util.Arrays;

import Common.Constants;
import Components.AddFilter.AddFilter;
import Components.Id.IdFilter;
import Components.Major.MajorFilter;
import Components.Sink.SinkFilter;
import Components.Source.SourceFilter;

public class LifeCycleManager_A1 {
    public static void main(String[] args) {
        try {
            CommonFilter filter1 = new SourceFilter(Constants.STUDENT_SOURCE_FILE_NAME);
            CommonFilter filter2 = new SinkFilter(Constants.OUTPUT_A1_FILE_NAME);
            CommonFilter filter3 = new MajorFilter(Constants.CS);
            CommonFilter filter4 = new AddFilter(Arrays.asList(Constants.CS_COMPULSORY_COURSE_LIST_1, Constants.CS_COMPULSORY_COURSE_LIST_2));
            
            filter1.connectOutputTo(filter3);
            filter3.connectOutputTo(filter4);
            filter4.connectOutputTo(filter2);
            
            Thread thread1 = new Thread(filter1);
            Thread thread2 = new Thread(filter2);
            Thread thread3 = new Thread(filter3);
            Thread thread4 = new Thread(filter4);
            
            thread1.start();
            thread2.start();
            thread3.start();
            thread4.start();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
