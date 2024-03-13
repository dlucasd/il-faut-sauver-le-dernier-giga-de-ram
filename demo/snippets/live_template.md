```Java
@Query("""
        SELECT c 
        FROM Courrier c 
        LEFT JOIN FETCH c.adresses a 
        WHERE c.ville = :ville""")
```

```Java
@QueryHints(value = {
        @QueryHint(name = HINT_FETCH_SIZE, value = "300000")
})
```
