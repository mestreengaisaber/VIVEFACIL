Para arrancar el docker compose tenemos que poner el siguiente comando: docker-compose up --build
podemos ver que servicios estan corriendo si abrimos otra ventana y hacemos el comando: docker ps,
si queremos pararlo hacemos docker stop containerid (es el containerid tipo 2e4dbba560b6)

Para lanzar el swagger una vez tenemos levantado el servicio : http://localhost:8080/swagger-ui/index.html#/
Alli podemos probar los endpoints

El proyecto se ha añadido Jacoco para el coverage de los test unitarios de la capa de Servicio
lo podemos ver en la ruta : vivefacilv1/target/site/jacoco/index.html

