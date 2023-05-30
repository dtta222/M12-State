//-------------------------------------------------
//StateClass.java
//Author: David Taylor
//Class: CIT 149–19Z1–78178
//Instructor: Krishna Nandanoor
//Purpose: Develop a Java application where you display all the state names, nicknames and ratified dates in a nicely
// formatted manner
//-------------------------------------------------

import java.util.Calendar;

public class State {
    private String stateName = null;
    private String stateCapital = null;
    private	String stateBird = null;
    private String stateFlower = null;
    private String stateNickName = null;
    private String dateEnteredUnion = null;
    private int yearSettled = 0;
    public int date = Calendar.getInstance().get(Calendar.YEAR);

//--------------------------------------------------
//    Constructor for the State class
//--------------------------------------------------

    public State (String stateName, String stateCapital, String stateBird, String stateFlower) {

        this.stateName = stateName;
        this.stateCapital = stateCapital;
        this.stateBird = stateBird;
        this.stateFlower = stateFlower;
    }

    public State (String stateName, String stateCapital, String stateBird, String stateFlower, String nickname,
                  String dateEnteredUnion, int yearSettled) {
        this.stateName = stateName;
        this.stateCapital = stateCapital;
        this.stateBird = stateBird;
        this.stateFlower = stateFlower;
        this.stateNickName = nickname;
        this.dateEnteredUnion = dateEnteredUnion;
        this.yearSettled = yearSettled;
    }

//--------------------------------------------------
//    Accessors for the State class
//--------------------------------------------------

    public String getStateName() {
        return stateName;
    }

    public String getStateCapital() {
        return stateCapital;
    }

    public String getStateBird() {
        return stateBird;
    }

    public String getStateFlower() {
        return stateFlower;
    }

    public String getNickName() {
        return stateNickName;
    }

    public String getDateEnteredUnion() {
        return dateEnteredUnion;
    }

    public int getYearSettled() {
        return yearSettled;
    }


//--------------------------------------------------
//    Mutators for the State class
//--------------------------------------------------

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public void setStateCapital(String stateCapital) {
        this.stateCapital = stateCapital;
    }

    public void setStateBird(String stateBird) {
        this.stateBird = stateBird;
    }

    public void setStateFlower(String stateFlower) {
        this.stateFlower = stateFlower;
    }

    public void setNickName(String nickName) {
        this.stateNickName = nickName;
    }

    public void setDateEnteredUnion(String dateEnteredUnion) {
        String dash1 = dateEnteredUnion.substring(4,5);
        String dash2 = dateEnteredUnion.substring(7,8);

        //check that string is in correct format
        if (dateEnteredUnion.length() == 10){
            if (dash1 == "-" && dash2 == "-") {
                this.dateEnteredUnion = dateEnteredUnion;
            }
        }
    }

    public void setYearSettled(int yearSettled) {
        if (yearSettled >= 1400 && yearSettled <= date) {
            this.yearSettled = yearSettled;
        }
    }

//--------------------------------------------------
//    toString() method to override method from
//	  Object class
//--------------------------------------------------

    public String toString () {
        return stateName + "\t" + stateCapital;
    }

}
