package in.ongrid.kshitijroy.model.dto;

public class AddressDTO {
    private String houseDetail;
    private String city;
    private String pincode;

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

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public AddressDTO(String houseDetail, String city, String pincode) {
        this.houseDetail = houseDetail;
        this.city = city;
        this.pincode = pincode;
    }
}
