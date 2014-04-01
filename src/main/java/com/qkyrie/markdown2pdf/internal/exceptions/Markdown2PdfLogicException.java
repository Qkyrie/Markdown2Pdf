package com.qkyrie.markdown2pdf.internal.exceptions;

/**
 * User: Quinten
 * Date: 31-3-2014
 * Time: 16:50
 *
 * @author Quinten De Swaef
 */
public class Markdown2PdfLogicException extends Exception {

    public static final Markdown2PdfLogicException LOGIC_SETUP_READER = new Markdown2PdfLogicException("Markdown2Pdf logic exception: You didn't specify a reader for your markdown file");
    public static final Markdown2PdfLogicException LOGIC_SETUP_WRITER = new Markdown2PdfLogicException("Markdown2Pdf logic exception: You didn't specify a writer for your pdf file");

    public Markdown2PdfLogicException() {
    }

    public Markdown2PdfLogicException(String message) {
        super(message);
    }

    public Markdown2PdfLogicException(String message, Throwable cause) {
        super(message, cause);
    }

    public Markdown2PdfLogicException(Throwable cause) {
        super(cause);
    }

    public Markdown2PdfLogicException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
