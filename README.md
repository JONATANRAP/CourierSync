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
- Generación de rutas en menos de 3 segundos  
- Alta disponibilidad: 99.9%  
- Escalabilidad para múltiples solicitudes concurrentes  
- Seguridad: cifrado y autenticación por roles

### ⚙️ Restricciones Técnicas:
- Lenguaje: Java 17  
- Framework: Spring Boot  
- Base de datos: PostgreSQL  
- ORM: Hibernate (JPA)  
- API: RESTful (Spring MVC)  
- Seguridad: Spring Security + JWT  
- Otros: Lombok, ModelMapper  

---

## 🧱 Estilos y Patrones Arquitectónicos

### 🧩 Arquitectura en Capas:
- **Controller:** Control de entrada/salida HTTP  
- **Service:** Lógica de negocio  
- **Repository:** Persistencia con JPA  
- **Model/DTO:** Datos y transferencia  
- **Security/Exception:** Seguridad y errores globales

### 🔁 Patrones Aplicados:
- DTO (Data Transfer Object)  
- Repository Pattern  
- Seguridad basada en JWT  
- Inyección de Dependencias (IoC)  

---

## 📦 Vista de Paquetes

El backend está dividido en los siguientes paquetes:

- `controller`: Manejo de endpoints HTTP  
- `service`: Lógica del sistema (negocio)  
- `repository`: Acceso a datos y queries  
- `model`: Entidades JPA (tablas)  
- `dto`: Transferencia de datos entre capas  
- `security`: JWT y filtros de seguridad  
- `exception`: Captura de errores personalizados  

---

## 🧩 Vista de Componentes

Relaciones entre paquetes principales:

