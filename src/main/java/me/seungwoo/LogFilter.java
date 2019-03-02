package me.seungwoo;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Leo.
 * User: sonseungwoo
 * Date: 2019-03-02
 * Time: 13:55
 */
@Configuration
public class LogFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(LogFilter.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        final HttpServletRequest request = (HttpServletRequest) servletRequest;
        final HttpServletResponse response = (HttpServletResponse) servletResponse;

        RequestWrapper requestWrapper = new RequestWrapper((HttpServletRequest) servletRequest);
        ResponseWrapper responseWrapper = new ResponseWrapper((HttpServletResponse) servletResponse);
        filterChain.doFilter(requestWrapper, responseWrapper);

        String body = IOUtils.toString(requestWrapper.getBody(), request.getCharacterEncoding());
        servletRequest.setAttribute("requestBody", body);

        if (response.getContentType() != null && response.getContentType().contains("application/json")) {
            String content = responseWrapper.getCaptureAsString();
            response.getWriter().write(content);
        }

        logger.info("request : {} , response : {}", body, responseWrapper.getCaptureAsString());

    }
}
