package com.lalalalz.web.common;

import com.lalalalz.application.util.BusinessException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionController {

    public static final int SLASH_EXCLUDED_INDEX = 1;

    @ExceptionHandler(BusinessException.class)
    public ModelAndView businessExceptionHandler(final BusinessException businessException,
                                                 final HttpServletRequest httpServletRequest
    ) {
        String requestURI = httpServletRequest
                .getRequestURI()
                .substring(SLASH_EXCLUDED_INDEX);

        return new ModelAndView(requestURI, "error", businessException.getMessage());
    }
}
