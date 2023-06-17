package checkpoint3.angular.User;

import checkpoint3.angular.Ennemies.Ennemies;
import checkpoint3.angular.Weapons.Weapons;
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
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String name ;
    private String favoriteGame ;
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonIgnoreProperties("userList")
    private Set<Weapons> weaponList = new HashSet<>();
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonIgnoreProperties("defeatedBy")
    private Set<Ennemies> ennemiesSlain = new HashSet<>() ;

}
