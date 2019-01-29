package com.smile24es.sample.web;

import com.smile24es.sample.beans.error.CustomErrorBean;
import com.smile24es.sample.beans.error.ErrorCodes;
import com.smile24es.sample.exception.Smile24Exception;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * The base controller class
 * <p>
 * Created by hasithag
 * on 1/13/19.
 */
public class BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseController.class);
    private static final String UNKNOWN_ERROR_HAS_BEEN_THROWN_PLEASE_CONTACT_THE_ADMINISTRATOR =
            "Unknown CustomErrorBean has been thrown. Please contact the administrator";


    /**
     * Handle Smile24Exception, which is a runtime exception that can be thrown for known error conditions
     *
     * @param e
     * @param response
     * @return
     */
    @ExceptionHandler(Smile24Exception.class)
    @ResponseBody
    public CustomErrorBean handleForecasterException(Smile24Exception e, HttpServletResponse response) {
        LOGGER.error(e.getMessage(), e);
        return getError(e.getHttpStatusCode().value(), e.getErrorCode(), e.getMessage(), e.getMessage(), response);
    }

    /**
     * Handle docGenException, which is a runtime exception that can be thrown for known error conditions
     *
     * @param e
     * @param response
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public CustomErrorBean handleException(Exception e, HttpServletResponse response) {
        LOGGER.error(e.getMessage(), e);
        return getError(HttpStatus.INTERNAL_SERVER_ERROR.value(), ErrorCodes.SE_UNKNOWN_SERVER_ERROR,
                UNKNOWN_ERROR_HAS_BEEN_THROWN_PLEASE_CONTACT_THE_ADMINISTRATOR,
                e.getMessage(), response);
    }


    /**
     * method to populate the error object
     *
     * @param httpStatusCode
     * @param errorCode
     * @param description
     * @param additionalInfo
     * @param response
     * @return
     */
    private CustomErrorBean getError(int httpStatusCode,
                                     String errorCode,
                                     String description,
                                     String additionalInfo,
                                     HttpServletResponse response) {
        CustomErrorBean error = new CustomErrorBean(errorCode, description, additionalInfo);
        response.setStatus(httpStatusCode);
        return error;
    }
}
