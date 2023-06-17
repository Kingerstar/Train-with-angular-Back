package checkpoint3.angular.Ennemies;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnnemiesService {
    private final EnnemiesRepository repository;
    public List<Ennemies> getAll() {
        return repository.findAll();
    }

    public Ennemies getById(Long id) {
        Ennemies ennemiesFound = repository.findById(id).orElseThrow(()-> new RuntimeException(id + "not found"));
        return ennemiesFound ;
    }

    public Ennemies add(Ennemies ennemies) {
        return repository.save(ennemies) ;
    }

    public Ennemies update(Ennemies ennemies, Long id) {
        Ennemies ennemiesfound = repository.getById(id);
        ennemiesfound.setName(ennemies.getName()) ;
        return repository.save(ennemiesfound);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}
