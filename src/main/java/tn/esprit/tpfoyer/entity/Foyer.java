package tn.esprit.tpfoyer.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
  private Set<Bloc> blocs;

}
