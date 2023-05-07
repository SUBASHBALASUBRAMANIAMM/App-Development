package com.example.todo;


import java.util.ArrayList;

public class Utils {
    public static Utils getInstance;
    private ArrayList<task>needToCompleted;
    private ArrayList<task>completed;
    private Utils() {
        if(needToCompleted==null){
            needToCompleted=new ArrayList<>();
//            initdata();
        }


    }

    public static Utils getInstance() {
        if (getInstance == null) {
            return getInstance = new Utils();

        }

        return getInstance;
    }
    private void initdata(){
        needToCompleted.add(new task("hi",true,"hhbb"));
        needToCompleted.add(new task("bye",true,"oihgfc"));
    }

    public ArrayList<task> getNeedToCompleted() {
        return needToCompleted;
    }

    public void setNeedToCompleted(task t) {
        needToCompleted.add(0,t);
    }

    public ArrayList<task> getCompleted() {
        return completed;
    }

    public void setCompleted(ArrayList<task> completed) {
        this.completed = completed;
    }
}
