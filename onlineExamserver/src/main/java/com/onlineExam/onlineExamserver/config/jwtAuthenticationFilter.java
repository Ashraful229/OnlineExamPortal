package com.onlineExam.onlineExamserver.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import com.onlineExam.onlineExamserver.serviceImpl.UserDetailsServiceImpl;


import io.jsonwebtoken.ExpiredJwtException;

@Service
public class jwtAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;
	@Autowired
	private JwtUtils jwtUtils;
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		final String requestTokenHeader= request.getHeader("Authorization");
		System.out.println(requestTokenHeader);
		String username=null;
		String jwtToken=null;
		if(requestTokenHeader!=null && requestTokenHeader.startsWith("Bearer "))
		{
			//yes
			jwtToken=requestTokenHeader.substring(7);
			try {
				
			    username=this.jwtUtils.extractUsername(jwtToken);
				
				
			} catch (ExpiredJwtException e) {
				// TODO: handle exception
				e.printStackTrace();
				System.out.println("jwt token has expired");
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				System.out.println("error");
			}
		}
		else {
			System.out.println("Invalid token , not start with bearer string");
		}
		//validated
		if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null)
		{
		final UserDetails userDetails=this.userDetailsServiceImpl.loadUserByUsername(username);
		if(this.jwtUtils.validateToken(jwtToken, userDetails))
		{
			//tokin isalid
			UsernamePasswordAuthenticationToken  usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
			usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
		}
		}
		else {
			System.out.println("Token is not valid");
		}
		
		filterChain.doFilter(request, response);
	}

}
