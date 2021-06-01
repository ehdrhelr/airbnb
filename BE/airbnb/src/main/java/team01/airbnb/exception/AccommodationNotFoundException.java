package team01.airbnb.exception;

public class AccommodationNotFoundException extends RuntimeException {

    public AccommodationNotFoundException() {
        super("숙소를 찾을 수 없습니다.");
    }

    public AccommodationNotFoundException(String message) {
        super(message);
    }

    public AccommodationNotFoundException(Throwable cause) {
        super(cause);
    }
}
