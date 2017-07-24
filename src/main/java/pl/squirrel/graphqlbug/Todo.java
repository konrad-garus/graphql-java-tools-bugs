package pl.squirrel.graphqlbug;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String what;
    private boolean done;

    public Todo() {
    }

    public Todo(String what) {
        this.what = what;
    }

    public Todo(String what, boolean done) {
        this.what = what;
        this.done = done;
    }

    public int getId() {
        return id;
    }

    public String getWhat() {
        return what;
    }

    public void setWhat(String what) {
        this.what = what;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
