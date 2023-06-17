package checkpoint3.angular.bind.UserEnnemies;

import checkpoint3.angular.User.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("bind")
public class UserEnnemiesController {
    private final UserEnnemiesService service ;
    @GetMapping("/userId={userId}/ennemiesId={ennemiesId}")
    public User bindUserWithEnnemies(@PathVariable("userId")Long userId, @PathVariable("ennemiesId")Long ennemiesId) {
        return service.bindUserWithEnnemies(userId,ennemiesId) ;
    }
}
