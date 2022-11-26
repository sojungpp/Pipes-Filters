/**
 * Copyright(c) 2019 All rights reserved by JU Consulting
 */
package Framework;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public interface CommonFilter extends Runnable{
    public void connectOutputTo(CommonFilter filter) throws IOException;
//    public void connectOutputTo(CommonFilter filter, int portNum) throws IOException;
//    public void connectInputTo(CommonFilter filter, int portNum) throws IOException;
//    public PipedInputStream getPipedInputStream(int portNum);
//    public PipedOutputStream getPipedOutputStream(int portNum);
    public void connectInputTo(CommonFilter filter) throws IOException;
    public PipedInputStream getPipedInputStream();
    public PipedOutputStream getPipedOutputStream();
}
