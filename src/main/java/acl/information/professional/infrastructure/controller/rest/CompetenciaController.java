package acl.information.professional.infrastructure.controller.rest;

import acl.information.professional.application.port.in.CompetenciaCommand;
import acl.information.professional.domain.model.Competencia;
import acl.information.professional.infrastructure.entity.CompetenciaDao;
import acl.information.professional.infrastructure.mapper.CompetenciaMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/competencia")
@Slf4j
public class CompetenciaController {

    private final CompetenciaCommand competenciaCommand;
    private final CompetenciaMapper competenciaMapper;
    private final String errorMessage = "No hay registros para esa Habilidad";

    public CompetenciaController(CompetenciaCommand competenciaCommand, CompetenciaMapper competenciaMapper) {
        this.competenciaCommand = competenciaCommand;
        this.competenciaMapper = competenciaMapper;
    }


    @GetMapping
    public ResponseEntity<List<CompetenciaDao>> getAllCompetenciasController(){
        return ResponseEntity.ok(competenciaCommand.getAllCompetencia().stream()
                .map(competenciaMapper::mapToCompetenciasDao)
                .collect(Collectors.toList())
        );
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<CompetenciaDao> getCompetenciaByIdController(@PathVariable String id) {
//        log.info("getProfessionalById");
        Competencia competencia = competenciaCommand.getCompetencia(id);
        return  ResponseEntity.ok(competenciaMapper.mapToCompetenciasDao(competencia));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveCompetenciaController(@RequestBody CompetenciaDao competenciaDao){
//        log.info("saveProfessional {}", personDao);
        competenciaCommand.saveCompetencia(competenciaMapper.mapToCompetenciasModel(competenciaDao));
    }

    @PutMapping(value = "/update/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCompetenciaController(@PathVariable  final String id, @RequestBody CompetenciaDao competenciaDao){
//        log.info("updateProfessional {} {}", id, personDao);
        Competencia competencia = competenciaCommand.getCompetencia(id);
        if(competencia == null){
            throw new NoSuchElementException(errorMessage + id);
        }
        competenciaCommand.saveCompetencia(competenciaMapper.INSTANCE.mapToCompetenciasModel(competenciaDao));
    }
    @PostMapping(value = "/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCompetenciaController(@PathVariable String id) {
        Competencia competencia = competenciaCommand.getCompetencia(id);
        if(competencia == null){
            throw new NoSuchElementException(errorMessage + id);
        }
        competenciaCommand.deleteCompetencia(id);
    }
}
