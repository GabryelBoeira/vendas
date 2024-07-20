package br.com.gabryel.vendas.repository;

import br.com.gabryel.vendas.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

}
