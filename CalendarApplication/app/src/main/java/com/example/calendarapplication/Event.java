package com.example.calendarapplication;

//annotations
@Entity(tableName = "Events_table") //each @Entity class represents an entity in a tble

public class Event {

    //annotations
    @PrimaryKey //every entity needs a primary key. to keep things simple, each event acts as its own pk
    @NonNull //a parameter, field, or method return value can never be null
    @ColumnInfo(name = "event") //the name of the column in the table

    //?
    private String mEvent;

    //attributes
    private String name;
    private String startDate;
    private String endDate;
    private String creator;

    //??
    public Event(@NonNull String event) {this.mEvent = event;}

    //getter method; every field that's stored in the database needs to either be public or have a "getter" method.
    public String getEvent(){return this.mEvent;}

    //FUNCTIONS
    public void createEvent(){
        name = setEventName();

        do {
            startDate = setStartDate();
            endDate = setEndDate();
        }while(!checkDatesValid(startDate, endDate))

        creator = getUserID();
    }

    public void editEvent(){
        public String field;

        //does the user want to edit the event name
        field = "nameField";
        if(chooseToEditField(field))
            name = setEventName();

        //editDates(startDate, endDate, field);

        //does the user want to edit the start date
        field = "startDateField";
        if(chooseToEditField(field))
            startDate = setStartDate();

        //does the user want to edit the end date
        field = "endDateField";
        if(chooseToEditField(field))
            endDate = setEndDate();

        //check the dates
        while(!checkDatesValid(startDate, endDate)){
            //does the user want to edit the start date
            field = "startDateField";
            if(chooseToEditField(field))
                startDate = setStartDate();

            //does the user want to edit the end date
            field = "endDateField";
            if(chooseToEditField(field))
                endDate = setEndDate();
        }

        //cannot change event creator
    }

    public String setEventName(){
        //get user input

        //check if valid
    }

    public String setStartDate(){
        //get user input: startDate

        //check if valid date
    }

    public String setEndDate(){
        //get user input: endDate

        //check if valid date

    }

    public Boolean checkDatesValid(String s, String e){
        if(s<=e)
            return true;
        else
            return false;
    }

    /*
    void editDates(String s, String e, String f){
        //does the user want to edit the start date
        f = "startDate";
        if(chooseToEditField(f))
            startDate = setStartDate();

        //does the user want to edit the end date
        f= "endDate";
        if(chooseToEditField(f))
            endDate = setEndDate();
    }
    */

    public String getUserID(){
        //get user ID
    }

    public Boolean chooseToEditField(String f){
        cout << "do u wanna change " << f << "?\n"
                << "y or n";
        cin >> choice;

        if(choice==y)
            return true;
        else
            return false;
    }
}
