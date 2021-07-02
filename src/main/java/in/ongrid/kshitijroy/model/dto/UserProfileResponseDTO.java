package in.ongrid.kshitijroy.model.dto;

import in.ongrid.kshitijroy.model.entity.Address;

public class UserProfileResponseDTO {
    private Long id;
    private String name;
    private String email;
    private String houseDetail;
    private String city;

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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserProfileResponseDTO(Long id, String name, String email, String houseDetail, String city) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.houseDetail = houseDetail;
        this.city = city;
    }

    public String getHouseDetail() {
        return houseDetail;
    }

    public void setHouseDetail(String houseDetail) {
        this.houseDetail = houseDetail;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
