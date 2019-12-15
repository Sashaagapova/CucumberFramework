package utilities;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Configuration {

    // reading the information from properties file


    public static String getProperties(String key) throws IOException {
        //specify the needed file
        File credsFile = new File("/Users/sasha/IdeaProjects/CucumberFramework/src/test/resourses/conf/Configuration.properties");
        //read from a file
        FileReader fileReader = new FileReader(credsFile);
        Properties properties = new Properties();
        properties.load(fileReader);
        String value = properties.getProperty(key);
        return value;
    }





}
