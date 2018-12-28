package BeNi.service;
import BeNi.entity.House;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HouseService {
    void addHouse(House House);
    void link(Long person_id, House house);
    List<House> getAll();
    House getById(Long id);
    void delete(House house);
    void delete(long id);
}
