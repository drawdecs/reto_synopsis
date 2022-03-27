package pe.company.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.company.bean.request.AddClientRequest;
import pe.company.bean.request.DeleteClientRequest;
import pe.company.bean.request.EditClientRequest;
import pe.company.service.ClientServiceImpl;

@Controller
@RequestMapping("/clients")
@AllArgsConstructor
public class ClientController {

    private ClientServiceImpl clientService;

    @PostMapping("/add")
    public String add(AddClientRequest beanRequest) {
        clientService.add(beanRequest);
        return "redirect:/";
    }

    @PostMapping("/edit")
    public String edit(EditClientRequest beanRequest) {
        clientService.edit(beanRequest);
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String delete(DeleteClientRequest beanRequest) {
        clientService.delete(beanRequest);
        return "redirect:/";
    }

}
