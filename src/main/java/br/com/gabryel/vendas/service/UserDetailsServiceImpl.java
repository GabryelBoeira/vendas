package br.com.gabryel.vendas.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        if (StringUtils.isAllBlank(username)) throw new UsernameNotFoundException(username);

        // User user = userRepository.findByUsername(username);

        // if (user == null) throw new UsernameNotFoundException(username);

        // TODO: User
        return User.builder()
                .username("username")
                .password(encoder.encode("123456"))
                .roles("USER", "ADMIN")
                .passwordEncoder(password -> password)
                .build();
    }

}
