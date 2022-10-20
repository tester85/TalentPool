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
import acl.information.professional.infrastructure.model.CountryRequest;
import acl.information.professional.infrastructure.model.PerfilDto;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.bson.json.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class WebController {
    private static final Logger log = LoggerFactory.getLogger(WebController.class);

    static List<String> country = null;
    static List<String> database = null;
    static List<String> framework = null;
    static List<String> languageP = null;
    static List<String> language = null;
    static List<String> schedule = null;
    static String countryBaseURL = "https://api.worldbank.org/v2/country/?format=json";

    @Value("${header_authorization}")
    String authorization_token;


    static {
        country = new ArrayList<>();
        country.add("Chile");
        country.add("Canada");
        country.add("Estados Unidos");
        country.add("Rusia");

        database = new ArrayList<>();
        database.add("SQL");
        database.add("Oracle");
        database.add("MySQL");
        database.add("MongoDB");

        language = new ArrayList<>();
        language.add("Ingles");
        language.add("Ruso");
        language.add("Aleman");
        language.add("Frances");

        framework = new ArrayList<>();
        framework.add("Wordpress");
        framework.add("Joomla");
        framework.add("Angular");
        framework.add("React");
        framework.add("SpringBoot");

        schedule = new ArrayList<>();
        schedule.add(Horario.Diurno.toString());
        schedule.add(Horario.Vespertino.toString());
    }

    private final ProfessionalCommand professionalCommand;
    private final CasaEstudiosCommand casaEstudiosCommand;
    private final CasaEstudioMapper casaEstudioMapper;
    private final CompetenciaCommand competenciaCommand;
    private final CompetenciaMapper competenciaMapper;
    private final ProfessionalMapper professionalMapper;
    private final PerfilDtoMapper perfilDtoMapper;
    //    private final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    private final RestTemplate restTemplate;

    public WebController(ProfessionalCommand professionalCommand, CasaEstudiosCommand casaEstudiosCommand, CasaEstudioMapper casaEstudioMapper, CompetenciaCommand competenciaCommand, CompetenciaMapper competenciaMapper, ProfessionalMapper professionalMapper, PerfilDtoMapper perfilDtoMapper, RestTemplate restTemplate) {
        this.professionalCommand = professionalCommand;
        this.casaEstudiosCommand = casaEstudiosCommand;
        this.casaEstudioMapper = casaEstudioMapper;
        this.competenciaCommand = competenciaCommand;
        this.competenciaMapper = competenciaMapper;
        this.professionalMapper = professionalMapper;
        this.perfilDtoMapper = perfilDtoMapper;
        this.restTemplate = restTemplate;
    }

    @GetMapping("/signup")
    public String showSignUpOauth(Professional person) {
        return "/";
    }


    public HttpResponse<String> getContactInformationHubSpot() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.hubapi.com/crm/v3/objects/contacts"))
                .header("Authorization", authorization_token)
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
        return response;
    }

    @GetMapping("/form")
    public String ShowFormPage(Model model) throws IOException, InterruptedException {
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
                Horario.Diurno,
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
        model.addAttribute("countries", country);
        model.addAttribute("databases", database);
        model.addAttribute("framework", framework);
        model.addAttribute("schedule", schedule);
        model.addAttribute("lang", language);
        this.getContactInformationHubSpot();
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
//        restTemplate.postForObject("");
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
        professionalCommand.updateProfessional(id, professionalMapper.mapToProfessionalModel(person));
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
                    "El profesional " + person.getName() + " ha sido eliminado");
        } catch (Exception e) {
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/";
    }

}

