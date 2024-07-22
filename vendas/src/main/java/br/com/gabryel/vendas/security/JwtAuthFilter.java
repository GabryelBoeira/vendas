package br.com.gabryel.vendas.security;

import br.com.gabryel.vendas.service.UserDetailsServiceImpl;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JwtAuthFilter extends OncePerRequestFilter  {

    private JwtService jwtService;
    private UserDetailsServiceImpl userDetailsService;

    public JwtAuthFilter(JwtService jwtService, UserDetailsServiceImpl userDetailsService) {
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
    }


    /**
     * A method to perform the actual filter logic for incoming requests.
     *
     * @param  httpRequest        the HTTP servlet request
     * @param  httpResponse       the HTTP servlet response
     * @param  filterChain        the filter chain for executing the next filter
     * @throws ServletException   if the request cannot be handled
     * @throws IOException        if an input or output error occurs
     */
    @Override
    protected void doFilterInternal(HttpServletRequest httpRequest, HttpServletResponse httpResponse, FilterChain filterChain) throws ServletException, IOException {

        String authorization = httpRequest.getHeader("Authorization");

        if (authorization != null && authorization.startsWith("Bearer")) {
            String token = authorization.split(" ")[1];
            if (jwtService.isValidToken(token)) {
                String username = jwtService.getUsername(token);
                UserDetails userSystem = userDetailsService.loadUserByUsername(username);
                if (userSystem != null) {
                    UsernamePasswordAuthenticationToken userAuth =
                            new UsernamePasswordAuthenticationToken(userSystem, null, userSystem.getAuthorities());
                    userAuth.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpRequest));
                    SecurityContextHolder.getContext().setAuthentication(userAuth);

                    filterChain.doFilter(httpRequest, httpResponse);
                }
            }
        } else {
            filterChain.doFilter(httpRequest, httpResponse);
        }
    }


}
