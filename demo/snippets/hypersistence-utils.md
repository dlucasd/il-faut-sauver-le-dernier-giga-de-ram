# Ajout de la dépendance à hypersistence-utils

```xml
<dependency>
    <groupId>io.hypersistence</groupId>
    <artifactId>hypersistence-utils-hibernate-63</artifactId>
    <version>3.7.3</version>
</dependency>
```

# Ajout de l'inspecteur

```java
@Component
public class HibernateConfig implements HibernatePropertiesCustomizer {

	@Override
	public void customize(Map<String, Object> hibernateProperties) {
		hibernateProperties.put(
				AvailableSettings.STATEMENT_INSPECTOR,
				new QueryStackTraceLogger(
						"fr.onepoint.demo"
				)
		);
	}
}
```

# Configuration du niveau de log

```yaml
logging:
    level:
        io.hypersistence.utils.hibernate.query: DEBUG
```
