package com.qkyrie.markdown2pdf.internal.converting;

import com.lowagie.text.DocumentException;
import com.qkyrie.markdown2pdf.internal.exceptions.ConversionException;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.ByteArrayOutputStream;

/**
 * User: Quinten
 * Date: 31-3-2014
 * Time: 09:44
 *
 * @author Quinten De Swaef
 */
public class Html2PdfConverter implements Converter<String, byte[]> {
    @Override
    public byte[] convert(String input) throws ConversionException {
        try {
            ITextRenderer renderer = new ITextRenderer();
            renderer.setDocumentFromString(new String(input.getBytes()));
            renderer.layout();
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            renderer.createPDF(outputStream);
            byte[] bytes = outputStream.toByteArray();
            return bytes;
        } catch (DocumentException e) {
            e.printStackTrace();
            throw ConversionException.HTML_TO_PDF_EXCEPTION;
        }
    }
}
