package com.mycompany.hw1_131044084_mehmed_mustafa;

import java.util.Calendar;

/**
 *
 * @author Mehmed Mustafa 131044084
 */
public class mainTester {
    public static void main(String [] args){
        
        System.out.println("--------START ADDING USERS TO MOODLE------------");
        Administrator admin = new Administrator("No", "Mercy");
        SystemMoodle.addUser(admin);
        
        Teacher teacher1 = new Teacher("Erkan", "Zergeroglu");
        Teacher teacher2 = new Teacher("Sinan", "Akgul");
        Teacher teacher3 = new Teacher("Erdogan", "Sevilgen");
        Student student1 = new Student("Mehmed", "Mustafa");
        Student student2 = new Student("Ali", "Yasin");
        Student student3 = new Student("Stilian", "Ivanov");
        Student student4 = new Student("Chuck", "Norris");
        
        admin.addUser(teacher1);
        admin.addUser(teacher2);
        admin.addUser(teacher3);
        admin.addUser(student1);
        admin.addUser(student2);
        admin.addUser(student3);
        admin.addUser(student4);
        admin.addUser(new Administrator("Salih", "Bulut"));
        System.out.println();
        
        // Trying to add users that are already in the moodle
        admin.addUser(new Student("Ali", "Yasin"));
        admin.addUser(new Teacher("Erdogan", "Sevilgen"));
        System.out.println("--------END ADDING USERS TO MOODLE------------\n");
        
        System.out.println("--------START ADDING COURSES TO MOODLE------------");
        Course course1 = new Course("BIL244", teacher1);
        Course course2 = new Course("BIL241", teacher2);
        Course course3 = new Course("BIL102", teacher3);
        Course course4 = new Course("BIL108", teacher3);        
        
        admin.addCourse(course1);
        admin.addCourse(course2);
        admin.addCourse(course3);
        admin.addCourse(course4);
        System.out.println("--------END ADDING COURSES TO MOODLE------------\n");
        
        System.out.println("--------START ADDING STUDENTS TO COURSES------------");
        teacher2.addStudentToCourse(student1, "BIL241");
        teacher2.addStudentToCourse(student2, "BIL241");
        teacher2.addStudentToCourse(student3, "BIL241");
        teacher2.addStudentToCourse(student4, "BIL241");
        System.out.println();
        // Trying to add students that are already added to a course
        teacher2.addStudentToCourse(student2, "BIL241"); 
        System.out.println("--------END ADDING STUDENTS TO COURSES------------\n");

        course2.printTheCourseStudents();
        teacher2.removeStudentFromCourse("Ali", "Yasin", "BIL241");
        System.out.println();
        course2.printTheCourseStudents();
        teacher2.addStudentToCourse(student2, "BIL241");
        System.out.println();
        
        System.out.println("--------TRYING TO REMOVE STUDENT FROM ANOTHER COURSE------------");
        // Teacher can't remove student from course that doesn't manage
        teacher3.removeStudentFromCourse("Mehmed", "Mustafa", "BIL241");
        
        // But can add and remove student from course that manage
        teacher3.addStudentToCourse(new Student("Badi", "Muhles"), "BIL102");
        teacher3.removeStudentFromCourse("Badi", "Muhles", "BIL102");
        System.out.println("--------END TRYING TO REMOVE STUDENT FROM ANOTHER COURSE------------\n");
        
        System.out.println("-------START ADDING DOCUMENT TO COURSE---------");
        teacher2.addDocumentToCourse(new Book("CourseBook", "pdf", teacher2), "BIL241");
        teacher2.addDocumentToCourse(new Slide("CourseSlides", "ppt", teacher2), "BIL241");
        teacher2.addDocumentToCourse(new Document("UnknownTypeDoc", teacher2), "BIL241");
        // Trying to remove document that is not on the course
        teacher2.removeDocumentFromCourse("CourseBook", "ppt", "BIL241");
        System.out.println();
        course2.printTheCourseDocuments();
        teacher1.addDocumentToCourse(new Slide("System programming", "ppt", teacher1), "BIL244");
        teacher1.addDocumentToCourse(new Book("System programming", "pdf", teacher1), "BIL244");
        teacher1.addDocumentToCourse(new Slide("System programming", "ppxt", teacher1), "BIL244");
        teacher1.addDocumentToCourse(new Book("System programming", "pdf", teacher1), "BIL244");
        // Trying to cheat and use another teachers name to add document to his course
        // teacher3 is the manager of the BIL102 course
        teacher1.addDocumentToCourse(new Book("Preparation questions", "pdf", teacher3), "BIL102");
        // But we aren't allowed to do that.
        
        // Trying to remove document from another course that the teacher doesn't manage
        teacher1.removeDocumentFromCourse("CourseBook", "pdf", "BIL241");
        System.out.println();
        course1.printTheCourseDocuments();
        System.out.println("-------END ADDING DOCUMENT TO COURSE------------\n");        
        
        System.out.println("-------START TESTING ASSIGNMENTS AND SUBMISSIONS---------");        
        Student student5 = new Student("Emrah", "Ardali");
        Student student6 = new Student("Mustafa", "Saygin");
        Student student7 = new Student("Tuna", "Keskin");
        Student student8 = new Student("John", "Anderson");
        
        admin.addUser(student5);
        admin.addUser(student6);
        admin.addUser(student7);
        admin.addUser(student8);
        System.out.println();
        
        teacher1.addStudentToCourse(student5, "BIL244");
        teacher1.addStudentToCourse(student6, "BIL244");
        teacher1.addStudentToCourse(student7, "BIL244");
        //teacher1.addStudentToCourse(student8, "BIL244");
        System.out.println();
                
        //Deadline day
        Calendar hw1dl = Calendar.getInstance();
        hw1dl.set(Calendar.YEAR, 2016);
        hw1dl.set(Calendar.MONTH, 3);
        hw1dl.set(Calendar.DAY_OF_MONTH, 13);
        
        //Late deadline day
        Calendar hw1ldl = Calendar.getInstance();
        hw1ldl.set(Calendar.YEAR, 2016);
        hw1ldl.set(Calendar.MONTH, 3);
        hw1ldl.set(Calendar.DAY_OF_MONTH, 18);
        
        Assignment hw1 = new Homework("HW1", hw1dl, hw1ldl);
        teacher1.addAssignmentToCourse(hw1, "BIL244");
        System.out.println(hw1);
        
        System.out.println();
        student5.addSubmission("BIL244", "HW1", new RarForHomework("HW1_Emrah", "rar", student5));
        student6.addSubmission("BIL244", "HW1", new RarForHomework("HW1_Mustafa", "rar", student6));
        System.out.println();
        
        teacher1.isStudentSubmissionExist("HW1", "BIL244", student5);
        teacher1.isStudentSubmissionExist("HW1", "BIL244", student6);
        teacher1.isStudentSubmissionExist("HW1", "BIL244", student7);
        teacher1.isStudentSubmissionExist("HW1", "BIL244", student8);
        System.out.println();
        
        teacher1.gradeSubmission("HW1", "BIL244", student5, "AA");
        teacher1.gradeSubmission("HW1", "BIL244", student6, "BA");
        teacher1.gradeSubmission("HW1", "BIL244", student7, "NA");
        teacher1.gradeSubmission("HW1", "BIL244", student8, "NA");
        
        System.out.println("START CHECKING GRADES: ");
        student5.viewCourseGrade("BIL244", "HW1");
        student6.viewCourseGrade("BIL244", "HW1");
        student7.viewCourseGrade("BIL244", "HW1");
        student8.viewCourseGrade("BIL244", "HW1");
        System.out.println("END CHECKING GRADES: ");
        
        System.out.println();
        // Wrong callings to check protection
        // teacher2 can't grade students for course he doesn't manage
        teacher2.gradeSubmission("HW1", "BIL244", student5, "AA");        
        // student5 trying to upload hw1 to a course he is not enrolled
        student5.addSubmission("BIL102", "HW1", new RarForHomework("HW1_Emrah", "rar", student5));
        System.out.println("-------END TESTING ASSIGNMENTS AND SUBMISSIONS---------\n");
        
        System.out.println("-------START TESTING WHAT USERS CAN SEE---------");
        student5.viewCourseLectures("BIL244");
        student5.viewCourseLectures("BIL102");
        student2.viewCourseLectures("BIL244");
        System.out.println("-------END TESTING WHAT USERS CAN SEE---------");
        System.out.println();
        System.out.println("---------------PRINT ALL USERS IN THE MOODLE---------------");
        // Polymorphizm
        SystemMoodle.printAllUsersByTheirRights();
 
    // There was no enought time for more functions testing here, sorry!

    }

}
