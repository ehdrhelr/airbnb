package team01.airbnb.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import team01.airbnb.domain.Reservation;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.time.LocalDate;

@Repository
public class ReservationRepository {

    private final JdbcTemplate jdbcTemplate;

    public ReservationRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean save(Reservation reservation) {
        String query = "INSERT INTO reservation (accommodation_id, user_id, check_in, check_out, guests, charge) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        int result = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setLong(1, reservation.getAccommodationId());
            ps.setLong(2, reservation.getUserId());
            ps.setDate(3, Date.valueOf(reservation.getCheckIn()));
            ps.setDate(4, Date.valueOf(reservation.getCheckOut()));
            ps.setInt(5, reservation.getGuests());
            ps.setInt(6, reservation.getCharge());
            return ps;
        });
        return result == 1;
    }
}
