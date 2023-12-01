package tn.esprit.tpfoyer.service;

import tn.esprit.tpfoyer.entity.Bloc;

import java.util.List;

public interface IBlocService {

    public List<Bloc> retrieveAllBlocs();
    public Bloc retieveBloc(long blocId);
    public Bloc addBloc(Bloc b);
    public void removeBloc(long blocId);
    public Bloc modifyBloc(Bloc bloc);
    public Bloc addBlocandFoyer(Bloc b);
    public void assignBloctoFoyer(Long Bid,Long Fid);
    public void desaffecterBloctoFoyer(Long Bid,Long Fid);

}
