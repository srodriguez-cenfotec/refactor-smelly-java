# Proyecto Construcción Parte 2
Refactorización de Código en Java

## Tópicos a Corregir 

1. Código duplicado: Evite repetir lógica. Extraiga métodos reutilizables.
    - En la clase **UserHandler.java** se eliminó el código duplicado donde se valida el nombre de usuario ingresado en los métodos, este código fue movido a un método aparte que se invoca desde los otros métodos que lo necesitan
2. Números mágicos: Utilice constantes con nombre en lugar de números en el código.
   - En la clase **OrderProcessor.java**, se crean constantes para valores fijos que se utilizan en las operaciones.
3. Strings mágicos: Evite strings literales repetidos. Use constantes.
   - En la clase **DB.java**, se definen constantes `MSG_CONNECTING`, `MSG_QUERYING` y `MSG_DISCONNECTING` para reemplazar los strings literales usados en los métodos `connect()`, `query()` y `disconnect()`.
4. Constantes faltantes: Declare valores reutilizables como constantes estáticas.
   - En la clase **DB.java**, se cambió el campo `databaseName` de `protected` a `private final`, encapsulando correctamente el estado interno y evitando modificaciones externas.
   - En la clase **OrderProcessor.java**, se crean constantes para valores fijos que se utilizan en las operaciones.
5. Métodos largos: Divida métodos extensos en varios métodos con una sola responsabilidad.
   - En la clase **ReportManager.java** se divide la lógica del método **processReport()** en varios métodos, cada uno con solo una responsabilidad
   - En la clase **OrderProcessor.java** se divide el método **calculateTotal()**, separando el cálculo de cada valor (impuesto, cargo por servicio y descuento) y la presentación de resultados en métodos independientes, cada uno con una sola responsabilidad
6. Muchos métodos (SRP): Aplique el principio de responsabilidad única por clase.
7. Comentarios innecesarios: Elimine comentarios que expliquen lo obvio. Use código autodocumentado.
   - En el código no se encontraban comentarios innecesarios.
8. Nombres poco descriptivos: Use nombres claros y significativos para métodos y variables.
   - En la clase **DB.java**, se actualizó el nombre de los métodos para que sea más claro en cuanto a lo que se implementa.
9.  Falta de reutilización: Evite repetir lógica. Agrupe en funciones o clases comunes.
    - En la clase **DB.java**, para no recibir el nombre de la base de datos como parámetro por cada uno de sus métodos, se definió el nombre de la base de datos como un campo de la clase que se inicializa en el constructor, y este se usa en la implementación de los métodos.
    - En la clase **UserHandler.java** se eliminó el código duplicado donde se valida el nombre de usuario ingresado en los métodos, este código fue movido a un método aparte que se invoca desde los otros métodos que lo necesitan
10. Uso incorrecto de Object: Evite usar Object sin generics. Use tipado fuerte para claridad.
    - En la clase **ReportManager.java**, se reemplaza el tipo del campo **data** para que este sea un **String** en lugar de un **Object**.
11. Modularidad violada: Separe el código en clases con una sola responsabilidad.
   - En la clase **DB.java**, se extrajo un método privado `log()` que centraliza la salida de mensajes, evitando repetir `System.out.println()` en cada método.
12. Bajo acoplamiento: Evite dependencias fuertes. Use interfaces y abstracción.
   - Se creó la interfaz **DatabaseService.java** para que cualquier clase que use una base de datos dependa del contrato y no de la implementación concreta `DB`.
13. Alta cohesión faltante: Mantenga métodos relacionados dentro de la misma clase.
14. KISS (Keep It Simple, Stupid): Evite lógica compleja innecesaria. Prefiera lo simple.
15. Boy Scout Rule: Deje el código más limpio de como lo encontró. Elimine código muerto.
   - En la clase **DB.java**, se agregó validación en el constructor para rechazar un `databaseName` nulo o vacío, dejando la clase en un estado siempre válido.
16. Código no autodocumentado: Haga que el código se explique por sí mismo. Nombres y estructura clara.
17. Falta de interfaces o clases base: Use interfaces para separar la definición de la implementación.
   - Se creó la interfaz **DatabaseService.java** con los métodos `connect()`, `query()` y `disconnect()`, y **DB.java** la implementa, separando el contrato de la implementación.
