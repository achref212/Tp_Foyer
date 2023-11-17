package tn.esprit.tpfoyer.service;

import tn.esprit.tpfoyer.entity.Etudiant;

import java.util.List;

public interface IEtudiantService {
    public List<Etudiant> retrieveAllEtudiants();
    public Etudiant retieveEtudiant(long etudiantId);
    public Etudiant addEtudiant(Etudiant e);
    public void removeEtudiant(long etudiantId);
    public Etudiant modifyEtudiant(Etudiant etudiant);
}
