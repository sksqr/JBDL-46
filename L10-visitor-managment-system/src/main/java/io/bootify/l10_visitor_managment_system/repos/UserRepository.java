package io.bootify.l10_visitor_managment_system.repos;

import io.bootify.l10_visitor_managment_system.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByEmailIgnoreCase(String email);

}
