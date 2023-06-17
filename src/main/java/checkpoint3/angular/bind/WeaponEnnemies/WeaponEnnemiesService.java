package checkpoint3.angular.bind.WeaponEnnemies;

import checkpoint3.angular.Ennemies.Ennemies;
import checkpoint3.angular.Ennemies.EnnemiesRepository;
import checkpoint3.angular.User.User;
import checkpoint3.angular.Weapons.Weapons;
import checkpoint3.angular.Weapons.WeaponsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WeaponEnnemiesService {
    private final EnnemiesRepository ennemiesRepository;
    private final WeaponsRepository weaponsRepository;
    public Ennemies bindWeaponsWithEnnemies(Long weaponsId, Long ennemiesId) {
        Ennemies foundEnnemies = ennemiesRepository.findById(ennemiesId)
                .orElseThrow(() -> new RuntimeException("The ennemiesId " + ennemiesId + " cannot be found"));

        Weapons foundWeapon = weaponsRepository.findById(weaponsId)
                .orElseThrow(() -> new RuntimeException("The weaponId " + weaponsId + " cannot be found"));

        foundEnnemies.setWeaponHolded(foundWeapon);
        return ennemiesRepository.save(foundEnnemies);
    }
    }

