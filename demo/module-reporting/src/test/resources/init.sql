CREATE TABLE adresse
(
    id          SERIAL PRIMARY KEY,
    code_postal INTEGER,
    ville       VARCHAR(255),
    pays        VARCHAR(255),
    ligne1      VARCHAR(255),
    ligne2      VARCHAR(255),
    ligne3      VARCHAR(255),
    ligne4      VARCHAR(255),
    ligne5      VARCHAR(255),
    ligne6      VARCHAR(255)
);
CREATE TABLE personne
(
    id     SERIAL PRIMARY KEY,
    nom    VARCHAR(255),
    prenom VARCHAR(255)
);
CREATE TABLE courrier
(
    id           SERIAL PRIMARY KEY,
    code_postal  VARCHAR(100),
    ville        VARCHAR(100),
    pays         VARCHAR(100),
    destinataire VARCHAR(100),
    expediteur   VARCHAR(100),
    contenu      TEXT,
    adresse_id   INTEGER,
    FOREIGN KEY (adresse_id) REFERENCES adresse (id),
    personne_id   INTEGER,
    FOREIGN KEY (personne_id) REFERENCES personne (id)
);

create table lot_postal
(
    id serial
        constraint lot_postal_pk
            primary key
);

alter table courrier
    add lot_postal integer;

alter table courrier
    add constraint courrier_lot_postal_id_fk
        foreign key (lot_postal) references lot_postal;

