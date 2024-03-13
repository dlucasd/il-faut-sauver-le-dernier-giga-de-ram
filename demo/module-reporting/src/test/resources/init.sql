create table courrier
(
    id           serial
        primary key,
    code_postal  varchar(100),
    ville        varchar(100),
    pays         varchar(100),
    destinataire varchar(100),
    expediteur   varchar(100),
    contenu      text
);

create table adresse
(
    id          serial
        primary key,
    code_postal integer,
    ville       varchar(255),
    pays        varchar(255),
    ligne1      varchar(255),
    ligne2      varchar(255),
    ligne3      varchar(255),
    ligne4      varchar(255),
    ligne5      varchar(255),
    ligne6      varchar(255),
    courrier_id integer
        constraint adresse_courrier_id_fk
            references courrier
);

create table ref_postal
(
    code_postal integer not null
        constraint referentiel_postal_pk
            primary key,
    ville       varchar
);
