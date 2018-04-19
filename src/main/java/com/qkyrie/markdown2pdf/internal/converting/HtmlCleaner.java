package com.qkyrie.markdown2pdf.internal.converting;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.w3c.tidy.Tidy;

import com.qkyrie.markdown2pdf.internal.exceptions.ConversionException;

/**
 * User: Quinten
 * Date: 31-3-2014
 * Time: 09:44
 *
 * @author Quinten De Swaef
 */
public class HtmlCleaner {
	
	/**
	 * Clean-up HTML code, asumes UTF-8 as input and output encoding.
	 * @param input HTML Text
	 * @return
	 * @throws ConversionException
	 */
    public String clean(String input) throws ConversionException {
        return clean(input, null, null);
    }
    
    /**
     * Clean-up HTML code with specified output encoding, asumes UTF-8 as input encoding.
     * @param input
     * @param outputEncoding
     * @return
     * @throws ConversionException
     */
    public String cleanWithOutputEncoding(String input, String outputEncoding) throws ConversionException {
    	return clean(input, null, outputEncoding);
    }
    
    /**
     * Clean-up HTML code with specified input encoding, asumes UTF-8 as output encoding.
     * @param htmlFile
     * @param inputEncoding
     * @return
     * @throws ConversionException
     */
	public String cleanWithInputEncoding(String htmlFile, String inputEncoding) throws ConversionException {
		return clean(htmlFile, inputEncoding, null);
	}
    
    /**
     * Clean-up HTML code with specified input and output encodings.
     * 
     * @param input HTML text
     * @param inputEncoding A valid java encoding name. Uses UTF-8 if null.
     * @param outputEncoding A valid java encoding name. Uses UTF-8 if null.
     * @return
     * @throws ConversionException
     */
    public String clean(String input, String inputEncoding, String outputEncoding) throws ConversionException {
        InputStream stringAsStream;
        try {
            stringAsStream = new ByteArrayInputStream(input.getBytes(inputEncoding !=null ? inputEncoding : "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            throw ConversionException.HTML_TO_PDF_EXCEPTION;
        }
        ByteArrayOutputStream outputAsStream = new ByteArrayOutputStream();
        Tidy htmlCleaner = new Tidy();
        htmlCleaner.setInputEncoding(inputEncoding !=null ? inputEncoding : "UTF-8");
        htmlCleaner.setOutputEncoding(outputEncoding != null ? outputEncoding : "UTF-8");
        htmlCleaner.setXHTML(true);
        htmlCleaner.parse(stringAsStream, outputAsStream);

        try {
            String result = outputAsStream.toString(outputEncoding != null ? outputEncoding : "UTF-8");
            return result.trim();
        } catch (UnsupportedEncodingException e) {
            throw ConversionException.HTML_TO_PDF_EXCEPTION;
        }
    }
}
