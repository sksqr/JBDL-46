package io.bootify.l10_visitor_managment_system.repos;

import io.bootify.l10_visitor_managment_system.domain.Visit;
import org.springframework.data.jpa.repository.JpaRepository;


public interface VisitRepository extends JpaRepository<Visit, Long> {
}
