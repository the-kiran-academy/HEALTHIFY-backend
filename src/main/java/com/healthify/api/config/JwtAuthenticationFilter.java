package com.healthify.api.config;
import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.healthify.api.constants.JwtConstatnt;
import com.healthify.api.utility.JwtUtil;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    

	@Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        String header = req.getHeader(JwtConstatnt.HEADER_STRING);
        String username = null;
        String authToken = null;
        if (header != null && header.startsWith(JwtConstatnt.TOKEN_PREFIX)) {
            authToken = header.replace(JwtConstatnt.TOKEN_PREFIX,"");
            try {
                username = jwtTokenUtil.getUsernameFromToken(authToken);
                //System.out.println("User from token "+username);
            } catch (IllegalArgumentException e) {
            	 System.err.println("an error occured during getting username from token");
            } catch (ExpiredJwtException e) {
                System.err.println("the token is expired and not valid anymore");
            } catch(SignatureException e){
            	 System.err.println("Authentication Failed. Username or Password not valid.");
            }
        } else {
        	 System.err.println("couldn't find bearer string, will ignore the header ! Logged In With Credientials");
        }
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            UserDetails userDetails = userDetailsService.loadUserByUsername(username);

            if (jwtTokenUtil.validateToken(authToken, userDetails)) {
                UsernamePasswordAuthenticationToken authentication = jwtTokenUtil.getAuthentication(authToken, SecurityContextHolder.getContext().getAuthentication(), userDetails);
                //UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN")));
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(req));
                System.err.println("authenticated user " + username + ", setting security context");
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }

        chain.doFilter(req, res);
    }
}