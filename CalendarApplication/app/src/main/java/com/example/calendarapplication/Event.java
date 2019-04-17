//based on Task.java
import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "events")
public class Event {
   @PrimaryKey
   private int _id;

   @NonNull
   @ColumnInfo(name = "event")
   private String event;

   @NonNull
   @ColumnInfo(name = "date")
   private String date;

   public int get_id(){return _id;}
   public void set_id(int the_id){ _id = the_id;}

   public String get_event(){return event;}
   public void set_event(String the_event){event = the_event;}

   public String get_date(){return date;}
   public void set_date(String the_date){date = the_date;}
}
