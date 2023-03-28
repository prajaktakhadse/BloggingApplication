package com.learn.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JWTAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private JWTTokenHelper jwtTokenHelper;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		//get token
		String requestToken = request.getHeader("Authorization");
		
		String username = null;
		
		String token = null;
		
		if(requestToken !=null && requestToken.startsWith("Bearer"))
		{
			 token = requestToken.substring(7);
			 try {
			  username= this.jwtTokenHelper.getUsernameFromToken(token); //here we will get the username 
			 }
			 catch(IllegalArgumentException e) {
				 System.out.println("unable to get jwt token");
			 }
			 catch(ExpiredJwtException e) {
				 System.out.println("JWT token has been expired");
			 }
			 catch(MalformedJwtException e) {
				 System.out.println("invalid jwt");
			 }
		}else {
			System.out.println("jwt token does not begin with bearer");
		}
		
		//once got the token, now validate the token
		if(username != null && SecurityContextHolder.getContext().getAuthentication() == null) {//username is not null and authentication is null that time set the authentication 
			
					UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
			
			if(this.jwtTokenHelper.validateToken(token, userDetails)) {
				//if it return true then token is validate and do authentication
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = 
						new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
				
				//set detail
				usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				
				
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
				
				
			}else {
				//if not
				System.out.println("Invlaid token");
			}
		}
		else {
			//if not
			System.out.println("username is null or context is not null");
		}
		
		filterChain.doFilter(request, response);
	}

}




















