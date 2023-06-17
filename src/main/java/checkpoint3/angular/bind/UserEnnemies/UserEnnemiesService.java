package checkpoint3.angular.bind.UserEnnemies;

import checkpoint3.angular.Ennemies.EnnemiesRepository;
import checkpoint3.angular.User.User;
import checkpoint3.angular.User.UserRepository;
import checkpoint3.angular.Ennemies.Ennemies;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserEnnemiesService {
    private final UserRepository userRepository ;
    private final EnnemiesRepository ennemiesRepository;
    public User bindUserWithEnnemies(Long userId, Long ennemiesId) {
        User foundUser = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("The userId " + userId + " cannot be found"));

        Ennemies foundEnnemies = ennemiesRepository.findById(ennemiesId)
                .orElseThrow(() -> new RuntimeException("The ennemiesId " + ennemiesId + " cannot be found"));

        foundUser.getEnnemiesSlain().add(foundEnnemies);

        return userRepository.save(foundUser);

    }
}
