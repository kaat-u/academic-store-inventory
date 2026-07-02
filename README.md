# Academic Store Inventory

Sistema de gestión de productos para una tienda académica, desarrollado en Java como parte de la evaluación del curso de Programación Orientada a Objetos.

## Objetivo

Diseñar e implementar una solución en Java que integre colecciones de objetos y una jerarquía de clases, aplicando herencia, clase abstracta, interfaz y sobrescritura de métodos, para registrar, almacenar y consultar productos de una tienda académica.

## Integrantes y matriz de participación

| Nombre | Rol / Módulo desarrollado | % de participación |
|---|---|---|
| Fabricio | Jerarquía de clases (Producto, subclases, interfaz) | 25% |
| Katty | Colecciones y unicidad (List, HashSet) | 25% |
| Rodrigo | Búsqueda, ordenamiento y menú | 25% |
| Gustavo | Integración, pruebas, README y video | 25% |

## División de tareas

| Integrante | Módulo asignado | Detalle |
|---|---|---|
| Integrante 1 | Jerarquía de clases | Diseño e implementación de `Producto` (clase abstracta), `ProductoFisico`, `ProductoDigital` y la interfaz `Descontable`, incluyendo la sobrescritura de `mostrarInfo()` en cada subclase. |
| Integrante 2 | Colecciones y unicidad | Implementación de `List<Producto>` para el registro de productos y `HashSet<String>` para validar la unicidad del código antes de agregar un nuevo producto. |
| Integrante 3 | Búsqueda, ordenamiento y menú | Implementación de la búsqueda por código y por nombre, el ordenamiento con `Comparator`, y el menú de consola que conecta registrar, listar, buscar y ordenar. |
| Integrante 4 | Integración, pruebas y documentación | Integración de los módulos anteriores en un solo proyecto funcional, pruebas del flujo completo, redacción del README y coordinación de la grabación del video. |

## Descripción de la solución

El sistema permite registrar, listar, buscar y ordenar productos de una tienda académica. Se modeló una jerarquía de clases con:

- Producto (clase abstracta, paquete com.lideratec.model): define los atributos y comportamientos comunes a todos los productos.
- ProductoFisico y ProductoDigital (clases derivadas, paquete com.lideratec.model): representan tipos distintos de producto, cada una sobrescribiendo el método mostrarInfo().
- Descontable (interfaz, paquete com.lideratec.interfaces): define el comportamiento obligatorio aplicarDescuento(), implementado por las clases de producto.

La lógica de negocio se encapsula en la clase Inventario (paquete com.lideratec.service), que gestiona el registro, búsqueda y ordenamiento de productos. Para el almacenamiento se utilizó:
- Una colección genérica (List<Producto>) para registrar todos los productos.
- Un HashSet<String> para validar la unicidad del código de producto antes de registrarlo.

El sistema implementa además una búsqueda por código/nombre y un ordenamiento sobre la colección de productos.

## Decisiones técnicas tomadas por el equipo

(Completar: por qué eligieron esos dos tipos de producto, por qué esa clase abstracta, qué criterio usaron para el ordenamiento, etc.)

## Instrucciones de ejecución

1. Clonar el repositorio:
   ```bash
   git clone https://github.com/usuario/academic-store-inventory.git
   ```
2. Abrir el proyecto en IntelliJ IDEA (Open > seleccionar la carpeta del proyecto; IntelliJ detectará el `pom.xml` y lo importará como proyecto Maven).
3. Esperar a que Maven descargue las dependencias e indexe el proyecto.
4. Ubicar la clase `Main` en `src/main/java/com/lideratec/Main.java`.
5. Ejecutar la clase `Main` (Run > Run 'Main.main()' o botón de play sobre la clase).

## Video de explicación

Enlace del video: (agregar enlace de YouTube aquí - cámaras encendidas, explicando cómo resolvieron la evaluación, por qué llegaron a esa solución y qué decisiones tomaron)

## Estructura del proyecto

```
academic-store-inventory/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── lideratec/
│       │           ├── Main.java
│       │           ├── model/
│       │           │   ├── Producto.java
│       │           │   ├── ProductoFisico.java
│       │           │   └── ProductoDigital.java
│       │           ├── interfaces/
│       │           │   └── Descontable.java
│       │           └── service/
│       │               └── Inventario.java
│       └── resources/
├── pom.xml
├── README.md
└── .gitignore
```

## Curso

Programación Orientada a Objetos
