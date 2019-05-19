package com.jiepi.spring.weather.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.Reader;
import java.io.StringReader;

public class XmlBuilder {

    /**
     * xml 转成 object
      * @param clazz
     * @param xmlStr
     * @return
     * @throws Exception
     */
    public static Object xmlStrToObjec(Class<?> clazz, String xmlStr) throws Exception {
        Object xmlObject = null;
        Reader reader = null;

        JAXBContext context = JAXBContext.newInstance(clazz);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        reader = new StringReader(xmlStr);
        xmlObject = unmarshaller.unmarshal(reader);
        if (null != reader) {
            reader.close();
        }
        return xmlObject;
    }
}
