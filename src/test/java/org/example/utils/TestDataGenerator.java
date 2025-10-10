package org.example.utils;

import java.util.UUID;

public class TestDataGenerator {
    public String generateRandomString(int length) {
        return UUID.randomUUID().toString().replace("-", "").substring(0, length);
    }

    public String generateUniqueName() {
        return "User" + generateRandomString(5);
    }

    public String generateUniqueEmail() {
        String randomPart = generateRandomString(8);
        return "testuser_" + randomPart + "@example.com";
    }

    public String generateUniquePassword() {
        return generateRandomString(8) + "!$#";
    }
}
