package io.bootify.l11_visitor_managment_system.rest;

import io.bootify.l11_visitor_managment_system.domain.User;
import io.bootify.l11_visitor_managment_system.domain.Visit;
import io.bootify.l11_visitor_managment_system.model.VisitDTO;
import io.bootify.l11_visitor_managment_system.model.VisitStatus;
import io.bootify.l11_visitor_managment_system.model.VisitorDTO;
import io.bootify.l11_visitor_managment_system.repos.VisitRepository;
import io.bootify.l11_visitor_managment_system.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;

@RestController
@RequestMapping("/api/resident")
public class ResidentRestController
{

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private VisitService visitService;
    @Autowired
    private VisitRepository visitRepository;

//    @PutMapping("/updateVisit/{id}/{status}")
//    public ResponseEntity<Void> updateVisit(@PathVariable(name = "id") final Long id,
//                                            @PathVariable(name ="status") final String status) {
//        //
//        return ResponseEntity.ok().build();
//    }


    @PutMapping("/approveVisit/{id}")
    public ResponseEntity<Void> approveVisit(@PathVariable(name = "id") final Long id) {
        Visit visit = visitService.updateStatus(id,VisitStatus.APPROVED);
        String key = visit.getFlat().getId()+":visits:"+VisitStatus.WAITING.name();
        redisTemplate.delete(key);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/rejectVisit/{id}")
    public ResponseEntity<Void> rejectVisit(@PathVariable(name = "id") final Long id) {
        Visit visit =  visitService.updateStatus(id, VisitStatus.REJECTED);
        String key = visit.getFlat().getId()+":visits:"+VisitStatus.WAITING.name();
        redisTemplate.delete(key);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/visits/{status}")
    public ResponseEntity<List<VisitDTO>> getVisitsByStatus(@PathVariable(name = "status") final VisitStatus visitStatus){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String key = user.getFlat().getId()+":visits:"+visitStatus.name();
        List<VisitDTO> visits = (List<VisitDTO>) redisTemplate.opsForValue().get(key);
        if(visits == null){
            visits = visitService.findAllByStatusAndUserId(visitStatus,user.getId());
            redisTemplate.opsForValue().set(key,visits);
        }
        return ResponseEntity.ok(visits);
    }




}
