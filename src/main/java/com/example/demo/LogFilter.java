package com.example.demo;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

@Component
@Order(1)
public class LogFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        System.out.println("Start " + request.getPathInfo());
        CachedBodyHttpServletRequest cr = new CachedBodyHttpServletRequest(request);
        String firstAttempt = new BufferedReader(new InputStreamReader(cr.getInputStream())).lines().collect(Collectors.joining("\n"));
        String secondAttempt = new BufferedReader(new InputStreamReader(cr.getInputStream())).lines().collect(Collectors.joining("\n"));
        System.out.println("First Attempt Request is " + firstAttempt);
        System.out.println("Second Attempt Request is " + secondAttempt);
        filterChain.doFilter(cr, response);
        System.out.println("Finish " + request.getPathInfo());
    }
}
