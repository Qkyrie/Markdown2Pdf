package com.qkyrie.markdown2pdf.internal.converting;

import com.qkyrie.markdown2pdf.internal.converting.HtmlCleaner;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * User: Quinten
 * Date: 31-3-2014
 * Time: 22:40
 *
 * @author Quinten De Swaef
 */
public class HtmlCleanerTest {

    public static final String INPUT_HTML = "<p><strong><em>Test</em></strong></p>";

    @Test
    public void testClean() throws Exception {
        HtmlCleaner cleaner = new HtmlCleaner();
        String clean = cleaner.clean(INPUT_HTML);
        assertThat(clean).contains("<p><strong><em>Test</em></strong></p>");
        assertThat(clean).hasSize(321);
    }
}
