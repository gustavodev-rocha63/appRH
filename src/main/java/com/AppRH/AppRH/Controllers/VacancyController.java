    package com.AppRH.AppRH.Controllers;
    import com.AppRH.AppRH.Model.Candidates;
    import com.AppRH.AppRH.Model.Vacancy;
    import com.AppRH.AppRH.Repository.CandidatesRepository;
    import com.AppRH.AppRH.Repository.VacancyRepository;
    import jakarta.validation.Valid;
    import org.springframework.validation.BindingResult;
    import org.springframework.web.bind.annotation.*;
    import org.springframework.web.servlet.ModelAndView;
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

        @RequestMapping("/vacancy")
        public ModelAndView listVacancy() {
            ModelAndView mv = new ModelAndView("vacancy/listVacncy");
            Iterable<Vacancy> vacancy = vr.findAll();
            mv.addObject("Vacancy", vacancy);
            return mv;
        }

        @RequestMapping(value = "/{codigo}", method = RequestMethod.GET)
        public ModelAndView detailsVacancy(@PathVariable("codigo") long codigo) {
            Vacancy vacancy = vr.findByCodigo(codigo);
            ModelAndView mv = new ModelAndView("vacancy/detailsVacancy");
            mv.addObject("Vacancy", vacancy);

            Iterable<Candidates> candidates = cr.findByVacancy(vacancy);
            mv.addObject("Candidates", candidates);
            return mv;
        }

        @DeleteMapping("/deleteVacancy")
        public String deleteVacancy(long codigo) {
            Vacancy vacancy = vr.findByCodigo(codigo);
            vr.delete(vacancy);
            return "redirect:/vacancy";
        }

        public String detailsVacancyPost(@PathVariable("codigo") long codigo, @Valid Candidates candidates, BindingResult result,
                                         RedirectAttributes attributes) {
            if (result.hasErrors()) {
                attributes.addFlashAttribute("mensagem", "Verifique os campos...");
                return "redirect:/{codigo}";
            }

            if (cr.findByRg(candidates.getRg()) != null) {
                attributes.addFlashAttribute("mensagem erro", "RG duplicado");
                return "redirect:/{codigo}";
            }

            Vacancy vacancy = vr.findByCodigo(codigo);
            candidates.setVacancy(vacancy);
            cr.save(candidates);
            attributes.addFlashAttribute("mensagem", "Candidato adicionado com sucesso");
            return "redirect:/{codigo}";
        }

        @DeleteMapping("/DeleteCandidate")
        public String DeleteCandidate(String rg) {
            Candidates candidates = cr.findByRg(rg);
            Vacancy vacancy = candidates.getVacancy();
            String codigo = "" + vacancy.getCodigo();
            cr.delete(candidates);
            return "redirect:/{codigo}";
        }

        @RequestMapping(value="/edit-vacancy",method = RequestMethod.GET)
        public ModelAndView editVacancy(long codigo){
           Vacancy vacancy = vr.findByCodigo(codigo);
            ModelAndView mv = new ModelAndView("Vacancy/update-vacancy");
            mv.addObject("vacancy",vacancy);
            return mv;
        }

        @PostMapping("/edit-vacancyOne")
        public String UpdateVacacncy(@Valid Vacancy vacancy,BindingResult result,RedirectAttributes attributes){
            vr.save(vacancy);
            attributes.addFlashAttribute("sucess","Vaga alterada com sucesso");

            long codigo = vacancy.getCodigo();
            String codigoOne = "" + codigo;
            return "redirect:/" + codigo;
        }
    }

