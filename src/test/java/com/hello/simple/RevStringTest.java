package com.hello.simple;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RevStringTest {

    @Test
    public void testRevString() {
        RevString revString = new RevString();
        assertEquals(revString.getReverseWord("abcd"), "dcba");
    }

    @Test
    void assertThrowsException() {
        String str = null;
        assertThrows(IllegalArgumentException.class, () -> {
            Integer.valueOf(str);
        });
    }

}
