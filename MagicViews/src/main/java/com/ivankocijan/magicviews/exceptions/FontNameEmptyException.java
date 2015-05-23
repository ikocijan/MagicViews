package com.ivankocijan.magicviews.exceptions;

/**
 * @author Koc
 *         ivan.kocijan@infinum.hr
 * @since 23.05.15.
 */
public class FontNameEmptyException extends RuntimeException {

    public FontNameEmptyException(String detailMessage) {
        super(detailMessage);
    }
}
