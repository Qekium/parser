CREATE TABLE users (
    username VARCHAR,
    url      VARCHAR
);
INSERT INTO users (username) VALUES ('qekium'),
                                      ('kirby'),
                                      ('link'),
                                      ('sans');
SELECT username FROM users ORDER BY username DESC LIMIT 3;
SELECT * FROM users WHERE username = 'kirby';
SELECT count(*) FROM users;

UPDATE users SET url = 'vk.com/nodifferent', username = '';
UPDATE users SET url = 'vk.com/nodifferent' WHERE username = 'qekium';

DELETE FROM users WHERE url is null;
