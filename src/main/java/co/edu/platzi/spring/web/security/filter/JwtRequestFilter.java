package co.edu.platzi.spring.web.security.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import co.edu.platzi.spring.domain.service.PlatziUserDetailsService;
import co.edu.platzi.spring.web.security.JWTUtil;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

	@Autowired
	private JWTUtil jwtUtil;
	
	@Autowired
	private PlatziUserDetailsService platziUserDetails;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		var authorizationHeader = request.getHeader("Authorization");
		if (authorizationHeader != null && authorizationHeader.startsWith("Bearer")) {
			var jwt = authorizationHeader.substring(7);
			var username = jwtUtil.extractUsername(jwt);
			
			if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
				var userDetails = platziUserDetails.loadUserByUsername(username);
				
				if (jwtUtil.validateToken(jwt, userDetails)) {
					var authToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
					authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					SecurityContextHolder.getContext().setAuthentication(authToken);
				}
				
			}
		}
		
		filterChain.doFilter(request, response);
	}

}
