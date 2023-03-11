package io.bootify.l10_visitor_managment_system.rest;

import io.bootify.l10_visitor_managment_system.model.VisitorDTO;
import io.bootify.l10_visitor_managment_system.service.VisitorService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import javax.validation.*;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/visitors", produces = MediaType.APPLICATION_JSON_VALUE)
public class VisitorResource {

    private final VisitorService visitorService;

    public VisitorResource(final VisitorService visitorService) {
        this.visitorService = visitorService;
    }

    @GetMapping
    public ResponseEntity<List<VisitorDTO>> getAllVisitors() {
        return ResponseEntity.ok(visitorService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VisitorDTO> getVisitor(@PathVariable(name = "id") final Long id) {
        return ResponseEntity.ok(visitorService.get(id));
    }

    @PostMapping
    @ApiResponse(responseCode = "201")
    public ResponseEntity<Long> createVisitor(@RequestBody @Valid final VisitorDTO visitorDTO) {
        return new ResponseEntity<>(visitorService.create(visitorDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateVisitor(@PathVariable(name = "id") final Long id,
            @RequestBody @Valid final VisitorDTO visitorDTO) {
        visitorService.update(id, visitorDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @ApiResponse(responseCode = "204")
    public ResponseEntity<Void> deleteVisitor(@PathVariable(name = "id") final Long id) {
        visitorService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
