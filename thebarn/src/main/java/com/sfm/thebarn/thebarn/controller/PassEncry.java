package com.sfm.thebarn.thebarn.controller;

import org.apache.commons.codec.digest.DigestUtils;


/*This is a temporary solution, later it will be removed
* in the dev branch.*/

public class PassEncry {
    public static String HashString(String password)
    {
        return DigestUtils.sha256Hex(password);
    }
}
