package tn.esprit.tpfoyer.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Chambre;
import tn.esprit.tpfoyer.repository.ChambreRepository;

import java.util.List;
@Service
@AllArgsConstructor
public class ChambreServiceImpl implements IChambreService {
    ChambreRepository chambreRepository;

    public List<Chambre> retrieveAllChambres(){
        return chambreRepository.findAll();
    }
    public Chambre retieveChambre(long chambreId){
        return chambreRepository.findById(chambreId).get();
    }
    public Chambre addChambre(Chambre c){
        return chambreRepository.save(c);
    }
    public void removeChambre(long chambreId){
        chambreRepository.deleteById(chambreId);
    }

    public Chambre modifyChambre(Chambre chambre){
        return chambreRepository.save(chambre);
    }

    public  Chambre findchbycin(String cin){return  chambreRepository.trouverChselonEt(cin);}
}
