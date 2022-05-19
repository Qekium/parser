CREATE TABLE users
(
    id       BIGSERIAL PRIMARY KEY,
    username VARCHAR NOT NULL,
    url      VARCHAR NOT NULL
);
CREATE TABLE articles
(
    id           BIGSERIAL PRIMARY KEY,
    user_id      BIGINT    NOT NULL REFERENCES users (id),
    statistic_id BIGINT    NOT NULL, -- REFERENCES statistics (id), which has to be created as well
    publish_date TIMESTAMP NOT NULL,
    title        VARCHAR   NOT NULL,
    description  VARCHAR   NOT NULL,
    url          VARCHAR   NOT NULL
);
CREATE TABLE articles_categories
(
    article_id    BIGINT NOT NULL REFERENCES articles (id),
    categories_id BIGINT NOT NULL REFERENCES categories (id) --keep in mind: create categories
)
