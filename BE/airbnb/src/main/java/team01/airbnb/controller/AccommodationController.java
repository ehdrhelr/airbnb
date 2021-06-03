package team01.airbnb.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import team01.airbnb.dto.ApiResult;
import team01.airbnb.dto.request.TotalAccommodationSaveRequestDto;
import team01.airbnb.dto.response.AccommodationResultListResponseDto;
import team01.airbnb.dto.response.ChargesResponseDto;
import team01.airbnb.service.AccommodationService;

import java.time.LocalDate;

@Api(tags = {"숙소관련 API"}, description = "조건에 따라 예약 가능한 숙소 검색, 숙소 등록, 가격대 검색이 가능합니다.")
@Slf4j
@RequestMapping("/accommodations")
@RestController
public class AccommodationController {

    private final AccommodationService accommodationService;

    public AccommodationController(AccommodationService accommodationService) {
        this.accommodationService = accommodationService;
    }

    @ApiOperation(value = "조건에 따라 예약 가능한 숙소 검색", notes = "도시명, 체크인과 체크아웃, 최저금액과 최대금액, 인원수를 queryString으로 보내주세요.")
    @GetMapping
    public ApiResult<AccommodationResultListResponseDto> availableAccommodationForReservation(
            @RequestParam("city") String city
            , @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam("check_in") LocalDate checkIn
            , @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam("check_out") LocalDate checkOut
            , @RequestParam("min_charge") int minCharge
            , @RequestParam("max_charge") int maxCharge
            , @RequestParam("guests") int guests) {
        return ApiResult.succeed(accommodationService.findAvailableAccommodationsForReservation(
                city, checkIn, checkOut, minCharge, maxCharge, guests));
    }

    @ApiOperation(value = "숙소 등록", notes = "이건 숙소 등록페이지를 이용해주세요. /accommodations/form")
    @PostMapping("/")
    public ApiResult createAccommodation(TotalAccommodationSaveRequestDto totalAccommodationSaveRequestDto) {
        System.out.println(totalAccommodationSaveRequestDto.toString());
        System.out.println(totalAccommodationSaveRequestDto.getConditionSaveRequestDto().toString());
        accommodationService.save(totalAccommodationSaveRequestDto);
        return ApiResult.ok();
    }

    @ApiOperation(value = "주소로 숙소 검색", notes = "queryString으로 보낸 글자가 포함된 주소를 가진 숙소를 반환합니다.")
    @GetMapping("/search")
    public ApiResult<AccommodationResultListResponseDto> accommodationsByAddress(@RequestParam String address) {
        return ApiResult.succeed(accommodationService.findAccommodationsByAddress(address));
    }

    @ApiOperation(value = "일박 가격 검색", notes = "도시와 체크인, 체크아웃 날짜를 알려주시면 예약 가능한 숙소의 가격대를 보내드립니다.")
    @GetMapping("/charges")
    public ApiResult<ChargesResponseDto> charges(
            @RequestParam String city,
            @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam("check_in") LocalDate checkIn
            , @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam("check_out") LocalDate checkOut) {
        return ApiResult.succeed(accommodationService.findChargesPerNightByAddressAndPeriod(
                city, checkIn, checkOut));
    }
}
