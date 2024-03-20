# Solución Logger
### Autor: Pedro Antonio Luque López
### Descripción
Se ha creado la clase Logger con el método logger que recibe como parámetro un mensaje y 
lo imprime por pantalla. Adicionalmente, esta clase tiene un método privado y estático
para que sea accesible desde cualquier parte del código que tenga una instancia del Logger.

En el caso de los mensajes de inicialización y finalización del programa, he optado por
crear una variable de tipo LoggerUtil y que más abajo, para poder llamarlo desde el método
estático main, he creado un método estático que devuelve la instancia de LoggerUtil.

## Actualización 12/03/2024
La gracia del ejercicio es que se usen patrones de diseño, por lo que implementaré el patrón Singleton
para la clase LoggerUtil. De esta manera, se garantiza que solo exista una instancia de esta clase.
