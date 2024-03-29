package Models;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.math.BigInteger;

/**
 *
 * @author caiomartins
 */
public class SecurityUtil {
    
        /**
     * @param byteArr byte array to be converted to a hex String
     * @return String representation of hex value.
     * <p>
     */
    public static String byteArrayToHex(byte[] byteArr) {
        if(byteArr == null)
            return "";

        BigInteger value = new BigInteger(1, byteArr);
        String hex = value.toString(16);

        int paddingLength = (byteArr.length * 2) - hex.length();
        if (paddingLength > 0) {
            return String.format("%0" + paddingLength + "d", 0) + hex;
        } else {
            return hex;
        }
    }
    
}