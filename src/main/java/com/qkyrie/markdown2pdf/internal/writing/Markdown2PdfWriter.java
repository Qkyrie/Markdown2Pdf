package com.qkyrie.markdown2pdf.internal.writing;

/**
 * User: Quinten
 * Date: 31-3-2014
 * Time: 16:41
 *
 * @author Quinten De Swaef
 */
@FunctionalInterface
public interface Markdown2PdfWriter {
    void write(byte[] out);
}
