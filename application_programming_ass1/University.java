import java.util.*;

public class University
{
    private LinkedList<Subject> subjects = new LinkedList<Subject>();
    private LinkedList<Student> students = new LinkedList<Student>();

    public University()
    {
        Subject sub1 = new Subject(48024,"Applications Programming");
        Subject sub2 = new Subject(31284,"Web Services Development");
        addActivities(sub1);
        addActivities(sub2);
        subjects.add(sub1);
        subjects.add(sub2);
    }

    public void addActivities(Subject subject)
    {

        if(subject.getName().equals("Applications Programming"))
        {
            subject.addActivity("Lec1",1,"Wed",18,1,"CB11.00.405",200);
            subject.addActivity("Cmp1",1,"Wed",19,2,"CB11.B1.403",2);
            subject.addActivity("Cmp1",2,"Wed",19,2,"CB11.B1.401",2);
            subject.addActivity("Cmp1",3,"Wed",19,2,"CB11.B1.402",2);
        }
        else
        {

            subject.addActivity("Lec1",1,"Tue",16,1,"CB02.03.002",160);
            subject.addActivity("Cmp1",1,"Tue",9,2,"CB11.B1.102",30);
            subject.addActivity("Cmp1",2,"Tue",9,2,"CB11.B1.103",30);
            subject.addActivity("Cmp1",3,"Tue",14,2,"CB11.B1.102",30);
            subject.addActivity("Cmp1",4,"Tue",14,2,"CB11.B1.103",30);

        }
    }

    public static void main (String [] args)
    {
        new University().use();
    }

    public void use()
    {
        char choice;
        while((choice = readChoice()) != 'x')
        {
            switch (choice)
            {
                case 'a': addStudent(); break;
                case 'r': removeStudent(); break;
                case 'v': viewAllStudents(); break;
                case 'l': login(); break;
                default: help(); break;
            }
        }

    }

    private char readChoice() {
        System.out.print("Choice (a/r/v/l/x): ");
        return In.nextChar();
    }

    private void help() {
        System.out.println("University menu options");
        System.out.println("a = add a student");
        System.out.println("r = remove a student");
        System.out.println("v = view all students");
        System.out.println("l = login");
        System.out.println("x = exit");
    }

    public void addStudent()
    {
        String number = readNumber();
        if(checkNumber(number))
        {
            System.out.println("Student number already exists"); 
        }
        else
        {
            String name = readName();
            students.add(new Student(number,name));
        }

    }

    public void removeStudent()
    {

        String number = readNumber();

           
        for(int i =0;i<students.size();i++)
        {
            Student student = students.get(i);
            if(students.get(i).hasNumber(number))
            {

                students.get(i).removeEnrolled();
                students.remove(i);
                return;

            }
        }

        /*for(Iterator<Student> it = students.iterator(); it.hasNext();)
        if(it.next().hasNumber(number))
        {
        it.remove();

        }*/
        
        
        System.out.println("No such student");

    }
    public void viewAllStudents()
    {

        for (Student student : students)
        {  
            //removeStudent();
            System.out.println(student);

        }

    }

    public void login()
    {
        String number = readNumber();
        Student student = student(number);
        if (student!= null)
        {
            showStudentOptions(student);
        }

        else
        {
            System.out.println("No such student");
        }
    }

    private String readNumber()
    {
        System.out.print("Number: ");
        String number = In.nextLine();
        return number;
    }

    private String readName()
    {
        System.out.print("Name: ");
        return In.nextLine();
    }

    private boolean checkNumber(String number)
    {
        for (Student student: students) 
        {
            if (student.hasNumber(number))
                return true;            
        }
        return false;

    }

    private Student student(String number)
    {
        for (Student student: students) 
        {
            if (student.hasNumber(number))
                return student;            
        }
        return null;
    }

    public void showStudentOptions(Student student)
    {
        char choice;
        while((choice = StudentReadChoice()) != 'x')
        {
            switch (choice)
            {
                case 'v': studentViewEnrolledActivities(student); break;
                case 'e': studentEnrolInActivity(student); break;
                case 'w': withdrawFromActivity(student); break;
                default: studentOptionsHelp();
                break;
            }
        }

    }

    private char StudentReadChoice() 
    {
        System.out.print("Choice (v/e/w/x): ");
        return In.nextChar();
    }

    private void studentOptionsHelp() 
    {
        System.out.println("Student menu options");
        System.out.println("v = view my activities");
        System.out.println("e = enrol in an activity");
        System.out.println("w = withdraw from an activity");
        System.out.println("x = exit");
    }

    public void studentViewEnrolledActivities(Student student)
    {
        student.viewEnrolledActivity();       
    }

    public void studentEnrolInActivity(Student student)
    {
        int subjectNumber=0;
        Activity enrolledActivity, tempActivity = null;
        String [] tempInput;
        System.out.println("Select a subject");
        for (Subject subject: subjects)
        {
            System.out.println(subject);
        }
        subjectNumber = readSubjectNumber();
        Subject subject = subject(subjectNumber);

        if(checkSubject(subjectNumber))
        { //check subject
            System.out.println("Select an activity"); 
            if(subject!=null)
            {
                subject.printActivity(subject);   
            }
            System.out.print("Activity code (group:activity): ");
            String choiceInput =In.nextLine();
            tempInput = choiceInput.split(":");   
            String group = tempInput[0];

            if(tempInput.length == 2)
            {
                int activityNumber = Integer.parseInt(tempInput[1]);
                if(checkActivity(subject, group,activityNumber)== false)
                {
                    System.out.println("No such activity");
                }
                else
                {
                    if(group.equals("Lec1"))
                    {
                        enrolledActivity = subject.enrolInActivity(group,activityNumber); 
                        if(enrolledActivity!=null)
                        {
                            student.addEnrolledActivityToList(enrolledActivity);
                        }
                    }
                    else 
                    {

                        tempActivity = student.hasCmp1(subject);
                        if(tempActivity != null)
                        {
                            student.removeEnrolledActivity(tempActivity);
                            subject.withdrawStudentFromActivity(tempActivity);
                            enrolledActivity = subject.enrolInActivity(group,activityNumber); 
                            if(enrolledActivity!=null)
                            {
                                student.addEnrolledActivityToList(enrolledActivity);
                            }
                        }
                        else
                        {
                            enrolledActivity = subject.enrolInActivity(group,activityNumber); 
                            if(enrolledActivity!=null)
                            {
                                student.addEnrolledActivityToList(enrolledActivity);
                            }
                        }

                    }
                }
            }
            else if(tempInput.length == 1)
            {

                Subject subSubject = subject(subjectNumber);
                Activity activity = subSubject.autoEnrol(tempInput[0]);
                if(activity!=null)
                {
                    student.addEnrolledActivityToList(activity);
                }
                else
                {
                    System.out.println("No available seats");
                }

            }
        }
        else
        {
            System.out.println("No such subject");
        }
    }

    private int readSubjectNumber()
    {
        System.out.print("Subject number: ");
        int number = In.nextInt();
        return number;
    }
    //NEW
    public void withdrawFromActivity(Student student)
    {
        String [] tempInput;
        System.out.print("Activity code (subject:group): ");
        String choiceInput =In.nextLine();
        tempInput = choiceInput.split(":");   
        String group = tempInput[1];
        int subjectNumber = Integer.parseInt(tempInput[0]);        
        Subject subject = subject(subjectNumber);

        Activity subjectEnrolled = null;
        if(checkSubject(subjectNumber))
        {
            if(checkSubjectActivity(subject,subjectNumber,group)== false)
            {
                System.out.println("Not enrolled in activity");

            }
            else
            {
                subjectEnrolled = student.hasSubjectGroup(subject,group);
                if(subjectEnrolled != null)
                {
                    student.removeEnrolledActivity(subjectEnrolled);
                    subject.withdrawStudentFromActivity(subjectEnrolled);

                }
                else
                {
                    //System.out.println("subject not enrolled yet");
                    System.out.println("Not enrolled in activity");

                }

            }
        }
        else
        {
            System.out.println("Not enrolled in activity");
            // System.out.println("Not enrolled subject");
        }
    }

    private boolean checkSubject(int number)
    {
        for (Subject subject: subjects) 
        {
            if(subject.getNumber()== number)
            {
                return true;
            }
        }
        return false;
    }

    private Subject subject(int number)
    {
        for (Subject subject: subjects) 
        {
            if (subject.getNumber()== number)
                return subject;            
        }
        return null;
    }

    private boolean checkActivity(Subject subject,String group,int number)
    {

        if(subject.checkActivity(group, number))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    private boolean checkSubjectActivity(Subject subject,int subjectNumber,String group)
    {

        if(subject.checkSubjectActivity(subjectNumber, group))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    //NEW
    //checks if activity is full or not
    /*private boolean checkFullStatus(Subject subject,String group,int enrolled, int capacity)
    {

    if(subject.checkFullStatus(group, enrolled, capacity))
    {
    return true;
    }
    else
    {
    return false;
    }
    }*/

}
