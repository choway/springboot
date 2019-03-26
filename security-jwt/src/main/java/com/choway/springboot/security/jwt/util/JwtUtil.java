package com.choway.springboot.security.jwt.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;


@Slf4j
@Component
public class JwtUtil {

	public static String secret;
	public static int expire;

	@Value("${jwt.secret}")
	public void setSecret(String secret) {
		JwtUtil.secret = secret;
	}
	@Value("${jwt.expire}")
	public void setExpire(int expire) {
		JwtUtil.expire = expire;
	}


	/**
	 * 生成 token
	 * @return
	 */
	public static String generateToken(String id, String name) {
		Date now = new Date(System.currentTimeMillis());

		Claims claims = Jwts.claims();
		claims.setId(id); // JWT ID 编号
		claims.setSubject("jwt token"); // 主题
		claims.setAudience("user"); // 受众
		claims.setIssuer(name); // 签发人
		claims.setIssuedAt(now); // 签发时间
		claims.setNotBefore(now); // 生效时间
		claims.setExpiration(new Date(System.currentTimeMillis() + expire*1000)); // 过期时间

		String token = Jwts.builder()
				.setClaims(claims)
				.signWith(SignatureAlgorithm.HS256, secret)
				.compact();

		log.info("jwt token={}", token);
		return token;
	}

	public static Claims parseToken(String token) {
		Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
		return claims;
	}


}
