<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<CENTER><html:html lang="true">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><bean:message key="welcome.title"/></title>
        <html:base/>
    </head>
        <html:form action="/compute">
        <logic:present cookie="cookie1">
            <logic:notPresent cookie="JSESSIONID">
                <bean:cookie id="cookie1" name="cookie1"/>
                <bean:define id="thisval1" name="cookie1" property="value"/>
                <bean:cookie id="cookie2" name="cookie2"/>
                <bean:define id="thisval2" name="cookie2" property="value"/>
                <bean:cookie id="cookie3" name="cookie3"/>
                <bean:define id="thisval3" name="cookie3" property="value"/>
            </logic:notPresent>
        </logic:present>
        <logic:present cookie="JSESSIONID">
            <bean:define id="thisval1" name="computeForm" property="day"/>
            <bean:define id="thisval2" name="computeForm" property="month"/>
            <bean:define id="thisval3" name="computeForm" property="year"/>
        </logic:present>

        <h3><bean:message key="welcome.heading"/></h3>
        <center><img src="calendar.gif" width="300" height="225" alt="calendar"/></center>
        <p><bean:message key="welcome.message"/></p>
        
        <html:errors property="forall"/>
        <table border="0" cellspacing="4" cellpadding="4">
            <tbody>
                <tr>
                    <td><bean:message key="welcome.day" /></td>
                    <td><html:text property="day" size="10" maxlength="2" value="${thisval1}"/></td>
                </tr>
                <tr>
                    <td><bean:message key="welcome.month" /></td>
                    <td><html:text property="month" size="10" maxlength="2" value="${thisval2}"/></td>
                </tr>
                <tr>
                    <td><bean:message key="welcome.year" /></td>
                    <td><html:text property="year" size="10" maxlength="4" value="${thisval3}"/></td>
                </tr>
                <tr>
                    <td></td>
                    <td><html:submit value="FIND DAY" /></td>
                </tr>
            </tbody>
        </table>
        </html:form>
        <div>
            <center><a href="moreinfo.jsp">History of Gregorian Calendar</a></center>    
        </div>
    </body>
</html:html></CENTER>