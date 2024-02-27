#!/bin/bash

# Initialisation des listes
villes=("Memphis" "Atlanta" "Chicago" "New York" "Houston" "Washington" "Dallas" "Charlotte" "Los Angeles" "San Francisco")
expediteurs=("James Johnson" "Emma Martinez" "William Davis" "Sophia Rodriguez" "Benjamin Thompson" "Isabella Garcia" "Ethan Hernandez" "Mia Lopez" "Alexander Lee" "Charlotte Perez")
destinataires=("Liam Wilson" "Olivia Martinez" "Noah Johnson" "Ava Brown" "Logan Garcia" "Amelia Davis" "Mason Rodriguez" "Harper Miller" "Elijah Jones" "Abigail Jackson")
contenus=("I am writing to confirm our meeting scheduled for Date at Time at Location. Please let me know if there are any changes or if you require any additional information. Best regards," "I wanted to provide a quick update on the progress of the project. We have successfully completed the initial phase and are on track to meet the deadlines. I will be happy to discuss further details at your convenience. Best regards," "This is a gentle reminder regarding the pending invoice Invoice Number dated Date. We kindly request your prompt attention to settle the outstanding amount. Thank you," "We have received your job application for the position of Job Title. We appreciate your interest in joining our team. We will review your application and get back to you shortly. Best regards," "We would like to express our gratitude for your continued support and trust in our services. We look forward to serving you and meeting your expectations in the future. Sincerely," "We are pleased to confirm your registration for the upcoming training session on Topic scheduled for Date at Location. Please let us know if you have any questions or require further information. Best regards," "I am writing to request additional information regarding Topic. Could you please provide details on Specific Information Needed? Your prompt response would be greatly appreciated. Thank you," "We are excited to announce the launch of our new product, Product Name. This innovative solution is designed to meet the evolving needs of our customers. We look forward to your feedback and support. Best regards," "Thank you for the productive meeting earlier today. As per our discussion, I will follow up with the action items and next steps by Date. Please feel free to reach out if you have any further questions. Best regards" "This is a friendly reminder that your performance review is scheduled for Date. We encourage you to prepare for the discussion and share any achievements or concerns you would like to address. Best regards")

# Entête du fichier CSV
#codePostal;ville;pays;destinataire;expediteur;contenu;adresses;personnes;lotPostal

# Création des "métadonnées"
    for ((j=0; j <300; j++))
    do
      metadonnees+=$(echo $RANDOM | md5sum | head -c 20)
      metadonnees+=";"
      echo "Métadonnée $j créée"
    done

# Génération aléatoire des lignes
for ((i=1; i<=100000; i++))
do
  if [ $((i % 1000)) -eq 0 ]; then
    echo "Traitement de la $i ème ligne"
  fi
    codePostal=$(shuf -i 10000-99999 -n 1)
    ville=${villes[$(($RANDOM % 10))]}
    pays="USA"
    destinataire=${destinataires[$(($RANDOM % 10))]}
    expediteur=${expediteurs[$(($RANDOM % 10))]}
    contenu=${contenus[$(($RANDOM % 10))]}
    adresses=$(shuf -i 1-100 -n 1)
    personnes=$(shuf -i 1-100 -n 1)
    lotPostal=$(shuf -i 1-5 -n 1)

    # Écriture de la ligne dans le fichier CSV
    echo "$codePostal;$ville;$pays;$destinataire;$expediteur;$contenu;$adresses;$personnes;$lotPostal;$metadonnees" >> courriers.csv
done