package BeNi;

import BeNi.entity.House;
import BeNi.entity.Person;
import BeNi.service.impl.HouseServiceImpl;
import BeNi.service.impl.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;

@Controller
public class PersonController {

    @Autowired private PersonServiceImpl personService;
    @Autowired private HouseServiceImpl houseService;

    @GetMapping("/")
    public String main_page_get(ModelMap modelMap) {
        List<Person> personList = personService.getAll();
        modelMap.addAttribute("personList", personList);
        return "mainPage";
        }

    @PostMapping("/")
    public String main_page_post(@ModelAttribute("house") House house, ModelMap modelMap) {
    if (house.notEmpty()) houseService.addHouse(house);
    List<Person> personList = personService.getAll();
    modelMap.addAttribute("personList", personList);
    return "mainPage";
    }

   @PostMapping("/houseBuilder")
    public void house_Builder() {
    }

    @PostMapping("/link_complete")
    //@RequestParam or ModelAttribute ? Если Request, то можно использовать Long, иначе приходится
    //действовать через безаргументный конструктор String и затем отдельно строить лонг по этой строке
    public void link(@ModelAttribute("selected_person_id") String selected_person_id,
                     @ModelAttribute("selected_house_id") String selected_house_id,
                     ModelMap modelMap) {
        Long house_id = Long.valueOf(selected_house_id);
        Long person_id = Long.valueOf(selected_person_id);
        houseService.link(person_id,house_id);
        Person selected_person = personService.getById(house_id);
        House selected_house = houseService.getById(house_id);
        modelMap.addAttribute("selected_person", selected_person);
        modelMap.addAttribute("selected_house", selected_house);
    }

    @PostMapping("/possessions")
    public void possessions(@ModelAttribute("selected_person_id") String selected_person_id,
                            ModelMap modelMap) {
        Long person_id = Long.valueOf(selected_person_id);
        Person possess_person = personService.getById(person_id);
        modelMap.addAttribute("possess_person", possess_person);

        List<House> houseList = possess_person.getHouses();
        modelMap.addAttribute("houseList", houseList);
    }

    @PostMapping("/houseManager")
    public void house_Manager(ModelMap modelMap) {

        List<Person> personList = personService.getAll();
        modelMap.addAttribute("personList", personList);

        List<House> houseList = houseService.getAll();
        modelMap.addAttribute("houseList", houseList);
    }

    @PostMapping("/end")
    public void end_page(@ModelAttribute("person") Person person, ModelMap modelMap) {
        if (person.notEmpty()) {personService.addPerson(person);}
        List<Person> personList = personService.getAll();
        modelMap.addAttribute("personList", personList);
    }

}