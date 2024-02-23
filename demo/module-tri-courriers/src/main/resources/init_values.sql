-- Générer 500 000 adresses uniques
BEGIN;
INSERT INTO adresse (code_postal, ville, pays, ligne1, ligne2, ligne3, ligne4, ligne5, ligne6)
SELECT
    (FLOOR(RANDOM() * 100000) + 10000) AS code_postal,
    'Ville' || (FLOOR(RANDOM() * 1000) + 1) AS ville,
    'Pays' || (FLOOR(RANDOM() * 100) + 1) AS pays,
    'Ligne1' || (FLOOR(RANDOM() * 1000) + 1) AS ligne1,
    'Ligne2' || (FLOOR(RANDOM() * 1000) + 1) AS ligne2,
    'Ligne3' || (FLOOR(RANDOM() * 1000) + 1) AS ligne3,
    'Ligne4' || (FLOOR(RANDOM() * 1000) + 1) AS ligne4,
    'Ligne5' || (FLOOR(RANDOM() * 1000) + 1) AS ligne5,
    'Ligne6' || (FLOOR(RANDOM() * 1000) + 1) AS ligne6
FROM generate_series(1, 500000);

-- Générer 500 000 personnes uniques
INSERT INTO personne (nom, prenom)
SELECT
    'Nom' || (FLOOR(RANDOM() * 1000) + 1) AS nom,
    'Prenom' || (FLOOR(RANDOM() * 1000) + 1) AS prenom
FROM generate_series(1, 500000);

INSERT INTO lot_postal(id) values (1);
INSERT INTO lot_postal(id) values (2);
INSERT INTO lot_postal(id) values (3);
INSERT INTO lot_postal(id) values (4);
INSERT INTO lot_postal(id) values (5);

-- Générer 500 000 courriers uniques référençant des adresses et des personnes uniques
INSERT INTO courrier (code_postal, ville, pays, destinataire, expediteur, contenu, adresse_id, personne_id, lot_postal)
SELECT
    (FLOOR(RANDOM() * 100000) + 10000) AS code_postal,
    'Ville' || (FLOOR(RANDOM() * 1000) + 1) AS ville,
    'Pays' || (FLOOR(RANDOM() * 100) + 1) AS pays,
    'Nom' || (FLOOR(RANDOM() * 1000) + 1) || ' ' || 'Prenom' || (FLOOR(RANDOM() * 1000) + 1) AS destinataire,
    'Nom' || (FLOOR(RANDOM() * 1000) + 1) || ' ' || 'Prenom' || (FLOOR(RANDOM() * 1000) + 1) AS expediteur,
    'Contenu du courrier' || (FLOOR(RANDOM() * 1000) + 1) AS contenu,
    (FLOOR(RANDOM() * 500000) + 500001) AS adresse_id,
    (FLOOR(RANDOM() * 500000) + 500001) AS personne_id,
    (floor(random() * 4) +1) AS lot_postal
FROM generate_series(1, 500000);
COMMIT;