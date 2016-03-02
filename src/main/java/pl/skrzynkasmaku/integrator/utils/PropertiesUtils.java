package pl.skrzynkasmaku.integrator.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Bartosz Spychaj
 */
public class PropertiesUtils {

    private static final Properties properties = new Properties();

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static void read() throws FileNotFoundException, IOException {
        String propertiesPath = getAbsoluePath(IntegratorUtils.PROPERTIES_PATH);
        properties.load(new FileInputStream(propertiesPath));
    }

    public static Properties read(String fileName) throws FileNotFoundException, IOException {
        Properties p = new Properties();
        String propertiesPath = getAbsoluePath(fileName);
        p.load(new FileInputStream(propertiesPath));
        
        return p;
    }

    public static String getAbsoluePath() {
        File jarPath = new File(PropertiesUtils.class.getProtectionDomain().getCodeSource().getLocation().getPath());
        String path = jarPath.getParentFile().getAbsolutePath();
        return path;
    }

    public static String getAbsoluePath(String fileName) {
        String path = getAbsoluePath() + "\\" + fileName;
        return path;
    }
}
