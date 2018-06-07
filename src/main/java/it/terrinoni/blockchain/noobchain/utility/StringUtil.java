package it.terrinoni.blockchain.noobchain.utility;

/*
 * Created by Marco Terrinoni, on 07/06/2018 - 22:37.
 */

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class StringUtil {

  public static String applySha256(String msg) {
    //noinspection StringBufferMayBeStringBuilder
    StringBuffer hexString = new StringBuffer();
    try {
      MessageDigest digest = MessageDigest.getInstance("SHA-256");
      byte[] hash = digest.digest(msg.getBytes("UTF-8"));
      for (byte aHash : hash) {
        String hex = Integer.toHexString(0xff & aHash);
        if (hex.length() == 1) {
          hexString.append('0');
        }
        hexString.append(hex);
      }
    } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
      e.printStackTrace();
    }

    return hexString.toString();
  }
}
