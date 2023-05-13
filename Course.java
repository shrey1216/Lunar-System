//@author Shreyan Wankavala
//112634232
//Recitation 01

import java.io.*;

public class Course implements Serializable {

    private String department;
    private int number;
    private String semester;

    /** A constructor which takes in the department, number, and semester of a course as parameters.
     *
     * @param department = the department of a course in three letters
     * @param number = the course number
     * @param semester = the semester the student will be taking the course
     */
    public Course(String department, int number, String semester){
        this.department = department;
        this.number = number;
        this.semester = semester;
    }

    /** A method to set the department of a course
     *
     * @param department = the department of the course
     */
    public void setDepartment(String department){
        this.department = department;
    }

    /** a method to set the number of the course
     *
     * @param number = the number of the course
     */
    public void setNumber(int number){
        this.number = number;
    }

    /** a method to set the semester of a course
     *
     * @param semester = the semester of the course
     */
    public void setSemester(String semester){
        this.semester = semester;
    }

    /** A method which returns the department of a given course
     *
     * @return the department of the course
     */
    public String getDepartment(){
        return this.department;
    }

    /** A method which returns the number of a given course
     *
     * @return the number for a course
     */
    public int getNumber(){
        return this.number;
    }

    /** A method which returns the semester of a given course
     *
     * @return the semester for a course
     */
    public String getSemester(){
        return this.semester;
    }

    /** A method which returns the instance variables of Course as a string
     *
     * @return the instance variables of Course as a string
     */
    public String toString(){
        return department + "    " + number + "    " + semester;
    }
}
