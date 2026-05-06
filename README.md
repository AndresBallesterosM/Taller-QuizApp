# Quiz Interactivo - Android con Jetpack Compose

**Asignatura:** Programación para Dispositivos Móviles
**Universidad:** Universidad de Caldas
**Estudiante:** Carlos Andrés Ballesteros Muñoz
**Unidad:** Interfaces de Usuario y Arquitectura MVVM


## Descripción del proyecto

Este proyecto consiste en el desarrollo de una aplicación móvil tipo **quiz interactivo**, implementada en Android utilizando **Jetpack Compose** y siguiendo el patrón de arquitectura **MVVM (Model - View - ViewModel)**.

La aplicación permite a los usuarios responder preguntas de selección múltiple sobre conceptos básicos de desarrollo Android, mostrando retroalimentación inmediata y un puntaje acumulado.



## Objetivo

Aplicar los conceptos de:

* Arquitectura **MVVM**
* Manejo de estado con **StateFlow**
* Interfaz declarativa con **Jetpack Compose**
* Flujo de datos unidireccional

---

## Tecnologías utilizadas

* **Kotlin**
* **Jetpack Compose**
* **ViewModel**
* **StateFlow**
* **Material 3**

---

## Arquitectura

El proyecto sigue el patrón **MVVM**, separando responsabilidades de la siguiente forma:

### Model

Contiene las clases de datos:

* `Question.kt`
* `QuizUiState.kt`

### ViewModel

Contiene la lógica del negocio:

* `QuizViewModel.kt`

Funciones principales:

* Selección de respuesta
* Validación
* Manejo del puntaje
* Navegación entre preguntas
* Reinicio del quiz

### View (UI)

Interfaz construida con Compose:

* `QuizScreen.kt`
* `MainActivity.kt`



## Flujo de datos

La aplicación implementa un flujo de datos unidireccional:

1. El usuario interactúa con la UI
2. Se envía un evento al ViewModel
3. El ViewModel actualiza el estado (`StateFlow`)
4. La UI observa el estado con `collectAsState()`
5. La interfaz se recompone automáticamente



## Funcionalidades implementadas

* ✔ Mostrar preguntas una a una
* ✔ Selección de respuesta única
* ✔ Validación de respuesta
* ✔ Retroalimentación (correcto/incorrecto)
* ✔ Puntaje acumulado
* ✔ Navegación entre preguntas
* ✔ Diálogo final con resultado
* ✔ Reinicio del quiz
* ✔ Persistencia del estado ante rotación de pantalla



## Funcionamiento

1. El usuario selecciona una respuesta
2. Presiona **"Validar"**
3. Se muestra si es correcta o incorrecta
4. Avanza con **"Siguiente"**
5. Al finalizar, se muestra un **AlertDialog** con el resultado final
6. Puede reiniciar el quiz

---

## Pruebas realizadas

* Rotación de pantalla (estado persistente)
* Validación de respuestas correctas/incorrectas
* Flujo completo del quiz
* Reinicio del juego



## Conclusiones

Este proyecto permitió aplicar de forma práctica los conceptos de arquitectura moderna en Android, especialmente el manejo de estado con `StateFlow` y la separación de responsabilidades mediante MVVM.

Jetpack Compose facilitó la construcción de interfaces dinámicas y reactivas, mejorando la claridad del código y la mantenibilidad del sistema.



## Posibles mejoras

* Agregar temporizador por pregunta
* Mejorar diseño visual (colores, animaciones)
* Incorporar más preguntas dinámicas
* Persistencia de puntajes



## Autor

Carlos Andrés Ballesteros Muñoz
Universidad de Caldas


