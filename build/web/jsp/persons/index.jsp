<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<h2>Person CRUD</h2>
<s:form action="saveOrUpdatePerson">
    <s:push value="person">
        <s:hidden name="id"/>
        <s:textfield name="name" label="User Name"/>
        <s:radio name="gender" label="Gender" list="{'Male','Female'}"/>
        <s:select name="country" list="{'Canada','USA','Mexico'}"
                  headerKey="" headerValue="Select"
                  label="Select a country"/>
        <s:textarea name="aboutYou" label="About You"/>
        <s:checkbox name="mailingList" label="Would you like to join our mailing list?"/>
        <s:submit align="center"/>
    </s:push>
</s:form>

<s:if test="personList.size() > 0">
    <table>
        <tr>
            <th>Name</th>
            <th>Gender</th>
            <th>Country</th>
            <th>About You</th>
            <th>Mailing List</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <s:iterator value="personList">
        <tr>
            <td><s:property value="name"/></td>
            <td><s:property value="gender"/></td>
            <td><s:property value="country"/></td>
            <td><s:property value="aboutYou"/></td>
            <td><s:property value="mailingList"/></td>
            <td><s:url id="editURL" action="editPerson">
                    <s:param name="id" value="%{id}"/>
                </s:url><s:a href="%{editURL}">Edit</s:a></td>
            <td><s:url id="deleteURL" action="deletePerson">
                    <s:param name="id" value="%{id}"/>
                </s:url><s:a href="%{deleteURL}">Delete</s:a></td>
        </tr>
        </s:iterator>
    </table>
</s:if>

