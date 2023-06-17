package checkpoint3.angular.Weapons;

import checkpoint3.angular.Weapons.Weapons;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/weapons")

public class WeaponsController {
    private final WeaponService service ;
    @GetMapping
    public List<Weapons> getAll() {
        return service.getAll() ;
    }
    @GetMapping("/{id}")
    public Weapons getById(@PathVariable("id") Long id) {
        return service.getById(id) ;
    }
    @PostMapping("/add")
    public Weapons add(@RequestBody Weapons weapon) {
        return service.add(weapon);
    }
    @PutMapping("/update/{id}")
    public Weapons update(@RequestBody Weapons weapon ,@PathVariable("id")Long id) {
        return service.update(weapon, id);
    }
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id")Long id) {
        service.delete(id) ;
        return "weapon has been deleted" ;
    }
}
