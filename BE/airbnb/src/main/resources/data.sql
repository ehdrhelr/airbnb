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

-- id : 4
INSERT INTO accommodation (host_id, `name`, description, charge_per_night, cleaning_charge, check_in, check_out)
VALUES (2, '숙소4', '숙소4 더미데이터입니다.', 70000, 10000, '16:00:00', '12:00:00');

INSERT INTO accommodation_address (accommodation_id, country_id, city_id, address, latitude, longitude)
    VALUE (4, 1, 1, '강남구', 37.490320, 127.029000);

INSERT INTO accommodation_condition (accommodation_id, guests, bedroom_count, bed_count, bathroom_count)
    VALUE (4, 2, 1, 1, 1);

INSERT INTO accommodation_photo (accommodation_id, `name`) VALUES (4, 'https://codesquad.kr/img/place/img_5225.jpg');

INSERT INTO accommodation_has_amenity (accommodation_id, amenity_id) VALUE (4, 1);
INSERT INTO accommodation_has_amenity (accommodation_id, amenity_id) VALUE (4, 2);
INSERT INTO accommodation_has_amenity (accommodation_id, amenity_id) VALUE (4, 3);

-- id : 5
INSERT INTO accommodation (host_id, `name`, description, charge_per_night, cleaning_charge, check_in, check_out)
VALUES (2, '숙소5', '숙소5 더미데이터입니다.', 60000, 10000, '16:00:00', '12:00:00');

INSERT INTO accommodation_address (accommodation_id, country_id, city_id, address, latitude, longitude)
    VALUE (5, 1, 1, '강남구', 37.485320, 127.028500);

INSERT INTO accommodation_condition (accommodation_id, guests, bedroom_count, bed_count, bathroom_count)
    VALUE (5, 2, 1, 1, 1);

INSERT INTO accommodation_photo (accommodation_id, `name`) VALUES (5, 'https://codesquad.kr/img/place/img_5225.jpg');

INSERT INTO accommodation_has_amenity (accommodation_id, amenity_id) VALUE (5, 1);
INSERT INTO accommodation_has_amenity (accommodation_id, amenity_id) VALUE (5, 2);
INSERT INTO accommodation_has_amenity (accommodation_id, amenity_id) VALUE (5, 3);

-- id : 6
INSERT INTO accommodation (host_id, `name`, description, charge_per_night, cleaning_charge, check_in, check_out)
VALUES (2, '숙소6', '숙소6 더미데이터입니다.', 55000, 10000, '16:00:00', '12:00:00');

INSERT INTO accommodation_address (accommodation_id, country_id, city_id, address, latitude, longitude)
    VALUE (6, 1, 1, '강남구', 37.480320, 127.028000);

INSERT INTO accommodation_condition (accommodation_id, guests, bedroom_count, bed_count, bathroom_count)
    VALUE (6, 2, 1, 1, 1);

INSERT INTO accommodation_photo (accommodation_id, `name`) VALUES (6, 'https://codesquad.kr/img/place/img_5225.jpg');

INSERT INTO accommodation_has_amenity (accommodation_id, amenity_id) VALUE (6, 1);
INSERT INTO accommodation_has_amenity (accommodation_id, amenity_id) VALUE (6, 2);
INSERT INTO accommodation_has_amenity (accommodation_id, amenity_id) VALUE (6, 3);

-- id : 7
INSERT INTO accommodation (host_id, `name`, description, charge_per_night, cleaning_charge, check_in, check_out)
VALUES (2, '숙소7', '숙소7 더미데이터입니다.', 30000, 10000, '16:00:00', '12:00:00');

INSERT INTO accommodation_address (accommodation_id, country_id, city_id, address, latitude, longitude)
    VALUE (7, 1, 1, '강남구', 37.475320, 127.027500);

INSERT INTO accommodation_condition (accommodation_id, guests, bedroom_count, bed_count, bathroom_count)
    VALUE (7, 2, 1, 1, 1);

INSERT INTO accommodation_photo (accommodation_id, `name`) VALUES (7, 'https://codesquad.kr/img/place/img_5225.jpg');

INSERT INTO accommodation_has_amenity (accommodation_id, amenity_id) VALUE (7, 1);
INSERT INTO accommodation_has_amenity (accommodation_id, amenity_id) VALUE (7, 2);
INSERT INTO accommodation_has_amenity (accommodation_id, amenity_id) VALUE (7, 3);

-- id : 8
INSERT INTO accommodation (host_id, `name`, description, charge_per_night, cleaning_charge, check_in, check_out)
VALUES (2, '숙소8', '숙소8 더미데이터입니다.', 130000, 10000, '16:00:00', '12:00:00');

INSERT INTO accommodation_address (accommodation_id, country_id, city_id, address, latitude, longitude)
    VALUE (8, 1, 1, '강남구', 37.470320, 127.027000);

INSERT INTO accommodation_condition (accommodation_id, guests, bedroom_count, bed_count, bathroom_count)
    VALUE (8, 2, 1, 1, 1);

INSERT INTO accommodation_photo (accommodation_id, `name`) VALUES (8, 'https://codesquad.kr/img/place/img_5225.jpg');

INSERT INTO accommodation_has_amenity (accommodation_id, amenity_id) VALUE (8, 1);
INSERT INTO accommodation_has_amenity (accommodation_id, amenity_id) VALUE (8, 2);
INSERT INTO accommodation_has_amenity (accommodation_id, amenity_id) VALUE (8, 3);

-- id : 9
INSERT INTO accommodation (host_id, `name`, description, charge_per_night, cleaning_charge, check_in, check_out)
VALUES (2, '숙소9', '숙소9 더미데이터입니다.', 25000, 10000, '16:00:00', '12:00:00');

INSERT INTO accommodation_address (accommodation_id, country_id, city_id, address, latitude, longitude)
    VALUE (9, 1, 1, '강남구', 37.465000, 127.026500);

INSERT INTO accommodation_condition (accommodation_id, guests, bedroom_count, bed_count, bathroom_count)
    VALUE (9, 2, 1, 1, 1);

INSERT INTO accommodation_photo (accommodation_id, `name`) VALUES (9, 'https://codesquad.kr/img/place/img_5225.jpg');

INSERT INTO accommodation_has_amenity (accommodation_id, amenity_id) VALUE (9, 1);
INSERT INTO accommodation_has_amenity (accommodation_id, amenity_id) VALUE (9, 2);
INSERT INTO accommodation_has_amenity (accommodation_id, amenity_id) VALUE (9, 3);

-- id : 10
INSERT INTO accommodation (host_id, `name`, description, charge_per_night, cleaning_charge, check_in, check_out)
VALUES (2, '숙소10', '숙소10 더미데이터입니다.', 110000, 10000, '16:00:00', '12:00:00');

INSERT INTO accommodation_address (accommodation_id, country_id, city_id, address, latitude, longitude)
    VALUE (10, 1, 1, '강남구', 37.460000, 127.026000);

INSERT INTO accommodation_condition (accommodation_id, guests, bedroom_count, bed_count, bathroom_count)
    VALUE (10, 2, 1, 1, 1);

INSERT INTO accommodation_photo (accommodation_id, `name`) VALUES (10, 'https://codesquad.kr/img/place/img_5225.jpg');

INSERT INTO accommodation_has_amenity (accommodation_id, amenity_id) VALUE (10, 1);
INSERT INTO accommodation_has_amenity (accommodation_id, amenity_id) VALUE (10, 2);
INSERT INTO accommodation_has_amenity (accommodation_id, amenity_id) VALUE (10, 3);

-- id : 11
INSERT INTO accommodation (host_id, `name`, description, charge_per_night, cleaning_charge, check_in, check_out)
VALUES (2, '숙소11', '숙소11 더미데이터입니다.', 100000, 10000, '16:00:00', '12:00:00');

INSERT INTO accommodation_address (accommodation_id, country_id, city_id, address, latitude, longitude)
    VALUE (11, 1, 1, '강남구', 37.480000, 127.026000);

INSERT INTO accommodation_condition (accommodation_id, guests, bedroom_count, bed_count, bathroom_count)
    VALUE (11, 2, 1, 1, 1);

INSERT INTO accommodation_photo (accommodation_id, `name`) VALUES (11, 'https://codesquad.kr/img/place/img_5225.jpg');

INSERT INTO accommodation_has_amenity (accommodation_id, amenity_id) VALUE (11, 1);
INSERT INTO accommodation_has_amenity (accommodation_id, amenity_id) VALUE (11, 2);
INSERT INTO accommodation_has_amenity (accommodation_id, amenity_id) VALUE (11, 3);

-- id : 12
INSERT INTO accommodation (host_id, `name`, description, charge_per_night, cleaning_charge, check_in, check_out)
VALUES (2, '숙소12', '숙소12 더미데이터입니다.', 100000, 10000, '16:00:00', '12:00:00');

INSERT INTO accommodation_address (accommodation_id, country_id, city_id, address, latitude, longitude)
    VALUE (12, 1, 1, '강남구', 37.480000, 127.025000);

INSERT INTO accommodation_condition (accommodation_id, guests, bedroom_count, bed_count, bathroom_count)
    VALUE (12, 2, 1, 1, 1);

INSERT INTO accommodation_photo (accommodation_id, `name`) VALUES (12, 'https://codesquad.kr/img/place/img_5225.jpg');

INSERT INTO accommodation_has_amenity (accommodation_id, amenity_id) VALUE (12, 1);
INSERT INTO accommodation_has_amenity (accommodation_id, amenity_id) VALUE (12, 2);
INSERT INTO accommodation_has_amenity (accommodation_id, amenity_id) VALUE (12, 3);

-- id : 13
INSERT INTO accommodation (host_id, `name`, description, charge_per_night, cleaning_charge, check_in, check_out)
VALUES (2, '숙소13', '숙소13 더미데이터입니다.', 100000, 10000, '16:00:00', '12:00:00');

INSERT INTO accommodation_address (accommodation_id, country_id, city_id, address, latitude, longitude)
    VALUE (13, 1, 1, '강남구', 37.475000, 127.025000);

INSERT INTO accommodation_condition (accommodation_id, guests, bedroom_count, bed_count, bathroom_count)
    VALUE (13, 2, 1, 1, 1);

INSERT INTO accommodation_photo (accommodation_id, `name`) VALUES (13, 'https://codesquad.kr/img/place/img_5225.jpg');

INSERT INTO accommodation_has_amenity (accommodation_id, amenity_id) VALUE (13, 1);
INSERT INTO accommodation_has_amenity (accommodation_id, amenity_id) VALUE (13, 2);
INSERT INTO accommodation_has_amenity (accommodation_id, amenity_id) VALUE (13, 3);

-- id : 14
INSERT INTO accommodation (host_id, `name`, description, charge_per_night, cleaning_charge, check_in, check_out)
VALUES (2, '숙소14', '숙소14 더미데이터입니다.', 150000, 10000, '16:00:00', '12:00:00');

INSERT INTO accommodation_address (accommodation_id, country_id, city_id, address, latitude, longitude)
    VALUE (14, 1, 1, '강남구', 37.470000, 127.025000);

INSERT INTO accommodation_condition (accommodation_id, guests, bedroom_count, bed_count, bathroom_count)
    VALUE (14, 2, 1, 1, 1);

INSERT INTO accommodation_photo (accommodation_id, `name`) VALUES (14, 'https://codesquad.kr/img/place/img_5225.jpg');

INSERT INTO accommodation_has_amenity (accommodation_id, amenity_id) VALUE (14, 1);
INSERT INTO accommodation_has_amenity (accommodation_id, amenity_id) VALUE (14, 2);
INSERT INTO accommodation_has_amenity (accommodation_id, amenity_id) VALUE (14, 3);

-- id : 15
INSERT INTO accommodation (host_id, `name`, description, charge_per_night, cleaning_charge, check_in, check_out)
VALUES (2, '숙소15', '숙소15 더미데이터입니다.', 150000, 10000, '16:00:00', '12:00:00');

INSERT INTO accommodation_address (accommodation_id, country_id, city_id, address, latitude, longitude)
    VALUE (15, 1, 1, '강남구', 37.465000, 127.025000);

INSERT INTO accommodation_condition (accommodation_id, guests, bedroom_count, bed_count, bathroom_count)
    VALUE (15, 2, 1, 1, 1);

INSERT INTO accommodation_photo (accommodation_id, `name`) VALUES (15, 'https://codesquad.kr/img/place/img_5225.jpg');

INSERT INTO accommodation_has_amenity (accommodation_id, amenity_id) VALUE (15, 1);
INSERT INTO accommodation_has_amenity (accommodation_id, amenity_id) VALUE (15, 2);
INSERT INTO accommodation_has_amenity (accommodation_id, amenity_id) VALUE (15, 3);

-- id : 16
INSERT INTO accommodation (host_id, `name`, description, charge_per_night, cleaning_charge, check_in, check_out)
VALUES (2, '숙소16', '숙소16 더미데이터입니다.', 50000, 10000, '16:00:00', '12:00:00');

INSERT INTO accommodation_address (accommodation_id, country_id, city_id, address, latitude, longitude)
    VALUE (16, 1, 1, '강남구', 37.460000, 127.025000);

INSERT INTO accommodation_condition (accommodation_id, guests, bedroom_count, bed_count, bathroom_count)
    VALUE (16, 2, 1, 1, 1);

INSERT INTO accommodation_photo (accommodation_id, `name`) VALUES (16, 'https://codesquad.kr/img/place/img_5225.jpg');

INSERT INTO accommodation_has_amenity (accommodation_id, amenity_id) VALUE (16, 1);
INSERT INTO accommodation_has_amenity (accommodation_id, amenity_id) VALUE (16, 2);
INSERT INTO accommodation_has_amenity (accommodation_id, amenity_id) VALUE (16, 3);

-- id : 17
INSERT INTO accommodation (host_id, `name`, description, charge_per_night, cleaning_charge, check_in, check_out)
VALUES (2, '숙소17', '숙소17 더미데이터입니다.', 300000, 10000, '16:00:00', '12:00:00');

INSERT INTO accommodation_address (accommodation_id, country_id, city_id, address, latitude, longitude)
    VALUE (17, 1, 1, '강남구', 37.455000, 127.025000);

INSERT INTO accommodation_condition (accommodation_id, guests, bedroom_count, bed_count, bathroom_count)
    VALUE (17, 2, 1, 1, 1);

INSERT INTO accommodation_photo (accommodation_id, `name`) VALUES (17, 'https://codesquad.kr/img/place/img_5225.jpg');

INSERT INTO accommodation_has_amenity (accommodation_id, amenity_id) VALUE (17, 1);
INSERT INTO accommodation_has_amenity (accommodation_id, amenity_id) VALUE (17, 2);
INSERT INTO accommodation_has_amenity (accommodation_id, amenity_id) VALUE (17, 3);

-- id : 18
INSERT INTO accommodation (host_id, `name`, description, charge_per_night, cleaning_charge, check_in, check_out)
VALUES (2, '숙소18', '숙소18 더미데이터입니다.', 70000, 10000, '16:00:00', '12:00:00');

INSERT INTO accommodation_address (accommodation_id, country_id, city_id, address, latitude, longitude)
    VALUE (18, 1, 1, '강남구', 37.450000, 127.025000);

INSERT INTO accommodation_condition (accommodation_id, guests, bedroom_count, bed_count, bathroom_count)
    VALUE (18, 2, 1, 1, 1);

INSERT INTO accommodation_photo (accommodation_id, `name`) VALUES (18, 'https://codesquad.kr/img/place/img_5225.jpg');

INSERT INTO accommodation_has_amenity (accommodation_id, amenity_id) VALUE (18, 1);
INSERT INTO accommodation_has_amenity (accommodation_id, amenity_id) VALUE (18, 2);
INSERT INTO accommodation_has_amenity (accommodation_id, amenity_id) VALUE (18, 3);

-- id : 19
INSERT INTO accommodation (host_id, `name`, description, charge_per_night, cleaning_charge, check_in, check_out)
VALUES (2, '숙소19', '숙소19 더미데이터입니다.', 55000, 10000, '16:00:00', '12:00:00');

INSERT INTO accommodation_address (accommodation_id, country_id, city_id, address, latitude, longitude)
    VALUE (19, 1, 1, '강남구', 37.445000, 127.025000);

INSERT INTO accommodation_condition (accommodation_id, guests, bedroom_count, bed_count, bathroom_count)
    VALUE (19, 2, 1, 1, 1);

INSERT INTO accommodation_photo (accommodation_id, `name`) VALUES (19, 'https://codesquad.kr/img/place/img_5225.jpg');

INSERT INTO accommodation_has_amenity (accommodation_id, amenity_id) VALUE (19, 1);
INSERT INTO accommodation_has_amenity (accommodation_id, amenity_id) VALUE (19, 2);
INSERT INTO accommodation_has_amenity (accommodation_id, amenity_id) VALUE (19, 3);

-- id : 20
INSERT INTO accommodation (host_id, `name`, description, charge_per_night, cleaning_charge, check_in, check_out)
VALUES (2, '숙소20', '숙소20 더미데이터입니다.', 100000, 10000, '16:00:00', '12:00:00');

INSERT INTO accommodation_address (accommodation_id, country_id, city_id, address, latitude, longitude)
    VALUE (20, 1, 1, '강남구', 37.440000, 127.025000);

INSERT INTO accommodation_condition (accommodation_id, guests, bedroom_count, bed_count, bathroom_count)
    VALUE (20, 2, 1, 1, 1);

INSERT INTO accommodation_photo (accommodation_id, `name`) VALUES (20, 'https://codesquad.kr/img/place/img_5225.jpg');

INSERT INTO accommodation_has_amenity (accommodation_id, amenity_id) VALUE (20, 1);
INSERT INTO accommodation_has_amenity (accommodation_id, amenity_id) VALUE (20, 2);
INSERT INTO accommodation_has_amenity (accommodation_id, amenity_id) VALUE (20, 3);

-- 예약 등록
INSERT INTO reservation (accommodation_id, user_id, check_in, check_out, guests, charge)
VALUE (1, 4, '2021-05-05', '2021-05-07', 2, 100000);

INSERT INTO reservation (accommodation_id, user_id, check_in, check_out, guests, charge)
    VALUE (2, 5, '2021-05-09', '2021-05-12', 2, 300000);

INSERT INTO reservation (accommodation_id, user_id, check_in, check_out, guests, charge)
    VALUE (3, 6, '2021-05-15', '2021-05-17', 2, 200000);