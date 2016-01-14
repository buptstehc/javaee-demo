package com.cmcciot.demo.web.interceptor;

import com.cmcciot.demo.common.constants.ErrorConstants;
import com.cmcciot.demo.common.utils.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;

/**
 * @Description
 * @Author 黄川
 * @Date 16/1/14
 */
@ControllerAdvice
public class GlobalDefaultInterceptor {

    private final static Logger logger = LoggerFactory.getLogger(GlobalDefaultInterceptor.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Map<String, Object> defaultErrorHandler(HttpServletRequest request,
                                                   HttpServletResponse response,
                                                   Exception e) throws IOException {
        logger.error(e.getMessage(), e);

        if (isAjax(request)) {
            return ResponseUtil.failWithError(ErrorConstants.SYS_ERR_CODE, ErrorConstants.SYS_ERR_MSG);
        }

//        response.sendRedirect("/500"); //非ajax请求重定向到500页面

        return Collections.emptyMap();
    }

    private boolean isAjax(HttpServletRequest request) {
        return "XMLHttpRequest".equals(request.getHeader("X-Requested-With"));
    }
}
