<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<h2>Edit User</h2>
<s:actionerror/>
<s:form action="updateUser" method="post" validate="true">
    <s:hidden name="user.id"/>
    <s:textfield name="user.firstName" label="First Name"/>
    <s:textfield name="user.lastName" label="Last Name"/>
    <s:textfield name="user.username" label="Username"/>
    <s:textfield name="user.email" label="Email"/>
    <s:password name="password" label="Password"/>
    <s:password name="passwordConfirmation" label="Password Confirmation"/>
    <s:submit value="Update User" align="center"/>
</s:form>