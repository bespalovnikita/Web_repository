package BeNi.controller;

import BeNi.Service.impl.ReestrServiceImpl;
import BeNi.entity.Reestr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainPageController {

    @Autowired private ReestrServiceImpl reestrService;

    @GetMapping("/")
    public String main_page_get(ModelMap modelMap) {
        List<Reestr> reestrList = reestrService.getAll();
        modelMap.addAttribute("personList", reestrList);
    return "mainPage";
    }
}
