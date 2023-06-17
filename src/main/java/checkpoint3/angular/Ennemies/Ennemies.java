package checkpoint3.angular.Ennemies;

import checkpoint3.angular.User.User;
import checkpoint3.angular.Weapons.Weapons;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Ennemies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String name ;
    @ManyToMany(mappedBy = "ennemiesSlain")
    @JsonIgnoreProperties("ennemiesSlain")
    private Set<User> defeatedBy = new HashSet<>() ;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonIgnoreProperties({"holdedBy","userList"})
    private Weapons weaponHolded ;
}
