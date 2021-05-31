INSERT INTO `user` (`username`, `email`, `role`) VALUES ('김시온', 'test@test.com', 'ADMIN');
INSERT INTO `user` (`username`, `email`, `role`) VALUES ('Jong', 'godrm77@gmail.com', 'USER');
INSERT INTO `user` (`username`, `email`, `role`) VALUES ('바이든', 'buydone@gmail.com', 'USER');
INSERT INTO `user` (`username`, `email`, `role`) VALUES ('시민1', 'citizen1@gmail.com', 'USER');
INSERT INTO `user` (`username`, `email`, `role`) VALUES ('시민2', 'citizen2@gmail.com', 'USER');
INSERT INTO `user` (`username`, `email`, `role`) VALUES ('시민3', 'citizen3@gmail.com', 'USER');

-- amenity 등록
INSERT INTO amenity (`name`) VALUES ('주방');
INSERT INTO amenity (`name`) VALUES ('무선 인터넷');
INSERT INTO amenity (`name`) VALUES ('에어컨');
INSERT INTO amenity (`name`) VALUES ('헤어드라이기');

-- 국가 등록
INSERT INTO countries (`name`, code) VALUES ('한국', 'KR');

-- 도시 등록
INSERT INTO cities (country_id, `name`) VALUE (1, '서울');

-- 숙소 등록
-- id : 1
INSERT INTO accommodation (host_id, `name`, description, charge_per_night, cleaning_charge, check_in, check_out)
VALUES (2, 'Spacious and Comfortable cozy house #4', '강남역 5번 출구에서 도보로 이동 가능합니다.', 50000, 5000, '16:00:00', '12:00:00');

INSERT INTO accommodation_address (accommodation_id, country_id, city_id, address, latitude, longitude)
VALUE (1, 1, 1, '서초구', 37.496697, 127.027723);

INSERT INTO accommodation_condition (accommodation_id, guests, bedroom_count, bed_count, bathroom_count)
VALUE (1, 3, 1, 1, 1);

INSERT INTO accommodation_photo (accommodation_id, `name`) VALUES (1, 'https://codesquad.kr/img/place/img_5225.jpg');

INSERT INTO accommodation_has_amenity (accommodation_id, amenity_id) VALUE (1, 1);
INSERT INTO accommodation_has_amenity (accommodation_id, amenity_id) VALUE (1, 2);
INSERT INTO accommodation_has_amenity (accommodation_id, amenity_id) VALUE (1, 3);
INSERT INTO accommodation_has_amenity (accommodation_id, amenity_id) VALUE (1, 4);

-- id : 2
INSERT INTO accommodation (host_id, `name`, description, charge_per_night, cleaning_charge, check_in, check_out)
VALUES (3, '백악관', '새하얀 페인트가 수놓인 공간', 100000, 10000, '16:00:00', '12:00:00');

INSERT INTO accommodation_address (accommodation_id, country_id, city_id, address, latitude, longitude)
    VALUE (2, 1, 1, '강남구', 37.496181, 127.030825);

INSERT INTO accommodation_condition (accommodation_id, guests, bedroom_count, bed_count, bathroom_count)
    VALUE (2, 4, 2, 2, 2);

INSERT INTO accommodation_photo (accommodation_id, `name`) VALUES (2, 'https://codesquad.kr/img/place/img_5225.jpg');

INSERT INTO accommodation_has_amenity (accommodation_id, amenity_id) VALUE (2, 1);
INSERT INTO accommodation_has_amenity (accommodation_id, amenity_id) VALUE (2, 2);
INSERT INTO accommodation_has_amenity (accommodation_id, amenity_id) VALUE (2, 3);
INSERT INTO accommodation_has_amenity (accommodation_id, amenity_id) VALUE (2, 4);

-- id : 3
INSERT INTO accommodation (host_id, `name`, description, charge_per_night, cleaning_charge, check_in, check_out)
VALUES (2, '경복궁', '조선 왕실에서의 하루', 150000, 15000, '16:00:00', '12:00:00');

INSERT INTO accommodation_address (accommodation_id, country_id, city_id, address, latitude, longitude)
    VALUE (3, 1, 1, '중구', 37.495320, 127.029590);

INSERT INTO accommodation_condition (accommodation_id, guests, bedroom_count, bed_count, bathroom_count)
    VALUE (3, 2, 3, 3, 3);

INSERT INTO accommodation_photo (accommodation_id, `name`) VALUES (3, 'https://codesquad.kr/img/place/img_5225.jpg');

INSERT INTO accommodation_has_amenity (accommodation_id, amenity_id) VALUE (3, 1);
INSERT INTO accommodation_has_amenity (accommodation_id, amenity_id) VALUE (3, 2);
INSERT INTO accommodation_has_amenity (accommodation_id, amenity_id) VALUE (3, 3);
INSERT INTO accommodation_has_amenity (accommodation_id, amenity_id) VALUE (3, 4);

-- 예약 등록
INSERT INTO reservation (accommodation_id, user_id, check_in, check_out, guests, charge)
VALUE (1, 4, '2021-05-05', '2021-05-07', 2, 100000);

INSERT INTO reservation (accommodation_id, user_id, check_in, check_out, guests, charge)
    VALUE (2, 5, '2021-05-09', '2021-05-12', 2, 300000);

INSERT INTO reservation (accommodation_id, user_id, check_in, check_out, guests, charge)
    VALUE (3, 6, '2021-05-15', '2021-05-17', 2, 200000);