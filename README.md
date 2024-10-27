# Como configurar ambientes de Producción y Desarrollo en Java Web con Maven Profiles

Este proyecto demuestra cómo crear y configurar un proyecto de Java Web (JSF o JSP) utilizando Maven para manejar distintos entornos (desarrollo y producción). Incluye una configuración de perfiles de Maven que permite especificar archivos de configuración para cada ambiente. La configuración permite la exclusión de los recursos de desarrollo en el compilado final para producción.

## Explicación del proyecto

Puedes ver a detalle el proyecto directamente desde mi canal de YouTube [https://youtu.be/EImKiIJEho8](https://youtu.be/WSGs9fbmK1E)


## Características
* GConfiguración de perfiles de Maven (dev y prod)
* Exclusión del entorno de desarrollo en el compilado de producción

##  Herramientas utilizadas:
- **Java [11 o Superior]** como lenguaje de programación.
- **PostgreSQL  [12 o Superior]** como motor de la base de datos.
- **Jakarta Server Faces [3.0]** para la creación de las vistas en XHTML.
- **PrimeFaces [13.0.0]**  para el uso de componentes.
- **WildFly [24.0.1.FINAL]** para el despliegue de aplicaciones.


## Instrucciones de Uso

Para la compilación del proyecto se lo realizara con los comandos de Maven, donde se le asigna la variable del comando -P indicando que es un perfil y se asigna el nombre del perfil en este caso |dev|prod|test
```
mvn clean install -P dev
```

```
mvn clean install -P prod
```


Este proyecto es ideal para aquellos que buscan aprender cómo configurar múltiples entornos en aplicaciones de Java Web, simplificando el despliegue en producción y controlando las configuraciones a través de perfiles de Maven.


---

