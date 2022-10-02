package acl.information.professional.infrastructure.controller.web;

import acl.information.professional.application.port.in.CasaEstudiosCommand;
import acl.information.professional.application.port.in.CompetenciaCommand;
import acl.information.professional.application.port.in.ProfessionalCommand;
import acl.information.professional.domain.model.*;
import acl.information.professional.infrastructure.entity.CasaEstudioDao;
import acl.information.professional.infrastructure.entity.CompetenciaDao;
import acl.information.professional.infrastructure.entity.ProfessionalDao;
import acl.information.professional.infrastructure.mapper.CasaEstudioMapper;
import acl.information.professional.infrastructure.mapper.CompetenciaMapper;
import acl.information.professional.infrastructure.mapper.PerfilDtoMapper;
import acl.information.professional.infrastructure.mapper.ProfessionalMapper;
import acl.information.professional.infrastructure.model.PerfilDto;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class WebController {

//    @Bean
//    public RestTemplate restTemplate(RestTemplateBuilder builder) {
//        return builder.build();
//    }

    private final ProfessionalCommand professionalCommand;
    private final CasaEstudiosCommand casaEstudiosCommand;
    private final CasaEstudioMapper casaEstudioMapper;
    private final CompetenciaCommand competenciaCommand;
    private final CompetenciaMapper competenciaMapper;
    private final ProfessionalMapper professionalMapper;
    private final PerfilDtoMapper perfilDtoMapper;
//    private final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//    private final RestTemplate restTemplate;

    public WebController(ProfessionalCommand professionalCommand, CasaEstudiosCommand casaEstudiosCommand, CasaEstudioMapper casaEstudioMapper, CompetenciaCommand competenciaCommand, CompetenciaMapper competenciaMapper, ProfessionalMapper professionalMapper, PerfilDtoMapper perfilDtoMapper) {
        this.professionalCommand = professionalCommand;
        this.casaEstudiosCommand = casaEstudiosCommand;
        this.casaEstudioMapper = casaEstudioMapper;
        this.competenciaCommand = competenciaCommand;
        this.competenciaMapper = competenciaMapper;
        this.professionalMapper = professionalMapper;
//        this.restTemplate = restTemplate;
        this.perfilDtoMapper = perfilDtoMapper;
    }

    @GetMapping("/signup")
    public String showSignUpOauth(Professional person) {
        return "/";
    }

//    public CountryRequest[] getCountry(){
//        ResponseEntity<CountryRequest[]> response = restTemplate.getForEntity("https://api.first.org/data/v1/countries",CountryRequest[].class);
//        CountryRequest[] countries = response.getBody();
//        return countries;
//    }
    @GetMapping("/form")
    public String ShowFormPage(Model model){
        PerfilDto data = new PerfilDto(
                "",
                "",
                "",
                "",
                "",
                "",
                List.of(""),
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                true,
                List.of(""),
                List.of(""),
                List.of(""),
                List.of(""));
//        PerfilDto data = new PerfilDto();

        model.addAttribute("perfil", data);
//        model.addAttribute("countries", getCountry());
        return "form";
    }

    @Transactional
    @PostMapping("/professional/save")
    public String addProfessional(PerfilDto perfil, RedirectAttributes ra,
                                  BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/error";
        }

        ProfessionalDao person = perfilDtoMapper.mapToProfessionalDao(perfil);
        CasaEstudioDao study = perfilDtoMapper.mapToCasaEstudioDao(perfil);
        CompetenciaDao ability = perfilDtoMapper.mapToCompetenciaDao(perfil);
        professionalCommand.saveProfessional(professionalMapper.mapToProfessionalModel(person));
        casaEstudiosCommand.saveCasaEstudio(casaEstudioMapper.mapToCasaEstudiosModel(study));
        competenciaCommand.saveCompetencia(competenciaMapper.mapToCompetenciasModel(ability));
        ra.addFlashAttribute("message", "El profesional ha sido registrado correctamente");
        return "redirect:/";
    }

    @Transactional
    @PostMapping("/professional/update/{id}")
    public String updProfessional(@PathVariable String id, ProfessionalDao person, RedirectAttributes ra,
                            BindingResult result) {
        if (result.hasErrors()) {
            ra.addFlashAttribute("message", "Some Errors where found");
            return "redirect:/agency";
        }
        professionalCommand.updateProfessional(id,professionalMapper.mapToProfessionalModel(person));
        ra.addFlashAttribute("message",
                "El profesional ha sido actualizado correctamente");
        return "redirect:/";
    }

    @GetMapping("/professional/delete/{id}")
    public String delProfessional(@PathVariable String id, RedirectAttributes ra) {
        try {
            Professional person = professionalCommand.getProfessional(id);
            professionalCommand.deleteProfessional(id);

            ra.addFlashAttribute("message",
                    "El profesional " + person.getNombre() +" ha sido eliminado");
        } catch (Exception e) {
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/";
    }

}

