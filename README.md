# 🎧 Data-Driven Music Recommendation Engine (Java)

![Java](https://img.shields.io/badge/Java-21%2B-blue?style=for-the-badge)
![SQLite](https://img.shields.io/badge/SQLite-3.x-003B57?style=for-the-badge&logo=sqlite&logoColor=white)
![Status](https://img.shields.io/badge/status-active-success?style=for-the-badge)
![Algorithm](https://img.shields.io/badge/algorithm-cosine%20similarity-orange?style=for-the-badge)

---

<img width="1280" height="771" alt="Bildschirmfoto 2026-06-23 um 21 55 46" src="https://github.com/user-attachments/assets/2a23df1b-388c-4b28-ac35-5ae6a2c85983" />

---

## 🚀 Overview

This is a high-performance, data-driven **music recommendation engine** built in native Java. It simulates advanced, content-based filtering mechanics similar to real-world streaming services by processing large datasets through a vector-space model.

Instead of hardcoded mock data, this system connects to a local, file-based **SQLite database** containing thousands of tracks, utilizing strict mathematical models to find the perfect stylistic matches for any given input song.

---

## 🏗️ Architecture & Design Patterns

The project strictly adheres to a **3-Tier Architecture** to decouple data persistence, business logic, and presentation:

* **Data Tier (`DatabaseManager` & `CsvImporter`):** Manages connection lifecycles via JDBC, initializes relational database schemas, and pipes parsed data into SQLite.
* **Logic Tier (`SongRepository` & `VectorService`):** Functions as the data abstraction layer. Maps relational rows into highly optimized Java objects and computes spatial mathematics.
* **Presentation/Service Tier (`Main` & `RecommendationService`):** Processes the target input, calculates similarity scores, and handles duplicate-free output delivery.

---

## 🧠 Core Algorithmic Logic

### 1. Vector Space Mapping
Every song is treated as a point in a multidimensional space based on its objective acoustic metadata extracted from raw audio signals:

* **Energy** (Intensity and activity)
* **Danceability** (Rhythmic stability and beat strength)
* **Valence** (Musical positiveness/mood)
* **Tempo** (BPM scaled to vector space)
* **Acousticness** (Analog vs. synthesized tracking)
* **Instrumentalness** (Vocal presence ratio)

### 2. Cosine Similarity
To find stylistic twins, the engine does not just look at distance, but calculates the **angle between two multi-dimensional feature vectors**. This prevents tempo or volume spikes from breaking the vibe match.

The similarity score ranges from `-1.0` (complete opposite) to `1.0` (mathematical match):

$$\text{Similarity} = \frac{\mathbf{A} \cdot \mathbf{B}}{\|\mathbf{A}\| \|\mathbf{B}\|} = \frac{\sum_{i=1}^{n} A_i B_i}{\sqrt{\sum_{i=1}^{n} A_i^2} \sqrt{\sum_{i=1}^{n} B_i^2}}$$

---

## ⚙️ Data Engineering & Pipeline

To handle raw Kaggle CSV dumps, a custom **ETL (Extract, Transform, Load) Pipeline** was written into the `CsvImporter`. 

1.  **Strict Popularity Filter:** Automatically drops any obscure or sub-standard data entries ($\text{Popularity} < 55$) to focus on well-known tracks.
2.  **Algorithmic Genre-Mapping:** Normalizes messy raw tags into clean, sharp buckets (`RNB`, `HIPHOP`, `POP`).
3.  **Runtime Deduplication:** Prevents identical track titles (e.g., from album vs. single duplicates) from clogging up the recommendations using state tracking (`seenTitles`).

---

## 🔧 Technologies & Tech-Stack

* **Language:** Java 21+ (utilizing modern Stream API pipelines)
* **Database:** SQLite 3.x (Embedded relational file-database)
* **Driver/API:** JDBC (Java Database Connectivity) for batch execution execution
* **Mathematical Concept:** Vector Calculus & Cosine Similarity

---

## 🚀 How to Run

The application is structured to allow full control over the database lifecycle:

1.  **Database Reset (Manual):** Delete the generated `music.db` file from the root directory to clear out previous data states.
2.  **Execution:** Run the `main` method. The application will instantly trigger `DatabaseManager.createTable()` to construct a clean database schema and run the `CsvImporter` to parse the specified dataset path fresh into SQLite.
3.  **Processing:** The engine initializes the repositories, loads the freshly written dataset into memory, and performs vector calculations on the requested input song.
