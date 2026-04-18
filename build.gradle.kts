plugins {
    id("java-library")
    id("org.allaymc.gradle.plugin") version "0.2.1"
}

group = "com.mythicalgames.discordrelay"
description = "A Simple Minecraft to Discord Relay for the AllayMC Server Software!"
version = "2.0.0"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    maven("https://jitpack.io/")
    maven("https://storehouse.okaeri.eu/repository/maven-public/")
}

allay {
    api = "0.27.0"
    plugin {
        entrance = ".DiscordRelay"
        authors += "Acktar"
        website = "https://github.com/Mythical-Games/DiscordChat"
    }
}

dependencies {
    compileOnly(group = "org.projectlombok", name = "lombok", version = "1.18.34")
    implementation("com.github.discord-jda:JDA:v5.3.0")
    implementation("eu.okaeri:okaeri-configs-yaml-snakeyaml:6.0.0-beta.1")

    annotationProcessor(group = "org.projectlombok", name = "lombok", version = "1.18.34")
}
