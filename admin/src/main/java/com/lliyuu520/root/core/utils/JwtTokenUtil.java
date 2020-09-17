package com.lliyuu520.root.core.utils;

import com.lliyuu520.root.entity.SysUser;
import com.lliyuu520.root.properties.XlyyProperties;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * JWT 工具类
 * @author liliangyu
 */
@Component
public class JwtTokenUtil implements Serializable {

    private static final String CLAIM_KEY_USERNAME = "sub";



    @Autowired
    private XlyyProperties xlyyProperties;

    /**
     * 签发JWT
     */
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>(16);
        claims.put(CLAIM_KEY_USERNAME, userDetails.getUsername());
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(new Date(Instant.now().toEpochMilli() + xlyyProperties.getJwtExpirationTime()))
                .signWith(SignatureAlgorithm.HS512, xlyyProperties.getJwtSecret())
                .compact();
    }

    /**
     * 验证JWT
     */
    public Boolean validateToken(String token, UserDetails userDetails) {
        SysUser user = (SysUser) userDetails;
        String username = getUsernameFromToken(token);

        return username.equals(user.getUsername());
    }

    /**
     * 根据token获取username
     */
    public String getUsernameFromToken(String token) throws ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, SignatureException, IllegalArgumentException {
        return getClaimsFromToken(token).getSubject();
    }


    /**
     * 解析JWT
     */
    private Claims getClaimsFromToken(String token) throws ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, SignatureException, IllegalArgumentException {
        return Jwts.parser()
                .setSigningKey(xlyyProperties.getJwtSecret())
                .parseClaimsJws(token)
                .getBody();
    }

}
