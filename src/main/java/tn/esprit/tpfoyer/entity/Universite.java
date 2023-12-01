package tn.esprit.tpfoyer.entity;

import jakarta.persistence.*;
import lombok.*;
import org.apache.commons.lang3.builder.ToStringExclude;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Universite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUniversite;
    private  String nomUniversite;
    private String adresse;

    @OneToOne(mappedBy="idUniversite")
    @ToString.Exclude
    private Foyer foyer;
}
