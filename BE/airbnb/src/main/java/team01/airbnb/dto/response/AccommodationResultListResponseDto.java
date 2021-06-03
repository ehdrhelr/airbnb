package team01.airbnb.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class AccommodationResultListResponseDto {
    private List<AccommodationResponseDto> accommodations;

    public static AccommodationResultListResponseDto of(
            List<AccommodationResponseDto> accommodationResultList) {
        return AccommodationResultListResponseDto.builder()
                .accommodations(accommodationResultList)
                .build();
    }
}
