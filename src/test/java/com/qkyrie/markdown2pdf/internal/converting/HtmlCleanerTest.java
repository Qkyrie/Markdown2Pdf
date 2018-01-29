package com.qkyrie.markdown2pdf.internal.converting;

import com.qkyrie.markdown2pdf.internal.converting.HtmlCleaner;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

import java.nio.charset.Charset;

/**
 * User: Quinten
 * Date: 31-3-2014
 * Time: 22:40
 *
 * @author Quinten De Swaef
 */
public class HtmlCleanerTest {

    public static final String INPUT_HTML = "<p><strong><em>Test</em></strong></p>";
    public static final String UTF_16_INPUT_HTML = "<p><strong><em>ЀЁЂЃЄЅЊ</em></strong></p>";
    public static final String UTF_8_INPUT_HTML = "<p><strong><em>Belén</em></strong></p>";
    public static final String ASCII_INPUT_HTML = "<em>&#1024;&#1025;&#1026;&#1027;&#1028;&#1029;&#1034;</em>";

    @Test
    public void testClean() throws Exception {
        HtmlCleaner cleaner = new HtmlCleaner();
        String clean = cleaner.clean(INPUT_HTML);
        assertThat(clean).contains("<p><strong><em>Test</em></strong></p>");
    }
    
    @Test
    public void testCleanWithEncoding() throws Exception {
        HtmlCleaner cleaner = new HtmlCleaner();
        String clean = cleaner.clean(UTF_16_INPUT_HTML, "UTF-16", "ASCII");
        assertThat(clean).contains("<em>&#1024;&#1025;&#1026;&#1027;&#1028;&#1029;&#1034;</em>");
        
        clean = cleaner.cleanWithInputEncoding(UTF_8_INPUT_HTML, "UTF-8");
        assertThat(clean).contains("<p><strong><em>Belén</em></strong></p>");
        
        clean = cleaner.cleanWithOutputEncoding(ASCII_INPUT_HTML, "UTF-16");
        assertThat(clean).contains("<em>ЀЁЂЃЄЅЊ</em>");
    }
}
