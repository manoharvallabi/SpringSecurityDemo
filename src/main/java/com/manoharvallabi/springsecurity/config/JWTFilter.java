package com.manoharvallabi.springsecurity.config;


import com.manoharvallabi.springsecurity.service.CustomUserDetailsService;
import com.manoharvallabi.springsecurity.service.JWTService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JWTFilter extends OncePerRequestFilter {

    @Autowired
    private JWTService jwtService;

    @Autowired
    ApplicationContext context;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //authorization header will have the incoming jwt details(Bearer your_jwt_token)
        String authorizationHeader = request.getHeader("Authorization");
        String jwtToken = null;
        String username = null;
        if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            //we are collecting the jwt token which comes after "Bearer jwt_token"
            jwtToken = authorizationHeader.substring(7);
            username = jwtService.extractUserName(jwtToken);
        }

        //validating the token
        //we will validate it only if it's not already validated
        //that's the reason we are asking the SecurityContextHolder for authentication details
        if(jwtToken != null && SecurityContextHolder.getContext().getAuthentication()==null) {
            //fetch the UserDetails
            UserDetails userDetails = context
                    .getBean(CustomUserDetailsService.class)
                    .loadUserByUsername(username);
            //validate the token and pass it to the next filter
            if(jwtService.validateToken(jwtToken,userDetails))
            {
                //create a UsernamePasswordAuthenticationToken to send it to filter chain
                UsernamePasswordAuthenticationToken authToken =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }

        }
        //send it to filter chain to pass it to next filter
        filterChain.doFilter(request, response);

    }
}
