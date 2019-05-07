package edu.csusm.cscalendarapp;

import java.util.UUID;

public class EventObject {
    String eventID = UUID.randomUUID().toString();
    String eventName;
    String dateSet;
    String dateDue;
    String eventDescription = "No Description";

    public EventObject(){
        //no-arg constructor needed
    }

    public EventObject(String eventName, String dateSet, String dateDue, String eventDescription) {

        this.eventName = eventName;
        this.dateSet = dateSet;
        this.dateDue = dateDue;
        this.eventDescription = eventDescription;
    }

    public String getEventName() {

        return eventName;
    }

    public String getEventID() {
        return  eventID;
    }

    public String getDateSet(){
        return dateSet;
    }

    public String getDateDue() {
        return dateDue;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventID(String eventID) {
        this.eventID = eventID;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setDateSet(String dateSet) {
        this.dateSet = dateSet;
    }

    public void setDateDue(String dateDue) {
        this.dateDue = dateDue;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }
}
