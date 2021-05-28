package team01.airbnb.dto.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import team01.airbnb.domain.accommodation.Accommodation;
import team01.airbnb.domain.accommodation.AccommodationAddress;
import team01.airbnb.domain.accommodation.AccommodationCondition;
import team01.airbnb.domain.accommodation.AccommodationPhoto;
import team01.airbnb.dto.Charge;

import java.time.LocalTime;
import java.util.List;

@ToString
@Setter
@Getter
public class TotalAccommodationSaveRequestDto {

    private Long id;
    private AccommodationSaveRequestDto accommodationSaveRequestDto;
    private String address;
    private ConditionSaveRequestDto conditionSaveRequestDto;
    private List<String> amenities;
    private String photo;

    public Accommodation toAccommodation() {
        return Accommodation.builder()
                .hostId(2L) // 임시로 2 고정
                .name(getName())
                .description(getDescription())
                .chargePerNight(getChargePerNight())
                .cleaningCharge(getCleaningCharge())
                .checkIn(getCheckIn())
                .checkOut(getCheckOut())
                .build();
    }

    public AccommodationAddress toAddress() {
        return AccommodationAddress.builder()
                .accommodationId(getId())
                .countryId(1L) // 임시로 1 고정 (한국)
                .cityId(1L) // 임시로 1 고정 (서울)
                .address(getAddress())
                .latitude(0.0d) // 임시
                .longitude(0.0d) // 임시
                .build();
    }

    public AccommodationCondition toCondition() {
        return AccommodationCondition.builder()
                .accommodationId(getId())
                .guests(getGuests())
                .bedroomCount(getBedroomCount())
                .bedCount(getBedCount())
                .bathroomCount(getBathroomCount())
                .build();
    }

    public AccommodationPhoto toPhoto() {
        return AccommodationPhoto.builder()
                .accommodationId(getId())
                .name(getPhoto())
                .build();
    }

    public String getName() {
        return accommodationSaveRequestDto.getName();
    }

    public String getDescription() {
        return accommodationSaveRequestDto.getDescription();
    }

    public Charge getChargePerNight() {
        return Charge.wons(accommodationSaveRequestDto.getChargePerNight());
    }

    public Charge getCleaningCharge() {
        return Charge.wons(accommodationSaveRequestDto.getCleaningCharge());
    }

    public LocalTime getCheckIn() {
        return accommodationSaveRequestDto.getCheckIn();
    }

    public LocalTime getCheckOut() {
        return accommodationSaveRequestDto.getCheckOut();
    }

    public int getGuests() {
        return conditionSaveRequestDto.getGuests();
    }

    public int getBedroomCount() {
        return conditionSaveRequestDto.getBedroomCount();
    }

    public int getBedCount() {
        return conditionSaveRequestDto.getBedCount();
    }

    public int getBathroomCount() {
        return conditionSaveRequestDto.getBathroomCount();
    }
}
