package BeNi.controller;

import BeNi.Service.impl.PersonServiceImpl;
import BeNi.entity.House;
import BeNi.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;

@Controller
public class PersonController {

    @Autowired private PersonServiceImpl personService;

    @PostMapping("/person_builder")
    public void person_Builder() {}

    @PostMapping("/persons_showing")
    public void persons_showing(@ModelAttribute("person") Person person, ModelMap modelMap) {
        if (person.notEmpty()) {personService.addPerson(person);}
        List<Person> personList = personService.getAll();
        modelMap.addAttribute("personList", personList);
    }

    @PostMapping("/person_possessions")
    public void possessions(
            @ModelAttribute("selected_person_id") String selected_person_id,
            ModelMap modelMap) {
        Long person_id = Long.valueOf(selected_person_id);
        Person possess_person = personService.getById(person_id);
        modelMap.addAttribute("possess_person", possess_person);
        List<House> houseList = possess_person.getHouses();
        modelMap.addAttribute("houseList", houseList);
    }
}