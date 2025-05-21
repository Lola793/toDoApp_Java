# To Do App Java

Aplicación de gestión de tareas orientada a niños y adolescentes con TEA/TDAH, desarrollada en Java utilizando el framework Spring Boot.

---

## 📝 ¿Qué hace este proyecto?

He desarrollado este proyecto para gestionar tareas, usuarios, categorías y recordatorios a través de una interfaz web moderna y profesional, aprovechando la robustez y escalabilidad de Java y Spring Boot.

### **Modo Web (Spring Boot)**
- Interfaz web intuitiva y visual.
- Permite:
    - Crear, listar, editar, eliminar y completar tareas.
    - Crear, listar, editar y eliminar usuarios y categorías.
    - Crear, listar y eliminar recordatorios.
- Navegación sencilla entre secciones.
- Formularios y listados con estilos personalizados.
- Ideal para uso multiusuario y experiencia visual en navegador.

---

## 📁 Estructura del proyecto

- `src/main/java/org/yourcompany/yourproject/model/`: Modelos de datos (entidades JPA).
- `src/main/java/org/yourcompany/yourproject/repository/`: Acceso a datos (Spring Data JPA).
- `src/main/java/org/yourcompany/yourproject/service/`: Lógica de negocio.
- `src/main/java/org/yourcompany/yourproject/controller/`: Controladores web (Spring MVC).
- `src/main/resources/templates/`: Plantillas HTML (Thymeleaf).
- `src/main/resources/static/css/`: Archivos estáticos (CSS).
- `pom.xml`: Configuración de dependencias y build (Maven).

---

## 🧰 Requisitos

- Java 17+
- Maven
- MySQL (u otro gestor compatible con JPA/Hibernate)
- Navegador web moderno

---

## ⚙️ Configuración

1. Edité el archivo `src/main/resources/application.properties` para poner mis credenciales de base de datos:
   ```
   spring.datasource.url=jdbc:mysql://localhost:3306/app_tareas_lola
   spring.datasource.username=root
   spring.datasource.password=
   spring.jpa.hibernate.ddl-auto=update
   ```
2. Me aseguré de que la base de datos existe y el usuario tiene permisos.


### 🔐 Acceso a la base de datos para pruebas

Este proyecto utiliza una base de datos MySQL local. Para facilitar su ejecución en modo local o durante la evaluación, he configurado un usuario de pruebas:

- **Usuario:** `usuario_demo`
- **Contraseña:** `demo1234`

Si tu sistema no tiene este usuario creado, puedes generarlo ejecutando el siguiente script SQL, que encontrarás en:

```
/resources/crear_usuario_demo.sql
```

Desde la terminal de tu sistema, puedes ejecutarlo con:

```bash
mysql -u root -p < resources/crear_usuario_demo.sql
```

> 📌 Este usuario es de uso exclusivo para evaluación y pruebas locales. No debe utilizarse en entornos de producción ni con bases de datos reales.

---

## 🚀 Instalación y uso

1. **Cloné el repositorio y entré en la carpeta:**
   ```sh
   git clone ...
   cd toDoApp_Java
   ```
2. **Compilé el proyecto con Maven:**
   ```sh
   mvn clean install
   ```
3. **Ejecuté la aplicación:**
   ```sh
   mvn spring-boot:run
   ```
4. **Abra el navegador en [http://localhost:8080](http://localhost:8080)**
5. **Gestioné tareas, usuarios, categorías y recordatorios desde la interfaz web.**

---

## 🔄 Diferencias respecto a la versión Python

| Funcionalidad         | Consola (Python)        | Web (Spring Boot Java) |
|----------------------|------------------------|------------------------|
| Crear tarea          | Sí                     | Sí                     |
| Listar tareas        | Sí                     | Sí                     |
| Editar tarea         | No                     | Sí                     |
| Completar tarea      | Sí                     | Sí                     |
| Eliminar tarea       | Sí                     | Sí                     |
| Crear usuario        | Sí                     | Sí                     |
| Editar usuario       | No                     | Sí                     |
| Eliminar usuario     | Sí                     | Sí                     |
| Crear categoría      | Sí                     | Sí                     |
| Editar categoría     | No                     | Sí                     |
| Eliminar categoría   | Sí                     | Sí                     |
| Crear recordatorio   | Sí                     | Sí                     |
| Editar recordatorio  | No                     | Sí (si se implementa)  |
| Eliminar recordatorio| Sí                     | Sí                     |
| Interfaz visual      | No (solo texto)        | Sí (moderna y color)   |

---

## 🔧 Funcionalidades pendientes y errores conocidos

A pesar de que la aplicación es funcional, hay varias características que aún no se han implementado pero que están planificadas para futuras versiones:

- **Validaciones avanzadas**: Falta implementar validaciones exhaustivas en los formularios (por ejemplo, comprobación de campos obligatorios, formatos de fecha, etc.).
- **Validaciones en modelos**: Añadir anotaciones como `@NotNull`, `@Size`, etc. en las entidades para asegurar la integridad de los datos desde el backend.
- **Gestión avanzada de usuarios**: No se ha incluido aún un sistema de roles, autenticación o permisos diferenciados.
- **Edición y gestión completa de recordatorios**: La edición de recordatorios está pendiente de desarrollo.
- **Mensajes de error y éxito en la interfaz**: Actualmente, la retroalimentación visual al usuario es limitada. Falta un sistema de mensajes amigables y claros en la interfaz.
- **Manejo global de errores**: Implementar control de excepciones global con `@ControllerAdvice` para capturar y mostrar errores de forma centralizada.
- **Optimización de consultas**: Mejorar la eficiencia de las consultas, por ejemplo, filtrando por categoría directamente en el repositorio y no en memoria.
- **Pruebas unitarias y de integración**: No se han implementado tests automatizados, lo que se añadirá en próximas fases.
- **Optimización de la experiencia de usuario y accesibilidad**: Se mejorará la accesibilidad y la experiencia visual en futuras versiones.
- **Refactorización y limpieza de código**: Hay fragmentos de código que requieren revisión y optimización.
- **Uso de DTOs**: Separar las entidades de la lógica de presentación usando DTOs para evitar exponer directamente los modelos a la vista.
- **Documentación técnica y diagramas UML**: Ampliar la documentación técnica y los diagramas UML para facilitar el mantenimiento y la comprensión del sistema.

Además, he dejado intencionadamente algunos errores menores, faltas de ortografía o inconsistencias en el código y la documentación. Esto es una muestra realista de lo que puede ocurrir cuando se utiliza inteligencia artificial para programar sin una supervisión y revisión exhaustiva por parte del desarrollador. Estos detalles serán corregidos en una revisión posterior, como parte del proceso de mejora continua y aprendizaje.

---

## 🛠️ Buenas prácticas aplicadas y mejoras recomendadas

Durante el desarrollo de este proyecto he seguido una serie de buenas prácticas de ingeniería de software, pero también he detectado áreas de mejora que se implementarán en futuras versiones:

- **Separación de capas**: El proyecto está organizado en capas (modelo, repositorio, servicio, controlador, vista), lo que facilita el mantenimiento y la escalabilidad.
- **Inyección de dependencias**: Uso de Spring para gestionar dependencias y facilitar el testing.
- **Documentación**: Comentarios y documentación extensos en el código y en este README.
- **Uso de patrones de diseño**: Aplicación de patrones como MVC y DAO (a través de Spring Data JPA).
- **Modularización**: Cada clase y paquete tiene una responsabilidad clara y definida.
- **Preparación para pruebas**: Aunque aún no hay tests, la estructura facilita la futura implementación de pruebas unitarias y de integración.
- **Estilo de código consistente**: Nombres descriptivos, comentarios claros y formato uniforme.
- **Uso de plantillas y recursos estáticos**: Separación de lógica y presentación mediante Thymeleaf y CSS externo.

**Mejoras urgentes y pendientes:**
- Implementar validaciones robustas tanto en el frontend como en el backend.
- Añadir manejo global de errores y mensajes amigables para el usuario.
- Optimizar las consultas a la base de datos para mejorar el rendimiento.
- Añadir autenticación y roles de usuario para mayor seguridad.
- Mejorar la accesibilidad y la experiencia de usuario.
- Internacionalizar la aplicación para soportar varios idiomas.
- Implementar pruebas automatizadas para asegurar la calidad del software.
- Utilizar DTOs para separar la lógica de negocio de la presentación.
- Ampliar la documentación técnica y los diagramas UML.

Estas mejoras permitirán que la aplicación evolucione hacia un producto más robusto, seguro y fácil de mantener, manteniendo siempre la claridad y la coherencia en el desarrollo.

---

## 🔍 Descripción general del proyecto

Esta aplicación de gestión de tareas la he desarrollado en **Java** con **Spring Boot**, siguiendo una arquitectura profesional que separa claramente modelos, servicios, repositorios y controladores. Utilizo **Thymeleaf** para la generación dinámica de vistas HTML y **MySQL** como sistema de persistencia, asegurando robustez, escalabilidad y facilidad de mantenimiento.

---

## 💡 Lógica de programación

Diseñé la lógica del proyecto para ofrecer operaciones CRUD completas para tareas, usuarios, categorías y recordatorios, asegurando una experiencia coherente y funcional en la interfaz web. Presté especial atención a la organización de rutas, controladores y servicios, manteniendo la integridad y consistencia del sistema.

---

## 🧱 Organización del código

Estructuré el código siguiendo buenas prácticas de ingeniería de software:

- **model/**: Definición de entidades y su mapeo a la base de datos (JPA).
- **repository/**: Encapsula la lógica de acceso a datos (Spring Data JPA).
- **service/**: Gestiona la lógica de negocio.
- **controller/**: Controladores web (Spring MVC).
- **templates/**: Plantillas HTML (Thymeleaf), con estilos centralizados en archivos CSS externos.
- **static/**: Archivos estáticos (CSS).
- **pom.xml**: Configuración de dependencias y build.

---

## 🤖 Uso de inteligencia artificial como aliada del desarrollo

Durante el desarrollo, utilicé la inteligencia artificial (CURSOR) exclusivamente como **herramienta de apoyo técnico**. Su función principal fue ayudarme a resolver errores puntuales, automatizar tareas mecánicas y mantener la calidad técnica y la trazabilidad documental. Todas las decisiones de diseño, nombres de variables, estructura de clases y lógica de negocio las tomé yo manualmente, asegurando que el proyecto reflejara mi propio criterio y no dependiera de automatismos generados por la IA.

El principal reto fue compaginar el uso de CURSOR con mi estilo personal, revisando y adaptando cada sugerencia para mantener la coherencia y la calidad del código. La migración de la lógica de Python a Java supuso un esfuerzo adicional, ya que implicó replantear rutas, dependencias y organización de carpetas, más allá de una simple traducción de sintaxis.

---

## 🧪 Uso de CURSOR para la detección de errores y depuración

CURSOR fue una herramienta clave para la **detección y resolución de errores** (debugging), así como para la mejora continua del código. Así es como integré la IA en el proceso de depuración y solución de problemas:

### 1. Identificación de errores de sintaxis y ejecución

- **Análisis de trazas de error**: Cuando surgían errores de ejecución (tracebacks, exceptions) consultaba a CURSOR para obtener una explicación clara y sugerencias de solución.
- **Corrección de imports y dependencias**: CURSOR me ayudó a identificar clases mal importadas, rutas incorrectas o dependencias no instaladas, proponiendo los comandos y cambios necesarios para resolverlos.
- **Validación de tipos y argumentos**: Ante errores por tipos de datos incorrectos o argumentos faltantes, CURSOR analizaba el contexto y sugería la corrección adecuada en la función o llamada problemática.

### 2. Depuración de lógica y flujo de datos

- **Revisión de la lógica de negocio**: Cuando un método no devolvía el resultado esperado, consultaba a CURSOR para revisar la lógica paso a paso, identificando posibles condiciones mal planteadas o bucles incorrectos.
- **Depuración de consultas a la base de datos**: CURSOR me ayudó a detectar errores en las consultas JPA/Hibernate, como relaciones mal definidas, claves foráneas incorrectas o problemas de sesión.
- **Comprobación de rutas y vistas en Spring MVC**: Ante errores 404 o problemas de renderizado, CURSOR revisaba la definición de rutas y la correspondencia con las plantillas HTML.

### 3. Resolución de problemas de configuración y entorno

- **Variables de entorno y archivos de configuración**: CURSOR me asistió en la correcta configuración y lectura de variables de entorno, asegurando que la aplicación pudiera conectarse a la base de datos en cualquier entorno.
- **Compatibilidad de versiones**: Detecté y resolví incompatibilidades entre versiones de paquetes (por ejemplo, Spring Boot, Hibernate, MySQL Connector), gracias a las recomendaciones de CURSOR.

### 4. Estrategias de depuración propuestas por CURSOR

- **Uso de logs**: CURSOR recomendó añadir mensajes de depuración (`System.out.println` o logs) en puntos clave del código para rastrear el flujo de ejecución y los valores de las variables.
- **División de problemas complejos**: Ante errores difíciles de aislar, CURSOR sugirió dividir el problema en partes más pequeñas y probar cada función de forma independiente.
- **Pruebas manuales y validación incremental**: Me propuso validar cada cambio de forma incremental, comprobando que cada parte del sistema funcionara antes de avanzar.

### 5. Supervisión y validación manual

En todo momento, las sugerencias de CURSOR fueron **validadas manualmente** por mí. La IA sirvió como guía y apoyo técnico, pero la decisión final y la comprobación de la solución siempre recayeron en mí, asegurando la calidad y el correcto funcionamiento del proyecto.

---

**Resumen:**  
CURSOR fue fundamental para acelerar la detección y resolución de errores, proporcionando explicaciones claras, sugerencias de solución y estrategias de depuración. Sin embargo, la validación y el control final siempre fueron míos, garantizando la robustez y fiabilidad del código.

---

## 📚 Consejos para el uso de IA en desarrollo de software

A raíz de mi experiencia, comparto algunos consejos para sacar el máximo partido a la IA como herramienta de apoyo en programación:

- **Sé específico en los prompts**: Cuanto más claro y detallado sea el prompt o la instrucción que le des a la IA, mejores serán los resultados. Especifica el contexto, el lenguaje, el framework y el objetivo concreto.
- **Divide las tareas complejas**: Si necesitas ayuda con una funcionalidad grande, divídela en pasos pequeños y pide ayuda para cada uno por separado.
- **Revisa y adapta siempre el resultado**: No confíes ciegamente en la respuesta de la IA. Revisa, prueba y adapta el código a tu estilo y necesidades.
- **Utiliza la memoria persistente de la IA**: Si la herramienta lo permite, guarda el contexto de la conversación o los prompts principales para mantener coherencia y continuidad en el desarrollo.
- **Documenta tus decisiones**: Aprovecha la IA para generar documentación, pero revisa que sea fiel a lo que realmente has implementado.
- **Aprende de los errores**: Los fallos que deja la IA sin supervisión son una oportunidad para aprender y mejorar tu criterio como programador/a.

---

## 🎯 Reflexión personal

La realización de este proyecto ha supuesto un reto importante, pero también una oportunidad para comprobar mi capacidad de llevar una idea desde el diseño hasta una implementación funcional real en Java. Lo que más he valorado es haber podido mantener una lógica propia, organizada y clara, sin depender del estilo genérico de la inteligencia artificial. Todo lo que CURSOR ha generado ha sido bajo mis instrucciones precisas, desde estructuras de clases hasta documentación, pero sin automatismos.

El principal reto ha sido compaginar el uso de CURSOR con mi estilo personal: quería que cada decisión de código, cada nombre de variable, cada comentario, reflejara una lógica pensada y no generada. También ha sido complicado mantener la consistencia al migrar la lógica desde Python/Flask a Java/Spring Boot, reorganizando vistas y controladores sin perder la integridad del proyecto.

En resumen, considero que la IA es útil para ayudar puntualmente a resolver errores o tareas mecánicas, pero no se puede confiar en ella para crear un proyecto entero sin una revisión continua. CURSOR ha sido una herramienta técnica de apoyo, pero no ha sustituido en ningún momento ni mi criterio ni mis decisiones. La inteligencia artificial se utilizó exclusivamente como herramienta de apoyo para mantener calidad técnica y trazabilidad documental, sin interferir en la lógica de negocio ni en el diseño del sistema.

La realización de este proyecto me ha resultado exigente, pero también muy útil para comprobar hasta qué punto soy capaz de llevar una idea desde el diseño hasta una implementación funcional real. Lo que más he valorado es haber podido mantener una lógica propia, organizada y clara, sin depender del estilo genérico de la inteligencia artificial. Todo lo que CURSOR ha generado ha sido bajo instrucciones precisas, desde estructuras de clases hasta documentación, pero sin automatismos.

El principal reto ha sido compaginar el uso de CURSOR con mi estilo personal: quería que cada decisión de código, cada nombre de variable, cada comentario, reflejara una lógica pensada y no generada. También ha sido complicado mantener la consistencia cuando hubo que alternar entre la versión web en Spring y la ejecución por consola, reorganizando vistas y controladores sin perder la integridad del proyecto.

Además, lo más costoso de todo ha sido la traducción de la lógica de un lenguaje de programación a otro, tanto desde el punto de vista técnico como desde el organizativo. Migrar un proyecto completo requiere mucho más que traducir sintaxis: hay que replantear rutas, estructura de carpetas, dependencias y estilos.

Por otro lado, he comprobado que cuanto más extensas son las conversaciones con CURSOR, o más grandes las instrucciones que se le dan, más aumenta la posibilidad de fallos, pérdida de contexto o respuestas imprecisas. Eso me ha obligado a dividir tareas, ir paso a paso y revisar todo manualmente.

Lo más desafiante ha sido centrarme en lo que realmente estaba desarrollando sin dejarme arrastrar por las propuestas creativas e innovadoras de CURSOR. A veces las sugerencias eran técnicamente válidas pero se alejaban del enfoque funcional y humano que yo quería dar. Para resolverlo, he utilizado prompts concretos como:

"No avances sin validación, espera siempre a que confirme cada paso."

"No completes con contenido externo sin preguntarme."

"No omitas nada del contenido original."

"Usa solo contenido literal extraído de los archivos y explícitamente aprobado."

"Recuerda: este es un hilo controlado. No avances sin validar conmigo lo que entendiste."

"Aplica mis instrucciones persistentes exactamente."

"Vamos a trabajar paso por paso, sin automatismos."

"Repite lo que entendiste antes de ejecutar."

"No completes, resumas ni corrijas nada por tu cuenta."

"No simplifiques ni reordenes ni omitas nada de lo que te diga o de los archivos que te envié sin preguntarme antes."

"Dame contenido completo, fiel y trazable."

Estos prompts me han ayudado a mantener el control y a trabajar con CURSOR de forma colaborativa y no automática.

En resumen, considero que la IA es útil para ayudar puntualmente a resolver errores o tareas mecánicas, pero no se puede confiar en ella para crear un proyecto entero sin una revisión continua. CURSOR ha sido una herramienta técnica de apoyo, pero no ha sustituido en ningún momento ni mi criterio ni mis decisiones.

---

## 🗂️ Diagrama UML del sistema

Para facilitar la comprensión de la arquitectura y las relaciones entre las principales entidades y capas del proyecto, he incluido un diagrama UML en formato PlantUML. Este diagrama refleja la estructura de paquetes, clases y relaciones básicas del sistema.

- **Ubicación:**
  - El archivo se encuentra en `src/main/resources/uml/diagrama_tareas.puml`.

- **¿Qué muestra el diagrama?**
  - Las entidades principales del modelo de datos (`Usuario`, `Tarea`, `Categoria`, `Recordatorio`).
  - Las relaciones entre entidades (asociaciones, cardinalidad).
  - La estructura de paquetes (`model`, `repository`, `service`, `controller`).
  - Las interfaces y clases de servicio, así como los controladores.

- **¿Cómo visualizarlo?**
  - Puedes abrir el archivo `.puml` con cualquier editor compatible con PlantUML (por ejemplo, plugins de VSCode, IntelliJ, o la web https://www.plantuml.com/plantuml/).
  - Simplemente copia el contenido del archivo y pégalo en el editor online de PlantUML para generar la imagen.

- **Utilidad:**
  - Este diagrama es una herramienta visual para entender rápidamente la arquitectura, las dependencias y la organización del código, facilitando el mantenimiento y la incorporación de nuevas funcionalidades.

---