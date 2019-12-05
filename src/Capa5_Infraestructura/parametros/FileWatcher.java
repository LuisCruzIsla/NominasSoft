/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa5_Infraestructura.parametros;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.WatchEvent.Kind;

import static java.nio.file.StandardWatchEventKinds.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public abstract class FileWatcher {

    private Path folderPath;
    private String watchFile;

    public FileWatcher(String watchFile) {
        Path filePath = Paths.get(watchFile);

        boolean isRegularFile = Files.isRegularFile(filePath);

        if (!isRegularFile) {
            // Do not allow this to be a folder since we want to watch files
            throw new IllegalArgumentException(watchFile + " is not a regular file");
        }

        // This is always a folder
        folderPath = filePath.getParent();

        // Keep this relative to the watched folder
        this.watchFile = watchFile.replace(folderPath.toString() + File.separator, "");
    }

    public void watchFile() throws Exception {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                FileSystem fileSystem = folderPath.getFileSystem();

                // We create the new WatchService using the try-with-resources block
                try (WatchService service = fileSystem.newWatchService()) {
                    // We watch for modification events
                    folderPath.register(service, ENTRY_MODIFY);

                    // Start the infinite polling loop
                    while (true) {
                        // Wait for the next event
                        WatchKey watchKey = service.take();

                        for (WatchEvent<?> watchEvent : watchKey.pollEvents()) {
                            // Get the type of the event
                            Kind<?> kind = watchEvent.kind();

                            if (kind == ENTRY_MODIFY) {
                                Path watchEventPath = (Path) watchEvent.context();

                                // Call this if the right file is involved
                                if (watchEventPath.toString().equals(watchFile)) {
                                    onModified();
                                }
                            }
                        }

                        if (!watchKey.reset()) {
                            // Exit if no longer valid
                            break;
                        }
                    }
                } catch (IOException ex) {
                    Logger.getLogger(FileWatcher.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InterruptedException ex) {
                    Logger.getLogger(FileWatcher.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        t1.start();
    }

    public abstract void onModified();
}
