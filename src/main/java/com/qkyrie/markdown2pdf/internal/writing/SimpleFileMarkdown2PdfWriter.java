package com.qkyrie.markdown2pdf.internal.writing;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * User: Quinten
 * Date: 1-4-2014
 * Time: 12:27
 *
 * @author Quinten De Swaef
 */
public class SimpleFileMarkdown2PdfWriter implements Markdown2PdfWriter {

    private File file;

    public SimpleFileMarkdown2PdfWriter(File file) {
        this.file = file;
    }

    @Override
    public void write(byte[] out) {
        if(this.file == null) {
            throw new RuntimeException("File was not found or undefined");
        }

        try {
            FileUtils.writeByteArrayToFile(file, out);
        } catch (IOException e) {
            throw new RuntimeException("File was not found or undefined");
        }
    }
}
