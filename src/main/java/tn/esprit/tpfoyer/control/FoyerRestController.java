package tn.esprit.tpfoyer.control;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Foyer;
import tn.esprit.tpfoyer.service.IFoyerService;

import java.util.List;

@RestController
@Tag(name = "Gestion Foyer")

@AllArgsConstructor
@RequestMapping("/foyer")
public class FoyerRestController {
    IFoyerService foyerService;
    // http://localhost:8089/tpfoyer/foyer/retriveve-all-foyers
    @Operation(description = "Récupérer toutes les foyers de la base de données")
    @GetMapping("/retriveve-all-foyers")
    public List<Foyer> getFoyers(){
        List<Foyer> listFoyers = foyerService.retrieveAllFoyers();
        return listFoyers;
    }

    // http://localhost:8089/tpfoyer/foyer/retriveve-foyers/8
    @Operation(description = "Récupérer une foyer avec ID de la base de données")
    @GetMapping("/retriveve-foyers/{foyer-id}")
    public Foyer retrieveFoyer(@PathVariable("foyer-id") Long chId){
        return foyerService.retieveFoyer(chId);
    }
    // http://localhost:8089/tpfoyer/foyer/add-foyer
    @Operation(description = "Ajouter une foyer à la base de données")
    @PostMapping("/add-foyer")
    public Foyer addFoyer(@RequestBody Foyer c){
        return foyerService.addFoyer(c);
    }

    //http://localhost:8089/tpfoyer/foyer/remove-foyer/8
    @Operation(description = "Supprimer une foyer de la base de données")
    @DeleteMapping("/remove-foyer/{foyer-id}")
    public void removeFoyer(@PathVariable("foyer-id") Long chId){
        foyerService.removeFoyer(chId);
    }

    // http://localhost:8089/tpfoyer/foyer/modify-foyer
    @Operation(description = "Modifier une foyer de la base de données")
    @PutMapping("/modify-foyer")
    public Foyer modifyFoyer(@RequestBody Foyer c){
        return foyerService.modifyFoyer(c);
    }
}
