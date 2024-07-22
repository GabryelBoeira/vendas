package br.com.gabryel.vendas.service;

import br.com.gabryel.vendas.dto.UserSystemRequest;
import br.com.gabryel.vendas.dto.UserSystemResponse;
import br.com.gabryel.vendas.dto.security.CredentialsDTO;
import br.com.gabryel.vendas.entity.UserSystem;
import br.com.gabryel.vendas.exception.PasswordInvalidException;
import br.com.gabryel.vendas.repository.UserSystemRepository;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
public class UserDetailsServiceImpl implements AuthenticationProvider, UserDetailsService {

    private final UserSystemRepository userRepository;
    private final ModelMapper modelMapper;

    public UserDetailsServiceImpl(UserSystemRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if (StringUtils.isAllBlank(username)) throw new UsernameNotFoundException("username not found");

        UserSystem userSystem = userRepository.findByUsername(username);

        if (userSystem == null) throw new UsernameNotFoundException("User not found: " + username);

        String[] roles = userSystem.getAdmin() ? new String[]{"ADMIN", "USER"} : new String[]{"USER"};

        return User.builder()
                .username(userSystem.getUsername())
                .password(userSystem.getPassword())
                .roles(roles)
                .build();
    }

    @Transactional
    public UserSystemResponse createUser(UserSystemRequest user) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        UserSystem userSystem = new UserSystem();
        userSystem.setUsername(user.getUsername());
        userSystem.setPassword(encoder.encode(user.getPassword()));
        userSystem.setAdmin(user.getAdmin());

        return modelMapper.map(userRepository.save(userSystem), UserSystemResponse.class);
    }

    /**
     * Authenticates a user by verifying the password and returning the corresponding UserDetails object.
     *
     * @param  credentials  the CredentialsDTO object containing the username and password to be authenticated
     * @return              the UserDetails object representing the authenticated user
     * @throws PasswordInvalidException  if the password is invalid for the given username
     */
    public UserSystemResponse authenticateUser(CredentialsDTO credentials) throws PasswordInvalidException, UsernameNotFoundException {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        UserDetails user = loadUserByUsername(credentials.getUsername());
        boolean matchesPassword = encoder.matches(credentials.getPassword(), user.getPassword());

        if (!matchesPassword) throw new PasswordInvalidException("Password Invalid: " + credentials.getUsername());

        return modelMapper.map(user, UserSystemResponse.class);
    }

    /**
     * <p> The authenticate method to authenticate the request. We will get the username from the Authentication object and will
     * use the custom @userDetailsService service to load the given user.</p>
     * @param authentication
     * @return
     * @throws AuthenticationException
     */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        final String username = (authentication.getPrincipal() == null) ? "NONE_PROVIDED" : authentication.getName();
        if (StringUtils.isEmpty(username)) {
            throw new BadCredentialsException("invalid login details");
        }
        // get user details using Spring security user details service
        UserDetails user = null;
        try {
            user = loadUserByUsername(username);
        } catch (UsernameNotFoundException exception) {
            throw new BadCredentialsException("invalid login details");
        }
        return createSuccessfulAuthentication(authentication, user);
    }

    private Authentication createSuccessfulAuthentication(final Authentication authentication, final UserDetails user) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user.getUsername(), authentication.getCredentials(), user.getAuthorities());
        token.setDetails(authentication.getDetails());
        return token;
    }

    @Override
    public boolean supports(Class < ? > authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}
