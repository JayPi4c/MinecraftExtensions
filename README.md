# MinecraftExtensions

### Wie kann Ich bei dem Projekt mitmachen?
1. Erstelle einen Ordner, der als Workspace bei Eclipse fungieren soll.
2. Führe in dem neuen Ordner den git-Befehl `git clone https://github.com/JayPi4c/MinecraftExtensions.git`
3. Führe den Befehl `./gradlew setupDecompWorkspace` aus, um Artefakte und Resourcen herunterzuladen und Minectaft zu decompilen, damit man es modden kann.
4. Führe den Befehl `./gradlew eclispe` aus, um das Projekt für Eclipse vorzubereiten.
5. Öffne Eclipse und nutze den eingangs erstellten Ordner als Workspace.
6. In dem geöffneten Eclipse gehe auf File>Open Projects from Filesystem... 
7. Klicke auf Directory... und wähle den Ordner "MinecraftExtensions" in dem Workspaceordner aus
8. In dem Fenster sind nun zwei Projekte, welche importiert werden können. Entferne das Häckchen bei MinecraftExtensions/src und klicke auf Finish.

Nun ist das Projekt so in Eclipse importiert, dass ohne Probleme gemoddet werden kann.

Um das Projekt in Eclipse zu starten und zu testen, klicke auf den Pfeil nach unten, der neben dem Startbutton ist und klicke auf Run Configurations... . Dort wähle als Project MinecraftExtensions und bei Main class klicke auf Search und wähle bei der Auflistung die Klasse GradleStart-(default package). Klicke auf apply und danach auf run und Minecraft startet mit der Mod MinecraftExtensions. Von nun an kannst du immer auf den grünen Startbutton klicke, um die Mod zu starten.
