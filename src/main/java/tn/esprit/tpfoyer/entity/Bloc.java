package tn.esprit.tpfoyer.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Bloc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long idBloc;
    private  String nomBloc;
    private  Long capaciteBloc;
    @ToString.Exclude
    @ManyToOne(cascade = CascadeType.ALL)
    private Foyer foyer;
    @ToString.Exclude
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "bloc")
    private Set<Chambre>chambres;


}
