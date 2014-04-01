package com.qkyrie.markdown2pdf.internal.converting;

import com.qkyrie.markdown2pdf.internal.converting.Html2PdfConverter;
import com.qkyrie.markdown2pdf.internal.exceptions.ConversionException;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

/**
 * User: Quinten
 * Date: 31-3-2014
 * Time: 16:56
 *
 * @author Quinten De Swaef
 */
public class Html2PdfConverterTest {

    @Test
    public void testConvert() throws ConversionException {
        Html2PdfConverter converter = new Html2PdfConverter();
        byte[] convert = converter.convert("<p>testing</p>");
        assertNotNull(convert);
        assertThat(convert).hasSize(992);
    }

}
