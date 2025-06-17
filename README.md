# ProvaConnessione

**ProvaConnessione** è una web application Java basata su Spring Boot che consente la gestione di eventi, prenotazioni, sedi e utenti. Il sistema fornisce un'API REST per operazioni CRUD su tutte le entità principali.

## 🧩 Tecnologie utilizzate

- Java 17+
- Spring Boot
- Spring Security
- Spring Data JPA
- MySQL (o altro DB compatibile)
- Gradle
- REST API

## 📦 Struttura del progetto

src/main/java/com/example/provaconnessione/
├── controller/ # Controller REST per Evento, Prenotazioni, Auth, Sede
├── model/ # Classi Entity: Evento, User, Sede, Prenotazioni
├── repository/ # Interfacce JPA per l'accesso ai dati
├── service/ # Logica di business per ogni entità
├── SpringSecurityConfig # Configurazione sicurezza
└── ProvaconnessioneApplication.java


## ▶️ Come eseguire il progetto

### Prerequisiti
- JDK 17 o superiore
- Gradle
- MySQL (oppure H2 per test locali)

### Setup rapido

1. **Clona il repository**
   ```bash
   git clone https://github.com/Luca16-95/provaconnessione.git
   cd provaconnessione
   ```
Configura il database

Modifica application.properties o application.yml per connetterti al tuo database.

Avvia l'applicazione

```bash
./gradlew bootRun
```
Accesso API

Endpoint esempio: GET /api/eventi

L'applicazione espone endpoint REST protetti con autenticazione.

✅ Funzionalità principali
Registrazione e login utenti

CRUD eventi, prenotazioni, sedi

Autenticazione e autorizzazione con Spring Security

Separazione chiara tra controller, service e repository

🧪 Test
```bash
./gradlew test
```
🔐 Sicurezza
La sicurezza è gestita tramite Spring Security e autenticazione basata su ruoli. Le rotte sono protette da accessi non autorizzati.

🧑‍💻 Autore
Luca Manzo
GitHub
