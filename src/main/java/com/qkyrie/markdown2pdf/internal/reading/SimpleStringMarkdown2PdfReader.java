package com.qkyrie.markdown2pdf.internal.reading;

/**
 * User: Quinten
 * Date: 1-4-2014
 * Time: 12:26
 *
 * @author Quinten De Swaef
 */
public class SimpleStringMarkdown2PdfReader implements Markdown2PdfReader {

    private String markdownAsString;

    public SimpleStringMarkdown2PdfReader(String markdownAsString) {
        this.markdownAsString = markdownAsString;
    }

    @Override
    public String read() {
        return markdownAsString;
    }
}
