package checkpoint3.angular.bind.UserWeapon;

import checkpoint3.angular.User.User;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("bind")
public class UserWeaponController {
    private final UserWeaponService service;

    @GetMapping("/userId={userId}/weaponId={weaponId}")
        public User bindUserWithWeapon(@PathVariable("userId")Long userId, @PathVariable("weaponId")Long weaponId) {
        return service.bindUserWithWeapon(userId,weaponId) ;
        }
}
