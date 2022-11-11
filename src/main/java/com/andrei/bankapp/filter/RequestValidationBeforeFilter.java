package com.andrei.bankapp.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class RequestValidationBeforeFilter implements Filter {
    public static final String AUTHENTICATION_SCHEME_BASIC = "Basic";
    private final Charset credentialsCharset = StandardCharsets.UTF_8;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        String authorizationHeader = httpRequest.getHeader("Authorization");
        if (authorizationHeader != null && authorizationHeader.startsWith(AUTHENTICATION_SCHEME_BASIC)) {
            String base64Credentials = authorizationHeader.substring(AUTHENTICATION_SCHEME_BASIC.length()).trim();
            String credentials = new String(java.util.Base64.getDecoder().decode(base64Credentials), credentialsCharset);
            // credentials = username:password
            final String[] values = credentials.split(":", 2);
            String email = values[0];
//            String password = values[1];
            if (email.contains("test")) {
                httpResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                return;
            }
        }
        chain.doFilter(request, response);

    }

}
