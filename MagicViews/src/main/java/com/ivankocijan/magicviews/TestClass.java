package com.ivankocijan.magicviews;

/**
 * @author Koc
 *         ivan.kocijan@infinum.hr
 * @since 09/10/16
 */

public class TestClass {

    public static final String CONSTANT = "CONSTANt";


    public TestClass() {
    }

    public void evaluate() {
        throw new NullPointerException("Null");
    }

    private boolean returnTrue() {
        if (true) {
            return false;
        }
        return true;
    }

}
