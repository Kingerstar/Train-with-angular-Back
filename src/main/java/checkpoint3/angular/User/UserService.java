package checkpoint3.angular.User;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;
    public List<User> getAll() {
       return repository.findAll();
    }

    public User getById(Long id) {
        User userFound = repository.findById(id).orElseThrow(()-> new RuntimeException(id + "not found"));
        return userFound ;
    }

    public User add(User user) {
         return repository.save(user) ;
    }

    public User update(User user, Long id) {
        User userfound = repository.getById(id);
        userfound.setName(user.getName());
        userfound.setFavoriteGame(user.getFavoriteGame());
        return repository.save(userfound);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
