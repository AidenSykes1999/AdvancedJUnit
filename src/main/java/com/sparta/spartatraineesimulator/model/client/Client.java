package com.sparta.spartatraineesimulator.model.client;

import com.sparta.spartatraineesimulator.model.Course;
import com.sparta.spartatraineesimulator.model.Trainee;

import java.util.ArrayList;
import java.util.List;

public class Client {

    private int clientId;
    private Course traineeTypeRequirement;
    private int traineeNumberRequirement;

    private ArrayList<Trainee> trainees = new ArrayList<>();
    int months;

    public Client(int clientId, Course traineeTypeRequirement, int traineeRequirement){
        this.clientId = clientId;
        this.traineeTypeRequirement = traineeTypeRequirement;
        this.traineeNumberRequirement = traineeRequirement;
        this.months = 1;
    }

    public int getClientId() {
        return clientId;
    }

    public Course getTraineeTypeRequirement() {
        return traineeTypeRequirement;
    }

    public int getTraineeNumberRequirement() {
        return traineeNumberRequirement;
    }

    public ArrayList<Trainee> getTrainees() {
        return trainees;
    }

    public void setTrainees(List<Trainee> traineeList){
        trainees.addAll(traineeList);
    }

    public int getMonths() {
        return months;
    }

    public void incrementMonths(){
        months++;
    }

    public void resetMonths(){
        months = 1;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientId=" + clientId +
                ", traineeTypeRequirement=" + traineeTypeRequirement +
                ", traineeNumberRequirement=" + traineeNumberRequirement +
                ", trainees=" + trainees +
                ", months=" + months +
                '}';
    }

    public void resetTrainees() {
        this.trainees.clear();
    }
}
