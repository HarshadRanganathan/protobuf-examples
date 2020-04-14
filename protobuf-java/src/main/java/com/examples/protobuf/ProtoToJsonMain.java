package com.examples.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
import example.simple.Simple.SimpleMessage;
import java.util.Arrays;

public class ProtoToJsonMain {
    public static void main(String[] args) {
        final SimpleMessage.Builder builder = SimpleMessage.newBuilder();

        builder.setId(42)
                .setIsSimple(true)
                .setName("Simple Message");

        builder.addAllSampleList(Arrays.asList(4 ,5, 6));

        // protobuf to JSON
        String jsonString = null;
        try {
            jsonString = JsonFormat
                    .printer()
                    .print(builder);
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
        System.out.println(jsonString);

        // JSON to protobuf
        SimpleMessage.Builder builder2 = SimpleMessage.newBuilder();
        try {
            JsonFormat.parser()
                    .ignoringUnknownFields()
                    .merge(jsonString, builder2);
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
        System.out.println(builder2);
    }
}
