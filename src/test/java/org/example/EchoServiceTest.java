package org.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import  java.io.InputStream;
import  java.io.OutputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class EchoServiceTest {

    @Test
    public void givenValidRequestAnResponse_WhenEcho_ThenTrueIsResponded() throws IOException {
        //Given
            EchoService echoService = new EchoService();


            String request = "hell";
            byte [] messageInBytes = new byte[]{
                    'h','e','l','l'
        };


        OutputStream outputStream = Mockito.mock(OutputStream.class);
        InputStream inputStream =Mockito.mock(InputStream.class);

        Mockito.when(inputStream.readAllBytes()).thenReturn(messageInBytes);

        //When
        boolean response = echoService.sendEchoMessage(request,outputStream,inputStream);

        //Then
        Mockito.verify(inputStream).readAllBytes();
        Mockito.verify(outputStream).write(messageInBytes);
        Mockito.verifyNoMoreInteractions(inputStream,outputStream);

        assertTrue(response);

    }

    @Test
    public void givenValidRequestAnWrongResponse_WhenEcho_ThenFalseIsResponded() throws IOException {
        //Given
        EchoService echoService = new EchoService();
        byte [] messageResponse = new byte[]{
                'h','e','l','l','!'
        };
        byte [] messageRequest = new byte[]{
                'h','e','l','l'
        };
        String request = "hell";

        OutputStream outputStream = Mockito.mock(OutputStream.class);
        InputStream inputStream = Mockito.mock(InputStream.class);

        Mockito.when(inputStream.readAllBytes()).thenReturn(messageResponse);

        //When
        boolean response = echoService.sendEchoMessage(request,outputStream,inputStream);

        //Then

        Mockito.verify(inputStream).readAllBytes();
        Mockito.verify(outputStream).write(messageRequest);
        Mockito.verifyNoMoreInteractions(inputStream,outputStream);

        assertFalse(response);

    }
}