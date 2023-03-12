package io.bootify.l11_visitor_managment_system.repos;

import io.bootify.l11_visitor_managment_system.domain.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface VisitorRepository extends JpaRepository<Visitor, Long> {

}
