package tn.esprit.tpfoyer.control;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.service.IBlocService;

import java.util.List;
@Tag(name = "Gestion Bloc")

@RestController
@AllArgsConstructor
@RequestMapping("/bloc")
public class BlocRestController {
    IBlocService blocService;

    // http://localhost:8089/tpfoyer/bloc/retriveve-all-blocs
    @Operation(description = "Récupérer toutes les Blocs de la base de données")
    @GetMapping("/retriveve-all-blocs")
    public List<Bloc> getBlocs(){
        List<Bloc> listBlocs = blocService.retrieveAllBlocs();
        return listBlocs;
    }

    // http://localhost:8089/tpfoyer/bloc/retriveve-bloc/8
    @Operation(description = "Récupérer une Bloc avec ID de la base de données")
    @GetMapping("/retriveve-bloc/{bloc-id}")
    public Bloc retrieveChambre(@PathVariable("bloc-id") Long blId){
        return blocService.retieveBloc(blId);
    }

    // http://localhost:8089/tpfoyer/bloc/add-bloc
    @Operation(description = "Ajouter un bloc à la base de données")
    @PostMapping("/add-bloc")
    public Bloc addChambre(@RequestBody Bloc b){
        return blocService.addBloc(b);
    }

    //http://localhost:8089/tpfoyer/bloc/remove-bloc/8
    @Operation(description = "Supprimer un bloc de la base de données")
    @DeleteMapping("/remove-bloc/{bloc-id}")
    public void removeChambre(@PathVariable("bloc-id") Long blocId){
        blocService.retieveBloc(blocId);
    }

    // http://localhost:8089/tpfoyer/bloc/modify-bloc
    @Operation(description = "Modifier une chambre de la base de données")
    @PutMapping("/modify-bloc")
    public Bloc modifyChambre(@RequestBody Bloc b){
        return blocService.modifyBloc(b);
    }
}
