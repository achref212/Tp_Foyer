package tn.esprit.tpfoyer.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Foyer {
    @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFoyer;

    private String nomFoyer;
    private  Long capaciteFoyer;

    @OneToOne
    private Universite idUniversite;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "foyer")
    @ToString.Exclude
  private Set<Bloc> blocs;

}
