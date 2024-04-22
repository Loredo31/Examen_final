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
import mx.utng.Loredo.model.entity.ClaseVirtual;
import mx.utng.Loredo.model.service.IClaseVirtualService;

@Controller
@SessionAttributes("claseVirtual")
public class ClaseVirtualController {
    @Autowired
    private IClaseVirtualService service;

    @GetMapping({"/claseVirtual", "/claseVirtual/", "/claseVirtual/list"})
    public String list(Model model){
        model.addAttribute("title", "Listado de ClaseVirtuales");
        model.addAttribute("claseVirtuales", service.list());
        return "claseVirtual-list";
    }

    @GetMapping("/claseVirtual/form")
    public String create(Model model){
        model.addAttribute("title", "Formulario de ClaseVirtuales");
        model.addAttribute("claseVirtual", new ClaseVirtual());
        return "claseVirtual-form";
    }

    @PostMapping("/claseVirtual/form")
    public String save(@Valid ClaseVirtual claseVirtual, BindingResult br, Model model){
        if(br.hasErrors()){
            model.addAttribute("title", "Formulario de ClaseVirtuales");
            return "claseVirtual-form";
        }
        service.save(claseVirtual);
        return "redirect:/claseVirtual/list";
    }

    @GetMapping("/claseVirtual/form/{id}")
    public String update(@PathVariable Long id, Model model){
        ClaseVirtual claseVirtual = null;
        if(id>0){
            claseVirtual = service.getById(id);
        }else{
            return "redirect:/claseVirtual/list";
        }
        model.addAttribute("title", "Editar ClaseVirtual");
        model.addAttribute("claseVirtual", claseVirtual);
        return "claseVirtual-form";
    }

    @GetMapping("/claseVirtual/delete/{id}")
    public String delete(@PathVariable Long id, Model model){
        if(id > 0){
            service.delete(id);
        }
        return "redirect:/claseVirtual/list";
    }
    
}
