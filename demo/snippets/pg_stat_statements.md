# Ajout pg_stat_statements aux shared_preload_libraries
# en se connectant au conteneur en mode terminal

```bash
echo "shared_preload_libraries = 'pg_stat_statements'" >> $PGDATA/postgresql.conf
```

# Création de l'extension
```sql
create extension if not exists pg_stat_statements;
```

# Réinitialisation des statistiques
```sql
select pg_stat_statements_reset();
```

# Requête d'analyse
```sql
select trim(to_char(calls, 'FM9 999 999 999'))                               as appels,
       trim(to_char(round(mean_exec_time * 1000), 'FM9 999 999 999')) || 's' as temps_moyen,
       trim(to_char(shared_blks_read, 'FM9 999 999 999'))                    as quantite_donnees_lues,
       trim(to_char(rows, 'FM9 999 999 999'))                                as lignes,
       query
from pg_stat_statements
where query like any (array ['%courrier%', '%adresse%', '%ref_postal%']);
```