public class Event {
    //attributes
    private String name;
    private String startDate;
    private String endDate;
    private String creator;

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
        name = editEventName();
        void editDates(startDate, endDate);
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

    public String getUserID(){
        //get user ID
    }

}
