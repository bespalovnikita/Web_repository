package BeNi.service;
import BeNi.entity.House;
import java.util.List;

public interface HouseService {

    void addHouse(House House);
    void link(Long person_id, Long house_id);
    List<House> getAll();
    House getById(Long id);
}
