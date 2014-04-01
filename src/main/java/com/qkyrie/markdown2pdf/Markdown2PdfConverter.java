package com.qkyrie.markdown2pdf;

import com.qkyrie.markdown2pdf.internal.converting.Html2PdfConverter;
import com.qkyrie.markdown2pdf.internal.converting.HtmlCleaner;
import com.qkyrie.markdown2pdf.internal.converting.Markdown2HtmlConverter;
import com.qkyrie.markdown2pdf.internal.exceptions.ConversionException;
import com.qkyrie.markdown2pdf.internal.exceptions.Markdown2PdfLogicException;
import com.qkyrie.markdown2pdf.internal.reading.Markdown2PdfReader;
import com.qkyrie.markdown2pdf.internal.writing.Markdown2PdfWriter;

/**
 * User: Quinten
 * Date: 31-3-2014
 * Time: 09:43
 *
 * @author Quinten De Swaef
 */
public class Markdown2PdfConverter {
    private Markdown2PdfReader reader;
    private Markdown2PdfWriter writer;
    private Markdown2HtmlConverter markdown2htmlConverter;
    private HtmlCleaner htmlCleaner;
    private Html2PdfConverter html2PdfConverter;


    private Markdown2PdfConverter() {
        this.markdown2htmlConverter = new Markdown2HtmlConverter();
        this.htmlCleaner = new HtmlCleaner();
        this.html2PdfConverter = new Html2PdfConverter();
    }

    public static Markdown2PdfConverter newConverter() {
        return new Markdown2PdfConverter();
    }

    public Markdown2PdfConverter readFrom(Markdown2PdfReader reader){
        this.reader = reader;
        return this;
    }

    public Markdown2PdfConverter writeTo(Markdown2PdfWriter writer) {
        this.writer = writer;
        return this;
    }

    public void doIt() throws ConversionException, Markdown2PdfLogicException {
        validateLogicBeforeExecution();
        String originalMarkdownFile = reader.read();
        String htmlFile = markdown2htmlConverter.convert(originalMarkdownFile);
        String cleanedHtmlFile = htmlCleaner.clean(htmlFile);
        byte[] convertedPdfFile = html2PdfConverter.convert(cleanedHtmlFile);
        writer.write(convertedPdfFile);
    }

    private void validateLogicBeforeExecution() throws Markdown2PdfLogicException {
        if(this.reader == null) {
            throw Markdown2PdfLogicException.LOGIC_SETUP_READER;
        }
        if(this.writer == null) {
            throw Markdown2PdfLogicException.LOGIC_SETUP_WRITER;
        }
    }

}
