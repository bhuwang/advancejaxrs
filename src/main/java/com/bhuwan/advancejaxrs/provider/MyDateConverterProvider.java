/**
 * 
 */
package com.bhuwan.advancejaxrs.provider;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Calendar;

import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;

import com.bhuwan.advancejaxrs.model.MyDate;

/**
 * ParamConverter: input-> String output -> Custom Data Type
 * 
 * ParamConverterProvider: input-> Custom Data Type output-> Param Converter
 * 
 * @author bhuwan
 *
 */
@Provider
public class MyDateConverterProvider implements ParamConverterProvider {

    @Override
    public <T> ParamConverter<T> getConverter(final Class<T> rawType, Type genericType, Annotation[] annotations) {
        if (rawType.getName().equals(MyDate.class.getName())) {
            return new ParamConverter<T>() {
                @Override
                public T fromString(String value) {
                    Calendar requestedDate = Calendar.getInstance();
                    if ("tomorrow".equals(value)) {
                        requestedDate.add(Calendar.DATE, 1);
                    } else if ("yesterday".equals(value)) {
                        requestedDate.add(Calendar.DATE, -1);
                    }
                    MyDate date = new MyDate();
                    date.setDate(requestedDate.get(Calendar.DATE));
                    date.setMonth(requestedDate.get(Calendar.MONTH));
                    date.setYear(requestedDate.get(Calendar.YEAR));
                    return rawType.cast(date);
                }

                @Override
                public String toString(T myBean) {
                    if (myBean == null) {
                        return null;
                    }
                    return myBean.toString();
                }
            };
        }
        return null;
    }

}
