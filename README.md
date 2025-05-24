# CourierSync
# 📦 CourierSync – Feature 2: Gestión de Entregas

Este repositorio forma parte del proyecto *CourierSync_V1*, desarrollado como implementación práctica dentro del modelo de Fábrica Escuela de Ingeniería de Sistemas. Nos enfocamos en aplicar metodologías ágiles bajo el marco de trabajo **Scrum**, y esta sección corresponde al trabajo realizado por el **equipo de arquitectura de software** en el **Sprint 1**, para la **FEATURE 2 – Gestión de Entregas**.

---

## ✅ Entregables Sprint 1 – Arquitectura de Software

### 1. 📌 Contexto del Sistema y Alcance General

**Descripción**:  
La Feature 2 permite registrar, consultar, actualizar y gestionar el estado de las entregas realizadas por los couriers a los clientes. Esta funcionalidad es fundamental para llevar un control de las entregas asignadas y garantizar trazabilidad.

**Diagrama de Contexto**:  
Incluye actores como:
- Courier  
- Cliente  
- Administrador del sistema  
- Sistema externo (si aplica)

Representa la interacción entre estos actores y el sistema para procesos como asignación de entregas, cambios de estado y consulta de información.

---

### 2. 🛠️ Requisitos Arquitectónicos

**Requisitos No Funcionales**:
- **Escalabilidad**: Soporte para múltiples entregas simultáneas.
- **Disponibilidad**: Alta disponibilidad para actualizaciones en tiempo real.
- **Seguridad**: Acceso autenticado por roles.

**Restricciones Técnicas**:
- Lenguaje: `Java + Spring Boot`
- Base de Datos: `PostgreSQL`
- Arquitectura: Microservicios

---

### 3. 🧱 Estilos y Patrones Arquitectónicos

**Estilo adoptado**:
- Microservicios (cada feature como servicio independiente)

**Patrones aplicados**:
- Repositorio
- Servicio (Service Layer)
- Controlador (Controller)
- API Gateway
- CQRS (si aplica)

---

### 4. 📁 Vista de Paquetes (UML)

Organización modular del microservicio `entregas`, dividiendo la lógica en:

- `entregas.controller`: Manejo de peticiones REST.
- `entregas.service`: Lógica de negocio (validaciones, flujo de estado).
- `entregas.repository`: Acceso y persistencia de datos.
- `entregas.model`: Entidades como `Entrega`, `EstadoEntrega`, `Vehiculo`.

> Diagrama generado en PlantUML con estilo visual de carpetas y relaciones entre paquetes.

---

### 5. 🧩 Vista de Componentes (UML)

Representación de los principales componentes del microservicio:

- `EntregaController`
- `EntregaService`
- `NotificadorDeEntrega`
- `EntregaRepository`
- Base de datos

> Se muestran las dependencias entre componentes y flujos de interacción internos.

---

### 6. ☁️ Vista de Despliegue

Despliegue del microservicio de entregas usando contenedores y arquitectura basada en servicios:

- `API Gateway` (Nginx / Zuul)
- `Contenedor Docker: entregas.jar`
- `Base de Datos PostgreSQL`
- `Servidor Kubernetes` o plataforma cloud

> Incluye nodo lógico, artefactos desplegados y conectividad entre capas.

---

### 7. 🔌 Definición Inicial de APIs (REST)

| Método | Endpoint                       | Descripción                          |
|--------|--------------------------------|--------------------------------------|
| POST   | `/entregas`                   | Registrar nueva entrega              |
| GET    | `/entregas/{id}`             | Consultar información de una entrega |
| PUT    | `/entregas/{id}`             | Actualizar estado de entrega         |
| GET    | `/entregas/courier/{id}`     | Consultar entregas por courier       |

> Documentación futura en OpenAPI (Swagger).

---

### 🚀 Herramientas Utilizadas

- **Lenguaje**: Java
- **Framework**: Spring Boot
- **Base de Datos**: PostgreSQL
- **Contenerización**: Docker
- **Diagramas**: PlantUML

---

### 🧠 Autor del módulo de arquitectura

> Responsable del diseño y documentación arquitectónica de la Feature 2 durante el Sprint 1.

---

