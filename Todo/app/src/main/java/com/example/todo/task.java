package com.example.todo;


public class task {

    String string;
    boolean checkedOrUnchecked;
    String desc;

    public task(String desc) {
        this.desc = desc;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public boolean isCheckedOrUnchecked() {
        return checkedOrUnchecked;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setCheckedOrUnchecked(boolean checkedOrUnchecked) {
        this.checkedOrUnchecked = checkedOrUnchecked;
    }

    public task(String string, boolean checkedOrUnchecked, String desc) {
        this.string = string;
        this.checkedOrUnchecked = checkedOrUnchecked;
        this.desc = desc;
    }
}
