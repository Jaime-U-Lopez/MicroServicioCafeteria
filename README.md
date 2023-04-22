# Servicio Cafeteria


El Servicio Cafetería es un microservicio diseñado para ayudar a los dueños de cafeterías a controlar sus ventas e inventario. Con este servicio, los usuarios pueden llevar un registro de los productos vendidos, la cantidad de stock disponible y más. Todo esto se hace utilizando tecnologías modernas como Java 8, Spring Boot y MySQL, y siguiendo principios de diseño sólidos para garantizar la escalabilidad y mantenibilidad del código."



## 💻:construction_worker: Tecnologias utlizadas 

- Java 8: 

- Maven: una herramienta de gestión de dependencias que simplifica la construcción y administración de proyectos de Java.

- Swagger: una herramienta para diseñar, construir, documentar y consumir servicios web RESTful.

- MySQL: un sistema de gestión de bases de datos relacionales muy utilizado en la industria.

- Data JPA/Hibernate: un framework que facilita el acceso a bases de datos relacionales desde aplicaciones Java.

- Spring Boot: un framework de desarrollo de aplicaciones web que simplifica la configuración y la integración de varias tecnologías.

- Principios SOLID: un conjunto de principios de diseño de software que buscan promover la modularidad, la flexibilidad y la mantenibilidad del código.

- Patrón DAO: un patrón de diseño que separa la lógica de acceso a datos de la lógica de negocio.

- Patrón DTO: un patrón de diseño que permite transferir datos entre objetos de diferentes capas de la aplicación.

- Patrón de diseño Cadena de responsabilidad: un patrón de diseño que permite procesar solicitudes en una cadena de objetos."

- Code Clean :  diseño por capas 

- Thymeleaf  : Para el dar una presentacion visual de los datos y sus interacciones















### Para poner en marcha el Microservicio sigue estos pasos :
 
 1) Descarga el proyecto y correlo en tu ide de preferencia Inteligent, visual studio, Eclipse, etc
 2) Compilalo ( las dependencias de maven o Gradle)
  
 3)  Modifica el archivo 'application.properties' del proyecto de Spring Boot con los siguientes campos para configurar la conexión a tu base de datos:

      'spring.datasource.url=jdbc:mysql://localhost:3306/nombre_de_la_base_de_datos'

      'spring.datasource.username=nombre_de_usuario'

      'spring.datasource.password=contraseña_del_usuario'"

 4) Arranca el servidor 


###  Para hacer el uso le microservicio tienes varias  alternativas :

1) Puedes interactuar con Swagger , dejo la ruta de mi Localhost, solo cambia el puerto por el tuyo : http://localhost:8080/swagger-ui/index.html#
2) Interactua con el fron realizado con Thymeleaf

3) Utiliza Postman o Insomnia para hacer solicitudes HTTP a la API del microservicio. Por ejemplo, para obtener una lista de todos los productos, haz una solicitud GET a la siguiente URL: 'http://localhost:8080/api/productos'."



### Link para uso:

- github :  https://github.com/Jaime-U-Lopez/MicroServicioCafeteria
- copia de la base de datos


### sentencias de MySql consultas personalizadas :

1 ) Realizar una consulta que permita conocer cuál es el producto que más stock tiene: 

      -  Consulta SQL :  select * from producto p Order by p.stock Desc limit 1
      
        respuesta : 
        
       <img style=whit=20px>
 ![image](https://user-images.githubusercontent.com/50783391/233808090-428e7250-ad69-49c0-a942-ea9f78eae73f.png)
      
       </img>
 

2 )  Realizar una consulta que permita conocer cuál es el producto más vendido.

 
      -  Consulta SQL :  select producto from  venta_productos group by producto  order by sum(cantidad_vendida) desc limit 1

         respuesta: 
         
  ![image](https://user-images.githubusercontent.com/50783391/233808076-1148532b-c668-44eb-925a-faea87e8f90d.png)





## 🏛 Diagrama de entidades :

![image](https://user-images.githubusercontent.com/50783391/233806447-3d121259-b843-4c9f-8efc-6bdb92b8a263.png)






