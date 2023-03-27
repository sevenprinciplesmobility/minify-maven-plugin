package com.samaxes.maven.minify.common;

/**
 * String utils
 */
public class Strings {

    /**
     * Returns true if given string is null or empty
     *
     * @param str String to test for nullness or emptiness
     * @return true if null or empty
     */
    public static boolean isNullOrEmpty(String str){
        return str == null || str.isEmpty();
    }
}
