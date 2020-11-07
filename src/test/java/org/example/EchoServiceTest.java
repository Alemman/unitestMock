package org.example;

import org.example.stubs.TestInputStream;
import org.example.stubs.TestOutputStream;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static org.junit.jupiter.api.Assertions.*;

class EchoServiceTest {

    @Test
    public void givenValidRequestAnResponse_WhenEcho_ThenTrueIsResponded() throws IOException {
        //Given
            EchoService echoService = new EchoService();

            String ip = "";
            int port = 3000;
            String request = "11001";

        TestOutputStream outputStream = new TestOutputStream();
        TestInputStream inputStream = new TestInputStream(request);

        //When
        boolean response = echoService.sendEchoMessage(request,outputStream,inputStream);

        //Then
        String messageSent = outputStream.getMessageSend();
        assertEquals(request,messageSent);
        assertTrue(response);

    }

    @Test
    public void givenValidRequestAnWrongResponse_WhenEcho_ThenFalseIsResponded() throws IOException {
        //Given
        EchoService echoService = new EchoService();

        String request = "fgdgfd";

        TestOutputStream outputStream = new TestOutputStream();
        TestInputStream inputStream = new TestInputStream("Hello WOrld!");

        //When
        boolean response = echoService.sendEchoMessage(request,outputStream,inputStream);

        //Then
        String messageSent = outputStream.getMessageSend();
        assertEquals(request,messageSent);
        assertFalse(response);

    }
}