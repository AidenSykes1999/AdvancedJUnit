package com.sparta.spartatraineesimulator.controller;

// tick stuff

import com.sparta.spartatraineesimulator.model.*;
import com.sparta.spartatraineesimulator.view.DisplayManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Controller {

    private int totalEnlisted = 0;
    private int traineeId = 0;
    private int totalTraining = 0;
    private ArrayList<AbstractCentre> centres = new ArrayList<>();
    private ArrayList<Trainee> waitingList = new ArrayList<>();

    public void runSimulation(int month) {
        DisplayManager dm = new DisplayManager();
        for(int i = 0; i < month; i++){

            ArrayList<Trainee> newTrainees = generateTrainees();
            waitingList.addAll(newTrainees);
            totalEnlisted += newTrainees.size();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("1 month passed");
            if(i % 2 == 0){

                Random randint = new Random();
                int min = 1;
                int max = 3;

                // let 1 = Tech, 2 = Boot and 3 = Training

                int randomChoice = (int)Math.floor(Math.random()*(max-min+1)+min);

                switch(randomChoice){

                    case 1:
                        centres.add(new TechCentre());
                        break;
                    case 2:
                        centres.add(new BootCamp());
                        break;
                    case 3:
                        centres.add(new TrainingHub());
                        break;
                    default:

                }


            }

            for (AbstractCentre centre : centres) {
                if (!centre.isCentreFull()) {
                    int freeSpace = centre.getEmptySpace();

                    if (freeSpace >= waitingList.size()) {
                        centre.addAllTrainees(waitingList);
                        waitingList.clear();
                    }
                    else if (freeSpace < waitingList.size()) {
                        List<Trainee> subListTrainee = waitingList.subList(0, freeSpace);
                        centre.addAllTrainees(subListTrainee);
                        waitingList.removeAll(subListTrainee);
                    }

                }
            }

            for (AbstractCentre centre : centres) {
                System.out.print(centre.getCurrentCapacity() + ", ");
            }
            System.out.println("Waiting list size: " + waitingList.size());

           // for(int j = 0; j < trainees.size(); i++){
            //     while(trainees.get(j).getTrainingTime() < )
            //     trainees.get(j).incrementTrainingTime();
            // }
        }

        System.out.println("Total enlisted: " + totalEnlisted);

        int totalFullCenters = 0;
        for (AbstractCentre centre : centres) {
            totalFullCenters += centre.getCurrentCapacity()/100;
        }
        if (totalEnlisted > (centres.size()*100)){
            totalTraining = centres.size()*100;
        }
        else
            totalTraining = totalEnlisted;

        System.out.println(dm.displayTheDetails(centres.size(), totalFullCenters, totalTraining, waitingList.size()));

//        System.out.println("Total centres: " + totalCenters/100);
//        System.out.println("Total waitingList size: " + waitingList.size());
    }

    public ArrayList<Trainee> generateTrainees(){
        Random r = new Random();
        int numberOfTrainees = r.nextInt(50, 101);
        ArrayList<Trainee> newTrainees = new ArrayList<Trainee>();

        for(int i = 0; i < numberOfTrainees; i++){
            newTrainees.add(new Trainee(traineeId, 0));
            traineeId++;
        }

        return newTrainees;
    }

    public int getTotalEnlisted() {
        return totalEnlisted;
    }

    public ArrayList<AbstractCentre> getCentres() {
        return centres;
    }

    public ArrayList<Trainee> getWaitingList() {
        return waitingList;
    }
}
