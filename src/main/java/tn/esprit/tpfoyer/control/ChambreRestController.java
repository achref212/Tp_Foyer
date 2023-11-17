package tn.esprit.tpfoyer.control;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Chambre;
import tn.esprit.tpfoyer.service.IChambreService;

import java.util.List;

@Tag(name = "Gestion Chambre")
@RestController
@AllArgsConstructor
@RequestMapping("/chambre")
public class ChambreRestController {
    IChambreService chambreService;

    // http://localhost:8089/tpfoyer/chambre/retriveve-all-chambres
    @Operation(description = "Récupérer toutes les chambres de la base de données")
    @GetMapping("/retriveve-all-chambres")
    public List<Chambre> getChambres(){
        List<Chambre> listChambres = chambreService.retrieveAllChambres();
        return listChambres;
    }

    // http://localhost:8089/tpfoyer/chambre/retriveve-chambres/8
    @Operation(description = "Récupérer une chambre avec ID de la base de données")
    @GetMapping("/retriveve-chambres/{chambre-id}")
    public Chambre retrieveChambre(@PathVariable("chambre-id") Long chId){
        return chambreService.retieveChambre(chId);
    }
    // http://localhost:8089/tpfoyer/chambre/add-chambre
    @Operation(description = "Ajouter une chambre à la base de données")
    @PostMapping("/add-chambre")
    public Chambre addChambre(@RequestBody Chambre c){
        return chambreService.addChambre(c);
    }

    //http://localhost:8089/tpfoyer/chambre/remove-chambre/8
    @Operation(description = "Supprimer une chambre de la base de données")
    @DeleteMapping("/remove-chambre/{chambre-id}")
    public void removeChambre(@PathVariable("chambre-id") Long chId){
        chambreService.removeChambre(chId);
    }

    // http://localhost:8089/tpfoyer/chambre/modify-chambre
    @Operation(description = "Modifier une chambre de la base de données")
    @PutMapping("/modify-chambre")
    public Chambre modifyChambre(@RequestBody Chambre c){
        return chambreService.modifyChambre(c);
    }

}
