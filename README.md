# Reto 2

**Arquitectura, estilo MVC (Model-View-Controller) con Strategy Pattern:**
El proyecto está estructurado en capas. En el paquete **model**, definimos el dominio: `NumericInterval` para representar los rangos y la interfaz `NumberCriteria` para encapsular la lógica de validación matemática (mitades iguales o patrones periódicos). En el paquete **view**, `ConsoleResultPrinter` se encarga de mostrar la salida al usuario. En el **controller**, `SequenceController` controla el flujo, recibe los datos crudos, los transforma en objetos de dominio y deja la ejecución a **command**.

**Principios aplicados:**
* **Responsabilidad Única (SRP):** Cada componente tiene un propósito definido. `FileContentReader` solo sabe de archivos, `SequenceController` solo controla el flujo, y las implementaciones de `NumberCriteria` solo validan números.
* **Inversión de Dependencias (DIP):** El sistema depende de abstracciones. El comando `SumMatchingNumbersCommand` no conoce la lógica específica (si es mitad repetida o periódico), solo sabe que recibe un `NumberCriteria`. Esto separa la ejecución de la validación.
* **Abierto-Cerrado (OCP):** El sistema es extensible sin modificar el código existente. Si queremos usar otro criterio solo hay que añadir una nueva clase que implemente `NumberCriteria` e inyectarla en el `Main`, sin tocar controller ni command.

**Extras:**
* **Patrón Strategy:** Implementado en `NumberCriteria`. Permite cambiar el algoritmo de validación.
* **Paquete Command:** Se usa `SumMatchingNumbersCommand` para aislar la lógica de procesamiento.
* **Java Records:** Uso de `NumericInterval` para definir objetos inmutables de datos de forma poco verbosa.
* **Streams Paralelos:** Uso de `.parallel()` y `flatMapToLong` para procesar grandes volúmenes de números de manera eficiente aprovechando los núcleos del procesador.
