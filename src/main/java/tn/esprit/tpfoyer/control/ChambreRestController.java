package tn.esprit.tpfoyer.control;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Chambre;
import tn.esprit.tpfoyer.service.IChambreService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/chambre")
public class ChambreRestController {
    IChambreService chambreService;

    // http://localhost:8089/tpfoyer/chambre/retriveve-all-chambres
    @GetMapping("/retriveve-all-chambres")
    public List<Chambre> getChambres(){
        List<Chambre> listChamres = chambreService.retrieveAllChambres();
        return listChamres;
    }

    // http://localhost:8089/tpfoyer/chambre/retriveve-chambres/8
    @GetMapping("/retriveve-chambres/{chambre-id}")
    public Chambre retrieveChambre(@PathVariable("chambre-id") Long chId){
        return chambreService.retieveChambre(chId);
    }
    // http://localhost:8089/tpfoyer/chambre/add-chambre
    @PostMapping("/add-chambre")
    public Chambre addChambre(@RequestBody Chambre c){
        return chambreService.addChambre(c);
    }

    //http://localhost:8089/tpfoyer/chambre/remove-chambre/8
    @DeleteMapping("/remove-chambre/{chambre-id}")
    public void removeChambre(@PathVariable("chambre-id") Long chId){
        chambreService.removeChambre(chId);
    }

    // http://localhost:8089/tpfoyer/chambre/modify-chambre
    @PutMapping("/modify-chambre")
    public Chambre modifyChambre(@RequestBody Chambre c){
        return chambreService.modifyChambre(c);
    }

}
