package tn.esprit.tpfoyer.control;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Reservation;
import tn.esprit.tpfoyer.service.IReservationService;

import java.util.List;

@RestController
@Tag(name = "Gestion Reservation")

@AllArgsConstructor
@RequestMapping("/reservation")
public class ReservationRestController {
    IReservationService reservationService;
    // http://localhost:8089/tpfoyer/reservation/retriveve-all-reservations
    @Operation(description = "Récupérer toutes les reservations de la base de données")
    @GetMapping("/retriveve-all-reservations")
    public List<Reservation> getReservations(){
        List<Reservation> listReservations = reservationService.retrieveAllReservations();
        return listReservations;
    }

    // http://localhost:8089/tpfoyer/reservation/retriveve-reservations/8
    @Operation(description = "Récupérer une reservation avec ID de la base de données")
    @GetMapping("/retriveve-reservations/{reservation-id}")
    public Reservation retrieveReservation(@PathVariable("reservation-id") String reservationId){
        return reservationService.retieveReservation(reservationId);
    }
    // http://localhost:8089/tpfoyer/reservation/add-reservation
    @Operation(description = "Ajouter une reservation à la base de données")
    @PostMapping("/add-reservation")
    public Reservation addReservation(@RequestBody Reservation c){
        return reservationService.addReservation(c);
    }

    //http://localhost:8089/tpfoyer/reservation/remove-reservation/8
    @Operation(description = "Supprimer une reservation de la base de données")
    @DeleteMapping("/remove-reservation/{reservation-id}")
    public void removeReservation(@PathVariable("reservation-id") String chId){
        reservationService.removeReservation(chId);
    }

    // http://localhost:8089/tpfoyer/reservation/modify-reservation
    @Operation(description = "Modifier une reservation de la base de données")
    @PutMapping("/modify-reservation")
    public Reservation modifyReservation(@RequestBody Reservation c){
        return reservationService.modifyReservation(c);
    }
}
