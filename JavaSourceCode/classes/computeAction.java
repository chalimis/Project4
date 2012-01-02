package classes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class computeAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    private static final String FAILURE = "failure";

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
      
        ActionErrors errors = new ActionErrors();
        computeForm dateData = (computeForm) form;

        int day = dateData.getDay();
        int month = dateData.getMonth();
        int year = dateData.getYear();
        
        Cookie cookie1 = new Cookie("cookie1", Integer.toString(day));
        cookie1.setMaxAge(30*60);
        response.addCookie(cookie1);
        Cookie cookie2 = new Cookie("cookie2", Integer.toString(month));
        cookie2.setMaxAge(30*60);
        response.addCookie(cookie2);
        Cookie cookie3 = new Cookie("cookie3", Integer.toString(year));
        cookie3.setMaxAge(30*60);
        response.addCookie(cookie3);
        
        int dayOfWeek, valcen, valleap, valmon, valyear, valday;

        int[] centuries = new int[4];
        centuries[0] = 2;
        centuries[1] = 0;
        centuries[2] = 5;
        centuries[3] = 3;

        int[] months = new int[13];
        months[1] = 5;
        months[2] = 1;
        months[3] = 0;
        months[4] = 3;
        months[5] = 5;
        months[6] = 1;
        months[7] = 3;
        months[8] = 6;
        months[9] = 2;
        months[10] = 4;
        months[11] = 0;
        months[12] = 2;

        String[] daysOfWeek = new String[7];
        daysOfWeek[0] = "Sunday";
        daysOfWeek[1] = "Monday";
        daysOfWeek[2] = "Tuesday";
        daysOfWeek[3] = "Wednesday";
        daysOfWeek[4] = "Thursday";
        daysOfWeek[5] = "Friday";
        daysOfWeek[6] = "Saturday";

        try {

            if (month < 3) {
                year--;
            }

            valcen = centuries[year / 100 % 4];
            valleap = year % 100 / 4;
            valyear = year % 100 % 7;
            valmon = months[month];
            valday = day % 7;
            dayOfWeek = valcen + valleap + valyear + valmon + valday;
            dayOfWeek = dayOfWeek % 7;

            dateData.setDayOfWeek(daysOfWeek[dayOfWeek]);

            request.setAttribute("dateData", dateData); 
        } catch (Exception e) {
            errors.add("exception", new ActionMessage("exception.nameofDay"));
             throw new UnsupportedOperationException(e.fillInStackTrace());
        }

        saveErrors(request, errors);
        if (errors.isEmpty()) {
            return mapping.findForward(SUCCESS);
        } else {
            return mapping.findForward(FAILURE);
        }
    }
}