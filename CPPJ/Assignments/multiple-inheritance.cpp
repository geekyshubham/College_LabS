//1. Apply Multiple Inheritance  Derive Mtech student from employee and student class    

#include<iostream>

using namespace std;

// Base class employee
class employee {
    protected:  
        char    empName[30];
        int     empId;
    public:
        void setEmployeeInfo()
        {
           cout << "Enter Emp. Id: ";
            cin  >> empId;
            cout << "Enter Employee Name: "; 
            cin>>empName;
            cout<<endl;
           
        }

};

// Base class student
class student {

    protected:  
        char studName[10];
        int rollNo;

   public:
      void setStudentInfo() {
         cout << "Enter Student Name: "; 
         cin>>studName;
         cout<<endl;
         cout << "Enter Rollno: ";
         cin  >> rollNo;
      }
};

// Derived class
class mtech: public employee, public student {
   public:
      void getStudentDetails() {
         cout << "Student Name: "<<studName<<endl;
         cout << "Roll No.: "<<rollNo<<endl;
         cout<<"\n";
      }
      void getEmployeeDetails(){
         cout << "Employee Name: "<<empName<<endl;
         cout << "Employee ID: "<<empId<<endl;
         cout<<"\n";
      }
};

int main(void) {

    mtech stud1;
    stud1.setStudentInfo();
    cout<<"student details set!\n";
    
    stud1.setEmployeeInfo();
    cout<<"employee details set!\n";

    cout<<"\n";
    stud1.getEmployeeDetails();
    cout<<"\n";
    stud1.getStudentDetails();
    char temp[10];
    cin.getline(temp,10);

   return 0;
}