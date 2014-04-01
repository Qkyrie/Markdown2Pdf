package com.qkyrie.markdown2pdf.internal.converting;

import com.qkyrie.markdown2pdf.internal.converting.Markdown2HtmlConverter;
import com.qkyrie.markdown2pdf.internal.exceptions.ConversionException;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * User: Quinten
 * Date: 31-3-2014
 * Time: 16:56
 *
 * @author Quinten De Swaef
 */
public class Markdown2HtmlConverterTest {

    public static final String TEST_INPUT = "***Test***";
    public static final String EXPECTED_TEST_OUTPUT = "<p><strong><em>Test</em></strong></p>";

    @Test
    public void testConvertWithTestData() throws ConversionException {
        Markdown2HtmlConverter converter = new Markdown2HtmlConverter();
        String convertedString = converter.convert(TEST_INPUT);
        assertThat(convertedString, equalTo(EXPECTED_TEST_OUTPUT));
    }
}
