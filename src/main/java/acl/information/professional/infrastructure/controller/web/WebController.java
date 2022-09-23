package acl.information.professional.infrastructure.controller.web;

import acl.information.professional.application.port.in.ProfessionalCommand;
import acl.information.professional.domain.model.Professional;
import acl.information.professional.infrastructure.entity.ProfessionalDao;
import acl.information.professional.infrastructure.mapper.ProfessionalMapper;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    @GetMapping("/signup")
    public String showSignUpAgency(Professional person) {
        return "/";
    }

    @GetMapping("/form")
    public String ShowFormPage(Model model){
        return "form";
    }

    @Transactional
    @PostMapping("/v1/professional")
    public String addProfessional(ProfessionalDao person, RedirectAttributes ra,
                            BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/error";
        }
        professionalCommand.saveProfessional(professionalMapper.mapToProfessionalModel(person));
        ra.addFlashAttribute("message", "El profesional ha sido registrado correctamente");
        return "redirect:/";
    }

    @Transactional
    @PostMapping("/v1/professional/update/{id}")
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

    @GetMapping("/v1/professional/delete/{id}")
    public String delProfessional(@PathVariable String id, RedirectAttributes ra,
                            Model model) {
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

