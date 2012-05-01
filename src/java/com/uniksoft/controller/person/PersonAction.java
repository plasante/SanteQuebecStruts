package com.uniksoft.controller.person;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.uniksoft.model.Person;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

public class PersonAction extends ActionSupport implements ModelDriven<Person> {

    private Person person = new Person();
    private List<Person> personList = new ArrayList<Person>();
    private PersonDAO personDAO = new PersonDAO();
    
    @Override
    public Person getModel() {
        return person;
    }

    public String saveOrUpdate() {
        personDAO.saveOrUpdate(person);
        return SUCCESS;
    }
    
    public String list() {
        personList = personDAO.listUser();
        return SUCCESS;
    }
    
    public String edit() {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        person = personDAO.listPersonById(Integer.parseInt(request.getParameter("id")));
        return SUCCESS;
    }
    
    public String delete() {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        personDAO.deletePerson(Integer.parseInt(request.getParameter("id")));
        return SUCCESS;
    }
    
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }
}
