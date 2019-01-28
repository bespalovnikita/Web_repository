package BeNi.controller;

import BeNi.Service.PersonService;
import BeNi.entity.House;
import BeNi.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.LinkedList;
import java.util.List;

@Controller
public class SearchController {

    @Autowired private PersonService personService;

    @PostMapping("/search_page")
    public void search(ModelMap modelMap) {
        List<Person> personList = personService.getAll();
        modelMap.addAttribute("personList", personList);
    }

    @PostMapping("/filter")
    public String filter(@ModelAttribute("Name") String Name,
                         @ModelAttribute("Surname") String Surname,
                         @ModelAttribute("Patronymic") String Patronymic,
                         @ModelAttribute("Address") String Address,
                         ModelMap modelMap) {

    List<Person> personList = personService.filter(Name, Surname, Patronymic, Address);
    modelMap.addAttribute("personList", personList);
    return "search_page";
    }
}
