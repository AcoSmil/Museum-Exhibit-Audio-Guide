package org.aco.museumapi.config;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ApiKeyFilter implements Filter {

    private static final String API_KEY = "my-secret-key"; // You can change this to anything
    private static final String HEADER_NAME = "X-API-Key";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String key = httpRequest.getHeader(HEADER_NAME);

        if (API_KEY.equals(key)) {
            chain.doFilter(request, response); // valid, continue
        } else {
            httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            httpResponse.getWriter().write("Unauthorized - Missing or invalid API key");
        }
    }
}
