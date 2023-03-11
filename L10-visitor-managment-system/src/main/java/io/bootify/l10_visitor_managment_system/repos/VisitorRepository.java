package io.bootify.l10_visitor_managment_system.repos;

import io.bootify.l10_visitor_managment_system.domain.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;


public interface VisitorRepository extends JpaRepository<Visitor, Long> {
}
