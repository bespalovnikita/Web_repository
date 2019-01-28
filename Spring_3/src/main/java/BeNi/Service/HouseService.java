package BeNi.Service;
import BeNi.entity.House;
import java.util.List;

public interface HouseService {
    void addHouse(House House);
    void link(Long person_id, House house);
    List<House> getAll();
    House getById(Long id);
}
