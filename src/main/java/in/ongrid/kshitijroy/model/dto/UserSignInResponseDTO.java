package in.ongrid.kshitijroy.model.dto;

public class UserSignInResponseDTO {
    public Long id;
    private String name;



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

    public UserSignInResponseDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
