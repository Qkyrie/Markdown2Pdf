package com.qkyrie.markdown2pdf.internal.converting;

import com.qkyrie.markdown2pdf.internal.exceptions.ConversionException;
import org.markdown4j.Markdown4jProcessor;

import java.io.IOException;

/**
 * User: Quinten
 * Date: 31-3-2014
 * Time: 09:44
 *
 * @author Quinten De Swaef
 */
public class Markdown2HtmlConverter  implements Converter<String, String> {
    @Override
    public String convert(String input) throws ConversionException {
        try {
            return new Markdown4jProcessor().process(input).trim();
        } catch (IOException e) {
            throw ConversionException.HTML_TO_PDF_EXCEPTION;
        }
    }
}
