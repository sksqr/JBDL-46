package io.bootify.l11_visitor_managment_system.repos;

import io.bootify.l11_visitor_managment_system.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AddressRepository extends JpaRepository<Address, Long> {
}
