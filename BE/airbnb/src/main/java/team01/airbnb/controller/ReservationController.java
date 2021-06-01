package team01.airbnb.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import team01.airbnb.dto.ApiResult;
import team01.airbnb.dto.response.ReservationViewResponseDto;
import team01.airbnb.service.ReservationService;

import java.time.LocalDate;

@RequestMapping("/reservations")
@RestController
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public ApiResult<ReservationViewResponseDto> reservationView(
            @RequestParam("accommodation_id") Long accommodationId
            , @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam("check_in") LocalDate checkIn
            , @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam("check_out") LocalDate checkOut
            , @RequestParam("guests") int guests) {
        return ApiResult.succeed(
                reservationService.getReservationView(accommodationId, checkIn, checkOut, guests));
    }
}
