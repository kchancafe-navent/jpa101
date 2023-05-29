package com.kchancafe.transactional101;

public class Faker {

    private static final net.datafaker.Faker INSTANCE = new net.datafaker.Faker();

    public static final net.datafaker.Faker get() {
        return INSTANCE;
    }

}
