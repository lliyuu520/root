package com.lliyuu520.root.core.filter;


import cn.hutool.core.util.StrUtil;
import com.lliyuu520.root.core.utils.JwtTokenUtil;
import com.lliyuu520.root.core.utils.ResponseUtil;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * jwt拦截器
 * @author liliangyu
 */
@Component
@Slf4j
public class JwtTokenFilter extends OncePerRequestFilter {

    /**
     * 存放Token的Header Key
     */
    private static final String HEADER_STRING = "Authorization";
    @Resource
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        String token = request.getHeader(HEADER_STRING);

        String requestURI = request.getRequestURI();
        boolean b = StrUtil.startWithAny(requestURI, "/swagger-ui", "/swagger-resources", "/images", "/webjars", "/v2", "/configuration", "/auth");
        if (b) {
            chain.doFilter(request, response);
        } else {
            if (StrUtil.isNotEmpty(token)) {
                String username;
                try {
                    username = jwtTokenUtil.getUsernameFromToken(token);
                } catch (ExpiredJwtException e1) {
                    logger.error(e1);
                    ResponseUtil.authExpired(response);
                    return;
                } catch (UnsupportedJwtException e2) {
                    logger.error(e2);
                    ResponseUtil.serverException(response);
                    return;
                } catch (MalformedJwtException e3) {
                    logger.error(e3);
                    ResponseUtil.malformedJwt(response);
                    return;
                } catch (SignatureException e4) {
                    logger.error(e4);
                    ResponseUtil.signatureException(response);
                    return;
                } catch (IllegalArgumentException e5) {
                    logger.error(e5);
                    ResponseUtil.serverException(response);
                    return;
                }

                SecurityContext context = SecurityContextHolder.getContext();
                if (username != null && context.getAuthentication() == null) {
                    UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
                    if (jwtTokenUtil.validateToken(token, userDetails)) {
                        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                                userDetails, null, userDetails.getAuthorities());
                        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(
                                request));
                        context.setAuthentication(authentication);
                    }
                }
            } else {
                ResponseUtil.noAuth(response);
                return;
            }
            chain.doFilter(request, response);
        }
    }

}
