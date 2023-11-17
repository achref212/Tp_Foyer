package tn.esprit.tpfoyer.control;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Universite;
import tn.esprit.tpfoyer.service.IUniversiteService;

import java.util.List;

@RestController
@Tag(name = "Gestion Universite")

@AllArgsConstructor
@RequestMapping("/universite")
public class UniversiteRestController {
    IUniversiteService universiteService;
    // http://localhost:8089/tpfoyer/universite/retriveve-all-universites
    @Operation(description = "Récupérer toutes les universites de la base de données")
    @GetMapping("/retriveve-all-universites")
    public List<Universite> getUniversites(){
        List<Universite> listUniversites = universiteService.retrieveAllUniversites();
        return listUniversites;
    }

    // http://localhost:8089/tpfoyer/universite/retriveve-universites/8
    @Operation(description = "Récupérer une universite avec ID de la base de données")
    @GetMapping("/retriveve-universites/{universite-id}")
    public Universite retrieveUniversite(@PathVariable("universite-id") Long chId){
        return universiteService.retieveUniversite(chId);
    }
    // http://localhost:8089/tpfoyer/universite/add-universite
    @Operation(description = "Ajouter une universite à la base de données")
    @PostMapping("/add-universite")
    public Universite addUniversite(@RequestBody Universite c){
        return  universiteService.addUniversite(c);

    }

    //http://localhost:8089/tpfoyer/universite/remove-universite/8
    @Operation(description = "Supprimer une universite de la base de données")
    @DeleteMapping("/remove-universite/{universite-id}")
    public void removeUniversite(@PathVariable("universite-id") Long chId){
        universiteService.removeUniversite(chId);
    }

    // http://localhost:8089/tpfoyer/universite/modify-universite
    @Operation(description = "Modifier une universite de la base de données")
    @PutMapping("/modify-universite")
    public Universite modifyUniversite(@RequestBody Universite c){
        return universiteService.modifyUniversite(c);
    }
    
}
