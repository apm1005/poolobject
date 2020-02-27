poolobject
==========

[![Build Status](https://travis-ci.org/apm1005/poolobject.svg?branch=master)](https://travis-ci.org/apm1005/poolobject)
[![codecov](https://codecov.io/gh/apm1005/poolobject/branch/master/graph/badge.svg)](https://codecov.io/gh/apm1005/poolobject)

Java code example of design creational pattern pool object.

Example to apply good practise in software developmemnt: test and mesurement.

---
### ENUNCIADO

En la práctica se va simular un pequeño desarrollo de un producto software para realizar mediciones sobre él.

El objetivo es establecer un caso de estudio que sirva para caracterizar y evaluar tanto el producto desarrollado como el proceso seguido.

* Descripción del producto

Dado un código de ejemplo del patrón diseño creacional Pool Object, se debe crear una batería de pruebas tal que las coberturas de sus clases sean del 100%. El código de las clases se puede obtener en el [repositorio](https://github.com/clopezno/poolobject). La batería de pruebas JUnit debe estar contenida en la clase ubu.gii.dass.test.c01.ReuseblePoolTest.java.

* Descripción del proceso

El proceso de desarrollo de la batería de pruebas se va a gestionar utilizando el control de versiones del sistema Git proporcionado por el repositorio de proyectos [GitHub](https://github.com).

Los pasos para gestionar el procesos son los siguientes:

1. Cada miembro del equipo tiene que estar registrado en GitHub, Travis CI y Codecov.io.

2. Uno de los miembros tiene que realizar un fork del repositorio donde se encuentra el [código](https://github.com/clopezno/poolobject) que se quiere probar. El nuevo repositorio tiene que ser público.

3. Invitar al resto de miembros del equipo para que puedan participar en el desarrollo de las pruebas.

4. Vincular el proyecto con Travis CI y Codecov.io.

5. Cada nuevo test realizado ejecutar un commit/push al repositorio del grupo. El texto del commit tiene que describir el caso de prueba añadido.

6. Verificar el resultado de las pruebas en el pipeline de integración continua y cómo la calidad del producto va mejorando con las sucesivas integraciones.

---

### CUESTIONES


* ¿Se ha realizado trabajo en equipo?

Tal y como se puede apreciar en los commits del repositorio, el trabajo ha sido distribuido entre ambos miembros del equipo.

* ¿Tiene calidad el conjunto de pruebas disponibles?

Las pruebas realizadas sobre la clase ReusablePool cubren todas las posibles funcionalidades de la misma.

* ¿Cuál es el esfuerzo invertido en realizar la actividad?

El esfuerzo invertido en esta actividad ha sido de aproximadamente 3-4 horas.

* ¿Cuál es el número de fallos encontrados en el código?

En algunas clases había importadas librerías a las que no se han dado uso. Por otra parte, la clase con la excepción DuplicatedInstanceException no posee un atributo serialVersion:
```java
private static final long serialVersionUID = 1L;
```