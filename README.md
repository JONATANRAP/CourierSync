
````markdown
# 📦 CourierSync – Sprint 1  
## 🚀 Feature: Optimización de Rutas  

### 👥 Estudiantes:
- Cristian Agudelo Márquez  
- Jonatan Romero Arrieta  

### 👨‍🏫 Profesor:
- Diego Botia  
- Universidad de Antioquia – Facultad de Ingeniería  

---

## 📌 Contexto del Sistema

La feature **"Optimización de Rutas"** forma parte del sistema **CourierSync**, diseñado para mejorar la eficiencia logística de una empresa de transporte. Permite calcular rutas óptimas considerando distancia, tráfico y prioridad de entrega.

### ✅ Problemas que resuelve:
- Reducción de tiempos de entrega  
- Ahorro de combustible  
- Mejor uso de recursos (vehículos y conductores)  
- Mayor trazabilidad de rutas  

### 👤 Principales usuarios:
- Administradores logísticos  
- Conductores  
- Operadores de monitoreo  

---

## 🏗️ Requisitos Arquitectónicos

### ✅ No Funcionales:
- ⏱️ Generación de rutas en < 3 segundos  
- 📶 Disponibilidad ≥ 99.9%  
- ⚙️ Escalabilidad concurrente  
- 🔐 Seguridad por roles y cifrado de datos  

### ⚙️ Restricciones Técnicas:
- Lenguaje: Java 17  
- Framework: Spring Boot  
- Base de datos: PostgreSQL (con soporte geoespacial)  
- ORM: Hibernate (JPA) con Spring Data  
- API: RESTful (controladores Spring MVC)  
- Seguridad: Spring Security + JWT  
- Notificaciones: Twilio o SendGrid  
- Herramientas extra: Lombok, ModelMapper  

---

## 🧱 Estilos y Patrones Arquitectónicos

- **Arquitectura en Capas**:  
  - `controller`: presentación  
  - `service`: lógica de negocio  
  - `repository`: acceso a datos  
  - `model`, `dto`: dominio y transporte  
  - `security`, `exception`: capas transversales  

- **Patrones Aplicados**:
  - Controlador–Servicio–Repositorio  
  - DTO (Data Transfer Object)  
  - Seguridad con JWT  
  - Inyección de Dependencias (IoC)

---

## 🧩 Vista de Paquetes

> El sistema está modularizado en paquetes según su responsabilidad:
- `controller`: entrada de solicitudes HTTP  
- `service`: lógica central del sistema  
- `repository`: acceso a base de datos  
- `dto`: objetos de transferencia  
- `model`: entidades JPA  
- `security`: configuración de seguridad y JWT  
- `exception`: manejo global de errores

---

## 🧩 Vista de Componentes

> Este diagrama representa los módulos principales del backend:
- `controller` → depende de `service`  
- `service` → consume `repository` y `dto`  
- `repository` → interactúa con `model`  
- `exception` y `security` son capas transversales

---

## 🚀 Vista de Despliegue

> Representa los componentes físicos y servicios externos:
- 🌐 **Frontend** (Next.js) en [Vercel](https://vercel.com)  
- ⚙️ **Backend** (Spring Boot) en [Render](https://render.com)  
- 🗃️ **Base de datos PostgreSQL** en [Railway](https://railway.app)  
- 🌐 Comunicación: HTTPS / REST API

---

## 📚 Definición Inicial de APIs

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| POST | `/api/auth/register` | Registrar usuario |
| POST | `/api/auth/login` | Login con token |
| GET | `/api/users` | Listar todos los usuarios |
| GET | `/api/users/{id}` | Buscar usuario por ID |
| PUT | `/api/users/{id}` | Actualizar usuario |
| DELETE | `/api/users/{id}` | Eliminar usuario |
| POST | `/roles` | Crear rol |
| PUT | `/roles/{id}` | Actualizar rol |
| DELETE | `/roles/{id}` | Eliminar rol |
| GET | `/roles` | Listar roles |

> ℹ️ Todos los endpoints protegidos requieren token Bearer y rol “administrator”.

---

## 🧪 Consultas al Backend

- 🔗 URL Base: `https://couriersync.onrender.com`

### Ejemplo Login:
```json
POST /api/auth/login
{
  "email": "admin@email.com",
  "password": "123456"
}
````

🔐 Respuesta:

```json
{
  "token": "eyJhbGciOiJIUzUxMiJ9...",
  "role": "administrator"
}
```

### Ejemplo Listado de Usuarios:

```http
GET /api/users
Authorization: Bearer <token>
```

---

## ✅ Herramienta de Diagramación

Los diagramas UML fueron elaborados con **Enterprise Architect**.

```

---

¿Deseas también que te genere el `README.md` como archivo descargable? Puedo hacerlo.
```

