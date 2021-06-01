package team01.airbnb.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team01.airbnb.domain.accommodation.Accommodation;
import team01.airbnb.domain.accommodation.AccommodationAddress;
import team01.airbnb.domain.accommodation.AccommodationCondition;
import team01.airbnb.domain.accommodation.AccommodationPhoto;
import team01.airbnb.dto.Charge;
import team01.airbnb.dto.request.TotalAccommodationSaveRequestDto;
import team01.airbnb.dto.response.AccommodationResultListResponseDto;
import team01.airbnb.dto.response.ChargesResponseDto;
import team01.airbnb.exception.AccommodationNotFoundException;
import team01.airbnb.repository.AccommodationRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class AccommodationService {

    private final AccommodationRepository accommodationRepository;

    public AccommodationService(AccommodationRepository accommodationRepository) {
        this.accommodationRepository = accommodationRepository;
    }

    public AccommodationResultListResponseDto findAvailableAccommodationsForReservation(
            LocalDate checkIn, LocalDate checkOut, int minCharge, int maxCharge, int guests) {
        return accommodationRepository.findAvailableAccommodationsForReservation(
                checkIn, checkOut, minCharge, maxCharge, guests);
    }

    public AccommodationResultListResponseDto findAccommodationsByAddress(String address) {
        return accommodationRepository.findAccommodationsByAddress(address);
    }

    public ChargesResponseDto findChargesPerNightByAddressAndPeriod(
            String address, LocalDate checkIn, LocalDate checkOut) {
        return accommodationRepository.findChargesPerNightByAddressAndPeriod(
                address, checkIn, checkOut);
    }

    public Charge findChargePerNightByAccommodationId(Long accommodationId) {
        return accommodationRepository.findChargePerNightByAccommodationId(accommodationId)
                .orElseThrow(AccommodationNotFoundException::new);
    }

    public Charge findCleaningChargeByAccommodationId(Long accommodationId) {
        return accommodationRepository.findCleaningChargeByAccommodationId(accommodationId)
                .orElseThrow(AccommodationNotFoundException::new);
    }

    @Transactional
    public void save(TotalAccommodationSaveRequestDto totalAccommodationSaveRequestDto) {
        // request dto에서 Accommodation 숙소도메인을 얻고 숙소를 등록한다. 반환된 id값을 request dto에 저장한다.
        Long accommodationId = saveAccommodation(totalAccommodationSaveRequestDto.toAccommodation());
        totalAccommodationSaveRequestDto.setId(accommodationId);
        // 숙소에 대한 부가 정보(숙박정보, 주소, 사진, 어메니티)를 테이블에 등록한다.
        saveAccommodationCondition(totalAccommodationSaveRequestDto.toCondition());
        saveAccoommodationAddress(totalAccommodationSaveRequestDto.toAddress());
        saveAccommodationPhoto(totalAccommodationSaveRequestDto.toPhoto());
        addAmenitiesToAccommodation(totalAccommodationSaveRequestDto.getAmenities(), accommodationId);
    }

    private Long saveAccommodation(Accommodation accommodation) {
        return accommodationRepository.saveAccommodation(accommodation);
    }

    private boolean saveAccommodationCondition(AccommodationCondition condition) {
        return accommodationRepository.saveAccommodationCondition(condition);
    }

    private boolean saveAccoommodationAddress(AccommodationAddress address) {
        return accommodationRepository.saveAccommodationAddress(address);
    }

    private boolean saveAccommodationPhoto(AccommodationPhoto photo) {
        return accommodationRepository.saveAccommodationPhoto(photo);
    }

    private boolean addAmenitiesToAccommodation(List<String> amenities, Long accommodationId) {
        List<Long> amenityIds = accommodationRepository.findAmenityIdsByNames(amenities);
        return accommodationRepository.addAmenitiesToAccommodation(amenityIds, accommodationId);
    }
}
