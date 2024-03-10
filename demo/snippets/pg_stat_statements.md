# Ajout pg_stat_statements aux shared_preload_libraries
# En se connectant au conteneur en mode terminal
echo "shared_preload_libraries = 'pg_stat_statements'" >> $PGDATA/postgresql.conf

# Création de l'extension
create extension if not exists pg_stat_statements;

# Réinitialisation des statistiques
select pg_stat_statements_reset();


