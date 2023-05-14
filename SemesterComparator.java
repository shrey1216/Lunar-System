//@author Shreyan Wankavala

import java.io.Serializable;
import java.util.*;

public class SemesterComparator implements Comparator, Serializable {

    /** A method to override compare from Comparator
     *
     * @param o1 = the first object
     * @param o2 = the second object
     * @return
     */
    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }

    /** A method to compare two course objects given the left and right objects using their semesters
     *
     * @param left = the left object
     * @param right = the right object
     * @return 1 if the left and right objects should be switched. Return 0 otherwise.
     */
    public int compare(Course left, Course right){
        int answer = 0;

        if(Integer.parseInt(left.getSemester().substring(1)) > Integer.parseInt(right.getSemester().substring(1))){
            answer = 1;
        }else if(Integer.parseInt(left.getSemester().substring(1)) == Integer.parseInt(right.getSemester().substring(1))){
            if(left.getSemester().charAt(0) < right.getSemester().charAt(0)){
                answer = 1;
            }
        }

        return answer;
    }
}
