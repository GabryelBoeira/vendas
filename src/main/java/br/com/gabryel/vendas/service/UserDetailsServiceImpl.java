package br.com.gabryel.vendas.service;

import br.com.gabryel.vendas.dto.UserSystemRequest;
import br.com.gabryel.vendas.dto.UserSystemResponse;
import br.com.gabryel.vendas.entity.UserSystem;
import br.com.gabryel.vendas.repository.UserSystemRepository;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

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

}
