package team01.airbnb.repository;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import team01.airbnb.domain.Amenity;
import team01.airbnb.domain.Reservation;
import team01.airbnb.domain.accommodation.Accommodation;
import team01.airbnb.domain.accommodation.AccommodationAddress;
import team01.airbnb.domain.accommodation.AccommodationCondition;
import team01.airbnb.domain.accommodation.AccommodationPhoto;
import team01.airbnb.dto.Charge;
import team01.airbnb.dto.response.AccommodationAddressResponseDto;
import team01.airbnb.dto.response.AccommodationResponseDto;
import team01.airbnb.dto.response.AccommodationResultListResponseDto;
import team01.airbnb.dto.response.ChargesResponseDto;

import java.sql.*;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class AccommodationRepository {

    private static final RowMapper<AccommodationResponseDto> ACCOMMODATION_RESPONSE_DTO_ROW_MAPPER =
            (rs, rowNum) ->
                    AccommodationResponseDto.builder()
                            .id(rs.getLong("id"))
                            .name(rs.getString("name"))
                            .chargePerNight(Charge.wons(rs.getInt("charge_per_night")))
                            .photo(rs.getString("photo"))
                            .address(AccommodationAddressResponseDto.builder()
                                    .city(rs.getString("city"))
                                    .address(rs.getString("address"))
                                    .latitude(rs.getDouble("latitude"))
                                    .longitude(rs.getDouble("longitude"))
                                    .build())
                            .condition(AccommodationCondition.builder()
                                    .guests(rs.getInt("guests"))
                                    .bedroomCount(rs.getInt("bedroom_count"))
                                    .bedCount(rs.getInt("bed_count"))
                                    .bathroomCount(rs.getInt("bathroom_count"))
                                    .build())
                            .amenities(rs.getString("amenities"))
                            .build();

    private static final RowMapper<Accommodation> ACCOMMODATION_ROW_MAPPER =
            (rs, rowNum) -> Accommodation.builder()
                    .id(rs.getLong("id"))
                    .hostId(rs.getLong("host_id"))
                    .name(rs.getString("name"))
                    .description(rs.getString("description"))
                    .chargePerNight(Charge.wons(rs.getInt("charge_per_night")))
                    .cleaningCharge(Charge.wons(rs.getInt("cleaning_charge")))
                    .checkIn(rs.getTime("check_in").toLocalTime())
                    .checkOut(rs.getTime("check_out").toLocalTime())
                    .build();

    private static final RowMapper<AccommodationAddress> ACCOMMODATION_ADDRESS_ROW_MAPPER =
            (rs, rowNum) -> AccommodationAddress.builder()
                    .accommodationId(rs.getLong("accommodation_id"))
                    .countryId(rs.getLong("country_id"))
                    .cityId(rs.getLong("city_id"))
                    .address(rs.getString("address"))
                    .latitude(rs.getDouble("latitude"))
                    .longitude(rs.getDouble("longitude"))
                    .build();

    private static final RowMapper<AccommodationCondition> ACCOMMODATION_CONDITION_ROW_MAPPER =
            (rs, rowNum) -> AccommodationCondition.builder()
                    .accommodationId(rs.getLong("accommodation_id"))
                    .guests(rs.getInt("guests"))
                    .bedroomCount(rs.getInt("bedroom_count"))
                    .bedCount(rs.getInt("bed_count"))
                    .bathroomCount(rs.getInt("bathroom_count"))
                    .build();

    private static final RowMapper<Amenity> AMENITY_ROW_MAPPER =
            (rs, rowNum) -> Amenity.builder()
                    .id(rs.getLong("id"))
                    .name(rs.getString("name"))
                    .build();

    private static final RowMapper<AccommodationPhoto> ACCOMMODATION_PHOTO_ROW_MAPPER =
            (rs, rowNum) -> AccommodationPhoto.builder()
                    .id(rs.getLong("id"))
                    .accommodationId(rs.getLong("accommodation_id"))
                    .name(rs.getString("name"))
                    .build();

    private static final RowMapper<Reservation> RESERVATION_ROW_MAPPER =
            (rs, rowNum) -> Reservation.builder()
                    .id(rs.getLong("id"))
                    .accommodationId(rs.getLong("accommodation_id"))
                    .userId(rs.getLong("user_id"))
                    .checkIn(rs.getDate("check_in").toLocalDate())
                    .checkOut(rs.getDate("check_out").toLocalDate())
                    .guests(rs.getInt("guests"))
                    .charge(rs.getInt("charge"))
                    .createdTime(
                            new Timestamp(rs.getDate("created_time").getTime()).toLocalDateTime())
                    .build();

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final JdbcTemplate jdbcTemplate;

    public AccommodationRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate
            , JdbcTemplate jdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.jdbcTemplate = jdbcTemplate;
    }

    public Long saveAccommodation(Accommodation accommodation) {
        String query = "INSERT INTO accommodation " +
                "(host_id, `name`, description, charge_per_night, cleaning_charge, check_in, check_out) " +
                "VALUE (?, ?, ?, ?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1, accommodation.getHostId());
            ps.setString(2, accommodation.getName());
            ps.setString(3, accommodation.getDescription());
            ps.setInt(4, accommodation.getChargePerNight().getCharge());
            ps.setInt(5, accommodation.getCleaningCharge().getCharge());
            ps.setTime(6, Time.valueOf(accommodation.getCheckIn()));
            ps.setTime(7, Time.valueOf(accommodation.getCheckOut()));
            return ps;
        }, keyHolder);
        return keyHolder.getKey().longValue();
    }

    public boolean saveAccommodationAddress(AccommodationAddress address) {
        String query = "INSERT INTO accommodation_address (accommodation_id, country_id, city_id, address) " +
                "VALUE (?, ?, ?, ?)";
        int result = jdbcTemplate.update(
                query
                , address.getAccommodationId()
                , address.getCountryId()
                , address.getCityId()
                , address.getAddress()
        );
        return result == 1;
    }

    public boolean saveAccommodationCondition(AccommodationCondition condition) {
        String query = "INSERT INTO accommodation_condition (accommodation_id, guests, bedroom_count, bed_count, bathroom_count) " +
                "VALUE (?, ? ,? ,? ,?)";
        int result = jdbcTemplate.update(
                query
                , condition.getAccommodationId()
                , condition.getGuests()
                , condition.getBedroomCount()
                , condition.getBedCount()
                , condition.getBathroomCount()
        );
        return result == 1;
    }

    public boolean saveAccommodationPhoto(AccommodationPhoto photo) {
        String query = "INSERT INTO accommodation_photo (accommodation_id, `name`) VALUE (?, ?)";
        int result = jdbcTemplate.update(
                query
                , photo.getAccommodationId()
                , photo.getName()
        );
        return result == 1;
    }

    public List<Long> findAmenityIdsByNames(List<String> amenityNames) {
        String query = "SELECT id FROM amenity WHERE `name` IN (:names)";
        SqlParameterSource namedParameters = new MapSqlParameterSource("names", amenityNames);
        List<Long> ids = namedParameterJdbcTemplate.query(
                query
                , namedParameters
                , (rs, rowNum) -> rs.getLong("id")
        );
        return ids;
    }

    public boolean addAmenitiesToAccommodation(List<Long> amenityIds, Long accommodationId) {
        String query = "INSERT INTO accommodation_has_amenity (accommodation_id, amenity_id) VALUE (?, ?)";
        int[] result = jdbcTemplate.batchUpdate(query
                , new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        if (i >= amenityIds.size()) return;
                        ps.setLong(1, accommodationId);
                        ps.setLong(2, amenityIds.get(i));
                    }

                    @Override
                    public int getBatchSize() {
                        return amenityIds.size();
                    }
                });
        return result.length == amenityIds.size();
    }

    public AccommodationResultListResponseDto findAvailableAccommodationsForReservation(
            String city, LocalDate checkIn, LocalDate checkOut, int minCharge, int maxCharge, int guests) {
        String query = "SELECT DISTINCT a.id, a.`name`, a.charge_per_night, p.`name` photo, " +
                "(SELECT `name` FROM cities WHERE id = ad.city_id) city , ad.address, ad.latitude, ad.longitude, " +
                "c.guests, c.bedroom_count, c.bed_count, c.bathroom_count, " +
                "(" +
                "   SELECT GROUP_CONCAT(m.`name`) " +
                "   FROM amenity m " +
                "   WHERE m.id IN (" +
                "       SELECT h.amenity_id " +
                "       FROM accommodation_has_amenity h " +
                "       WHERE h.accommodation_id = a.id " +
                "   )" +
                ") amenities " +
                "FROM accommodation a " +
                "JOIN accommodation_photo p " +
                "JOIN accommodation_condition c " +
                "JOIN accommodation_address ad " +
                "JOIN cities ci " +
                "on (a.id = p.accommodation_id) AND (a.id = c.accommodation_id) AND (a.id = ad.accommodation_id) " +
                "WHERE a.id NOT IN (" +
                "   SELECT r.accommodation_id " +
                "   FROM reservation r" +
                "   WHERE (r.check_in <= :check_in AND r.check_out > :check_in) " +
                "       OR (r.check_in < :check_out AND r.check_out >= :check_out) " +
                "       OR (:check_in <= r.check_in AND :check_out > r.check_in) " +
                "   ) AND (:min_charge <= a.charge_per_night AND a.charge_per_night <= :max_charge) " +
                "   AND a.id IN (SELECT c.accommodation_id FROM accommodation_condition c WHERE c.guests >= :guests) " +
                "AND ci.`name` = :city";
        SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("check_in", checkIn)
                .addValue("check_out", checkOut)
                .addValue("min_charge", minCharge)
                .addValue("max_charge", maxCharge)
                .addValue("guests", guests)
                .addValue("city", city);
        List<AccommodationResponseDto> accommodations = namedParameterJdbcTemplate.query(
                query,
                namedParameters,
                ACCOMMODATION_RESPONSE_DTO_ROW_MAPPER);
        return AccommodationResultListResponseDto.of(accommodations);
    }

    public AccommodationResultListResponseDto findAccommodationsByAddress(String address) {
        String query = "SELECT DISTINCT a.id, a.`name`, a.charge_per_night, p.`name` photo, c.guests" +
                ", c.bedroom_count, c.bed_count, c.bathroom_count, " +
                "(SELECT `name` FROM cities WHERE id = ad.city_id) city , ad.address, ad.latitude, ad.longitude, " +
                "(" +
                "   SELECT GROUP_CONCAT(m.`name`) " +
                "   FROM amenity m " +
                "   WHERE m.id IN (" +
                "       SELECT h.amenity_id " +
                "       FROM accommodation_has_amenity h " +
                "       WHERE h.accommodation_id = a.id " +
                "   )" +
                ") amenities " +
                "FROM accommodation a " +
                "JOIN accommodation_photo p " +
                "JOIN accommodation_condition c " +
                "JOIN accommodation_address ad " +
                "on (a.id = p.accommodation_id) AND (a.id = c.accommodation_id) AND (a.id = ad.accommodation_id) " +
                "WHERE ad.address LIKE :address";
        SqlParameterSource namedParameters = new MapSqlParameterSource("address", "%" + address + "%");
        List<AccommodationResponseDto> accommodations = namedParameterJdbcTemplate.query(query
                , namedParameters
                , ACCOMMODATION_RESPONSE_DTO_ROW_MAPPER);
        return AccommodationResultListResponseDto.of(accommodations);
    }

    public ChargesResponseDto findChargesPerNightByAddressAndPeriod(
            String city, LocalDate checkIn, LocalDate checkOut) {
        String query = "SELECT a.charge_per_night " +
                "FROM accommodation a " +
                "JOIN accommodation_address ad " +
                "on (a.id = ad.accommodation_id) " +
                "WHERE a.id NOT IN (" +
                "   SELECT r.accommodation_id " +
                "   FROM reservation r " +
                "   WHERE (r.check_in <= :check_in AND r.check_out > :check_in) " +
                "       OR (r.check_in < :check_out AND r.check_out >= :check_out) " +
                "       OR (:check_in <= r.check_in AND :check_out > r.check_in) " +
                ") AND (SELECT `name` FROM cities WHERE id = ad.city_id) = :city";
        SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("city", city)
                .addValue("check_in", checkIn)
                .addValue("check_out", checkOut);
        List<Integer> charges = namedParameterJdbcTemplate.query(
                query
                , namedParameters
                , (rs, rowNum) -> rs.getInt("charge_per_night")
        );
        return ChargesResponseDto.from(charges);
    }

    public List<Accommodation> findAllAccommodations() {
        String query = "SELECT id, host_id, `name`, description, charge_per_night" +
                ", cleaning_charge, check_in, check_out FROM accommodation";
        List<Accommodation> accommodations = namedParameterJdbcTemplate.query(
                query,
                ACCOMMODATION_ROW_MAPPER);
        return accommodations;
    }

    public Optional<AccommodationAddress> findAddressByAccommodationId(Long accommodationId) {
        String query = "SELECT accommodation_id, country_id, city_id, address, latitude, longitude " +
                "FROM accommodation_address " +
                "WHERE accommodation_id = :accommodation_id";
        SqlParameterSource namedParameters = new MapSqlParameterSource("accommodation_id", accommodationId);
        List<AccommodationAddress> accommodationAddresses = namedParameterJdbcTemplate.query(
                query
                , namedParameters
                , ACCOMMODATION_ADDRESS_ROW_MAPPER);
        return accommodationAddresses.stream().findFirst();
    }

    public Optional<AccommodationCondition> findConditionByAccommodationId(Long accommodationId) {
        String query = "SELECT accommodation_id, guests, bedroom_count, bed_count, bathroom_count " +
                "FROM accommodation_condition " +
                "WHERE accommodation_id = :accommodation_id";
        SqlParameterSource namedParameters = new MapSqlParameterSource("accommodation_id", accommodationId);
        List<AccommodationCondition> accommodationConditions = namedParameterJdbcTemplate.query(
                query
                , namedParameters
                , ACCOMMODATION_CONDITION_ROW_MAPPER);
        return accommodationConditions.stream().findFirst();
    }

    public List<String> findAmenitiesByAccommodationId(Long accommodationId) {
        String query = "SELECT id, `name` FROM amenity " +
                "WHERE id in(" +
                "   SELECT amenity_id FROM airbnb.accommodation_has_amenity " +
                "   WHERE accommodation_id = :accommodation_id" +
                ")";
        SqlParameterSource namedParameters = new MapSqlParameterSource("accommodation_id", accommodationId);
        List<Amenity> amenities = namedParameterJdbcTemplate.query(
                query
                , namedParameters
                , AMENITY_ROW_MAPPER);
        return amenities.stream()
                .map(amenity -> amenity.getName())
                .collect(Collectors.toUnmodifiableList());
    }

    public List<String> findPhotosByAccommodationId(Long accommodationId) {
        String query = "SELECT id, accommodation_id, `name` FROM accommodation_photo " +
                "WHERE accommodation_id = :accommodation_id";
        SqlParameterSource namedParameters = new MapSqlParameterSource("accommodation_id", accommodationId);
        List<AccommodationPhoto> photos = namedParameterJdbcTemplate.query(
                query
                , namedParameters
                , ACCOMMODATION_PHOTO_ROW_MAPPER);
        return photos.stream()
                .map(photo -> photo.getName())
                .collect(Collectors.toUnmodifiableList());
    }

    public Optional<Reservation> findReservationByAccommodationId(Long accommodationId) {
        String query = "SELECT id, accmmodation_id, user_id, check_in, check_out, guests, charge " +
                "FROM reservation WHERE accommodation_id = :accommodation_id";
        SqlParameterSource namedParameters = new MapSqlParameterSource("accommodation_id", accommodationId);
        List<Reservation> reservations = namedParameterJdbcTemplate.query(
                query
                , namedParameters
                , RESERVATION_ROW_MAPPER);
        return reservations.stream().findFirst();
    }

    public Optional<Charge> findChargePerNightByAccommodationId(Long accommodationId) {
        String query = "SELECT charge_per_night FROM accommodation WHERE id = :accommodation_id";
        SqlParameterSource namedParameters = new MapSqlParameterSource("accommodation_id", accommodationId);
        List<Charge> charges = namedParameterJdbcTemplate.query(
                query
                , namedParameters
                , (rs, rowNum) -> Charge.wons(rs.getInt("charge_per_night")));
        return charges.stream().findFirst();
    }

    public Optional<Charge> findCleaningChargeByAccommodationId(Long accommodationId) {
        String query = "SELECT cleaning_charge FROM accommodation WHERE id = :accommodation_id";
        SqlParameterSource namedParameters = new MapSqlParameterSource("accommodation_id", accommodationId);
        List<Charge> charges = namedParameterJdbcTemplate.query(
                query
                , namedParameters
                , (rs, rowNum) -> Charge.wons(rs.getInt("cleaning_charge")));
        return charges.stream().findFirst();
    }
}
