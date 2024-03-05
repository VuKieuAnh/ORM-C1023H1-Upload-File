package org.example.demoorm.model;
import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String address;

    private String img;

    public String getImg() {
        return img;
    }



    public void setImg(String img) {
        this.img = img;
    }

    public Customer() {
    }

    public Customer(Long id, String name, String email, String address, String img) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.img = img;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    //    public Customer(int id, String name, String email, String address) {
//        this.id = id;
//        this.name = name;
//        this.email = email;
//        this.address = address;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @ManyToOne
    @JoinColumn(name="province_id")
    private Province province;

    public Customer(Long id, String name, String email, String address, String img, Province province) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.img = img;
        this.province = province;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }
}
