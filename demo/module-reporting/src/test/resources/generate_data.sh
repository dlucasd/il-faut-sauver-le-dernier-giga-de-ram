#!/bin/bash

# Définition des fonctions pour générer des valeurs aléatoires
generate_random_string() {
    cat /dev/urandom | tr -dc 'a-zA-Z0-9' | fold -w "$1" | head -n 1
}

generate_random_text() {
    cat /dev/urandom | tr -dc '[:alnum:] [:punct:]' | fold -w "$1" | head -n 1
}

# Définition des valeurs possibles pour les champs
codes_postaux=('33300' '24002' '12003' '45004' '75005' '65006' '75007' '75008' '75009' '75010')
pays=('France' 'Germany' 'United Kingdom' 'Italy' 'Spain' 'Portugal' 'Netherlands' 'Belgium' 'Switzerland' 'Austria')
noms_destinataires=('Forrest Gump' 'Woody' 'Captain John Miller' 'Chuck Noland' 'Walt Disney' 'Paul Edgecomb' 'Joe Fox' 'Ben Bradlee' 'Jim Lovell' 'Charlie Wilson' 'Josh Baskin' 'James Donovan' 'Andrew Beckett' 'Larry Crowne' 'David S. Pumpkins' 'Michael Sullivan' 'Richard Phillips' 'Joe Banks' 'James Mattingly' 'Carl Hanratty')
noms_expediteurs=('Forrest Gump' 'Woody' 'Captain John Miller' 'Chuck Noland' 'Walt Disney' 'Paul Edgecomb' 'Joe Fox' 'Ben Bradlee' 'Jim Lovell' 'Charlie Wilson' 'Josh Baskin' 'James Donovan' 'Andrew Beckett' 'Larry Crowne' 'David S. Pumpkins' 'Michael Sullivan' 'Richard Phillips' 'Joe Banks' 'James Mattingly' 'Carl Hanratty')

# Génération des insertions SQL
for (( i=1; i<=4000000; i++ )); do
    code_postal="${codes_postaux[$RANDOM % ${#codes_postaux[@]}]}"
    pays="${pays[$RANDOM % ${#pays[@]}]}"
    destinataire="${noms_destinataires[$RANDOM % ${#noms_destinataires[@]}]}"
    expediteur="${noms_expediteurs[$RANDOM % ${#noms_expediteurs[@]}]}"
    contenu="Contenu du courrier numéro $i"

    echo "INSERT INTO courrier (code_postal, ville, pays, destinataire, expediteur, contenu) VALUES ('$code_postal', 'Philadelphie', '$pays', '$destinataire', '$expediteur', '$contenu');"
done
