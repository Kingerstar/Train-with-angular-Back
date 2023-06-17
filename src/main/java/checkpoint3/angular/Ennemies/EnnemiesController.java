package checkpoint3.angular.Ennemies;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ennemies")

public class EnnemiesController {
    private final EnnemiesService service ;
    @GetMapping
    public List<Ennemies> getAll() {
        return service.getAll() ;
    }
    @GetMapping("/{id}")
    public Ennemies getById(@PathVariable("id") Long id) {
        return service.getById(id) ;
    }
    @PostMapping("/add")
    public Ennemies add(@RequestBody Ennemies ennemies) {
        return service.add(ennemies);
    }
    @PutMapping("/update/{id}")
    public Ennemies update(@RequestBody Ennemies ennemies ,@PathVariable("id")Long id) {
        return service.update(ennemies, id);
    }
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id")Long id) {
        service.delete(id) ;
        return "ennemies has been deleted" ;
    }
}


