package team01.airbnb.service;

import org.springframework.stereotype.Service;
import team01.airbnb.domain.Reservation;
import team01.airbnb.dto.Charge;
import team01.airbnb.dto.response.ReservationViewResponseDto;
import team01.airbnb.repository.ReservationRepository;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final AccommodationService accommodationService;

    public ReservationService(ReservationRepository reservationRepository
            , AccommodationService accommodationService) {
        this.reservationRepository = reservationRepository;
        this.accommodationService = accommodationService;
    }

    public ReservationViewResponseDto getReservationView(
            Long accommodationId, LocalDate checkIn, LocalDate checkOut, int guests) {
        Charge chargePerNight = accommodationService.findChargePerNightByAccommodationId(accommodationId);
        Charge cleaningCharge = accommodationService.findCleaningChargeByAccommodationId(accommodationId);
        long days = ChronoUnit.DAYS.between(checkIn, checkOut);
        return ReservationViewResponseDto.of(chargePerNight, cleaningCharge, days);
    }

    public boolean reserve(Long accommodationId, Long userId, LocalDate checkIn, LocalDate checkOut, int guests, int charge) {
        Reservation reservation = Reservation.builder()
                .accommodationId(accommodationId)
                .userId(userId)
                .checkIn(checkIn)
                .checkOut(checkOut)
                .guests(guests)
                .charge(charge)
                .build();
        return reservationRepository.save(reservation);
    }
}
