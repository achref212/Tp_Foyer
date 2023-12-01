package tn.esprit.tpfoyer.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.apache.commons.lang3.builder.ToStringExclude;

import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Reservation {
    @Id

    private String idReservation;
    private Date anneeUniversitaire;
    private Boolean estValide;
    @ToString.Exclude
    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Etudiant>etudiants;


}
