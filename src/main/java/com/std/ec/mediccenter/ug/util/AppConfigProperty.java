package com.std.ec.mediccenter.ug.util;

import java.util.Properties;

public class AppConfigProperty {

    private static final Properties properties;

    static {

        properties = new Properties();
        try {

            properties.load(AppConfigProperty.class.getClassLoader().getResourceAsStream("application.properties"));

        } catch (Exception e) {
            System.err.println("Error de cargar properties:" + e.getMessage());
        }
    }

    public static String getPropiedad(String clave) {
        return properties.getProperty(clave);
    }

}
