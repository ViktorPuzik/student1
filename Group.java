package sample;

import java.util.Arrays;
import java.util.Comparator;

public class Group {
	private String groupName;
	private Student[] studens = new Student[10];
	public Group(String groupName, Student[] studens) {
		super();
		this.groupName = groupName;
		this.studens = studens;
	}
	public Group() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public Student[] getStudens() {
		return studens;
	}
	public void setStudens(Student[] studens) {
		this.studens = studens;
	}
	public void addStudent(Student student) throws GroupOverflowException {
		for (int i = 0; i < studens.length; i++) {
			if ((studens[i] == null)||(studens[i].getId() == -1)) {
				student.setGroupName(this.groupName);
				studens[i] = student;
				return;
			}
		} throw new GroupOverflowException(student.getLastName() + " не добавлен. Группа "
			+ student.getGroupName() + " заполнена");
	}
	public Student searchStunentByLastName (String lastName) throws StudentNotFoundException {
		for (int i = 0; i < studens.length; i++) {
			if (studens[i].getLastName() == lastName) {
				return studens[i];
			}
		} throw new StudentNotFoundException("Student " + lastName + " not found");
		
	}
	public boolean removeStudentByID(int id) {
		for (int i = 0; i < studens.length; i++) {
			if (studens[i] != null && studens[i].getId() == id) {
				studens[i]= null;
				return true;
			}
		}
		return false;
	}
	public void sortStudentsByLastName() {
		
		Arrays.sort(studens, Comparator.nullsLast(new SortLastNameComparator()));
	}
	@Override
	public String toString() {
		return "Group [groupName=" + groupName + ", studens=" + Arrays.toString(studens) + "]";
	}
	
}
