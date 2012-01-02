package classes;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class computeForm extends org.apache.struts.action.ActionForm {
    
    private String setDayOfWeek;
    private int day, month, year;

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getSetDayOfWeek() {
        return setDayOfWeek.toString();
    }

    void setDayOfWeek(String setDayOfWeek) {
       this.setDayOfWeek = setDayOfWeek;
    }

    public computeForm() {
        super();
    }

    @Override
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        int z=0;
        if((month>12) || (month<=0)) { z=1; }
        if((day>31) || (day<=0)) { z=1; }
        if((day>30) && ((month==4) || (month==6) || (month==9) || (month==11))) { z=1; }
        if(month==2){
            if(day>29) { z=1; }
            if((day==29) && ((year%4)!=0)) { z=1; }
        }
        /*if ((year<1752)) { z=1; }*//*Test Error500*/
        if (z!=0) {errors.add("forall", new ActionMessage("errors.forall"));}
        return errors;
    }
}

