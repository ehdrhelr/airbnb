package team01.airbnb.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class AccommodationAddressResponseDto {
    private String city;
    private String address;
    private double latitude;
    private double longitude;
}
