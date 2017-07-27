package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.codec.binary.Hex;

public class FileMD5 {
	
	static MessageDigest MD5 = null;


    static {
        try {
        MD5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException ne) {
        ne.printStackTrace();
        }
    }
	
	
    public static String getMD5(String filePath) {
        FileInputStream fileInputStream = null;
        try {
        	File file = new File(filePath);
        fileInputStream = new FileInputStream(file);
            byte[] buffer = new byte[8192];
            int length;
            while ((length = fileInputStream.read(buffer)) != -1) {
            MD5.update(buffer, 0, length);
            }


            return new String(Hex.encodeHex(MD5.digest()));
        } catch (FileNotFoundException e) {
        e.printStackTrace();
            return null;
        } catch (IOException e) {
        e.printStackTrace();
            return null;
        } finally {
            try {
                if (fileInputStream != null)
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
	
	
	
	
	public static String Md5(String filePath) {
		String md5 = null;
		try {
			File file = new File(filePath);
			FileInputStream fis = new FileInputStream(file);
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] buffer = new byte[1024];
			int length = -1;
			while ((length = fis.read(buffer, 0, 1024)) != -1) {
				md.update(buffer, 0, length);
			}
			fis.close();
			BigInteger bigInt = new BigInteger(1, md.digest());
			md5 = bigInt.toString(16);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return md5;
	}
	
	
	public static void main(String[] a){
		/*String path="F:\\os\\img\\cn_windows_7_ultimate_with_sp1_x86_dvd_u_677486.iso";
		System.out.println(System.currentTimeMillis());
		String md5 = FileMD5.getMD5(path);// .Md5(path);
		System.out.println(md5);
		System.out.println(System.currentTimeMillis());
		
		 * 	15006165 81
			faa364a36cddcbbfd65c0224f35fcfd0
			15006165 91
		 */
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date now=new Date();
		System.out.println(sdf.format(now));
		
		
		
	}
	
	
	
}
