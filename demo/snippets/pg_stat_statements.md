# Ajout pg_stat_statements aux shared_preload_libraries
# En se connectant au conteneur en mode terminal

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

# Requêtes
```sql
select calls, query
from pg_stat_statements
order by calls desc;
```