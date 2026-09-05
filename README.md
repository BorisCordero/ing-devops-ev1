# Ingeniería DevOps - Evaluación Parcial N°1

## Microservicio m-pedidos

Proyecto realizado a partir de un microservicio desarrollado previamente en Spring Boot.  
El objetivo de esta evaluación es aplicar control de versiones con Git, una estrategia de ramificación, Pull Requests y automatización mediante GitHub Actions.

## Tecnologías

- Java 21
- Spring Boot
- Maven
- Spring Data JPA
- MySQL
- H2 para pruebas
- Git y GitHub
- GitHub Actions

## Modelos de ramificación

### GitFlow

GitFlow utiliza distintas ramas según el tipo de trabajo:

- `main`: código estable.
- `develop`: integración de cambios en desarrollo.
- `feature/*`: nuevas funcionalidades.
- `hotfix/*`: correcciones urgentes.

Permite mantener separados los cambios en desarrollo del código estable.

### GitHub Flow

GitHub Flow utiliza normalmente `main` y ramas temporales.  
Los cambios se realizan en una rama y luego se integran a `main` mediante Pull Request.

Es un flujo más simple y útil para proyectos con integraciones frecuentes.

### Trunk-Based Development

Trunk-Based Development busca integrar cambios pequeños y frecuentes en una rama principal, utilizando ramas de corta duración.

Es común en proyectos que cuentan con un alto nivel de automatización e integración continua.

## Estrategia utilizada

En este proyecto se utilizó **GitFlow**.

El flujo aplicado fue:

```text
feature/* -> develop

hotfix/* -> main
       \-> develop

develop -> main
```

### Justificación de GitFlow

> COMPLETAR PERSONALMENTE POR EL ESTUDIANTE.

## Ramas utilizadas

| Tipo | Rama |
|---|---|
| Feature | `feature/total-pedidos` |
| Feature | `feature/filtro-por-estado` |
| Hotfix | `hotfix/validacion-crear-pedido` |
| Hotfix | `hotfix/codigo-201-crear-pedido` |
| CI | `feature/pipeline-ci` |

Las features fueron integradas a `develop` mediante Pull Requests.

Los hotfixes fueron integrados primero a `main` y posteriormente a `develop`.

## Convención de ramas

Se utilizaron los siguientes formatos:

```text
feature/<nombre>
hotfix/<nombre>
```

Los nombres deben ser descriptivos, escritos en minúsculas y separados mediante guiones.

Ejemplos:

```text
feature/total-pedidos
hotfix/validacion-crear-pedido
```

## Convención de commits

Se utilizaron mensajes similares a Conventional Commits:

```text
feat: nueva funcionalidad
fix: corrección
test: pruebas
ci: integración continua
docs: documentación
```

Ejemplos utilizados:

```text
feat: agregar consulta de total de pedidos
feat: agregar filtro de pedidos por estado
fix: aplicar validacion al crear pedidos
fix: devolver 201 al crear pedidos
ci: agregar pipeline de integracion continua
```

## Flujo de merge y revisión

Los cambios se integraron utilizando Pull Requests.

Antes de realizar un merge se revisa:

- Que los cambios correspondan al objetivo de la rama.
- Que los commits sean claros.
- Que no existan archivos innecesarios.
- Que las pruebas funcionen correctamente.
- Que GitHub Actions termine correctamente.

El uso de Pull Requests permite mantener trazabilidad de los cambios realizados.

## GitHub Actions

El workflow se encuentra en:

```text
.github/workflows/ci.yml
```

Se ejecuta automáticamente cuando ocurre:

```yaml
push:
  branches:
    - develop

pull_request:
  branches:
    - main
```

El pipeline realiza las siguientes tareas:

```text
Repositorio
    ↓
Configurar Java 21
    ↓
Ejecutar pruebas
    ↓
Construir aplicación
    ↓
Generar JAR
    ↓
Guardar artefacto
```

GitHub Actions permite automatizar parte del proceso de integración continua.

En este proyecto se utiliza principalmente **CI (Integración Continua)**, ya que los cambios son validados automáticamente mediante pruebas y construcción del proyecto.

## Buenas prácticas

- Mantener `main` estable.
- Utilizar `develop` para integrar cambios.
- Crear una rama para cada feature o hotfix.
- Utilizar mensajes de commit descriptivos.
- Integrar cambios mediante Pull Requests.
- Revisar los cambios antes del merge.
- No guardar contraseñas o credenciales en Git.
- Mantener las pruebas dentro de `src/test`.
- Mantener los workflows dentro de `.github/workflows`.

## Uso de Inteligencia Artificial

Se utilizó ChatGPT como apoyo para organizar y mejorar la redacción del README y la documentación del repositorio.

El contenido fue revisado por el estudiante antes de la entrega.

Las decisiones técnicas, justificación de la estrategia y reflexión personal fueron realizadas por el estudiante.

## Reflexión individual

Con la ayuda de la cultura de devops comprendí como funciona el proceso de automatizar el despliegue de las aplicaciones para que estas no fallen y lo importante que es seguir todos los pasos para que no hayan problemas dentro del equipo de desarrollo
