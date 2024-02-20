# Il faut sauver le dernier giga de RAM

## Abstract

A l'approche des fortes volumétries de fin d'année, notre client ne peut plus se permettre d'ajouter à nouveau de la RAM sur son environnement de prod. Avec 96Go déjà en place sur le serveur, ça peut se comprendre !

Le mot d'ordre : réduire la consommation mémoire de notre application.

- "On a des metrics ?
- Non.
- Accès à la prod ?
- Non.
- Un composant identifié ?
- Non, plusieurs dizaines.
- Et on a combien de temps ?
- 3 semaines."

A travers ce talk nous vous présentons les outils que nous avons utilisés pour identifier les composants gourmands en RAM (Java Flight Recorder, MemoryAnalyzer, pg_statements, hypersistence-utils ...). Mais aussi comment nous les avons améliorés afin de réduire leur empreinte mémoire.

La stack du projet : Java, Spring, PostgreSQL.

## Plan

- Présentation du contexte projet dans lequel nous sommes intervenus – 4 minutes
- Démarche que nous avons adoptée pour identifier les composants consommateurs – 3 minutes
- Récolte de metrics avec les profilers Java Flight Recorder et Async – 5 minutes
- Analyse de la consommation mémoire avec Eclipse Memory Analyzer – 7 minutes
- Améliorations côté Java : instanciations inutiles, abus des opérations terminales dans les Stream, constantes – 10 minutes
- Affichage des requêtes générées par Hibernate, utilisation de l'extension pg_statements et hypersistence-utils – 7 minutes
- Optimisation des requêtes : mise en cache, projection, stream, réécriture de requêtes afin de limiter l'empreinte mémoire – 10 minutes
- Conclusion et questions – 4 minutes

## Pourquoi ce talk ?

Avec la puissance grandissante des serveurs de nos jours, la consommation mémoire de nos composants n'est que rarement considérée. Et quand nous sommes confrontés à cela, la plupart des développeurs ne savent pas quels sont les outils à disposition pour répondre à ce problème. Nous présentons donc un retour d'expérience concret sur la démarche adoptée et les outils que nous avons utilisés.

## Talk

Le talk sera présenté à deux. Sous forme d'un jeu de rôles, nous raconterons ce qu'on a vécu et ce qu'on a eu le temps de faire dans le temps imparti.

Nous alternerons entre quelques slides et plusieurs démos des différents outils.
