package io.bootify.l11_visitor_managment_system.service;

import io.bootify.l11_visitor_managment_system.domain.Flat;
import io.bootify.l11_visitor_managment_system.domain.User;
import io.bootify.l11_visitor_managment_system.domain.Visit;
import io.bootify.l11_visitor_managment_system.domain.Visitor;
import io.bootify.l11_visitor_managment_system.model.VisitDTO;
import io.bootify.l11_visitor_managment_system.model.VisitStatus;
import io.bootify.l11_visitor_managment_system.repos.FlatRepository;
import io.bootify.l11_visitor_managment_system.repos.UserRepository;
import io.bootify.l11_visitor_managment_system.repos.VisitRepository;
import io.bootify.l11_visitor_managment_system.repos.VisitorRepository;
import io.bootify.l11_visitor_managment_system.util.NotFoundException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class VisitService {

    private final VisitRepository visitRepository;
    private final VisitorRepository visitorRepository;
    private final FlatRepository flatRepository;

    private final UserRepository userRepository;

    public VisitService(final VisitRepository visitRepository,
            final VisitorRepository visitorRepository, final FlatRepository flatRepository, final UserRepository userRepository) {
        this.visitRepository = visitRepository;
        this.visitorRepository = visitorRepository;
        this.flatRepository = flatRepository;
        this.userRepository = userRepository;
    }

    public List<VisitDTO> findAll() {
        final List<Visit> visits = visitRepository.findAll(Sort.by("id"));
        return visits.stream()
                .map((visit) -> mapToDTO(visit, new VisitDTO()))
                .collect(Collectors.toList());
    }

    public List<VisitDTO> findAllByStatusAndUserId(VisitStatus visitStatus, Long userId) {
        User user = userRepository.findById(userId).get();
        Flat flat = user.getFlat();
        final List<Visit> visits = visitRepository.findByStatusAndFlat(visitStatus,flat);
        return visits.stream()
                .map((visit) -> mapToDTO(visit, new VisitDTO()))
                .collect(Collectors.toList());
    }

    public List<VisitDTO> findAll(Pageable pageable) {
        final List<Visit> visits = visitRepository.findAll(pageable).toList();
        return visits.stream()
                .map((visit) -> mapToDTO(visit, new VisitDTO()))
                .collect(Collectors.toList());
    }

    public VisitDTO get(final Long id) {
        return visitRepository.findById(id)
                .map(visit -> mapToDTO(visit, new VisitDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public Long create(final VisitDTO visitDTO) {
        final Visit visit = new Visit();
        mapToEntity(visitDTO, visit);
        return visitRepository.save(visit).getId();
    }

    public void update(final Long id, final VisitDTO visitDTO) {
        final Visit visit = visitRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        mapToEntity(visitDTO, visit);
        visitRepository.save(visit);
    }

    public void updateStatus(final Long id, final VisitStatus status) {
        final Visit visit = visitRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        visit.setStatus(status);
        visitRepository.save(visit);
    }


    public void delete(final Long id) {
        visitRepository.deleteById(id);
    }

    private VisitDTO mapToDTO(final Visit visit, final VisitDTO visitDTO) {
        visitDTO.setId(visit.getId());
        visitDTO.setStatus(visit.getStatus());
        visitDTO.setInTime(visit.getInTime());
        visitDTO.setOutTime(visit.getOutTime());
        visitDTO.setPurpose(visit.getPurpose());
        visitDTO.setImageUrl(visit.getImageUrl());
        visitDTO.setNoOfPeople(visit.getNoOfPeople());
        visitDTO.setVisitor(visit.getVisitor() == null ? null : visit.getVisitor().getId());
        visitDTO.setFlat(visit.getFlat() == null ? null : visit.getFlat().getId());
        return visitDTO;
    }

    private Visit mapToEntity(final VisitDTO visitDTO, final Visit visit) {
        visit.setStatus(visitDTO.getStatus());
        visit.setInTime(visitDTO.getInTime());
        visit.setOutTime(visitDTO.getOutTime());
        visit.setPurpose(visitDTO.getPurpose());
        visit.setImageUrl(visitDTO.getImageUrl());
        visit.setNoOfPeople(visitDTO.getNoOfPeople());
        final Visitor visitor = visitDTO.getVisitor() == null ? null : visitorRepository.findById(visitDTO.getVisitor())
                .orElseThrow(() -> new NotFoundException("visitor not found"));
        visit.setVisitor(visitor);
        final Flat flat = visitDTO.getFlat() == null ? null : flatRepository.findById(visitDTO.getFlat())
                .orElseThrow(() -> new NotFoundException("flat not found"));
        visit.setFlat(flat);
        return visit;
    }

}
