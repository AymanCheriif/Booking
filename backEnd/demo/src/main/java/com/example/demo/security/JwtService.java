package com.example.demo.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import java.security.Key;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.impl.lang.Function;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@Service
public class JwtService {

    private long jwtExpiration = 100000;
    private String secretKey = "OVbpsBjWLtBF/pCBATDHbDoUP59SF72yRD0NbD2Di5MpdL8zEIdYI61gyw5zbhIr10hsZAuOLDRBLToLTG9agOmEKRxU7w34I+xJF+EIp+knjsN0MO8fn0S7oCzfEd5Vetis52sBGsh/+GUInBYWzut69y2Sh7ljZJy1imActGqfBy+T/pTxWjJx7MlX4OMmHk69tNFYHvNZETKXGdmw/cDmdt4SdTvOArZi7zvwCDQhKJo5rJIRHQ5fjFyV8KDtsx9IJcu6j8eJaGuCRtnn3Lp/ijH8v1dq/4m6m3dStqWyc8eQpzlTGVhzUcTiNrmuhlFNptBtS4Wl4jDaL2FafqjyBsPONtFVzHjLrleA/Ac=" ;
    public String generateToken(UserDetails userDetails){
        return generateToken(new HashMap<>(), userDetails);
    }


    public String extractUsername(String token){
        return extractClaim(token, Claims::getSubject);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claomResolver){
        final Claims claims = extractAllClaims(token);
        return claomResolver.apply(claims);
    }

    private Claims extractAllClaims(String token){
        return Jwts.parser().setSigningKey(getSignInKey()).build().parseClaimsJws(token).getBody();
    }

    public boolean isTokenValid(String token, UserDetails userDetails){
        final String username = extractUsername(token);
        return( username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token){
        return extractClaim(token, Claims::getExpiration);
    }


    public <V, K> String generateToken(Map<String, Object> claims, UserDetails userDetails){
        return buildToken(claims, userDetails, jwtExpiration);
    }

    private String buildToken(
        Map<String, Object> claims,
        UserDetails userDetails,
        long jwtExpiration
    ){
        var authorities = userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList();
        
        
        return Jwts.builder().setClaims(claims).setSubject(userDetails.getUsername())
        .setIssuedAt(new Date(System.currentTimeMillis()))
        .setExpiration(new Date(System.currentTimeMillis() + jwtExpiration))
        .claim("authorities", authorities)
        .signWith(getSignInKey())
        .compact();
    }

    private Key getSignInKey(){
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
