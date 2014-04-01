package com.qkyrie.markdown2pdf.internal.converting;

import com.qkyrie.markdown2pdf.internal.exceptions.ConversionException;

/**
 * User: Quinten
 * Date: 31-3-2014
 * Time: 16:27
 *
 * @author Quinten De Swaef
 */
public interface Converter<T, I> {

    public I convert(T input) throws ConversionException;

}
