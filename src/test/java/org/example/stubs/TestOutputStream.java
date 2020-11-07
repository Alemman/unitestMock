package org.example.stubs;

import java.io.IOException;
import java.io.OutputStream;


public class TestOutputStream extends OutputStream{
    private String messageSend;

    @Override
    public void write(int b) throws IOException {

    }
    @Override
    public void write(byte []b) throws IOException {
        messageSend = new String(b);
    }
    public String getMessageSend(){
        return messageSend;
    }
}
