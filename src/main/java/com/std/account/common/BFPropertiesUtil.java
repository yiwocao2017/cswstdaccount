package com.std.account.common;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class BFPropertiesUtil {

    private static Properties props = null;

    public static void init(String configFile) {
        props = new Properties();
        try {
            InputStream in = BFPropertiesUtil.class
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
        public static String PC_VER = props.getProperty("PC_VER");

        public static String PC_KEYTYPE = props.getProperty("PC_KEYTYPE");

        public static String PC_NOTICETYPE = props.getProperty("PC_NOTICETYPE");

        public static String PC_PAYURL = props.getProperty("PC_PAYURL");

        // *********************PC end*********************

        // *********************WAP start*********************
        public static String WAP_VER = props.getProperty("WAP_VER");

        public static String WAP_INPUTCHARSET = props
            .getProperty("WAP_INPUTCHARSET");

        public static String WAP_LANGUAGE = props.getProperty("WAP_LANGUAGE");

        public static String WAP_TXNTYPE = props.getProperty("WAP_TXNTYPE");

        public static String WAP_TXNSUBTYPE = props
            .getProperty("WAP_TXNSUBTYPE");

        public static String WAP_PFXPATH = props.getProperty("WAP_PFXPATH");

        public static String WAP_PFXPWD = props.getProperty("WAP_PFXPWD");

        public static String WAP_CERPATH = props.getProperty("WAP_CERPATH");

        public static String WAP_DATATYPE = props.getProperty("WAP_DATATYPE");

        public static String WAP_PAYURL = props.getProperty("WAP_PAYURL");
        // *********************WAP end*********************
    }
}
