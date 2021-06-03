package team01.airbnb.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import team01.airbnb.dto.Charge;

import java.util.List;
import java.util.stream.Collectors;

@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ChargesResponseDto {
    private List<Charge> charges;

    public static ChargesResponseDto from(List<Integer> charges) {
        return ChargesResponseDto.builder()
                .charges(
                        charges.stream()
                        .map(charge -> Charge.wons(charge))
                        .collect(Collectors.toUnmodifiableList()))
                .build();
    }

    public int[] getCharges() {
        return this.charges.stream()
                .mapToInt(Charge::getCharge).toArray();
    }
}
