package org.example.demoorm.model.DTO;
import org.example.demoorm.model.entity.Province;
import org.springframework.web.multipart.MultipartFile;

public class CustomerForm {
    private int id;

    private String name;
    private String email;
    private String address;

    private MultipartFile img;

    private Province province;

    public CustomerForm(int id, String name, String email, String address, MultipartFile img, Province province) {
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

    public MultipartFile getImg() {
        return img;
    }

    public void setImg(MultipartFile img) {
        this.img = img;
    }

    public CustomerForm(int id, String name, String email, String address, MultipartFile img) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.img = img;
    }

    public CustomerForm() {
    }

    public CustomerForm(int id, String name, String email, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
}
