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

    @GetMapping
    public ApiResult<List<Accommodation>> accommodations() {
        return ApiResult.succeed(accommodationService.accommodations());
    }

    @GetMapping("/search")
    public ApiResult<List<AccommodationResponseDto>> accommodationsBySearch(
            @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam LocalDate checkIn
            , @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam LocalDate checkOut
            , @RequestParam int minCharge
            , @RequestParam int maxCharge
            , @RequestParam int guests) {
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
}
