# WoolWars
A wool wars plugin for the gamepixel server.

# WoolWars Plugin Documentation (Only for devs)

## Commands

- **DatabaseConfigReload:**
  Command to reload the database config file.

## Data

### player

#### WoolWarsPlayer

A custom class which is an extension to a Bukkit player class including the following things:
- `Player player` (Vanilla player)
- `int level`
- `int currentXp` (The current xp or the xp the player initially/currently has)
- `int finalXp` (The final xp the player needs to level up)
- `int wool` (The currency to buy cosmetics)
- `int layers` (Obtained by playing matches and used to collect wool from a custom sheep)
- `int wins`
- `int kills`
- `int deaths`
- `boolean ignoreLeaderboard` (Have added this to not mess with the admins having their own goofy stats)

Feel free to add things to this

(Note for dev: It would be better to convert WoolWarsPlayer into WoolWarsLobbyPlayer and WoolWarsArenaPlayer. Remove this note when done.)

### server

#### DatabaseConfigurator

A custom config file to set up, load, and reload the Database config file, which inputs the jdbcURL, username, and password for the database (Made this to promote privacy and safety)

### world

#### WoolWarsLobbyWorld

A custom class which is an extension to a Bukkit world class including the following things:
- `World bukkitWorld` (Vanilla world)
- `WorldType type` (The Custom WorldType Enum which is -> me.reaper_17.woolwars.enums.WorldType)
  
Feel free to add things to this

(Note for dev: It would be better to convert WoolWarsWorld into WoolWarsLobbyWorld and WoolWarsArenaWorld. Remove this note when done.)

## enums

### WorldType

It consists of:
- `NORMAL` (It is a normal vanilla world or a non-WoolWars world)
- `LOBBY` (It is a lobby world)
- `ARENA` (It is an arena world)

## events

### BasicLobbyEvents

Some basic lobby events

### JoinScoreShowEvents

An EventListener to display the lobby scoreboard whenever a player joins the server

(Note for dev: change the logic to display the scoreboard whenever the player joins a WoolWarsLobbyWorld of WorldType LOBBY. Remove this note when done.)

## kits

### Kits

A class to get the ItemStacks of a specific kit. Following kits are supported as of now:
- tank
- assault
- archer
- swordsman
- golem
- engineer

feel free to add things to this

(Bonus tip: Use the Collection<ArrayList<ItemStack>> kits to get all the kits at once whenever needed.)

## listeners

[Empty for now]

## managers

### CommandManager

A manager to register commands 

### ConfigManager

A manager to set up the regular config file (The regular config is empty just so we can get the plugins folder generated for the custom config files)

### DatabaseConfigManager

A manager to set up the custom database config file

### KitsManager

A manager to set up the kits (The plugin will remove everything from the lists when server is disabled and adds everything back when server starts)

(Note for dev: You may remove this functionality if you want as it may not be needed. Remove this note after it's read.)

### PlayerDatabaseManager

A manager to upload player's data to database on server disable and vice versa (The data is same as that of `WoolWarsPlayer`)

### WorldDatabaseManager

A manager to upload world's data to database on server disable and vice versa (The data is same as that of `WoolWarsWorld`)

## menus

[Empty for now]

## scoreboards

### LobbyScoreboard

The replica of the lobby scoreboard seen on hypixel

(Note for dev: have to fix the title animation. Remove this not when done.)

## tablists

### LobbyTablist

(Incomplete due to no tablist support on `spigot-api 1.8.8-R0.1-SNAPSHOT`. Use some external plugin or use NMS to complete this. Remove this when done)

## utility

[Empty for now]

## WoolWars (main class)

used lombok for getters of:
- The plugin main instance
- `Collection<WoolWarsLobbyWorld> woolWarsLobbyWorlds`
- `Collection<WoolWarsPlayer> woolWarsPlayers`

other notable variables:
- `String jdbcURL`
- `String username`
- `String password`

methods in it:
- `onEnable()`
- `onDisable`
- `initiateManagers()`
- `registerEvents()`

(Not much documentation provided on it due to it being simple)
