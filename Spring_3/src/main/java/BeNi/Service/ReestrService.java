package BeNi.Service;
import BeNi.entity.Reestr;
import java.util.List;

public interface ReestrService {
    void addReestr(Reestr reestr);
    Reestr getById(Long id);
    List<Reestr> getAll();
}
