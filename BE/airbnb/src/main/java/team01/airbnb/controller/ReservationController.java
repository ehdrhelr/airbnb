package team01.airbnb.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import team01.airbnb.dto.ApiResult;
import team01.airbnb.dto.response.ReservationViewResponseDto;
import team01.airbnb.service.ReservationService;

import java.time.LocalDate;

@Api(tags = {"예약관련 API"}, description = "숙소 예약화면을 가져오고, 숙소를 예약할 수 있습니다.")
@RequestMapping("/reservations")
@RestController
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @ApiOperation(value = "숙소 예약화면 불러오기"
            , notes = "숙소id, 체크인과 체크아웃, 인원수를 알려주시면 숙박가격, 수수료 및 세금, 총합 모두 보내드립니다.")
    @GetMapping
    public ApiResult<ReservationViewResponseDto> reservationView(
            @RequestParam("accommodation_id") Long accommodationId
            , @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam("check_in") LocalDate checkIn
            , @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam("check_out") LocalDate checkOut
            , @RequestParam("guests") int guests) {
        return ApiResult.succeed(
                reservationService.getReservationView(accommodationId, checkIn, checkOut, guests));
    }

    @ApiOperation(value = "숙소 예약하기", notes = "숙소를 예약합니다.")
    @PostMapping("/{accommodation_id}")
    public ApiResult reserve(@PathVariable("accommodation_id") Long accommodationId
            , @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam("check_in") LocalDate checkIn
            , @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam("check_out") LocalDate checkOut
            , @RequestParam("guests") int guests
            , @RequestParam("charge") int charge) {
        Long userId = 2L; // 임시
        reservationService.reserve(accommodationId, userId, checkIn, checkOut, guests, charge);
        return null;
    }
}
