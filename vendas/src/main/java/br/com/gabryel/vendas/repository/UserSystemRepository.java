package br.com.gabryel.vendas.repository;

import br.com.gabryel.vendas.entity.UserSystem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSystemRepository extends JpaRepository<UserSystem, Long> {

    UserSystem findByUsername(String userName);

}
