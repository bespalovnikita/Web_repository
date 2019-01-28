package BeNi.controller;

import BeNi.Service.HouseService;
import BeNi.Service.PersonService;
import BeNi.entity.House;
import BeNi.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HouseController {

    @Autowired private HouseService houseService;
    @Autowired private PersonService personService;

    @PostMapping("/house_builder")
    public void house_Builder() {}

    @PostMapping("/house_showing")
    public void house_showing(@ModelAttribute("house") House house, ModelMap modelMap) {
        if (house.notEmpty()) houseService.addHouse(house);
        List<House> houseList = houseService.getAll();
        modelMap.addAttribute("houseList", houseList);
    }

    @PostMapping("/link_complete")
    public void link(
            @ModelAttribute("selected_person_id") String selected_person_id,
            @ModelAttribute("selected_house_id") String selected_house_id,
            ModelMap modelMap){
        Long house_id = Long.valueOf(selected_house_id);
        Long person_id = Long.valueOf(selected_person_id);
        House selected_house = houseService.getById(house_id);
        Person selected_person = personService.getById(house_id);
        houseService.link(person_id,selected_house);
        modelMap.addAttribute("selected_person", selected_person);
        modelMap.addAttribute("selected_house", selected_house);
    }

    @PostMapping("/link_manager")
    public void house_Manager(ModelMap modelMap) {
        List<Person> personList = personService.getAll();
        modelMap.addAttribute("personList", personList);
        List<House> houseList = houseService.getAll();
        modelMap.addAttribute("houseList", houseList);
    }
}
