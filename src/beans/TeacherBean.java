package beans;

import dao.TeacherDAO;
import tables.Teacher;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class TeacherBean implements Serializable {
    @EJB
    TeacherDAO teacherDAO;

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    private Teacher teacher = new Teacher();

    public List<Teacher> getTeachers(){
        return teacherDAO.findAll();
    }

    public void add() {
        //TODO Проверить, почему не добавляется
        System.out.println(">>>" + teacher.getName());
        teacherDAO.add(teacher);
        teacher = new Teacher();
    }
}
