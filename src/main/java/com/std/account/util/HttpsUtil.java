package com.std.account.util;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/** 
 * @author: haiqingzheng 
 * @since: 2016年11月26日 下午2:03:54 
 * @history:
 */
public class HttpsUtil {
    private static class TrustAnyTrustManager implements X509TrustManager {

        @Override
        public void checkClientTrusted(X509Certificate[] chain, String authType)
                throws CertificateException {
        }

        @Override
        public void checkServerTrusted(X509Certificate[] chain, String authType)
                throws CertificateException {
        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[] {};
        }

    }

    private static class TrustAnyHostnameVerifier implements HostnameVerifier {
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    }

    /**
     * post方式请求服务器(https协议)
     * 
     * @param url
     *            请求地址
     * @param content
     *            参数
     * @param charset
     *            编码
     * @return
     * @throws NoSuchAlgorithmException
     * @throws KeyManagementException
     * @throws IOException
     */
    public static byte[] post(String url, String content, String charset)
            throws NoSuchAlgorithmException, KeyManagementException,
            IOException {
        SSLContext sc = SSLContext.getInstance("SSL");
        sc.init(null, new TrustManager[] { new TrustAnyTrustManager() },
            new java.security.SecureRandom());

        URL console = new URL(url);
        HttpsURLConnection conn = (HttpsURLConnection) console.openConnection();
        conn.setSSLSocketFactory(sc.getSocketFactory());
        conn.setHostnameVerifier(new TrustAnyHostnameVerifier());
        conn.setDoOutput(true);
        conn.connect();
        DataOutputStream out = new DataOutputStream(conn.getOutputStream());
        out.write(content.getBytes(charset));
        // 刷新、关闭
        out.flush();
        out.close();
        InputStream is = conn.getInputStream();
        if (is != null) {
            ByteArrayOutputStream outStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = is.read(buffer)) != -1) {
                outStream.write(buffer, 0, len);
            }
            is.close();
            return outStream.toByteArray();
        }
        return null;
    }

    private static void getUserList() {
        // String accessToken = WeChatClientSend.getAccessToken(
        // "wx8bc03dd744895352", "44ebf0ef908dc54656573625a579ea82");
        // // String openIds = WeChatClientSend.getOpenIdList(accessToken);
        // System.out.println(accessToken);
        // String postUrl =
        // "https://api.weixin.qq.com/cgi-bin/user/info/batchget?access_token="
        // + accessToken;
        // String[] openIds = { "ojdtdv8a8-q0zXinOXQjA1DKNMKg",
        // "ojdtdv4tCTUZ-aBsTZQ_duLBKg3I", "ojdtdv5k5eIIwa6mViWLpO34fRA4",
        // "ojdtdv5fmsOwDeikUy11LbHkU6i8", "ojdtdv9JNbYQqukXvesUsGXRA13E",
        // "ojdtdvyrZkB-NNmXEfiJSAglyZ9Y", "ojdtdv7NK4g9WplkZN7MMSpjmhT4",
        // "ojdtdv2G2NBeEMEQCinbbIDp0-j8", "ojdtdv5dunW9h4IPi_g5QmCOXrk8",
        // "ojdtdv71yky2o8yofg3TkSyog93E", "ojdtdvzE13X_QkqZ6qkGRXrlJNYM",
        // "ojdtdv-YX-hZH5rvM6ZEKpufjtdM", "ojdtdv7cSlzH5bgretl7z6KRy1kg",
        // "ojdtdvzvkrN7dkuNQX_j7KqQFt0s", "ojdtdv8avxBXl-Y125fCXuX3XkoE",
        // "ojdtdv5LejTCjFXaCcfcWjht4uxc", "ojdtdv4qiejFkei1sHOwPQkKCBBc",
        // "ojdtdvxU9zYBR7eKKs9JXxmhnhSg", "ojdtdv3_I1-kLBtgQCAtreEwbj6Q",
        // "ojdtdvyJ0iAn5oo4Zq5M32-sYDNI", "ojdtdvwWAVFl4beZQ9EsPtDXGZfM",
        // "ojdtdv2eDtr2WJTpokBaooHTlJD8", "ojdtdv_SFd8auuyg6nMcRglR8fwk",
        // "ojdtdv7QXxYPRGsnwqlbiPbl4nc0", "ojdtdv_3dNhHDJNiV0BJt7wW-N5s",
        // "ojdtdv6UmYhpTxcJIhB7Wx-rsw-A", "ojdtdvxIJmm3QLmSmQ0A_-burblU",
        // "ojdtdv5RfSzodwzJc9q21RV25ntU", "ojdtdvzuWuKZ4Kt4R7wUDICIwgjk",
        // "ojdtdvxY6L0n8hi4dgJZJIU-UGC8", "ojdtdv8Ol12rFoADbdL_bwBnoudk",
        // "ojdtdv471JqvTvr_ey8HSRnavyvE", "ojdtdv4Wg1N5C78_bKZZeWatmwfQ",
        // "ojdtdv44r_FgijS6a1dMZiCC1lQ8", "ojdtdvzRpxBvichsFNs1GdecSFbU",
        // "ojdtdv2iiCSLGAXV9QdlP_cDzxCk", "ojdtdvyDc6xAGcuq2Ob3dRkG7ZH8",
        // "ojdtdv7Fn9KIVivvBXekdksPIyPI", "ojdtdv4Zan2hXG5JTM9lZ-a4rtug",
        // "ojdtdv7DvvXRzlopcx8ZqwfLMqkY", "ojdtdvzzIkfxLmTRTsDqkLHCE7O4",
        // "ojdtdv5A4_dwNdjC7nt3HopPc5t0", "ojdtdv46MxYob5z5GXy3udPlPZcw",
        // "ojdtdv2VWmsrwLGTdJOb6zuyNfg4", "ojdtdv9g1syNVzWjFSLjBmUipMb4",
        // "ojdtdv1Z60PW9fswU7NXAwPmX7kQ", "ojdtdv8nM7Zo3w32b9fkcLAoxVrY",
        // "ojdtdv-pEQXKmVjY5D7gEDRLcUn8", "ojdtdv_gQAkrWa2-zFu794ZxoqfA",
        // "ojdtdvyMB31Bkc0GIMVFi1HBqQ9c", "ojdtdv0M_x8ujW02Qb-pkmhig2dk",
        // "ojdtdv0vbD0JgUxiqo83NobNxYuQ", "ojdtdv3vlUmuwfUww7sju36mzjFU" };
        // List<UserData> user_list = new ArrayList<UserData>();
        // for (int i = 0; i < openIds.length; i++) {
        // user_list.add(new UserData(openIds[i], null));
        // }
        // String content = "{\"user_list\":" + JsonUtil.Object2Json(user_list)
        // + "}";
        // System.out.println(content);
        // try {
        // String result = new String(post(postUrl, content, "UTF-8"));
        // System.out.println("result:" + result);
        // } catch (KeyManagementException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // } catch (NoSuchAlgorithmException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // } catch (IOException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }
    }

    private static void getOpenIdList() {
        String ACCESS_TOKEN = "";
    }

    public static void main(String[] args) {
        getUserList();
    }
}
