package pl.squirrel.graphqlbug;

public class TodoInput {
    private String what;

    public TodoInput() {
    }

    public TodoInput(String what) {
        this.what = what;
    }

    public String getWhat() {
        return what;
    }

    public void setWhat(String what) {
        this.what = what;
    }
}
