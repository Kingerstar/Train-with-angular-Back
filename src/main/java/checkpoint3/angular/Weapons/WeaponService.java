package checkpoint3.angular.Weapons;

import checkpoint3.angular.Weapons.Weapons;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WeaponService {
    private final WeaponsRepository repository ;
    public List<Weapons> getAll() {
        return repository.findAll();
    }

    public Weapons getById(Long id) {
        Weapons weaponFound = repository.findById(id).orElseThrow(()-> new RuntimeException(id + "not found"));
        return weaponFound ;
    }

    public Weapons add(Weapons weapon) {
        return repository.save(weapon) ;
    }

    public Weapons update(Weapons weapon, Long id) {
        Weapons weaponfound = repository.getById(id);
        weaponfound.setName(weapon.getName());
        weaponfound.setTypeOfDamage(weapon.getTypeOfDamage());
        return repository.save(weaponfound);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
