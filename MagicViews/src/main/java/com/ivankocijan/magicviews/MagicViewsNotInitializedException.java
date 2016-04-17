package com.ivankocijan.magicviews;

/**
 * @author Koc
 *         ivan.kocijan@infinum.hr
 * @since 19.12.14.
 */
public class MagicViewsNotInitializedException extends RuntimeException {

    public MagicViewsNotInitializedException(String detailMessage) {
        super(detailMessage);
    }

    public MagicViewsNotInitializedException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }
}
