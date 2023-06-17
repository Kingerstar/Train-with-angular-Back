package checkpoint3.angular.User;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

private final UserService service ;
@GetMapping
    public List<User> getAll() {
    return service.getAll() ;
}
@GetMapping("/{id}")
    public User getById(@PathVariable("id") Long id) {
    return service.getById(id) ;
}
@PostMapping("/add")
    public User add(@RequestBody User user) {
    return service.add(user);
}
@PutMapping("/update/{id}")
    public User update(@RequestBody User user ,@PathVariable("id")Long id) {
    return service.update(user, id);
}
@DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id")Long id) {
      service.delete(id) ;
      return "user has been deleted" ;
    }
}
