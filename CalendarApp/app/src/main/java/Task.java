public class Task {
    //attributes
    private String name;
    private String category;
    private String startDate;
    private String dueDate;
    private String creator;

    //FUNCTIONS
    public void createTask(){
        name = setTaskName();

        category = setCategory();

        do {
            startDate = setStartDate();
            endDate = setDueDate();
        }while(!checkDatesValid(startDate, dueDate))

        creator = getUserID();
    }

    public void editTask(){
        public String field;

        //does the user want to edit the event name
        field = "nameField";
        if(chooseToEditField(field))
            name = setEventName();

        //does the user want to edit the category
        field = "categoryField";
        if(chooseToEditField(field)){
          //list the categories
          //let the user select one
          //or cancel
        }

        //editDates(startDate, endDate, field);

        //does the user want to edit the start date
        field = "startDateField";
        if(chooseToEditField(field))
            startDate = setStartDate();

        //does the user want to edit the due date
        field = "dueDateField";
        if(chooseToEditField(field))
            endDate = setEndDate();

        //check the dates
         while(!checkDatesValid(startDate, dueDate)){
             //does the user want to edit the start date
             field = "startDateField";
             if(chooseToEditField(field))
                 startDate = setStartDate();

             //does the user want to edit the end date
             field = "dueDateField";
             if(chooseToEditField(field))
                 endDate = setDueDate();
         }

        //cannot change task creator
    }

    public String setTaskName(){
      //get user input

      //check if valid
    }

    public String setCategory(){
      char choice = 'n';
      cout << "do u wanna set a category? y or n\n";
      cin >> choice;
      if(choice choice=='y'){
        //list the categories
        //let the user select one
        //or cancel
      }
    }

    public String setStartDate(){
        //get user input: startDate

        //check if valid date
    }

    public String setDueDate(){
        //get user input: endDate

        //check if valid date

    }

    public Boolean checkDatesValid(String s, String d){
        if(s<=d)
            return true;
        else
            return false;
    }

    public String getUserID(){
        //get user ID
    }



}
