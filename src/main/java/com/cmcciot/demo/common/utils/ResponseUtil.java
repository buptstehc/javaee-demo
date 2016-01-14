package com.cmcciot.demo.common.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author 黄川
 * @Date 16/1/14
 */
public class ResponseUtil {

    private static final int SUCCESS_CODE = 1;

    private static final int FAILURE_CODE = 0;

    public static Map ok(Object data) {
        Map r = new HashMap();
        r.put("code", SUCCESS_CODE);
        r.put("msg", "ok");
        r.put("data", data);

        return r;
    }

    public static Map fail() {
        Map r = new HashMap();
        r.put("code", FAILURE_CODE);
        r.put("msg", "error");

        return r;
    }

    public static Map failWithError(int errorCode, String errMsg) {
        Map r = new HashMap();
        r.put("code", errorCode);
        r.put("msg", errMsg);

        return r;
    }
}
