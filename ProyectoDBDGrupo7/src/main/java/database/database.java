package database;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.sql2o.Sql2o;

/*
    Sql2o: Es una biblioteca de mapeo objeto-relacional (ORM) ligera que se utiliza para
    facilitar la interacción con bases de datos relacionales desde Java.

    @Configuration: Marca la clase como una clase de configuración que puede definir beans para ser gestionados por
    el contenedor de Spring. Esto indica que la clase contiene definiciones de beans y la lógica de
    configuración de la aplicación
 */
@Configuration
public class database {

    /*
    @Value: Utilizada para inyectar valores de propiedades desde el archivo de
    configuración (application.properties o application.yml) en los campos dbUrl, dbUser, y dbPass.
     */
    // ${spring.datasource.url}: Inyecta el valor de la propiedad spring.datasource.url.
    @Value("${spring.datasource.url}")
    private String dbUrl;

    // ${spring.datasource.username}: Inyecta el valor de la propiedad spring.datasource.username.
    @Value("${spring.datasource.username}")
    private String dbUser;

    // ${spring.datasource.password}: Inyecta el valor de la propiedad spring.datasource.password.
    @Value("${spring.datasource.password}")
    private String dbPass;

    /*
    @Bean: Marca el método como un bean de Spring. Esto significa que el objeto devuelto por este método (Sql2o) será
    gestionado por el contenedor de Spring y estará disponible para la inyección en otros componentes
    de la aplicación.

    El método sql2o crea y devuelve una nueva instancia de Sql2o, configurada con la URL de la base de datos,
    el nombre de usuario y la contraseña inyectados previamente.
     */
    @Bean
    public Sql2o sql2o(){
        return new Sql2o(dbUrl, dbUser, dbPass);
    }
}
