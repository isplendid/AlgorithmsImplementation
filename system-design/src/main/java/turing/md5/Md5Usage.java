package turing.md5;

import org.apache.commons.codec.binary.Hex;
import org.springframework.core.io.ClassPathResource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author xushichao
 * @date 2023/3/29 14:15
 * @desc
 */
public class Md5Usage {



    public static String rawDataMd5(InputStream in) throws NoSuchAlgorithmException, IOException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        byte[] buffer = new byte[64 * 1024];
        for(; ;) {
            int len = in.read(buffer);
            messageDigest.update(buffer, 0, len);
            if(len < buffer.length) {
                break;
            }
        }
        byte[] digest = messageDigest.digest();
        return new String(Hex.encodeHex(digest));
    }


    public static void main(String[] args) throws IOException {
       // String rootPath = System.getProperty("user.dir");

        String fileName = "test_md5";
//       String filePath = rootPath + "/system-design/" + fileName;
//        System.out.println(filePath);

        ClassPathResource classPathResource = new ClassPathResource(fileName);


        InputStream inputStream = classPathResource.getInputStream();

        String md5;
        try {
             md5 = rawDataMd5(inputStream);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        System.out.println(md5);
    }

}
