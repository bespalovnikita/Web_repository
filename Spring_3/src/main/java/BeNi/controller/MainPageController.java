package BeNi.controller;

import BeNi.Service.impl.PersonServiceImpl;
import BeNi.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainPageController {

    @Autowired private PersonServiceImpl personService;

    @GetMapping("/")
    public String main_page_get(ModelMap modelMap) {
        List<Person> personList = personService.getAll();
        modelMap.addAttribute("personList", personList);
    return "mainPage";
    }
}
