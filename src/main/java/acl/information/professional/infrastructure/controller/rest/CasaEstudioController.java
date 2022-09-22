package acl.information.professional.infrastructure.controller.rest;

import acl.information.professional.application.port.in.CasaEstudiosCommand;
import acl.information.professional.domain.model.CasaEstudio;
import acl.information.professional.infrastructure.entity.CasaEstudioDao;
import acl.information.professional.infrastructure.mapper.CasaEstudioMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/casaestudio")
@Slf4j
public class CasaEstudioController {

    private final CasaEstudiosCommand casaEstudiosCommand;
    private final CasaEstudioMapper casaEstudioMapper;
    private final String errorMessage = "No hay registros para esa Habilidad";

    public CasaEstudioController(CasaEstudiosCommand casaEstudiosCommand, CasaEstudioMapper casaEstudioMapper) {
        this.casaEstudiosCommand = casaEstudiosCommand;
        this.casaEstudioMapper = casaEstudioMapper;
    }

    @GetMapping
    public ResponseEntity<List<CasaEstudioDao>> getAllCasaEstudioController(){
        return ResponseEntity.ok(casaEstudiosCommand.getAllCasaEstudios().stream()
                .map(casaEstudioMapper::mapToCasaEstudiosDao)
                .collect(Collectors.toList())
        );
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CasaEstudioDao> getCasaEstudioController(@PathVariable String id) {
//        log.info("getProfessionalById");
        CasaEstudio person = casaEstudiosCommand.getCasaEstudio(id);
        return  ResponseEntity.ok(casaEstudioMapper.mapToCasaEstudiosDao(person));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveCasaEstudioController(@RequestBody CasaEstudioDao casaEstudioDao){
//        log.info("saveProfessional {}", personDao);
        casaEstudiosCommand.saveCasaEstudio(casaEstudioMapper.mapToCasaEstudiosModel(casaEstudioDao));
    }

    @PutMapping(value = "/update/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCasaEstudioController(@PathVariable  final String id, @RequestBody CasaEstudioDao casaEstudioDao){
//        log.info("updateProfessional {} {}", id, personDao);
        CasaEstudio casaEstudio = casaEstudiosCommand.getCasaEstudio(id);
        if(casaEstudio == null){
            throw new NoSuchElementException(errorMessage + id);
        }
        casaEstudiosCommand.saveCasaEstudio(casaEstudioMapper.INSTANCE.mapToCasaEstudiosModel(casaEstudioDao));
    }
    @PostMapping(value = "/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCasaEstudioController(@PathVariable String id) {
        CasaEstudio casaEstudio = casaEstudiosCommand.getCasaEstudio(id);
        if(casaEstudio == null){
            throw new NoSuchElementException(errorMessage + id);
        }
        casaEstudiosCommand.deleteCasaEstudio(id);
    }


}
