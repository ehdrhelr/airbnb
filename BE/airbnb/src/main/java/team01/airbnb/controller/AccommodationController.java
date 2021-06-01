package team01.airbnb.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import team01.airbnb.domain.accommodation.Accommodation;
import team01.airbnb.dto.ApiResult;
import team01.airbnb.dto.request.TotalAccommodationSaveRequestDto;
import team01.airbnb.dto.response.AccommodationResponseDto;
import team01.airbnb.dto.response.AccommodationResultListResponseDto;
import team01.airbnb.dto.response.ChargesResponseDto;
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

    @GetMapping
    public ApiResult<AccommodationResultListResponseDto> accommodationsForReservation(
            @RequestParam("city") String city
            , @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam("check_in") LocalDate checkIn
            , @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam("check_out") LocalDate checkOut
            , @RequestParam("min_charge") int minCharge
            , @RequestParam("max_charge") int maxCharge
            , @RequestParam("guests") int guests) {
        return ApiResult.succeed(accommodationService.findAvailableAccommodationsForReservation(
                city, checkIn, checkOut, minCharge, maxCharge, guests));
    }

    @PostMapping("/")
    public ApiResult createAccommodation(TotalAccommodationSaveRequestDto totalAccommodationSaveRequestDto) {
        System.out.println(totalAccommodationSaveRequestDto.toString());
        System.out.println(totalAccommodationSaveRequestDto.getConditionSaveRequestDto().toString());
        accommodationService.save(totalAccommodationSaveRequestDto);
        return ApiResult.ok();
    }

    @GetMapping("/search")
    public ApiResult<AccommodationResultListResponseDto> accommodationsByAddress(@RequestParam String address) {
        return ApiResult.succeed(accommodationService.findAccommodationsByAddress(address));
    }

    @GetMapping("/charges")
    public ApiResult<ChargesResponseDto> accommodationsForReservation(
            @RequestParam String address,
            @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam("check_in") LocalDate checkIn
            , @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam("check_out") LocalDate checkOut) {
        return ApiResult.succeed(accommodationService.findChargesPerNightByAddressAndPeriod(
                address, checkIn, checkOut));
    }
}
