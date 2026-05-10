# 💊 Medicine Tracker – Offline-First Android App with Supabase

A full-stack medication adherence app that helps users never miss a dose. Built with **Kotlin**, **Jetpack Compose**, and **Supabase** — works fully offline, syncs across devices, and delivers timely local reminders.

![Platform](https://img.shields.io/badge/Platform-Android%20API%2024%2B-brightgreen)
![Kotlin](https://img.shields.io/badge/Kotlin-2.0.0-purple)
![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-Material%203-blue)
![Supabase](https://img.shields.io/badge/Supabase-Cloud%20Backend-3ECF8E)
![License](https://img.shields.io/badge/License-MIT-lightgrey)

---

## 📱 Screenshots

| Login | Dashboard | Add Medication | Reminders | History |
|-------|-----------|----------------|-----------|---------|
| *(coming soon)* | *(coming soon)* | *(coming soon)* | *(coming soon)* | *(coming soon)* |

---

## ✨ Features

- 🔐 **Authentication** — Secure sign-up / login via email & password (Supabase Auth); persistent session with automatic token refresh
- 💊 **Medication Management** — Add, edit, and delete medications with name, dosage, strength, instructions, and start/end dates
- ⏰ **Multiple Reminders** — Configure several daily reminder times per medication (e.g. 8 AM, 1 PM, 9 PM)
- 🔔 **Local Notifications** — Exact-time alarms via `AlarmManager`; work even when the app is closed or the device reboots
- 📅 **Dose Logging** — Mark doses as Taken / Missed / Skipped directly from the notification or the app
- 📊 **Adherence History** — Browse your dose history by date and review weekly success rates
- ☁️ **Cloud Sync** — All data persisted in Supabase PostgreSQL; seamlessly sync across multiple devices
- 📴 **Offline-First** — Every feature works without internet; local changes queue automatically and sync when connectivity returns
- ⚙️ **Settings** — Master notification toggle, default snooze interval, manual sync trigger, and logout

---

## 🛠️ Tech Stack

### Android Client

| Technology | Purpose |
|------------|---------|
| **Kotlin** + Coroutines + Flow | Language & async operations |
| **Jetpack Compose** (Material 3) | Declarative UI |
| **Room** | Local database with sync metadata |
| **WorkManager** | Background sync & periodic tasks |
| **AlarmManager** | Exact-time notification scheduling |
| **Supabase Kotlin SDK** | Auth, PostgREST, Realtime |

### Backend (Supabase / BaaS)

| Technology | Purpose |
|------------|---------|
| **Supabase Auth** | Email/password authentication, JWT session management |
| **PostgreSQL** | Cloud data storage (medications, reminders, dose history) |
| **Row Level Security (RLS)** | User-level data isolation enforced at the database layer |

---

## 🗄️ Database Schema

Three tables power the app:

**`medications`** — core medication records linked to `auth.users`  
**`reminder_times`** — one-to-many reminder times per medication  
**`dose_history`** — per-dose log with status (`TAKEN` / `MISSED` / `SKIPPED`)

All tables use UUID primary keys, cascade deletes, an `updated_at` auto-update trigger on `medications`, and full RLS policies ensuring each user can only access their own data.

See [`supabase/schema.sql`](supabase/schema.sql) for the complete migration script.

---

## 🔄 Offline Sync Strategy

The app implements a **pending-queue** sync pattern — no third-party sync library required:

1. Every local insert / update / delete sets `syncStatus = PENDING` on the Room entity.
2. **WorkManager** runs a `SyncWorker` every 30 minutes *and* whenever the network reconnects (requires unmetered connection, not low battery).
3. `SyncWorker` runs two passes:
   - **Upload** — pushes all `PENDING` records to Supabase; on success stores `serverId` and marks `SYNCED`; on conflict applies **last-write-wins** using `updated_at` timestamps.
   - **Download** — fetches all user records newer than `lastSyncTimestamp` and merges into Room (replace by `serverId`, otherwise insert).
4. `lastSyncTimestamp` is persisted in SharedPreferences after each successful sync.
5. Failed syncs are retried with **exponential backoff** (max 3 attempts via WorkManager).

---

## 🚀 Getting Started

### Prerequisites

- Android Studio Hedgehog (or newer)
- JDK 17
- Android device / emulator — **API 24+**
- A free [Supabase](https://supabase.com) account

### 1. Clone the repository

```bash
git clone https://github.com/your-username/medicine-tracker.git
cd medicine-tracker
```

### 2. Set up your Supabase project

1. Create a new project on [supabase.com](https://supabase.com).
2. Open **SQL Editor** and run the full script at [`supabase/schema.sql`](supabase/schema.sql).  
   This creates all tables, RLS policies, foreign keys, and the `updated_at` trigger.
3. Enable **Email** authentication in **Authentication → Providers**.
4. Copy your **Project URL** and **anon key** from **Settings → API**.

### 3. Configure the Android app

Create or open `local.properties` in the project root and add:

```properties
SUPABASE_URL=https://your-project-ref.supabase.co
SUPABASE_ANON_KEY=your-anon-key-here
```

> The anon key is safe to include — Supabase RLS ensures every user can only read their own data.

### 4. Build and run

Sync Gradle, connect a device (or start an emulator), and press **Run** ▶ in Android Studio.

---

## 📁 Project Structure

```
app/src/main/java/com/medtracker/
├── auth/           # Login & signup screens, Supabase session handling
├── data/           # Room entities, DAOs, AppDatabase
├── repository/     # MedicationRepository, SyncManager
├── sync/           # SyncWorker, conflict resolution logic
├── notifications/  # NotificationScheduler, AlarmReceiver, BootReceiver
├── ui/             # Compose screens — Dashboard, Detail, History, Settings
└── utils/          # Extensions, date helpers, constants

supabase/
├── schema.sql      # Full migration: tables + RLS + triggers
└── rls-policies.md # RLS policy documentation
```

---

## 🔐 Security

- All Supabase communication is **HTTPS-only** (enforced by the SDK).
- **RLS policies** restrict every SELECT / INSERT / UPDATE / DELETE to `auth.uid() = user_id` — no cross-user access is possible.
- Passwords are never stored locally; only the encrypted session token is persisted (via `EncryptedSharedPreferences` or the Supabase SDK's built-in handling).
- On logout: local Room database is cleared, all pending alarms are cancelled, and the sync worker is stopped.

---

## 🧪 Testing

```bash
# Unit tests (JUnit4 + MockK)
./gradlew test

# Instrumented tests (Room, WorkManager — requires emulator/device)
./gradlew connectedAndroidTest
```

Manual acceptance criteria are documented in [`docs/ACCEPTANCE.md`](docs/ACCEPTANCE.md).

---

## 📋 Acceptance Criteria (MVP)

- [ ] User can register and log in via email/password using Supabase Auth
- [ ] Added medications appear locally and are saved to Supabase
- [ ] On a second device (or after reinstall), login restores all medications from the cloud
- [ ] Notifications fire at scheduled times even when the device is offline
- [ ] Marking a dose as taken records it locally and uploads to Supabase when online
- [ ] Offline edits are queued and sync without data loss when connectivity returns
- [ ] Deleting a medication locally removes it from Supabase on next sync
- [ ] RLS prevents any cross-user data access (verified by manual API test)
- [ ] Session expiry is handled gracefully via Supabase auto-refresh
- [ ] All screens use Jetpack Compose with Material 3

---

## 🗺️ Development Milestones

| Sprint | Focus |
|--------|-------|
| 1 | Supabase project setup (schema, RLS, auth) + Android login/signup |
| 2 | Room schema with sync metadata; local medication CRUD |
| 3 | Medication UI (add / edit / list) wired to Room |
| 4 | Sync implementation — SyncWorker, WorkManager, conflict resolution |
| 5 | Reminder times UI + exact alarm notification scheduling |
| 6 | Dose history screen + mark-as-taken (local + Supabase upload) |
| 7 | Settings screen — manual sync, logout, data clear |
| 8 | Polish, edge-case handling (offline, conflict, reboot), testing, release |

---

## 🤝 Contributing

This is a personal / portfolio project, but suggestions are welcome!

1. Fork the repository
2. Create a feature branch: `git checkout -b feature/your-idea`
3. Commit your changes
4. Push and open a Pull Request

---

## 📄 License

Distributed under the MIT License. See [`LICENSE`](LICENSE) for details.

---

## 🙏 Acknowledgements

- [Supabase](https://supabase.com) — Open-source Firebase alternative
- [Jetpack Compose](https://developer.android.com/jetpack/compose) — Modern Android UI toolkit
- [Supabase Kotlin SDK](https://github.com/supabase-community/supabase-kt) — Community-maintained Kotlin client

---

## 📬 Contact

Your Name · [@noobcoderrrr](https://x.com/noobcoderrrr) · thakuranubhav623@gmail.com  
Project: [https://github.com/your-username/medicine-tracker](https://github.com/Anubhav8176/medicine-tracker)
