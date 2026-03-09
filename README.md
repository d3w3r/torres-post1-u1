## Analisis de Violaciones SOLID

| Principio | Metodo/Seccion afectada                                                    | Descripcion de la Violacion                                                                                                         |
|-----------|----------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------|
| SRP       | "saveOrder", "sendEmail", "printReport", "calculateTotal", "applyDiscount" | Estos metodos no estan relacionados entonces deberian ser manejados independientemente.                                             |
| OCP       | "applyDiscount"                                                            | En la logica del metodo se aplican variaciones de descuentos fijos pero si anaden mas se debe modificar el metodo.                  |
| DIP       | Seccion completa del servicio                                              | Todos los metodos estan destinados a ser dependencias de una tarea general pero no estan inyectadas sino implicitamente declaradas. |

## Instrucciones de ejecucion

Luego de tener el repositorio instalado y listo para la ejecucion debemos ejecutar los siguientes comandos:

1. Instalacion en limpio `mvn clean install`.
2. Compilacion del proyecto `mvn compile`.
3. Ejecucion del proyecto `mvn exec:java -Dexec.mainClass=com.patrones.u1.App`.

## Resultados