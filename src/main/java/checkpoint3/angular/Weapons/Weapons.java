package checkpoint3.angular.Weapons;
import checkpoint3.angular.Ennemies.Ennemies;
import checkpoint3.angular.User.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor


public class Weapons {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String name ;
    private Boolean typeOfDamage ;
    @ManyToMany(mappedBy = "weaponList")
    @JsonIgnoreProperties({"weaponList","userList"})
    private Set<User> userList = new HashSet<>() ;
    @OneToMany
    @JsonIgnoreProperties("weaponHolded")
    private Set <Ennemies> holdedBy = new HashSet<>() ;

}
