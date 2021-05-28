package team01.airbnb.dto.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalTime;

@ToString
@Setter
@Getter
public class AccommodationSaveRequestDto {

    private String name;
    private String description;
    private int chargePerNight;
    private int cleaningCharge;
    private LocalTime checkIn;
    private LocalTime checkOut;

    public void setCheckIn(String checkIn) {
        this.checkIn = LocalTime.parse(checkIn);
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = LocalTime.parse(checkOut);
    }
}
