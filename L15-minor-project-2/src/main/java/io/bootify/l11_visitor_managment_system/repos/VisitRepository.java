package io.bootify.l11_visitor_managment_system.repos;

import io.bootify.l11_visitor_managment_system.domain.Flat;
import io.bootify.l11_visitor_managment_system.domain.Visit;
import io.bootify.l11_visitor_managment_system.model.VisitStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.List;

@Repository
public interface VisitRepository extends JpaRepository<Visit, Long> {
//    Page<Visit> findAll(Pageable pageable);

    List<Visit> findByStatusAndFlat(VisitStatus visitStatus, Flat flat);
//
    @Query("from Visit where dateCreated < :dateTime")
    List<Visit> findAllVisitsBeforeDateTime(OffsetDateTime dateTime);
}
