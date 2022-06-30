#include <iostream>
#include "Student.h"
using namespace std;
Student::Student() : name("Alex"), age(17), course(1), group(9) {}
Student::Student(string name1, int age1, int course1, int group1) :
                name(name1), age(age1), course(course1), group(group1) {}
Student::Student(const Student& stud) :
                name(stud.name), age(stud.age), course(stud.course), group(stud.group) {}
Student::~Student() {}
void Student::PrintInfo() const{
    cout << "Name: " << name << endl;
    cout << "Age: " << age << endl;
    cout << "Course: " << course << endl;
    cout << "Group: " << group << endl;
}
string Student::GetName() const {
    return name;
}
int Student::GetAge() const {
    return age;
}
void Student::SetName(string n)  {
    name = n;
}
void  Student::SetAge(int ag) {
    age = ag;
}

