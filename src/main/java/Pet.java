import java.util.List;
import java.util.Locale;

public class Pet {
    private long id;

    private String name;

    private String status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }





    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }





    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +

                ", name='" + name + '\'' +


                ", status='" + status + '\'' +
                '}';
    }

  //  public Pet(long id, Category category, String name, List<String> photoUrls, List<TagPet> tags, String status)
    public Pet(long id,  String name, String status){
        this.id = id;
//        this.category = category;
        this.name = name;
//        this.photoUrls = photoUrls;
//        this.tags = tags;
        this.status = status;
    }
}
