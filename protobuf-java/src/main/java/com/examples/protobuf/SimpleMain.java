package com.examples.protobuf;

import example.simple.Simple.SimpleMessage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class SimpleMain {
    public static void main(String[] args) {
        final SimpleMessage.Builder builder = SimpleMessage.newBuilder();

        builder.setId(42)
                .setIsSimple(true)
                .setName("Simple Message");

        builder.addAllSampleList(Arrays.asList(4 ,5, 6));

        final SimpleMessage simpleMessage = builder.build();

        try(FileOutputStream fileOutputStream = new FileOutputStream("simple_message.bin")) {
            simpleMessage.writeTo(fileOutputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(FileInputStream fileInputStream = new FileInputStream("simple_message.bin")) {
            System.out.println(SimpleMessage.parseFrom(fileInputStream));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
