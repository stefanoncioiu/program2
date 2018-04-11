INSERT INTO USERS (ID, USER_NAME, EMAIL, PASSWORD)
VALUES ((SELECT nextval('USERS_SEQ')), 'admin', 'admin', 'admin');