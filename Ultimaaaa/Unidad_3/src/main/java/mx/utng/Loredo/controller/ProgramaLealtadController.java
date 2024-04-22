package mx.utng.Loredo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;
import mx.utng.Loredo.model.entity.ProgramaLealtad;
import mx.utng.Loredo.model.service.IProgramaLealtadService;

@Controller
@SessionAttributes("programaLealtad")
public class ProgramaLealtadController {
    @Autowired
    private IProgramaLealtadService service;

    @GetMapping({"/programaLealtad", "/programaLealtad/", "/programaLealtad/list"})
    public String list(Model model){
        model.addAttribute("title", "Listado de ProgramaLealtades");
        model.addAttribute("programaLealtades", service.list());
        return "programaLealtad-list";
    }

    @GetMapping("/programaLealtad/form")
    public String create(Model model){
        model.addAttribute("title", "Formulario de ProgramaLealtades");
        model.addAttribute("programaLealtad", new ProgramaLealtad());
        return "programaLealtad-form";
    }

    @PostMapping("/programaLealtad/form")
    public String save(@Valid ProgramaLealtad programaLealtad, BindingResult br, Model model){
        if(br.hasErrors()){
            model.addAttribute("title", "Formulario de ProgramaLealtades");
            return "programaLealtad-form";
        }
        service.save(programaLealtad);
        return "redirect:/programaLealtad/list";
    }

    @GetMapping("/programaLealtad/form/{id}")
    public String update(@PathVariable Long id, Model model){
        ProgramaLealtad programaLealtad = null;
        if(id>0){
            programaLealtad = service.getById(id);
        }else{
            return "redirect:/programaLealtad/list";
        }
        model.addAttribute("title", "Editar ProgramaLealtad");
        model.addAttribute("programaLealtad", programaLealtad);
        return "programaLealtad-form";
    }

    @GetMapping("/programaLealtad/delete/{id}")
    public String delete(@PathVariable Long id, Model model){
        if(id > 0){
            service.delete(id);
        }
        return "redirect:/programaLealtad/list";
    }
    
}
