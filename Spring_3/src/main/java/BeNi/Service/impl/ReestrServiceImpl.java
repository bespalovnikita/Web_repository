package BeNi.Service.impl;

import BeNi.Service.ReestrService;
import BeNi.entity.Reestr;
import BeNi.repository.ReestrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReestrServiceImpl implements ReestrService {

    @Autowired
    private ReestrRepository reestrRepository;

    @Override
    public void addReestr(Reestr reestr) {
        reestrRepository.saveAndFlush(reestr);
    }

    @Override
    public Reestr getById(Long id) { return reestrRepository.getById(id); }

    @Override
    public List<Reestr> getAll() {
        return reestrRepository.findAll();
    }

}
