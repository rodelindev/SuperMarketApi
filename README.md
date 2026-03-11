# SuperMarket API 🛒

API REST desarrollada con **Spring Boot** para gestionar productos, autenticación y operaciones relacionadas con un sistema de supermercado.
El proyecto incluye autenticación basada en **JWT**, seguridad con **Spring Security** y documentación interactiva con **Swagger/OpenAPI**.

---

# 🚀 Tecnologías utilizadas

* Java 25
* Spring Boot 4
* Spring Security
* JWT Authentication
* Maven
* Swagger / OpenAPI
* BCrypt Password Encoder

---

# 📦 Instalación

### 1. Clonar el repositorio

```bash
git clone https://github.com/rodelindev/SuperMarketApi
```

### 2. Entrar al directorio del proyecto

```bash
cd SuperMarketApi
```

### 3. Ejecutar la aplicación

```bash
mvn spring-boot:run
```

La aplicación se ejecutará en:

```
http://localhost:8095
```

---

# 🔐 Autenticación

La API utiliza autenticación basada en **JWT (JSON Web Token)**.

### Endpoint de Login

```
POST /login
```

### Ejemplo de Request

```json
{
  "username": "admin",
  "password": "1234"
}
```

### Ejemplo de Response

```json
{
  "token": "jwt_token_aqui"
}
```

---

# 🔑 Usar el Token

Después de obtener el token, debes enviarlo en el header de cada petición protegida.

Ejemplo:

```
Authorization: Bearer <token>
```

---

# 📚 Documentación de la API

La documentación interactiva de la API está disponible con Swagger.

Abrir en el navegador:

```
http://localhost:8080/swagger-ui/index.html
```

Desde ahí puedes:

* Ver todos los endpoints
* Probar las APIs
* Enviar tokens JWT
* Revisar los modelos de datos

---

# 📂 Estructura del Proyecto

```
src/main/java/com/rodelindev/SuperMarketApi

│
├── controller
│     Controladores REST de la API
│
├── service
│     Lógica de negocio
│
├── repository
│     Acceso a datos
│
├── security
│     Configuración de JWT y filtros de seguridad
│
└── config
      Configuraciones generales del sistema
```

---

# 🧪 Ejecutar pruebas

Para ejecutar las pruebas del proyecto:

```bash
mvn test
```

---

# ⚙️ Variables de entorno (opcional)

Puedes configurar variables como:

```
DB_URL=jdbc:postgresql://localhost:5432/SuperMarketDB
DB_USER_NAME=database_user_name
DB_PASSWORD=database_password
JWT_SECRET=your_secret_key
SPRING_PROFILES_ACTIVE=dev
```

---

# 👨‍💻 Autor

**Rodelin Dipre**

Desarrollador de aplicaciones móviles y backend interesado en crear APIs seguras y escalables.

---

