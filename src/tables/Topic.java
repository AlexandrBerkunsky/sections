package tables;

import javax.persistence.*;

@Entity
public class Topic {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    public Topic(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public Topic() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(length = 50)
    @Basic
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
