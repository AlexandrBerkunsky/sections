package tables;

import javax.persistence.*;

@Entity
public class School {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    public School(String name, String phone, String address) {
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public School(int id, String name, String phone, String address) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.id = id;
    }

    public School() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(length = 100)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(length = 40)
    private String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}
