package tn.esprit.tpfoyer.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Foyer;
import tn.esprit.tpfoyer.repository.FoyerRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class FoyerServiceImpl implements  IFoyerService{
    FoyerRepository foyerRepository;
    public List<Foyer> retrieveAllFoyers(){
        return foyerRepository.findAll();
    }
    public Foyer retieveFoyer(long foyerId){
return foyerRepository.findById(foyerId).get();
    }
    public Foyer addFoyer(Foyer f){
        return foyerRepository.save(f);

    }
    public void removeFoyer(long foyerId){
        foyerRepository.deleteById(foyerId);

    }
    public Foyer modifyFoyer(Foyer foyer){
return foyerRepository.save(foyer);
    }
}
