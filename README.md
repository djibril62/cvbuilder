# **CV Builder** 📄
Projet permettant de créer, stocker et télécharger des **CVs en PDF** à l’aide de **Spring Boot**, **MongoDB** et **Apache PDFBox**.

---

## 🚀 **Installation et Exécution**

### **1️⃣ Prérequis**
- **Java 21+** (Vérifier avec `java -version`)
- **Maven** (Vérifier avec `mvn -version`)
- **MongoDB** (local ou MongoDB Atlas)
- **Postman** ou un navigateur pour tester les requêtes

### **2️⃣ Cloner le projet**
```sh
git clone https://github.com/ton-repo/cv-builder.git
cd cv-builder
```

### **3️⃣ Configurer MongoDB**
Dans `application.properties` ou `application.yml`, configure ta connexion MongoDB :

```properties
spring.data.mongodb.uri=mongodb+srv://<user>:<password>@<cluster>.mongodb.net/cvdb
spring.data.mongodb.database=cvdb
```
📌 **Remplace `<user>`, `<password>` et `<cluster>` par tes identifiants MongoDB.**

### **4️⃣ Installer les dépendances**
```sh
mvn clean install
```

### **5️⃣ Démarrer l’application**
```sh
mvn spring-boot:run
```
🚀 **L’application tourne maintenant sur `http://localhost:8080` !**

---

## 📌 **Endpoints de l'API**
### **📜 Créer un CV**
```http
POST /cv/generate
```
**Body (JSON) :**
```json
{
    "nom": "Djibril Ndiaye",
    "email": "djibril@example.com",
    "telephone": "+123456789",
    "competences": ["Java", "Spring Boot", "MongoDB"],
    "experiences": ["Développeur Java chez X", "Stage chez ITANDCLOUD"],
    "formations": ["Licence Informatique", "Formation Spring Boot"]
}
```
📌 **Retourne l'ID du CV créé.**

---

### **📜 Récupérer tous les CVs**
```http
GET /cv
```

---

### **📜 Télécharger un CV en PDF**
```http
GET /cv/{id}/download
```
📌 Remplace `{id}` par l’ID récupéré lors de la création du CV.

✅ **Le fichier `cv_nom.pdf` sera téléchargé !**

---

## 🛠 **Technologies utilisées**
- **Java 21** ☕
- **Spring Boot 3.4.2** 🚀
- **MongoDB** (Stockage des CVs) 🗄️
- **Apache PDFBox** (Génération PDF) 📄
- **Lombok** (Simplification du code) ⚡
- **Maven** (Gestion des dépendances) 🛠️

---

## 📌 **Améliorations possibles**
- 🔹 **Mise en page avancée du PDF** 🎨
- 🔹 **Stockage des fichiers PDF sur un serveur (ex: AWS S3)** ☁️
- 🔹 **Authentification avec JWT pour sécuriser l'API** 🔐
- 🔹 **Interface Web pour générer les CVs facilement** 🖥️

---

## 📜 **Auteur**
👨‍💻 **Djibril Ndiaye**  
💼 **Projet réalisé pour améliorer mes compétences en Spring Boot & MongoDB**

📌 **N’hésite pas à contribuer et à proposer des améliorations !** 🚀🔥  
