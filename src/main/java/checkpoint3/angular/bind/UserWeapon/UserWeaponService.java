package checkpoint3.angular.bind.UserWeapon;

import checkpoint3.angular.User.User;
import checkpoint3.angular.User.UserRepository;
import checkpoint3.angular.Weapons.Weapons;
import checkpoint3.angular.Weapons.WeaponsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class UserWeaponService {
    private final UserRepository userRepository ;
    private final WeaponsRepository weaponsRepository ;
    public User bindUserWithWeapon(Long userId, Long weaponId) {
        User foundUser = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("The userId " + userId + " cannot be found"));

        Weapons foundWeapon = weaponsRepository.findById(weaponId)
                .orElseThrow(() -> new RuntimeException("The weaponId " + weaponId + " cannot be found"));

        foundUser.getWeaponList().add(foundWeapon);

        return userRepository.save(foundUser);
    }
}
