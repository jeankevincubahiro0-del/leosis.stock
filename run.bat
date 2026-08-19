@echo off
cd /d "%~dp0"
javac App.java
if errorlevel 1 pause & exit /b 1
start http://localhost:8080
java App
pause
