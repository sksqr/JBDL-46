package org.commonlib;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class RequestFilter extends HttpFilter {
    private static Logger LOGGER = LoggerFactory.getLogger(RequestFilter.class);

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException, ServletException, IOException {
        MDC.put("requestId", request.getHeader("requestId"));
        LOGGER.info("Processing request before controller in filter");
        filterChain.doFilter(request,response);
        LOGGER.info("Processing request after controller in filter");
        MDC.clear();
    }
}
