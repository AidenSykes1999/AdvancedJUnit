package com.sparta.spartatraineesimulator;

import com.sparta.spartatraineesimulator.controller.Controller;
import com.sparta.spartatraineesimulator.view.DisplayManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    public static Logger logger = LogManager.getLogger("Sparta-Simulator-Logger");
    private static int currentMonth = 0;

    public static void main(String[] args) {

        DisplayManager dm = new DisplayManager();
        Controller controller = new Controller();

        int months = dm.numberOfMonths();

        for(int i = 0; i < months; i++) {

            controller.runSimulationTick(i);
            dm.displayMonthPassed();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            currentMonth++;

        }

        int numberOfOpenCentres = controller.getNumberOfOpenCentres();
        int numberOfFullCentres = controller.getNumberOfFullCentres();
        int numberCurrentlyTraining = controller.getNumberCurrentlyTraining();
        int numberOfTraineesWaiting = controller.getNumberOfTraineesWaiting();

        dm.displayTheDetails(numberOfOpenCentres, numberOfFullCentres, numberCurrentlyTraining, numberOfTraineesWaiting);

    }

}
