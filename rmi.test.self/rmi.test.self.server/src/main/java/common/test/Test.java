package common.test;

import java.io.UnsupportedEncodingException;

/**
 * Created by liyanan on 2019/8/30.
 */
public class Test {

    public static byte[] getUTF8BytesFromGBKString(String gbkStr) {
        int n = gbkStr.length();
        byte[] utfBytes = new byte[3 * n];
        int k = 0;
        for (int i = 0; i < n; i++) {
            int m = gbkStr.charAt(i);
            if (m < 128 && m >= 0) {
                utfBytes[k++] = (byte) m;
                continue;
            }
            utfBytes[k++] = (byte) (0xe0 | (m >> 12));
            utfBytes[k++] = (byte) (0x80 | ((m >> 6) & 0x3f));
            utfBytes[k++] = (byte) (0x80 | (m & 0x3f));
        }
        if (k < utfBytes.length) {
            byte[] tmp = new byte[k];
            System.arraycopy(utfBytes, 0, tmp, 0, k);
            return tmp;
        }
        return utfBytes;
    }

    public static void main(String[] args) {

        String  s="中国人";

        System.out.println(Test.isUTF8(s));


        try {
            String str2=new String(s.getBytes("GBK"),"GBK");
            System.out.println("转成GBK会乱码："+str2);
            System.out.println(Test.isUTF8(str2));
            System.out.println(Test.getEncoding(str2));;
            s = new String(s.getBytes(), "GBK");
            System.out.println(Test.isUTF8(s));
            System.out.println(Test.getEncoding(s));;
            System.out.println(new String(Test.getUTF8BytesFromGBKString(str2),"utf-8"));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static boolean isUTF8(String key){
            try {
                key.getBytes("utf-8");
                return true;
            } catch (UnsupportedEncodingException e) {
               return false;
         }
       }

    /**
     * 判断字符串的编码
     *
     * @param str
     * @return
     */
    public static String getEncoding(String str) {
        String encode = "GB2312";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                String s = encode;
                return s;
            }
        } catch (Exception exception) {
        }
        encode = "ISO-8859-1";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                String s1 = encode;
                return s1;
            }
        } catch (Exception exception1) {
        }
        encode = "UTF-8";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                String s2 = encode;
                return s2;
            }
        } catch (Exception exception2) {
        }
        encode = "GBK";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                String s3 = encode;
                return s3;
            }
        } catch (Exception exception3) {
        }
        return "";
    }

}
