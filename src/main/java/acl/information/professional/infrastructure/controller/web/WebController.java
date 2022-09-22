package acl.information.professional.infrastructure.controller.web;

import acl.information.professional.application.port.in.ProfessionalCommand;
import acl.information.professional.domain.model.Professional;
import acl.information.professional.infrastructure.entity.ProfessionalDao;
import acl.information.professional.infrastructure.mapper.ProfessionalMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class WebController {

    private final ProfessionalCommand professionalCommand;
    private final ProfessionalMapper professionalMapper;

    public WebController(ProfessionalCommand professionalCommand, ProfessionalMapper professionalMapper) {
        this.professionalCommand = professionalCommand;
        this.professionalMapper = professionalMapper;
    }

    @GetMapping("/form")
    public String ShowFormPage(Model model){
//        List<ProfessionalDao> person = professionalCommand.getAllProfessionals().stream()
//                .map(professionalMapper::mapToProfessionalDao).collect(Collectors.toList());
        String form = "";
        model.addAttribute(form);
        return "form";
    }

}

