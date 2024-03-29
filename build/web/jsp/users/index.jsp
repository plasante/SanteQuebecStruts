<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<s:actionmessage/>
<s:actionerror/>
<h2>Users Page</h2>
<table>
    <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Username</th>
        <th>Encrypted Password</th>
        <th>Salt</th>
    </tr>
    <s:iterator value="users">
        <tr>
            <td><s:property value="firstName"/></td>
            <td><s:property value="lastName"/></td>
            <td><s:property value="username"/></td>
            <td><s:property value="encryptedPassword" /></td>
            <td><s:property value="salt" /></td>
            <td><a href="editUser?id=<s:property value="id"/>">Edit</a></td>
            <td><a href="deleteUser?id=<s:property value="id"/>">Delete</a></td>
        </tr>
    </s:iterator>
</table>