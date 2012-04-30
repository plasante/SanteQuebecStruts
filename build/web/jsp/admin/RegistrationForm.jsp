<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<h2>Registration Form</h2>
<s:actionerror/><s:actionmessage/>
<s:form action="addUser" method="post" validate="true">
    <s:textfield name="firstName" label="First Name"/>
    <s:textfield name="lastName"  label="Last Name"/>
    <s:textfield name="username"  label="Username"/>
    <s:textfield name="email"     label="Email"/>
    <s:password  name="password"  label="Password"/>
    <s:password  name="passwordConfirmation" label="Password Confirmation"/>
    <s:submit value="Register" align="center"/>
</s:form>