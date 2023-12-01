package tn.esprit.tpfoyer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.tpfoyer.entity.Chambre;
import tn.esprit.tpfoyer.entity.TypeChambre;

import java.util.List;

public interface ChambreRepository extends JpaRepository<Chambre,Long> {
    Chambre findChambreByNumeroChambre(Long numC);
    List<Chambre> findAllByTypeC(TypeChambre tc);

    @Query("SELECT distinct (ch) FROM Chambre ch " +
            "INNER JOIN ch.reservations r " +
            "INNER JOIN r.etudiants e " +
            "WHERE e.cin=:Cin " )
    Chambre trouverChselonEt(String Cin);

}
