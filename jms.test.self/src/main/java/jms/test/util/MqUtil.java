package jms.test.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

/**
 * Created by liyanan on 2019/9/3.
 *
 * 公共类 产生公共的方式
 */
public class MqUtil {

    private static HashMap<String, String> File_MAPPINGS = new HashMap<String, String>();

    private static Properties evoucherConfPro = MqUtil
            .getProByCustomPath("/", "queue.properties");

    /**
     * 从当前路径获取文件
     * */
    public static Properties getProByCustomPath(String customPath,
                                                String fileName) {
        InputStream in = null;
        Properties prop = new Properties();
        try {
            String file = MqUtil.class.getClassLoader().getResource(customPath+fileName).getFile();
            file=file.replace("%20"," ");
            in=new FileInputStream(file);
            prop.load(in);
        } catch (Exception e) {
           e.printStackTrace();
        } finally {
            if (in != null)
                try {
                    in.close();
                } catch (IOException e) {
                   e.printStackTrace();
                }
        }
        return prop;
    }
}
