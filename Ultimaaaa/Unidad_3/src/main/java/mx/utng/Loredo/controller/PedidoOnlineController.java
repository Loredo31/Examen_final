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
import mx.utng.Loredo.model.entity.PedidoOnline;
import mx.utng.Loredo.model.service.IPedidoOnlineService;

@Controller
@SessionAttributes("pedidoOnline")
public class PedidoOnlineController {
    @Autowired
    private IPedidoOnlineService service;

    @GetMapping({"/pedidoOnline", "/pedidoOnline/", "/pedidoOnline/list"})
    public String list(Model model){
        model.addAttribute("title", "Listado de PedidoOnlinees");
        model.addAttribute("pedidoOnlinees", service.list());
        return "pedidoOnline-list";
    }

    @GetMapping("/pedidoOnline/form")
    public String create(Model model){
        model.addAttribute("title", "Formulario de PedidoOnlinees");
        model.addAttribute("pedidoOnline", new PedidoOnline());
        return "pedidoOnline-form";
    }

    @PostMapping("/pedidoOnline/form")
    public String save(@Valid PedidoOnline pedidoOnline, BindingResult br, Model model){
        if(br.hasErrors()){
            model.addAttribute("title", "Formulario de PedidoOnlinees");
            return "pedidoOnline-form";
        }
        service.save(pedidoOnline);
        return "redirect:/pedidoOnline/list";
    }

    @GetMapping("/pedidoOnline/form/{id}")
    public String update(@PathVariable Long id, Model model){
        PedidoOnline pedidoOnline = null;
        if(id>0){
            pedidoOnline = service.getById(id);
        }else{
            return "redirect:/pedidoOnline/list";
        }
        model.addAttribute("title", "Editar PedidoOnline");
        model.addAttribute("pedidoOnline", pedidoOnline);
        return "pedidoOnline-form";
    }

    @GetMapping("/pedidoOnline/delete/{id}")
    public String delete(@PathVariable Long id, Model model){
        if(id > 0){
            service.delete(id);
        }
        return "redirect:/pedidoOnline/list";
    }
    
}
