package edu.curso.java.hibernate.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Persona {

    private Long id;

    private String name;

    private String phone;

    private String address;

    private Collection < Tablet > tablets = new ArrayList < Tablet >();

    public Persona() {
    }

    public Persona(String name, String phone, String address) {
        super();
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public Collection < Tablet > getTablets() {
        return tablets;
    }

    public void setTablets(List < Tablet > tablet) {
        this.tablets = tablet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Persona [id=" + id + ", name=" + name + ", phone=" + phone
                + ", address=" + address + ", tablet=" + tablets + "]";
    }

}
