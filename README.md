# BookForum - RESTful API for Book Management

A Java Spring Boot RESTful API for managing a book collection with input validation and in-memory storage.

## Technologies Used

- Java 21
- Spring Boot 4.0.2
- Maven
- Lombok
- Jakarta Validation (Bean Validation)

---

## Testing the API

### Option 1: Postman (Step-by-Step)

### Add Book:
**Step 1:** Paste the endpoint URL in the address bar
```
POST http://localhost:8080/api/add-book
```

**Step 2:** Click on the **Body** tab

**Step 3:** Select **raw** format

**Step 4:** Paste the JSON directly into the raw field:
```json
{
  "title": "1984",
  "author": "George Orwell",
  "description": "A dystopian novel about totalitarianism",
  "category": "Science Fiction"
}
```

**Step 5:** Click the **Send** button

**Step 6:** Check the response (200 OK = success)

See the image below for visual reference:

![Postman Add Book Example](postman-add-book-example.png)

---

### Get Book:

**Step 1:** Change request method to **GET**

**Step 2:** Paste the endpoint URL with a book ID:
```
GET http://localhost:8080/api/get-book/1
```

**Step 3:** Click the **Send** button

**Step 4:** You'll see the book details in the response (200 OK)

See the image below for visual reference:

![Postman Get Book Example](image-1.png)
### Option 2: cURL

```bash
# Add a book
curl -X POST http://localhost:8080/api/add-book \
  -H "Content-Type: application/json" \
  -d '{"title":"1984","author":"George Orwell","description":"Dystopian novel","category":"Science Fiction"}'

# Get book by ID
curl http://localhost:8080/api/get-book/1
```

### Option 3: PowerShell

```powershell
# Add a book
Invoke-WebRequest -Method Post -Uri http://localhost:8080/api/add-book `
  -ContentType "application/json" -UseBasicParsing `
  -Body '{"title":"1984","author":"George Orwell","description":"Dystopian novel","category":"Science Fiction"}'

# Get book by ID
Invoke-RestMethod -Method Get -Uri http://localhost:8080/api/get-book/1
```

---

## API Endpoints

### 1. Add a Book

**POST** `/api/add-book`

**Request Body:**
```json
{
  "title": "The Great Gatsby",
  "author": "F. Scott Fitzgerald",
  "description": "A classic American novel",
  "category": "Fiction"
}
```

**Response:** `200 OK` (empty body)

---

### 2. Get a Book by ID

**GET** `/api/get-book/{bookId}`

**Success Response:** `200 OK`
```json
{
  "bookId": 1,
  "title": "The Great Gatsby",
  "author": "F. Scott Fitzgerald",
  "description": "A classic American novel",
  "category": "Fiction"
}
```

**Not Found:** `204 No Content`

---

## Input Validation

| Field | Rules |
|-------|-------|
| `title` | Required, 2-200 characters |
| `author` | Required, 2-100 characters |
| `description` | Optional, max 1000 characters |
| `category` | Required, max 100 characters |

**Validation Error Response:** `400 Bad Request`
```json
{
  "title": "Title is required"
}
```

---

## Implementation Summary

✅ **Book Model** - Java class with id, title, author, description, category  
✅ **In-Memory Storage** - HashMap with auto-generated IDs (AtomicInteger)  
✅ **REST Endpoints** - Add book, Get book by ID  
✅ **Input Validation** - Bean Validation with detailed error messages  
✅ **Exception Handling** - GlobalExceptionHandler for validation errors

**Data Storage:** In-memory HashMap (data resets on restart)  
**ID Generation:** Auto-incremented starting from 1

---

## How to Run from Scratch

**Prerequisites:** Java 21 or higher

**Start the application:**

Windows:
```bash
.\mvnw.cmd spring-boot:run
```

Linux/Mac:
```bash
./mvnw spring-boot:run
```

The application starts at `http://localhost:8080`

---

