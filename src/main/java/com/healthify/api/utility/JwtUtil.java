package com.healthify.api.utility;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.healthify.api.constants.JwtConstatnt;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import io.jsonwebtoken.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;


import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;


@Component
public class JwtUtil implements Serializable {

    

	public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(JwtConstatnt.SIGNING_KEY)
                .parseClaimsJws(token)
                .getBody();
    }

    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    public String generateToken(Authentication authentication) {
        final String authorities = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));
        return Jwts.builder()
                .setSubject(authentication.getName())
                .claim(JwtConstatnt.AUTHORITIES_KEY, authorities)
                .signWith(SignatureAlgorithm.HS256, JwtConstatnt.SIGNING_KEY)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JwtConstatnt.ACCESS_TOKEN_VALIDITY_SECONDS*1000))
                .compact();
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = getUsernameFromToken(token);
        return (
              username.equals(userDetails.getUsername())
                    && !isTokenExpired(token));
    }

    public UsernamePasswordAuthenticationToken getAuthentication(final String token, final Authentication existingAuth, final UserDetails userDetails) {

        final JwtParser jwtParser = Jwts.parser().setSigningKey(JwtConstatnt.SIGNING_KEY);

        final Jws<Claims> claimsJws = jwtParser.parseClaimsJws(token);

        final Claims claims = claimsJws.getBody();

        final Collection<? extends GrantedAuthority> authorities =
                Arrays.stream(claims.get(JwtConstatnt.AUTHORITIES_KEY).toString().split(","))
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList());

        return new UsernamePasswordAuthenticationToken(userDetails, "", authorities);
    }

}