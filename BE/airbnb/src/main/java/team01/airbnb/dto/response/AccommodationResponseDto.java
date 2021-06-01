package team01.airbnb.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import team01.airbnb.domain.accommodation.AccommodationCondition;
import team01.airbnb.dto.Charge;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class AccommodationResponseDto {

    private Long id;
    private String name;
    private String photo;
    private AccommodationAddressResponseDto address;
    private AccommodationCondition condition;
    private String amenities;
    private Charge chargePerNight;
    private Charge totalCharge;

    public int getChargePerNight() {
        return chargePerNight.getCharge();
    }

    public int getTotalCharge() {
        return 0;
    }

}
