# AREP_Parcial_2T

- **Autor**: Carlos David Barrero Velasquez  
- **Universidad**: Escuela Colombiana de Ingeniería Julio Garavito  
- **Asignatura**: Arquitecturas Empresariales (AREP)  
- **Fecha**: Marzo 2026  

Este proyecto consiste en conectar dos instancias del servicio `Math` y un proxy desplegados en AWS EC2. La funcionalidad principal incluye la implementación de **búsqueda lineal** y **búsqueda binaria** a través del proxy.

## Capturas de las instancias

Instancias de Math Service ya desplegadas:

![alt text](Capturas/image.png)

Verificación de las instancias creadas:

![alt text](<Capturas/Screenshot 2026-03-25 103355.png>)

## Evidencia de funcionamiento en local

![alt text](<Capturas/Screenshot 2026-03-25 105322.png>)  
![alt text](<Capturas/Screenshot 2026-03-25 110200.png>)  
![alt text](<Capturas/Screenshot 2026-03-25 112007.png>)  
![alt text](<Capturas/Screenshot 2026-03-25 112023.png>)

## Instalación de Java 17 en las instancias

![alt text](<Capturas/Screenshot 2026-03-25 113634.png>)  
![alt text](<Capturas/Screenshot 2026-03-25 113644.png>)

## Configuración de grupos de seguridad

Se añadieron reglas adicionales de entrada para evitar problemas de conexión:

![alt text](<Capturas/Screenshot 2026-03-25 115550.png>)

## Verificación del archivo JAR en la instancia

Se validó que el archivo JAR estuviera presente usando `ls -la`:

![alt text](<Capturas/Screenshot 2026-03-25 115741.png>)  
![alt text](<Capturas/Screenshot 2026-03-25 120019.png>)  
![alt text](<Capturas/Screenshot 2026-03-25 120028.png>)

## Evidencia de funcionamiento final

![alt text](Capturas/Evidencia.png)

## Video demostrativo

[Ver video demostrativo](https://pruebacorreoescuelaingeduco-my.sharepoint.com/:v:/g/personal/carlos_barrero-v_mail_escuelaing_edu_co/IQDxGP5i5m1-So8YFy3Bwa0WAYLdywoAiL0yr3yKokVLkxI?nav=eyJyZWZlcnJhbEluZm8iOnsicmVmZXJyYWxBcHAiOiJPbmVEcml2ZUZvckJ1c2luZXNzIiwicmVmZXJyYWxBcHBQbGF0Zm9ybSI6IldlYiIsInJlZmVycmFsTW9kZSI6InZpZXciLCJyZWZlcnJhbFZpZXciOiJNeUZpbGVzTGlua0NvcHkifX0&e=G5Nysc)