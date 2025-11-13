# 🧠 Online Learning System (Java Project)

A simple console-based **online learning system** inspired by apps like *Duolingo* and *Sporcle*.  
The project demonstrates **object-oriented programming**, **collections**, **records**, **interfaces**, **custom exceptions**, and **clean design** in Java.

---

## 📚 Project Overview

This system models a learning platform where:
- **Teachers** can create lessons and facts.
- **Students** can complete lessons and earn achievements.
- **Subjects** group lessons by category (e.g., Geography, History, Science).
- The system tracks progress, points, and achievements for each user.

The project evolves step-by-step according to lab assignments, gradually implementing:
- Abstraction, inheritance, interfaces
- Collections (`Set`, `List`, `Map`)
- Streams, lambdas, and generics
- Checked and unchecked exceptions
- File I/O (text + binary serialization)
- Multithreading and logging

---

## 🏗️ Current Structure

### 📦 Packages


---

### 🧩 Main Classes

| Class | Description |
|-------|--------------|
| **User (abstract)** | Base class for `Student` and `Teacher`. Holds `username` and a set of `Lesson` objects. |
| **Student** | Extends `User`. Tracks completed lessons, earned achievements, and total score. |
| **Teacher** | Extends `User`. Tracks created lessons. |
| **Lesson** | Contains a name, `Fact[]` list, and reference to its creator (`Teacher`). |
| **Fact** | Record holding a `String text` and `int points`. Represents a learning item or fact within a lesson. |
| **Subject** | Record containing the subject’s name and its related lessons. |
| **Achievement** | Record containing a `name` and `requirement`. Earned by students upon reaching milestones. |

---

## 💡 Example Flow

1. The user enters **Subjects** interactively (e.g., "History", "Science").
2. Each **Teacher** creates **Lessons** and adds **Facts** to them.
3. The program allows **Students** to:
    - Choose which lessons they’ve completed.
    - Earn **Achievements** based on their progress.
4. The system can calculate each student’s *best subject* based on accumulated points.

---

## ⚙️ Key Features

✅ Object-oriented design (inheritance, abstraction)  
✅ Interfaces (including a sealed interface) and records  
✅ Custom checked & unchecked exceptions  
✅ Collections and Streams for data management  
✅ User input validation and safe parsing  
✅ Extendable architecture for later GUI (JavaFX) or DB connection

---

## 🧩 Planned Extensions

- [ ] Add user login system (with file-based credentials)
- [ ] Serialize entities to binary files for persistence
- [ ] Implement JavaFX UI
- [ ] Add database integration
- [ ] Implement parallel data refresh with threads
- [ ] Integrate Logback for logging events and exceptions

---

## 🧰 Tech Stack

- **Language:** Java 17+
- **Libraries:** Logback (for logging)
- **Tools:** IntelliJ IDEA
- **Build system:** 
- **Version Control:** Git + GitHub

---

## 🧑‍💻 Author

**Your Name**  
Student project for *Programiranje u jeziku Java*.  
Faculty: *TVZ*  
Year: 2025/2026

---

