package checkpoint3.angular.bind.WeaponEnnemies;

import checkpoint3.angular.Ennemies.Ennemies;
import checkpoint3.angular.User.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("bind")
public class WeaponEnnemiesController {
    private final WeaponEnnemiesService service ;
    @GetMapping("/weaponsId={weaponsId}/ennemiesId={ennemiesId}")
    public Ennemies bindWeaponsrWithEnnemies(@PathVariable("weaponsId")Long weaponsId, @PathVariable("ennemiesId")Long ennemiesId) {
        return service.bindWeaponsWithEnnemies(weaponsId,ennemiesId) ;
}
}
