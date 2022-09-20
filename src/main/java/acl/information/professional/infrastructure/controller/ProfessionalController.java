package acl.information.professional.infrastructure.controller;

import acl.information.professional.application.port.in.ProfessionalCommand;
import acl.information.professional.domain.model.Professional;
import acl.information.professional.infrastructure.entity.ProfessionalDao;
import acl.information.professional.infrastructure.mapper.ProfessionalMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/professional")
@Slf4j
public class ProfessionalController {

    private final ProfessionalCommand professionalCommand;
    private final ProfessionalMapper professionalMapper;

    public ProfessionalController(ProfessionalCommand professionalCommand, ProfessionalMapper professionalMapper) {
        this.professionalCommand = professionalCommand;
        this.professionalMapper = professionalMapper;
    }

    @GetMapping
    public ResponseEntity<List<ProfessionalDao>> getProfessionals() {
        log.info("getProfessionals");
        return ResponseEntity.ok(professionalCommand.getAllProfessionals().stream()
                .map(professionalMapper::mapToProfessionalDao).collect(Collectors.toList()));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProfessionalDao> getProfessionalById(@PathVariable String id) {
        log.info("getProfessionalById");
        Professional person = professionalCommand.getProfessional(id);
        return  ResponseEntity.ok(professionalMapper.mapToProfessionalDao(person));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void SaveProfessional(@RequestBody ProfessionalDao personDao){
        log.info("saveProfessional {}", personDao);
        professionalCommand.saveProfessional(professionalMapper.mapToProfessionalModel(personDao));
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void UpdateProfessional(@PathVariable  final String id, @RequestBody ProfessionalDao personDao){
        log.info("updateProfessional {} {}", id, personDao);

    }
}
