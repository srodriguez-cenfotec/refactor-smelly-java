# Proyecto Construcción Parte 2
Refactorización de Código en Java

## Tópicos a Corregir 

1. Código duplicado: Evite repetir lógica. Extraiga métodos reutilizables.
   - En la clase **UserHandlerImpl.java** se eliminó el bloque repetido `if (hasInvalidUser(userName)) { return; }` en `process()`, `notify()` y `print()`, extrayendo la validación y manejo de error en `hasInvalidUser(String userName)`.
   - En la clase **UserHandlerImpl.java** se centralizó el mensaje de error en `printErrorMessage()` para no repetir la misma impresión en varios métodos.
2. Números mágicos: Utilice constantes con nombre en lugar de números en el código.
   - En la clase **OrderProcessor.java**, se crean constantes para valores fijos que se utilizan en las operaciones.
   - En la clase **ReportManager.java**, se define la constante `MSG_PROCESSING` para reemplazar el string literal `"Processing report: "` usado en `processReport()`.
3. Strings mágicos: Evite strings literales repetidos. Use constantes.
   - En la clase **DB.java**, se definen constantes `MSG_CONNECTING`, `MSG_QUERYING` y `MSG_DISCONNECTING` para reemplazar los strings literales usados en los métodos `connect()`, `query()` y `disconnect()`.
   - En la clase **UserHandlerImpl.java**, se eliminaron strings literales del código y se movieron a archivos de recursos (`messages.properties` y `messages_es.properties`) dentro del paquete `com.smelly.handlers`, usando `ResourceBundle`.
4. Constantes faltantes: Declare valores reutilizables como constantes estáticas.
   - En la clase **DB.java**, se cambió el campo `databaseName` de `protected` a `private final`, encapsulando correctamente el estado interno y evitando modificaciones externas.
   - En la clase **OrderProcessor.java**, se crean constantes para valores fijos que se utilizan en las operaciones.
   - En la clase **UserHandlerImpl.java**, se agregaron constantes estáticas para llaves de localización (`error.empty.user`, `welcome.message`, etc.) y para el nombre base del bundle.
5. Métodos largos: Divida métodos extensos en varios métodos con una sola responsabilidad.
   - En la clase **ReportManager.java** se simplificó el método **processReport()** para coordinar el procesamiento, envío y guardado del reporte.
   - En la clase **OrderProcessor.java** se divide el método **calculateTotal()**, separando el cálculo de cada valor (impuesto, cargo por servicio y descuento) y la presentación de resultados en métodos independientes, cada uno con una sola responsabilidad
6. Muchos métodos (SRP): Aplique el principio de responsabilidad única por clase.
   - En la clase **ReportManager.java** se separó la lógica de envío y guardado en clases independientes.
   - En la clase **UserHandlerImpl.java** se separó la validación (`isValid`) y el manejo de error (`printErrorMessage`) para reducir responsabilidades repetidas en los métodos públicos.
   - En la clase **UserHandlerImpl.java** se encapsuló el control de flujo de usuario inválido en `hasInvalidUser(String userName)` para evitar repetir lógica condicional en cada método público.
7. Comentarios innecesarios: Elimine comentarios que expliquen lo obvio. Use código autodocumentado.
   - En el código no se encontraban comentarios innecesarios.
8. Nombres poco descriptivos: Use nombres claros y significativos para métodos y variables.
   - En la clase **DB.java**, se actualizó el nombre de los métodos para que sea más claro en cuanto a lo que se implementa.
   - En la clase **ReportManager.java**, se cambió el nombre del campo `data` y del parámetro `d` por `reportData`.
   - En la clase **UserHandlerImpl.java**, se utiliza el nombre `userName` para mejorar la claridad del parámetro.
9.  Falta de reutilización: Evite repetir lógica. Agrupe en funciones o clases comunes.
    - En la clase **DB.java**, para no recibir el nombre de la base de datos como parámetro por cada uno de sus métodos, se definió el nombre de la base de datos como un campo de la clase que se inicializa en el constructor, y este se usa en la implementación de los métodos.
   - En la clase **UserHandlerImpl.java** el bloque de validación temprana fue reutilizado en un solo método (`hasInvalidUser`) invocado desde `process()`, `notify()` y `print()`.
10. Uso incorrecto de Object: Evite usar Object sin generics. Use tipado fuerte para claridad.
    - En la clase **ReportManager.java**, se reemplaza el tipo del campo **data** para que este sea un **String** en lugar de un **Object**.
11. Modularidad violada: Separe el código en clases con una sola responsabilidad.
   - En la clase **ReportManager.java**, se crearon las clases **ConsoleReportEmailSender.java** y **DiskReportStorage.java** para separar el envío y el guardado del reporte.
   - En la clase **OrderProcessor.java**, se extrajo la lógica de impresión a la clase **OrderSummaryPrinter.java**, dejando a `OrderProcessor` con la única responsabilidad de calcular.
12. Bajo acoplamiento: Evite dependencias fuertes. Use interfaces y abstracción.
   - En la clase **ReportManager.java**, se agregaron las interfaces **ReportEmailSender.java** y **ReportStorage.java** para depender de abstracciones.
   - En la clase **DB.java**, se extrajo un método privado `log()` que centraliza la salida de mensajes, evitando repetir `System.out.println()` en cada método.
   - Se creó la interfaz **DatabaseService.java** para que cualquier clase que use una base de datos dependa del contrato y no de la implementación concreta `DB`.
13. Alta cohesión faltante: Mantenga métodos relacionados dentro de la misma clase.
   - En la clase **ReportManager.java**, se mantuvo solo la coordinación del reporte y se movieron las operaciones específicas a sus propias clases.
   - En la clase **DB.java**, se agregó el método `reconnect()` que agrupa `disconnect()` y `connect()` como una operación cohesiva dentro de la misma clase.
14. KISS (Keep It Simple, Stupid): Evite lógica compleja innecesaria. Prefiera lo simple.
   - En la clase **UserHandlerImpl.java**, la validación quedó simplificada usando `isEmpty()` y una única función reutilizable de construcción de mensajes (`buildMessage`) con `MessageFormat` sobre `ResourceBundle`.
   - En la clase **ReportManager.java**, el método `processReport()` se simplificó extrayendo el log a `logProcessing()`, dejando el flujo principal con pasos claros y directos sin lógica mezclada.
15. Boy Scout Rule: Deje el código más limpio de como lo encontró. Elimine código muerto.
   - En la clase **DB.java**, se agregó validación en el constructor para rechazar un `databaseName` nulo o vacío, dejando la clase en un estado siempre válido.
   - En la clase **ReportManager.java**, se agregó validación en `setData()` para rechazar un `reportData` nulo o vacío, evitando que la clase opere con datos inválidos.
16. Código no autodocumentado: Haga que el código se explique por sí mismo. Nombres y estructura clara.
   - En la clase **ReportManager.java**, se usaron nombres más claros como `reportData`, `emailSender` y `reportStorage`.
   - En la clase **UserHandlerImpl.java**, se agregaron tipos de retorno explícitos (`boolean` y `void`) en métodos privados para dejar el código claro y compilable.
17. Falta de interfaces o clases base: Use interfaces para separar la definición de la implementación.
   - En la clase **ReportManager.java**, se crearon las interfaces **ReportEmailSender.java** y **ReportStorage.java** para separar el contrato de la implementación.
   - Se creó la interfaz **DatabaseService.java** con los métodos `connect()`, `query()` y `disconnect()`, y **DB.java** la implementa, separando el contrato de la implementación.
   - En la carpeta **src/refactored/com/smelly/handlers** se creó la interfaz **UserHandler.java** con el contrato de `process`, `notify` y `print`, y la clase **UserHandlerImpl.java** ahora implementa esta interfaz.
