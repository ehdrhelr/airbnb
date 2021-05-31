package team01.airbnb.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import team01.airbnb.domain.accommodation.Accommodation;
import team01.airbnb.dto.ApiResult;
import team01.airbnb.dto.request.TotalAccommodationSaveRequestDto;
import team01.airbnb.dto.response.AccommodationResponseDto;
import team01.airbnb.service.AccommodationService;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RequestMapping("/accommodations")
@RestController
public class AccommodationController {

    private final AccommodationService accommodationService;

    public AccommodationController(AccommodationService accommodationService) {
        this.accommodationService = accommodationService;
    }

    // todo : list 감쌀 것
    @GetMapping("/")
    public ApiResult<List<Accommodation>> accommodations() {
        return ApiResult.succeed(accommodationService.accommodations());
    }

    // todo : list 감쌀 것
    @GetMapping
    public ApiResult<List<AccommodationResponseDto>> accommodationsForReservation(
            @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam("check_in") LocalDate checkIn
            , @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam("check_out") LocalDate checkOut
            , @RequestParam("min_charge") int minCharge
            , @RequestParam("max_charge") int maxCharge
            , @RequestParam("guests") int guests) {
        return ApiResult.succeed(accommodationService.findAvailableAccommodationsForReservation(
                checkIn, checkOut, minCharge, maxCharge, guests));
    }

    @PostMapping("/")
    public ApiResult createAccommodation(TotalAccommodationSaveRequestDto totalAccommodationSaveRequestDto) {
        System.out.println(totalAccommodationSaveRequestDto.toString());
        System.out.println(totalAccommodationSaveRequestDto.getConditionSaveRequestDto().toString());
        accommodationService.save(totalAccommodationSaveRequestDto);
        return ApiResult.ok();
    }

    @GetMapping("/search")
    public ApiResult<List<AccommodationResponseDto>> accommodationsByAddress(@RequestParam String address) {
        List<AccommodationResponseDto> accommodations = accommodationService.findAccommodationsByAddress(address);
        return ApiResult.succeed(accommodations);
    }
}
