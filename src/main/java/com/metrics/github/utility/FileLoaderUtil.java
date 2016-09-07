package com.metrics.github.utility;

import org.apache.commons.configuration2.ConfigurationConverter;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

import java.io.File;
import java.io.InputStream;
import java.util.MissingResourceException;
import java.util.Properties;
import java.util.Scanner;

public class FileLoaderUtil {

    public static Properties load(String path) {
        Configurations configurations = new Configurations();
        File propFile = new File(path);
        PropertiesConfiguration config = null;
        try {
            config = configurations.properties(propFile);
        } catch (ConfigurationException e) {
            throw new MissingResourceException("Cannot find the " + path + " file", e.getClass().getName(), "Resource file");
        }
        Properties properties = ConfigurationConverter.getProperties(config);
        return properties;
    }

    public static String convertFileContentToString(String fileName) {
        InputStream is = FileLoaderUtil.class.getClassLoader().getResourceAsStream(fileName);
        Scanner scanner = new Scanner(is).useDelimiter("\\A");
        return scanner.hasNext() ? scanner.next() : "";
    }
}
