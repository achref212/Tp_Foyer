package tn.esprit.tpfoyer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.tpfoyer.entity.Bloc;

import java.util.List;

public interface BlocRepository extends JpaRepository<Bloc, Long> {



    Bloc findBlocByNomBloc(String nomB);
    List<Bloc> findAllByFoyerIsNull();
}
