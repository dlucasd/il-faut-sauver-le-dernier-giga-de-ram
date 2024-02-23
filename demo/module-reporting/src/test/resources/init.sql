CREATE TABLE courrier
(
    id           SERIAL PRIMARY KEY,
    code_postal  VARCHAR(100),
    ville        VARCHAR(100),
    pays         VARCHAR(100),
    destinataire VARCHAR(100),
    expediteur   VARCHAR(100),
    contenu      TEXT
);