package com.sparta.spartatraineesimulator.model;

public class Trainee {
    private int traineeId;
    private int trainingTime = 0;

    // new variables for the waiting list
    private boolean isWaiting = true;
    private final Courses courseType = Courses.randomCourseType(); //random course for a trainee

    public Trainee(int traineeId, int trainingTime){
        this.traineeId = traineeId;
        this.trainingTime = trainingTime;
    }

    public void incrementTrainingTime(){
        trainingTime++;
    }

    public int getTrainingTime() {
        return trainingTime;
    }

    public int getTraineeId() {
        return traineeId;
    }

    public void setTraineeId(int traineeId) {
        this.traineeId = traineeId;
    }

    @Override
    public String toString() {
        return "Trainee{" +
                "traineeId=" + traineeId + " " + courseType +
                '}';
    }

    //setter for the waiting
    public void setIsWaiting(boolean isWaiting) {
        this.isWaiting = isWaiting;
    }

    //getter for the waiting
    public boolean isWaiting() {
        return isWaiting;
    }

    //getter for the trainee's course type
    public Courses getCourseType() {
        return courseType;
    }

    @Override
    public String toString() {
        return "\nTrainee:\n" +
                "Trainee ID = " + traineeId +
                "\nTraining time = " + trainingTime +
                "\nIs waiting? = " + isWaiting +
                "\nCourse = " + courseType;
    }
}
