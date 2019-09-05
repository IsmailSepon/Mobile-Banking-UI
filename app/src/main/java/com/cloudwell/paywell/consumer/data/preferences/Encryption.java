package com.cloudwell.paywell.consumer.data.preferences;

/**
 * Created by Kazi Md. Saidul Email: Kazimdsaidul@gmail.com  Mobile: +8801675349882 on 2019-09-05.
 */
public interface Encryption {

    /**
     * Initialize the encryption algorithm, If the device does not support required
     * crypto return false
     *
     * @return true if crypto is supported
     */
    boolean init();

    /**
     * Encrypt the given string and returns cipher text
     *
     * @param key   is the given key
     * @param value is the plain text
     * @return cipher text as string
     */
    String encrypt(String key, String value) throws Exception;

    /**
     * Decrypt the given cipher text and return plain text
     *
     * @param key   is the given key
     * @param value is the cipher text
     * @return plain text
     */
    String decrypt(String key, String value) throws Exception;

}
