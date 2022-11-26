/**
 * Copyright(c) 2021 All rights reserved by Jungho Kim in Myungji University.
 */
package Framework;

import java.util.Arrays;

import Common.Constants;
import Components.DeleteFilter.DeleteFilter;
import Components.Id.IdFilter;
import Components.Major.MajorFilter;
import Components.Sink.SinkFilter;
import Components.Source.SourceFilter;

public class LifeCycleManager_A3 {
    public static void main(String[] args) {
        try {
            CommonFilter filter1 = new SourceFilter(Constants.STUDENT_SOURCE_FILE_NAME);
            CommonFilter filter2 = new SinkFilter(Constants.OUTPUT_A3_FILE_NAME);
            CommonFilter filter3 = new IdFilter(Constants.ID_2013);
            CommonFilter filter4 = new MajorFilter(Constants.EE);
            CommonFilter filter5 = new DeleteFilter(Arrays.asList(Constants.EE_NOT_TAKED_COURSE_LIST_1, Constants.EE_NOT_TAKED_COURSE_LIST_2));
            
            filter1.connectOutputTo(filter3);
            filter3.connectOutputTo(filter4);
            filter4.connectOutputTo(filter5);
            filter5.connectOutputTo(filter2);
            
            Thread thread1 = new Thread(filter1);
            Thread thread2 = new Thread(filter2);
            Thread thread3 = new Thread(filter3);
            Thread thread4 = new Thread(filter4);
            Thread thread5 = new Thread(filter5);
            
            thread1.start();
            thread2.start();
            thread3.start();
            thread4.start();
            thread5.start();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
