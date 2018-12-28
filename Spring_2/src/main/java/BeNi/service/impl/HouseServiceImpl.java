package BeNi.service.impl;
import BeNi.entity.House;
import BeNi.repository.HouseRepository;
import BeNi.service.HouseService;
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
    public House getById(Long id) { return houseRepository.getById(id);
    }

    @Override
    public void delete(House house) {
        houseRepository.delete(house);
    }

    @Override
    public void delete(long id) {
        houseRepository.deleteById(id);
    }

    @Override
    public List<House> getAll() {
        return houseRepository.findAll();
    }
}
