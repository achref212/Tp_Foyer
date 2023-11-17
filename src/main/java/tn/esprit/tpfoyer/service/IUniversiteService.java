package tn.esprit.tpfoyer.service;

import tn.esprit.tpfoyer.entity.Universite;

import java.util.List;

public interface IUniversiteService {
    public List<Universite> retrieveAllUniversites();
    public Universite retieveUniversite(long universiteId);
    public Universite addUniversite(Universite u);
    public void removeUniversite(long universiteId);
    public Universite modifyUniversite(Universite universite);
}
