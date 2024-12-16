package com.AppRH.AppRH.Controllers;

import com.AppRH.AppRH.Model.Candidates;
import com.AppRH.AppRH.Model.Vacancy;
import com.AppRH.AppRH.Repository.CandidatesRepository;
import com.AppRH.AppRH.Repository.VacancyRepository;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
public class VacancyController {
    private VacancyRepository vr;
    private CandidatesRepository cr;

    @GetMapping("/listVacancy")
    public String form() {
        return "vacancy/formVacancy";
    }

    @RequestMapping(value = "/registerVacancy", method = RequestMethod.POST)
    public String form(@Valid Vacancy vacancy, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            attributes.addFlashAttribute("message", "Verifique os campos...");
            return "redirect:/registerVacancy";
        }

        vr.save(vacancy);
        attributes.addFlashAttribute("message:", "Vaga cadastrada com sucesso!!");
        return "redirect:/registerVacancy";
    }
}

