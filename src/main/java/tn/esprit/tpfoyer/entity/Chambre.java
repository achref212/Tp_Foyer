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

public class Chambre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idChambre;
    private Long numeroChambre;
    @Enumerated(EnumType.STRING)
    private TypeChambre typeC;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Reservation> reservations;

    @ManyToOne
    Bloc bloc;


}
