# LifeAI OS - Native Mobile App (Capacitor)

This repository contains the native Android application for **LifeAI OS**, wrapping the web application [https://life-connecte-port.apper.so](https://life-connecte-port.apper.so) with native hardware integrations and offline handling.

---

## 📱 Generated Installation Files

Both production-ready files have been generated and signed:

| File | Path | Purpose |
|------|------|---------|
| **Installable APK** | [`release/LifeAI-OS-v1.0.apk`](file:///d:/LifeAI%20OS/release/LifeAI-OS-v1.0.apk) | **Direct phone install**. Send to your mobile phone via USB, Google Drive, or WhatsApp, tap and install directly. |
| **Android App Bundle (AAB)** | [`release/LifeAI-OS-v1.0.aab`](file:///d:/LifeAI%20OS/release/LifeAI-OS-v1.0.aab) | **Google Play Console**. Upload this directly to Google Play Store. |

---

## 🚀 How to Install on Your Android Phone

1. **Copy the APK**:
   Copy [`release/LifeAI-OS-v1.0.apk`](file:///d:/LifeAI%20OS/release/LifeAI-OS-v1.0.apk) to your Android phone (via USB cable, Google Drive, Telegram, or WhatsApp).
2. **Install**:
   Open your phone's File Manager / Downloads, tap on `LifeAI-OS-v1.0.apk`.
3. **Allow Permission**:
   If prompted *"For security, your phone is not allowed to install unknown apps from this source"*, tap **Settings** and toggle **Allow from this source**, then tap **Install**.
4. **Launch**:
   Open **LifeAI OS** directly from your home screen.

---

## ⚡ Scalable Architecture & Native Features

1. **Live Cloud Sync**:
   - The app connects directly to `https://life-connecte-port.apper.so`.
   - Any updates deployed to your web app are instantly reflected on mobile devices without requiring users to download an app update from the app store.
2. **Offline Fallback & Auto-Reconnect**:
   - When offline, a native dark-mode reconnect screen ([`www/index.html`](file:///d:/LifeAI%20OS/www/index.html)) is displayed.
   - Automatically detects when internet connectivity returns and transitions seamlessly into the live app.
3. **Native Back Button & Navigation**:
   - Custom back handler in [`MainActivity.java`](file:///d:/LifeAI%20OS/android/app/src/main/java/com/lifeai/os/MainActivity.java) traverses browser history rather than abruptly closing the app.
4. **Hardware Integrations**:
   - Status bar styled to match the dark slate theme (`#0f172a`).
   - Native splash screen with smooth transition.
   - Full network state change detection.
5. **Pre-configured Release Signing**:
   - Signed with `android/app/lifeai-release-key.jks`.
   - Keystore alias: `lifeai`, storepass: `lifeai123`.

---

## 🛠️ Build Commands

From the project root:

```powershell
# Rebuild installable APK
npm run build:apk

# Rebuild Play Store AAB
npm run build:aab

# Rebuild both
npm run build:all

# Open the project directly in Android Studio
npm run open:android
```
