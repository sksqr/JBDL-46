package io.bootify.l10_visitor_managment_system.rest;

import io.bootify.l10_visitor_managment_system.model.VisitDTO;
import io.bootify.l10_visitor_managment_system.model.VisitStatus;
import io.bootify.l10_visitor_managment_system.service.VisitService;
import io.bootify.l10_visitor_managment_system.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/resident")
public class ResidentRestController
{

    @Autowired
    private VisitService visitService;

//    @PutMapping("/updateVisit/{id}/{status}")
//    public ResponseEntity<Void> updateVisit(@PathVariable(name = "id") final Long id,
//                                            @PathVariable(name ="status") final String status) {
//        //
//        return ResponseEntity.ok().build();
//    }


    @PutMapping("/approveVisit/{id}")
    public ResponseEntity<Void> approveVisit(@PathVariable(name = "id") final Long id) {
        visitService.updateStatus(id,VisitStatus.APPROVED);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/rejectVisit/{id}")
    public ResponseEntity<Void> rejectVisit(@PathVariable(name = "id") final Long id) {
        visitService.updateStatus(id, VisitStatus.REJECTED);
        return ResponseEntity.ok().build();
    }




}
