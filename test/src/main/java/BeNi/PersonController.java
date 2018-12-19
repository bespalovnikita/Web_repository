package BeNi;

import BeNi.entity.Person;
import BeNi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/")
    public String getForm() {
        return "mainPage";
    }

    @PostMapping("/end")
    public String saveDetails(@RequestParam("Name") String Name,
                              @RequestParam("Surname") String Surname,
                              @RequestParam("Patronymic") String Patronymic,
                              ModelMap modelMap) {
    Person person = new Person(Name,Surname,Patronymic);
    personRepository.saveAndFlush(person);
    modelMap.put("Name", Name);
    modelMap.put("Surname", Surname);
    modelMap.put("Patronymic", Patronymic);
    return "end";
    }

}