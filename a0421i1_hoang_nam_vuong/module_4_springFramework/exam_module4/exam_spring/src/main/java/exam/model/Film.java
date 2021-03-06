package exam.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Film {
    @Id
    private String id;

    private String name;

    @OneToMany(mappedBy = "film")
    List<ShowTime> showList;

    public Film() {
    }

    public Film(String id, String name, List<ShowTime> showList) {
        this.id = id;
        this.name = name;
        this.showList = showList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ShowTime> getShowList() {
        return showList;
    }

    public void setShowList(List<ShowTime> showList) {
        this.showList = showList;
    }
}
