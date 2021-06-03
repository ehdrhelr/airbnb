package team01.airbnb.dto.response;

import lombok.*;
import team01.airbnb.dto.Charge;

@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ReservationViewResponseDto {
    private Charge chargePerNight;
    private Charge chargeForDays;
    private Charge cleaningCharge;
    private Charge serviceCharge;
    private Charge accommodationTax;
    private Charge totalCharge;

    public static ReservationViewResponseDto of(Charge chargePerNight, Charge cleaningCharge, long days) {
        Charge chargeForDays = chargePerNight.times(days);
        Charge serviceCharge = chargeForDays.times(0.1d);
        Charge accommodationTax = serviceCharge.times(0.1d);
        Charge totalCharge = chargeForDays
                .plus(cleaningCharge)
                .plus(serviceCharge)
                .plus(accommodationTax);

        return ReservationViewResponseDto.builder()
                .chargePerNight(chargePerNight)
                .chargeForDays(chargeForDays)
                .cleaningCharge(cleaningCharge)
                .serviceCharge(serviceCharge)
                .accommodationTax(accommodationTax)
                .totalCharge(totalCharge)
                .build();
    }

    public int getChargePerNight() {
        return chargePerNight.getCharge();
    }

    public int getChargeForDays() {
        return chargeForDays.getCharge();
    }

    public int getCleaningCharge() {
        return cleaningCharge.getCharge();
    }

    public int getServiceCharge() {
        return serviceCharge.getCharge();
    }

    public int getAccommodationTax() {
        return accommodationTax.getCharge();
    }

    public int getTotalCharge() {
        return totalCharge.getCharge();
    }
}
