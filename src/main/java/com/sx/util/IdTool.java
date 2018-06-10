package com.sx.util;

import java.util.UUID;

public class IdTool {
    /**
     * 获取id
     * @return
     */
    public static String getID(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
