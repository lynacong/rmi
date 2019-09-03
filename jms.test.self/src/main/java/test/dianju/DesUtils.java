package test.dianju;

import com.sun.crypto.provider.SunJCE;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.Security;

/**
 * Created by liyanan on 2019/9/3.
 */
public class DesUtils {
    public static String strDefaultKey = "leemenz";
    public static String strAvaliableDateKey = "dianju111111";
    public static String strUserNumKey = "dianju222222";
    public static String strSealNumKey = "dianju333333";
    public static String strUnitKey = "dianju444444";
    public static String strMenuKey = "dianju555555";
    private Cipher encryptCipher = null;
    private Cipher decryptCipher = null;
    public String strKey = "leemenz";

    public static String byteArr2HexStr(byte[] arrB)
            throws Exception
    {
        int iLen = arrB.length;

        StringBuffer sb = new StringBuffer(iLen * 2);
        for (int i = 0; i < iLen; i++)
        {
            int intTmp = arrB[i];
            while (intTmp < 0) {
                intTmp += 256;
            }
            if (intTmp < 16) {
                sb.append("0");
            }
            sb.append(Integer.toString(intTmp, 16));
        }
        return sb.toString();
    }

    public static byte[] hexStr2ByteArr(String strIn)
            throws Exception
    {
        byte[] arrB = strIn.getBytes();
        int iLen = arrB.length;

        byte[] arrOut = new byte[iLen / 2];
        for (int i = 0; i < iLen; i += 2)
        {
            String strTmp = new String(arrB, i, 2);
            arrOut[(i / 2)] = ((byte)Integer.parseInt(strTmp, 16));
        }
        return arrOut;
    }

    public DesUtils(String strKey)
            throws Exception
    {
        Security.addProvider(new SunJCE());
        Key key = getKey(strKey.getBytes());
        this.encryptCipher = Cipher.getInstance("DES");
        this.encryptCipher.init(1, key);
        this.decryptCipher = Cipher.getInstance("DES");
        this.decryptCipher.init(2, key);
    }

    public DesUtils()
            throws Exception
    {
        Security.addProvider(new SunJCE());
        Key key = getKey(this.strKey.getBytes());
        this.encryptCipher = Cipher.getInstance("DES");
        this.encryptCipher.init(1, key);
        this.decryptCipher = Cipher.getInstance("DES");
        this.decryptCipher.init(2, key);
    }

    public byte[] encrypt(byte[] arrB)
            throws Exception
    {
        return this.encryptCipher.doFinal(arrB);
    }

    public String encrypt(String strIn)
            throws Exception
    {
        return byteArr2HexStr(encrypt(strIn.getBytes("utf-8")));
    }

    public byte[] decrypt(byte[] arrB)
            throws Exception
    {
        return this.decryptCipher.doFinal(arrB);
    }

    public String decrypt(String strIn)
            throws Exception
    {
        return new String(decrypt(hexStr2ByteArr(strIn)), "utf-8");
    }

    public String decryptDate(String strIn)
            throws Exception
    {
        return new String(decrypt(hexStr2ByteArr(strIn)));
    }

    private Key getKey(byte[] arrBTmp)
            throws Exception
    {
        byte[] arrB = new byte[8];
        for (int i = 0; (i < arrBTmp.length) && (i < arrB.length); i++) {
            arrB[i] = arrBTmp[i];
        }
        Key key = new SecretKeySpec(arrB, "DES");
        return key;
    }

    public static void main(String[] args)
    {
        try
        {
            String test = "2019-09-10";
            DesUtils des = null;
            des = new DesUtils(strAvaliableDateKey);

            System.out.println("加密后的字符：" + des.encrypt(test));
            System.out.println("解密后的字符：" + des.decrypt("c6b1c6eaab1c9aa7d95b6c8563e42409"));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
