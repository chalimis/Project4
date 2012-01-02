<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<CENTER><html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Found Day</title>
    </head>
    <body>
        <h1>Day of Week</h1>
        <center><img src="calendar6.gif" width="100" height="98" alt="calendar6"/>
        </center>
        <ul>
            <p>The Day of week for this entry is <strong> <bean:write name="computeForm" property="setDayOfWeek"/></strong> </p>
        </ul>
        <ul>
            <center><p>Return to <a href="index.jsp"> Home Page </a></p></center>
        </ul>
        <ul><center><p><a href="celebration.jsp">See most important Name Days</a></p></center></ul>
    </body>

</html></CENTER>

