package tn.esprit.tpfoyer.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.entity.Foyer;
import tn.esprit.tpfoyer.repository.BlocRepository;
import tn.esprit.tpfoyer.repository.FoyerRepository;

import java.util.List;
@Service
@AllArgsConstructor
@Slf4j

public class BlocServiceImpl implements IBlocService {
    BlocRepository blocRepository;
    FoyerRepository foyerRepository;
    @Scheduled(fixedDelay = 10000)
    public List<Bloc> rretrieveAllBlocs(){
        List<Bloc> listB = blocRepository.findAll();
        for (Bloc b:listB){
            log.info("block: "+ b );
        }
        return listB;
    }

    public List<Bloc> retrieveAllBlocs(){
        return blocRepository.findAll();
    }
    public Bloc retieveBloc(long blocId){
        return blocRepository.findById(blocId).get();
    }
    public Bloc addBloc(Bloc b){
        return blocRepository.save(b);
    }
    public void removeBloc(long blocId){
        blocRepository.deleteById(blocId);
    }
    public Bloc modifyBloc(Bloc bloc){
        return blocRepository.save(bloc);
    }

    public Bloc addBlocandFoyer(Bloc b){return blocRepository.save(b);}

    public void assignBloctoFoyer(Long Bid,Long Fid){
    Bloc bloc =blocRepository.findById(Bid).get();
    Foyer foyer = foyerRepository.findById(Fid).get();
    bloc.setFoyer(foyer);
blocRepository.save(bloc);
    }
    public void desaffecterBloctoFoyer(Long Bid,Long Fid){
        Bloc bloc =blocRepository.findById(Bid).get();
        Foyer foyer = foyerRepository.findById(Fid).get();
        bloc.setFoyer(null);
        blocRepository.save(bloc);
    }
    @Scheduled(fixedDelay = 10000)
    public  List<Bloc> retriveBlocFoyerNull()
    {
        List<Bloc> listB = blocRepository.findAllByFoyerIsNull();
        for (Bloc b :listB){
            log.info("BlocNull",b);
        }
        return  listB;
    }
    public List<Bloc> blocsansfoyer()
    {
        return blocRepository.findAllByFoyerIsNull();
    }
}
