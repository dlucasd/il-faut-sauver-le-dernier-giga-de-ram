#!/bin/bash

# Définition des fonctions pour générer des valeurs aléatoires
generate_random_string() {
    cat /dev/urandom | tr -dc 'a-zA-Z0-9' | fold -w "$1" | head -n 1
}

generate_random_text() {
    cat /dev/urandom | tr -dc '[:alnum:] [:punct:]' | fold -w "$1" | head -n 1
}

# Définition des valeurs possibles pour les champs
codes_postaux=('75001' '75002' '75003' '75004' '75005' '75006' '75007' '75008' '75009' '75010')
villes=('Paris' 'Marseille' 'Lyon' 'Toulouse' 'Nice' 'Nantes' 'Strasbourg' 'Montpellier' 'Bordeaux' 'Lille')
pays=('France' 'Germany' 'United Kingdom' 'Italy' 'Spain' 'Portugal' 'Netherlands' 'Belgium' 'Switzerland' 'Austria')
noms_destinataires=('Jean Dupont' 'Marie Martin' 'Pierre Durand' 'Sophie Leroy' 'Thomas Dubois' 'Anne Moreau' 'Nicolas Rousseau' 'Isabelle Lefebvre' 'Julien Girard' 'Camille Lambert')
noms_expediteurs=('Pauline Chevalier' 'Antoine Leroux' 'Caroline Blanc' 'Lucas Petit' 'Aurélie Robert' 'Sylvain Morel' 'Céline Lemoine' 'David Roussel' 'Valérie Simon' 'Alexandre Gauthier')

# Génération des insertions SQL
for (( i=1; i<=4000000; i++ )); do
    code_postal="${codes_postaux[$RANDOM % ${#codes_postaux[@]}]}"
    ville="${villes[$RANDOM % ${#villes[@]}]}"
    pays="${pays[$RANDOM % ${#pays[@]}]}"
    destinataire="${noms_destinataires[$RANDOM % ${#noms_destinataires[@]}]}"
    expediteur="${noms_expediteurs[$RANDOM % ${#noms_expediteurs[@]}]}"
    contenu="Contenu du courrier numéro $i"

    echo "INSERT INTO courrier (code_postal, ville, pays, destinataire, expediteur, contenu) VALUES ('$code_postal', '$ville', '$pays', '$destinataire', '$expediteur', '$contenu');"
done
