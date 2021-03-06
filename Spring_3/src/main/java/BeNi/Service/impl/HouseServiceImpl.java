package BeNi.Service.impl;

import BeNi.Service.HouseService;
import BeNi.entity.House;
import BeNi.repository.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {

    @Autowired private HouseRepository houseRepository;

    @Override
    public void addHouse(House house) {
    houseRepository.saveAndFlush(house);
    }

    @Override
    public void link(Long person_id, House house) {
    house.setPersonid(person_id);
    houseRepository.saveAndFlush(house);
    }

    @Override
    public House getById(Long id) {return houseRepository.getById(id);
    }

    @Override
    public List<House> getAll() {
    return houseRepository.findAll();
    }



}
