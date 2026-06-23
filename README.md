# 🎧 Music Recommendation System (Java)

![Java](https://img.shields.io/badge/Java-17%2B-blue?style=for-the-badge)
![Status](https://img.shields.io/badge/status-active-success?style=for-the-badge)
![Algorithm](https://img.shields.io/badge/algorithm-cosine%20similarity-orange?style=for-the-badge)
![Type](https://img.shields.io/badge/project-recommendation%20system-purple?style=for-the-badge)

---

<img width="1280" height="771" alt="Bildschirmfoto 2026-06-23 um 21 55 46" src="https://github.com/user-attachments/assets/2a23df1b-388c-4b28-ac35-5ae6a2c85983" />


---

## 🚀 Overview

This is a Java-based **music recommendation system** that suggests songs based on their similarity.

The goal of this project is to simulate a simplified version of Spotify’s recommendation logic using **content-based filtering**.

---

## 🎯 Idea

You input a song → the system compares it with a database of songs → and returns the **Top 5 most similar songs**.

Similarity is calculated using musical features like energy, mood, and danceability.

---

## 🧠 How it works

Each song is converted into a feature vector:

- Energy  
- Danceability  
- Mood  
- Valence  
- Acousticness  
- Tempo  
- Instrumentalness (optional)

Then the system calculates similarity using:

> 📌 **Cosine Similarity**

After that:
1. All songs are compared
2. Scores are calculated
3. Results are sorted
4. Top 5 recommendations are returned

---

---

## 🔧 Technologies

- Java 17+
- Object-Oriented Programming (OOP)
- Collections Framework (List, HashMap)
- Algorithms (Cosine Similarity)
- Sorting & Ranking Logic

---

## 📌 Features

- 🎵 Manual song database
- 📊 Feature-based vector representation
- 📐 Cosine similarity scoring
- 🏆 Ranking system
- 🎧 Top 5 recommendations

---

## 🔮 Future Improvements

- Spotify API integration (auto-fetch real song data)
- Database integration (persist songs)
- Feature weighting system (improve accuracy)
- Better recommendation quality tuning
- User-based personalization

---

## 💡 Learning Goals

This project was built to understand:

- How recommendation systems work
- Vector-based similarity search
- Core algorithm design
- Data structures in real applications

---




