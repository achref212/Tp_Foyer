package tn.esprit.tpfoyer.control;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Etudiant;
import tn.esprit.tpfoyer.service.IEtudiantService;

import java.util.List;

@Tag(name = "Gestion Etudiant")
@RestController
@AllArgsConstructor
@RequestMapping("/etudiant")
public class EtudiantRestController {
    IEtudiantService etudiantService;
    // http://localhost:8089/tpfoyer/etudiant/retriveve-all-etudiants
    @Operation(description = "Récupérer toutes les etudiants de la base de données")
    @GetMapping("/retriveve-all-etudiants")
    public List<Etudiant> getEtudiants(){
        List<Etudiant> listBlocs = etudiantService.retrieveAllEtudiants();
        return listBlocs;
    }

    // http://localhost:8089/tpfoyer/etudiant/retriveve-etudiants/8
    @Operation(description = "Récupérer une etudiant avec ID de la base de données")
    @GetMapping("/retriveve-etudiants/{etudiant-id}")
    public Etudiant retrieveEtudiant(@PathVariable("etudiant-id") Long chId){
        return etudiantService.retieveEtudiant(chId);
    }
    // http://localhost:8089/tpfoyer/etudiant/add-etudiant
    @Operation(description = "Ajouter une etudiant à la base de données")
    @PostMapping("/add-etudiant")
    public Etudiant addEtudiant(@RequestBody Etudiant e){
        return etudiantService.addEtudiant(e);
    }

    //http://localhost:8089/tpfoyer/etudiant/remove-etudiant/8
    @Operation(description = "Supprimer une etudiant de la base de données")
    @DeleteMapping("/remove-etudiant/{etudiant-id}")
    public void removeEtudiant(@PathVariable("etudiant-id") Long etId){
        etudiantService.removeEtudiant(etId);
    }

    // http://localhost:8089/tpfoyer/etudiant/modify-etudiant
    @Operation(description = "Modifier une etudiant de la base de données")
    @PutMapping("/modify-etudiant")
    public Etudiant modifyEtudiant(@RequestBody Etudiant e){
        return etudiantService.modifyEtudiant(e);
    }
}
