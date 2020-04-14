package com.examples.protobuf;

import example.enumeration.Enum;
import example.enumeration.Enum.EnumMessage;

public class EnumMain {
    public static void main(String[] args) {
        EnumMessage.Builder builder = EnumMessage.newBuilder();

        builder.setId(345)
                .setDayOfTheWeek(Enum.DayOfTheWeek.MONDAY);

        EnumMessage enumMessage = builder.build();
        System.out.println(enumMessage);
    }
}
