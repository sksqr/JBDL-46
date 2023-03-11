package io.bootify.l10_visitor_managment_system.repos;

import io.bootify.l10_visitor_managment_system.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AddressRepository extends JpaRepository<Address, Long> {
}
