# EJERCICIO UNDO - PATRONES DE DISEÑO
## Pedro Antonio Luque López
### Descripción
El ejercicio consiste en implementar un patrón de diseño para un editor de texto que permite añadir, modificar y eliminar texto. 
Debemos implementar un patrón de diseño para poder deshacer la última operación realizada.

### Solución
Implementaremos el patrón `Memento` para realizar dichos cambios. 

Creamos la clase UndoCommand, que se encargará de realizar la operación undo. Creamos la clase Memento
y EditorCaretaker para guardar los estados del editor. Modificamos ConsoleEditor y CommandFactory
para que puedan realizar la operación undo.
Agregamos a la clase ConsoleEditor la opción para deshacer texto dentro del método showHelp.