package at.ac.fhcampuswien.downloader;

import at.ac.fhcampuswien.controllers.NewsAPIException;

import java.util.List;
import java.util.ArrayList;
//Hilfsklassen, die häufig bei der gleichzeitigen Programmierung nützlich sind.
import java.util.concurrent.*;
/**
 * 1. die Anzahl von Processors werden geholt -> availableProcessors
 * 2. pool initialisieren, welches eine fixe Anzahl von threads hat (basierend auf schritt 1)
 * */
public class ParallelDownloader extends Downloader {

    // returns number of downloaded article urls
    @Override
    public int process(List<String> urls) throws NewsAPIException {
        // TODO implement download function using multiple threads
        /*
         * Liefert die Anzahl verfügbaren CPU-Prozessoren (Kerne) der Java virtuelle
         * Maschine (VM).
         *  Quelle: http://blog.wenzlaff.de/?p=14142
         */
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        /*
         * Ein Thread-Pool verwendet zuvor erstellte Threads erneut, um aktuelle Aufgaben auszuführen,
         * und bietet eine Lösung für das Problem des Thread-Zyklus-Overheads und der Ressourcenüberlastung.
         */
        //ExecutorService: Dieses Interface ermöglicht einen Threadpool anzulegen
        ExecutorService threadPool = Executors.newFixedThreadPool(availableProcessors);
        //vorbereitung für async
        /* Callable: Repräsentiert einen Task, der in unterschiedlichsten
         * Threads ausgeführt werden kann und einen generischen Wert zurückgibt*/

        List<Callable<String>> strList = new ArrayList<>();
        for (String url : urls) {
            //die async-Funktion als Lambda übergeben
            Callable<String> task = () -> saveUrl2File(url);
            strList.add(task);
        }
        int count = 0;
        //Async teil:
        try {
            //Future: Dieses Interface erlaubt Variablen für laufende Threads zu definieren und trotzdem im Ablauf des Programms fortzufahren
            List<Future<String>> futureList = threadPool.invokeAll(strList);
            for (Future<String> future : futureList) {
                if (future.get() != null) {
                    count++;
                }
            }
        } catch (InterruptedException | ExecutionException e) {
            throw new NewsAPIException(e.getMessage());

        }

        threadPool.shutdown();// Disable new tasks from being submitted
        return count;
    }
}
