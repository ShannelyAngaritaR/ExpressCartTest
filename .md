# Proyecto de Automatización de Pruebas para ExpressCart

## Reto Técnico

### Objetivo del Reto
Evaluar tus habilidades prácticas en desarrollo y automatización de pruebas, organización de un flujo de trabajo eficiente y la capacidad de implementar una solución de testing estructurada en un entorno CI/CD.

### Descripción del Reto
Estás encargado de diseñar y ejecutar un conjunto de pruebas automatizadas para el módulo de carrito de compras de una aplicación de e-commerce. Deberás estructurar las pruebas, implementar un pipeline en Azure DevOps y configurar la ejecución en paralelo para optimizar el tiempo de prueba.

## Aplicación a Probar
Utilizarás la aplicación web de e-commerce open-source **expressCart**, disponible en GitHub:
- Repositorio de la aplicación: [expressCart](https://github.com/mrvautin/expressCart)

## Repositorio de Pruebas Automatizadas
El repositorio de las pruebas automatizadas está disponible en el siguiente enlace:
- [ExpressCartTest](https://github.com/ShannelyAngaritaR/ExpressCartTest.git)

## Estructura del Proyecto
El proyecto está organizado de la siguiente manera:

src/test/java/com
src/test/java/com/pages --- la logica del proyecto
src/test/java/com/test --- la ejecucion de los test de prueba
src/test/java/com/utils --- la insercion de data, para la correcta ejecucion de las pruebas
src/main/java/com/config/MongoDBConnection.java --- la conexion a la base de datos
src/test/resources/junit-platform.properties --- Ajuste de propiedades para la ejecución de pruebas en paralelo


## Pasos para Ejecutar las Pruebas Localmente

Para ejecutar las pruebas automatizadas en tu entorno local, sigue estos pasos:

### Requisitos Previos

1. **Instalar Java JDK**: Asegúrate de tener instalada la versión 17 del JDK de Java. Puedes descargarla desde [aquí](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html) o utilizar un gestor de paquetes adecuado para tu sistema operativo.

2. **Instalar Maven**: Necesitarás Maven para gestionar las dependencias y ejecutar las pruebas. Puedes descargarlo desde [aquí](https://maven.apache.org/download.cgi) y seguir las instrucciones de instalación.

3. **Instalar MongoDB**: Asegúrate de tener MongoDB instalado y en ejecución en tu máquina. Puedes descargarlo desde [aquí](https://www.mongodb.com/try/download/community) y seguir las instrucciones de instalación.

4. **Node.js**: Instala [Node.js](https://nodejs.org/) si no lo tienes, ya que algunas dependencias pueden requerirlo.

### Clonar el Repositorio

## Instrucciones para Ejecutar la Prueba correctamente

 Para ejecutar la aplicación de e-commerce ExpressCart en tu entorno local, sigue estos pasos: 
1. Clonar el Repositorio: Clona el repositorio de la aplicación utilizando el siguiente comando: `git clone https://github.com/mrvautin/expressCart.git` 
2. Entrar en el Directorio del Proyecto: Navega al directorio del proyecto con el siguiente comando: `cd expressCart`
3. Instalar las Dependencias: Instala las dependencias del proyecto utilizando npm: `npm install` 
4. Configurar la Aplicación: Antes de ejecutar la aplicación, es necesario realizar algunas configuraciones: - **Renombrar el Archivo de Configuración**: Renombra el archivo de configuración predeterminado: `mv config/config.default.js config/config.js` - **Editar el Archivo de Configuración**: Abre el archivo `config/settings.json` en un editor de texto y ajusta la configuración según tus necesidades. 
     Algunos parámetros importantes que debes considerar son: 
     - cartTitle: Título del carrito que se muestra en la página y es importante para SEO. 
     - currencySymbol: Símbolo de la moneda el cual debe ser *$* para que las pruebas funciones correctamente. 
     - currencyISO: Código ISO de la moneda (por ejemplo, USD, EUR, GBP). 
     - maxQuantity: Máxima cantidad permitida de un producto en el carrito (para el correcto funcionamiendo debe de ser de *25*)
     - Configurar la Conexión a la Base de Datos MongoDB**: Asegúrate de configurar la cadena de conexión a la base de datos MongoDB en `settings.json` bajo `"databaseConnectionString"`
     - Por defecto, debería ser: `"databaseConnectionString": "mongodb://127.0.0.1:27017/expresscart"` 
5. Iniciar la Aplicación: Una vez configurada la aplicación, puedes iniciar el servidor de desarrollo con el siguiente comando: `npm start`

## No es necesario hacer ajustes desde ADMIN ya que para el correcto funcionamiento y mayor accesiblidad de las pruebas, la crecion de los productos se hace directamente desde la base de datos##

6. **Clona el repositorio de pruebas automatizadas:**
   ```bash
   git clone https://github.com/ShannelyAngaritaR/ExpressCartTest.git
   
7. **Entra en el directorio del repositorio de pruebas:**
    - cd ExpressCartTest

8. **Instala las dependencias de pruebas: Si es necesario, instala las dependencias para el proyecto de pruebas:**
    - npm install

9. **Ejecuta las pruebas automatizadas: Utiliza el siguiente comando para ejecutar las pruebas:**
     - mvn test

## Pasos para Ejecutar el Pipeline en Azure DevOps

1. **Sube el repositorio a Azure DevOps**:
    - Inicia sesión en tu cuenta de Azure DevOps.
    - Crea un nuevo proyecto o selecciona uno existente.
    - Navega a la sección de "Repositorios" y elige la opción para importar un repositorio.
    - Proporciona la URL de tu repositorio de pruebas automatizadas y sigue las instrucciones para completar la importación.

2. **Copia el archivo de pipeline**:
    - Asegúrate de que el archivo `azure-pipelines.yml` esté en la raíz de tu repositorio.
    - Si no está presente, crea un nuevo archivo llamado `azure-pipelines.yml` y copia la configuración necesaria desde tu proyecto.
    - SE creo otro archivo  azure-pipelines2.yml en caso de tambien querer ejecutar los demas casos de prueba
3. **Configura el Pipeline**:
    - En tu proyecto de Azure DevOps, dirígete a la sección "Pipelines".
    - Haz clic en "New pipeline" para crear un nuevo pipeline.
    - Selecciona la opción "Azure Repos Git" y elige el repositorio que subiste.
    - Cuando se te pida, selecciona "Existing Azure Pipelines YAML file" y elige `azure-pipelines.yml`.
    - Revisa y confirma la configuración del pipeline.

4. **Crea el Agente Pool**:
    - Navega a "Project Settings" en la parte inferior izquierda de Azure DevOps.
    - Selecciona "Agent pools" y haz clic en "Add pool" para crear un nuevo pool de agentes.
    - Sigue las instrucciones para instalar el agente en tu máquina local. Puedes encontrar guías en la documentación de Azure sobre cómo hacerlo.
    - Una vez instalado, verifica la conexión del agente desde Azure DevOps asegurándote de que esté en línea y pueda comunicarse con tu cuenta.

5. **Ejecuta la página del carrito**:
    - Asegúrate de que la aplicación del carrito de compras esté en ejecución localmente. Inicia el servidor de la aplicación si aún no lo has hecho.
    - Verifica que puedas acceder a la aplicación en el navegador en la dirección que configuraste (por ejemplo, `http://localhost:1111`).

6. **Ejecuta las pruebas del pipeline**:
    - Regresa a Azure DevOps y ve a la sección "Pipelines".
    - Haz clic en el pipeline que configuraste y selecciona "Run pipeline".
    - Asegúrate de que el pipeline se ejecute correctamente y revisa los logs para verificar que todas las pruebas se ejecuten sin errores.
    - Si se presentan errores, revisa los mensajes en los logs para identificar la causa y ajustar tu configuración según sea necesario.


## Configuración del Paralelismo

Para habilitar la ejecución en paralelo de las pruebas automatizadas en nuestro proyecto, se utilizó JUnit 5 en conjunto con Selenium. La configuración se realiza en el archivo `junit-platform.properties`, donde se especifican los parámetros necesarios para controlar el comportamiento del paralelismo.

### Detalles de la Configuración

1. **Archivo `junit-platform.properties`**:
   Este archivo se encuentra en la ruta `src/test/resources`. Asegúrate de que esté presente y correctamente configurado para habilitar la ejecución en paralelo.

2. **Configuración en `junit-platform.properties`**:
   En este archivo, puedes agregar las siguientes propiedades para ajustar el paralelismo:

   ```properties
   junit.jupiter.execution.parallel.enabled = true
   junit.jupiter.execution.parallel.mode.default = concurrent
   junit.jupiter.execution.parallel.config.strategy = fixed
   junit.jupiter.execution.parallel.config.fixed.parallelism = 4


## Manejo y Registro de Errores en Pruebas

El manejo y registro de errores es crucial en cualquier proyecto de software, especialmente en el contexto de pruebas. Este proceso garantiza que los desarrolladores y probadores puedan identificar, diagnosticar y corregir problemas de manera eficiente. A continuación se detalla cómo se manejan las excepciones y errores, centrándonos en el error 500 y el uso de una prueba de reintento.

### 1. Generación de un Error Controlado

En el archivo `index.js` del proyecto `expressCart`, se ha insertado un fragmento de código para generar un error controlado. Este enfoque permite simular un error 500 (Error Interno del Servidor) de forma que sea informativa y manejable para el usuario. El código insertado es el siguiente:


if (req.params.page === 'causeError') {
    res.status(500).render('error', {
        title: '500 Error - Internal Server Error',
        config: req.app.config,
        message: 'Oops! Algo salió mal en el servidor. Por favor, inténtalo de nuevo más tarde.',
        helpers: req.handlebars.helpers,
        showFooter: 'showFooter',
        menu: sortMenu(await getMenu(db))
    });
    return;
}

Este fragmento de código se encarga de:

Detectar la Condición de Error: Cuando la ruta solicitada es causeError, se genera un error intencionalmente.
Enviar una Respuesta Adecuada: En lugar de simplemente lanzar una excepción, se devuelve un código de estado 500 y se renderiza una página de error amigable para el usuario, que explica que ha ocurrido un problema y sugiere que intente nuevamente más tarde.
