package util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ProUtil {
    public Properties Pro;
    public ProUtil(String filePath) throws IOException {
        Pro = redProperties(filePath);
    }
    private Properties redProperties(String filePath) throws IOException {
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream(filePath);
        BufferedInputStream inputStream = new BufferedInputStream(fileInputStream);
        properties.load(inputStream);
        return properties;
    }
    public String getPro(String key){
        String value;
        if(Pro.containsKey(key)) {
            value = Pro.getProperty(key);
            return value;
        }else {
            return "";
        }
    }
    public int getLines(){
        return Pro.size();

    }
    public static void main(String[] args) throws IOException {
        //String FilePath = null;
        ProUtil proUtil = new ProUtil("C:\\uitest\\src\\main\\resources\\element.properties");
        System.out.println(proUtil.getPro("username"));
    }
}
