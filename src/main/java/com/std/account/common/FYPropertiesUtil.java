package com.std.account.common;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class FYPropertiesUtil {

    private static Properties props = null;

    public static void init(String configFile) {
        props = new Properties();
        try {
            InputStream in = FYPropertiesUtil.class
                .getResourceAsStream(configFile);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            props.load(br);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        if (props == null) {
            // throw new Exception("配置文件初始化失败");
        }
        return props.getProperty(key);
    }

    public static final class Config {
        // *********************PC start*********************
        public static String PC_ORDERVALIDTIME = props
            .getProperty("PC_ORDERVALIDTIME");

        public static String PC_VER = props.getProperty("PC_VER");

        public static String PC_PAYURL = props.getProperty("PC_PAYURL");

        // *********************PC end*********************

        // *********************WAP start*********************
        public static String WAP_ENCTP = props.getProperty("WAP_ENCTP");

        public static String WAP_VERSION = props.getProperty("WAP_VERSION");

        public static String WAP_TYPE = props.getProperty("WAP_TYPE");

        public static String WAP_LOGOTP = props.getProperty("WAP_LOGOTP");

        public static String WAP_SIGNTP = props.getProperty("WAP_SIGNTP");

        public static String WAP_PAYURL = props.getProperty("WAP_PAYURL");
        // *********************WAP end*********************
    }
}
