package com.examples.protobuf;

import example.complex.Complex.ComplexMessage;
import example.complex.Complex.DummyMessage;

import java.util.Arrays;

public class ComplexMain {
    public static void main(String[] args) {
        DummyMessage oneDummy = newDummyMessage(55, "one dummy message");
        DummyMessage twoDummy = newDummyMessage(56, "two dummy message");
        DummyMessage threeDummy = newDummyMessage(57, "three dummy message");

        ComplexMessage.Builder coBuilder = ComplexMessage.newBuilder();
        coBuilder.setOneDummy(oneDummy);
        coBuilder.addAllMultipleDummy(Arrays.asList(twoDummy, threeDummy));

        ComplexMessage complexMessage = coBuilder.build();
        System.out.println(complexMessage);
    }

    public static DummyMessage newDummyMessage(Integer id, String name) {
        DummyMessage.Builder builder = DummyMessage.newBuilder();
        builder.setId(id).setName(name);
        return builder.build();
    }
}
