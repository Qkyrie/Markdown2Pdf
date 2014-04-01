package com.qkyrie.markdown2pdf.internal.writing;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * User: Quinten
 * Date: 1-4-2014
 * Time: 12:34
 *
 * @author Quinten De Swaef
 */
public class SimpleFileMarkdown2PdfWriterTest {

    public static final byte[] TEST_BYTES = "testbytes".getBytes();

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void testFileIsEmpty() {
        Markdown2PdfWriter writer = new SimpleFileMarkdown2PdfWriter(null);
        exception.expect(RuntimeException.class);
        writer.write(TEST_BYTES);
    }
}
