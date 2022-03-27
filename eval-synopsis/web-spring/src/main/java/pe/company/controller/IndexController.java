package pe.company.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.company.bean.response.ClientResponse;
import pe.company.exception.ClientException;
import pe.company.service.ClientServiceImpl;

import java.util.List;

@Controller
@RequestMapping("")
@AllArgsConstructor
public class IndexController {

    private ClientServiceImpl clientService;

    @GetMapping(path = {"", "/"})
    public String index(Model model) {
        List<ClientResponse> clients = clientService.list();
        model.addAttribute("items", clients);
        return "index";
    }

}
