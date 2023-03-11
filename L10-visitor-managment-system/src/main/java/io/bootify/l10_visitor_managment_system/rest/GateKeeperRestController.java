package io.bootify.l10_visitor_managment_system.rest;

import io.bootify.l10_visitor_managment_system.model.VisitDTO;
import io.bootify.l10_visitor_managment_system.model.VisitorDTO;
import io.bootify.l10_visitor_managment_system.service.VisitService;
import io.bootify.l10_visitor_managment_system.service.VisitorService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/gatekeeper")
public class GateKeeperRestController {

    @Autowired
    private VisitorService visitorService;

    @Autowired
    private VisitService visitService;

    @PostMapping
    @RequestMapping("/createVisitor")
    @ApiResponse(responseCode = "201")
    public ResponseEntity<Long> createVisitor(@RequestBody @Valid final VisitorDTO visitorDTO) {
        return new ResponseEntity<>(visitorService.create(visitorDTO), HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public ResponseEntity<VisitorDTO> getVisitor(@PathVariable(name = "id") final Long id) {
        return ResponseEntity.ok(visitorService.get(id));
    }

    @PostMapping
    @RequestMapping("/createVisit")
    @ApiResponse(responseCode = "201")
    public ResponseEntity<Long> createVisit(@RequestBody @Valid final VisitDTO visitDTO) {
        return new ResponseEntity<>(visitService.create(visitDTO), HttpStatus.CREATED);
    }

    @PutMapping
    @RequestMapping("/markEntry/{visitId}")
    @ApiResponse(responseCode = "201")
    public ResponseEntity<Long> markEntryVisit(@RequestBody  final Long visitId) {
        // approved
        // update intime
        return null;
    }


    @PutMapping
    @RequestMapping("/markExit/{visitId}")
    @ApiResponse(responseCode = "201")
    public ResponseEntity<Long> markExitVisit(@RequestBody  final Long visitId) {
        // approved
        // update outtime
        // mark completed
        return null;
    }

    // upload image file


}
