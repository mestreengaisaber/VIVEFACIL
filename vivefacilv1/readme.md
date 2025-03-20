# VIVEFACIL

## Docker
Para arrancar el Docker Compose, tenemos que poner el siguiente comando:

docker-compose up --build

Podemos ver qué servicios están corriendo si abrimos otra ventana y hacemos el comando:
docker ps

Si queremos pararlo, hacemos:
docker stop <container_id>  (el container_id es algo como 2e4dbba560b6)

## Swagger

Para lanzar el swagger una vez tenemos levantado el servicio, vamos a:
http://localhost:8080/swagger-ui/index.html#/

Alli podemos probar los endpoints

## Jacoco

El proyecto se ha añadido Jacoco para el coverage de los test
unitarios de la capa de Servicio. Lo podemos ver en la ruta:
        
        */vivefacilv1/vivefacilv1/target/site/jacoco/index.html


## Repositorios

url repositorio github: https://github.com/mestreengaisaber/VIVEFACIL/tree/master/vivefacilv1
url dockerhub: https://hub.docker.com/repository/docker/mestreengaisaber/vivefacil_test/general

## Subir Docker Compose a DockerHub
    1.Desde la raíz de nuestro proyecto ejecutamos:
        docker-compose build
    2.Listamos las imágenes para ver el image_id correspondiente:
        docker images
    3.Etiquetamos la imagen:
        docker tag <correct_image_id> mestreengaisaber/vivefacil_test:latest
    4.Iniciamos sesión en DockerHub:
        docker login
    5.Subimos la imagen a DockerHub:
        docker push
    docker push mestreengaisaber/vivefacil_test:latest
    docker push mestreengaisaber/vivefacil_test:latest

        Para poderme conectar a mi docker me tuve que crear un fichero con mis credenciales : docker-login.sh

## Descargar desde DockerHub
    1.Descargamos la imagen:
        docker pull mestreengaisaber/vivefacil_test:latest
    2.Ejecutamos el contenedor:
        docker run -d -p 8081:8081 mestreengaisaber/vivefacil_test:latest

## Uso del servicio de token interno que se ha generado:

1.nos conectamos con un cliente REST (POSTMAN, INSOMNIA ) via POST con ese cuerpo a la url:
        http://localhost:8081/token

    {
    "username":"auth-vivelibre",
    "password": "password"
    }
1.1.nos genera:

    {
    "token": "Bearer eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJKV1QiLCJzdWIiOiJhdXRoLXZpdmVsaWJyZSIsImF1dGhvcml0aWVzIjpbIlJPTEVfVVNFUiJdLCJpYXQiOjE3NDI0NDExOTMsImV4cCI6MTc0MjQ2OTk5M30.4TEH6XSzNwOQiCE-RssFCaPfRxxpuFS4hb6Doyq8G9vXdyJsIJDKyjfoIdBxXKBfpuS6X65fS7fPANKgZqo3Tg",
    "timestamp": "2025-03-20T04:26:33.8536079"
    }
En cualquier peticion por ejemplo esa GET: http://localhost:8080/vivefacil/orderBooksWithAuthorCountBooks

2) Se nos hace crear un nuevo servicio que se conecte a un docker que nos genera dicho token y ese pasarlo por nuestra aplicaicon :

Veamos al detalle las 3 urls disponibles que tenemos en el puerto 8081 nuestra aplicacion
y en el 8080 el docker de donde extraemos los datos :

    1)  docker externo levantado : http://localhost:8080/token
                
                1)lo hemos descargado del repo :  docker pull skeet15/auth-vivelibre
                2)docker run -d -p 8080:8080 skeet15/auth-vivelibre

        
    2) endpoint que conecta a nuestro token interno : http://localhost:8081/tokenInt
    3) endpoint que conecta a nuestro token externo del docker del punto 1 : http://localhost:8081/tokenExt

En com.atam.vivefacilv1.application.security.Constants hemos definido :

        public static final String LOGIN_URL = "/tokenInt";
        public static final String LOGIN_EXTERNAL_URL = "/tokenExt";


Le adjuntamos  la cabecera: Authorization:
Bearer eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJKV1QiLCJzdWIiOiJhdXRoLXZpdmVsaWJyZSIsImF1dGhvcml0aWVzIjpbIlJPTEVfVVNFUiJdLCJpYXQiOjE3NDI0NDExOTMsImV4cCI6MTc0MjQ2OTk5M30
.4TEH6XSzNwOQiCE-RssFCaPfRxxpuFS4hb6Doyq8G9vXdyJsIJDKyjfoIdBxXKBfpuS6X65fS7fPANKgZqo3Tg
Ya nos permitiría mostrar el contenido si no le ponemos el user correcto, el password correcto o el token correcto nos da un código 403









