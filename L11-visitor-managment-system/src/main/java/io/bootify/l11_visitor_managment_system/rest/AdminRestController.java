package io.bootify.l11_visitor_managment_system.rest;


import io.bootify.l11_visitor_managment_system.domain.Visit;
import io.bootify.l11_visitor_managment_system.model.UserDTO;
import io.bootify.l11_visitor_managment_system.model.UserStatus;
import io.bootify.l11_visitor_managment_system.model.VisitDTO;
import io.bootify.l11_visitor_managment_system.service.UserService;
import io.bootify.l11_visitor_managment_system.service.VisitService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminRestController {


    static private Logger LOGGER = LoggerFactory.getLogger(AdminRestController.class);


    @Autowired
    private UserService userService;

    @Autowired
    private VisitService visitService;

    @PostMapping("/createUser")
    @ApiResponse(responseCode = "201")
    public ResponseEntity<Long> createUser(@RequestBody @Valid final UserDTO userDTO) {
        return new ResponseEntity<>(userService.create(userDTO), HttpStatus.CREATED);
    }


    @PutMapping("markInactive/{id}")
    public ResponseEntity<Void> markInactive(@PathVariable(name = "id") final Long id) {
        userService.markInactive(id);
        return ResponseEntity.ok().build();
    }

    // upload CSV to create user



    @PostMapping("/user-csv/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";
        try {
            BufferedReader fileReader = new BufferedReader(new InputStreamReader(file.getInputStream(), "UTF-8"));
            CSVParser csvParser = new CSVParser(fileReader,
                    CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());
            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
            List<UserDTO> userDTOList = new ArrayList<>();
            for (CSVRecord csvRecord : csvRecords) {
                UserDTO usersDTO = UserDTO.builder()
                        .name(csvRecord.get("name"))
                        .email(csvRecord.get("email"))
                        .phone(csvRecord.get("phone"))
                        .flat(Long.parseLong(csvRecord.get("flat")))
                       // .address(Long.parseLong(csvRecord.get("address")))
                        .role(csvRecord.get("role"))
                        .status(UserStatus.ACTIVE).build();
                userDTOList.add(usersDTO);
                LOGGER.info("Read user name :{}",usersDTO.getName());
            }
            userService.createInBulk(userDTOList);
            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(message);
        } catch (Exception e) {
            LOGGER.error("Exception occurred: {}",e);
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
        }

    }

    @GetMapping("/allVisits")
    ResponseEntity<List<VisitDTO>> getAllVisits(@RequestParam Integer pageSize, @RequestParam Integer pageNo){
        Pageable pageable = Pageable.ofSize(pageSize).withPage(pageNo);
        List<VisitDTO> visitDTOS = visitService.findAll(pageable);
        return ResponseEntity.ok(visitDTOS);
    }

}
