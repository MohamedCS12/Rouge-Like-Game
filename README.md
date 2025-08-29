# Rogue-Like Game

A **Java-based rogue-like game project** featuring multiple demos, including **Conway’s Life** and a **Mars exploration adventure**.
The project showcases a modular game engine with extensible actors, actions, behaviours, and environments.

## 🎮 Implemented Demos

### 🔹 Conway’s Life

An interactive extension of Conway’s Game of Life, with added player interactions and dynamic world evolution.

### 🔹 Mars Exploration

A turn-based rogue-like game set on Mars, featuring:

* Custom actors such as **Player** and **Bug**
* Unique actions (**Kick**, **Smash**, etc.)
* AI behaviours (e.g., **SpitBehaviour**)
* Interactive items like **Stick** and **Martian artifacts**
* Custom terrains (**Crater**, **Wall**, **LockedDoor**)


## 📂 Project Structure
* `engine/` → Core game engine
* `demo/conwayslife/` → Conway’s Life demo
* `demo/mars/` → Mars exploration demo
* `Application.java` → The Game itself fully implemented


## 🚀 How to Run

### Prerequisites

* Java JDK 8+
* A terminal or Java IDE (IntelliJ, Eclipse, or VS Code with Java extensions)

### Steps

1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/Rogue-Like-Game.git
   cd Rouge-Like-Game/src
   ```
2. Compile the project:

   ```bash
   javac edu/monash/fit2099/**/**/*.java
   ```
3. Run a demo:

   * **Conway’s Life**

     ```bash
     java edu.monash.fit2099.demo.conwayslife.Application
     ```
   * **Mars Exploration**

     ```bash
     java edu.monash.fit2099.demo.mars.Application
     ```
4. Run the Game itself
   ```bash
   java game.Application
   ```

   
## ✨ Features

* Tile-based map system
* Actor–action–item framework
* Turn-based gameplay loop
* AI-controlled enemies with behaviours
* Extendable for new mechanics, items, and terrains

## 📌 Notes
This project demonstrates a modular and extensible approach to building rogue-like games in Java.
