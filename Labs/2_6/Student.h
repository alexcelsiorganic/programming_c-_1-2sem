#pragma once
#include <iostream>
#include <fstream>
#include <string>
using namespace std;

class Student {
public:
    Student();
    Student(string name, int age, int course, int group);
    Student(const Student& student);
    string GetName() const;
    int GetAge() const;
    void SetName(string n);
    void SetAge(int ag);
    ~Student();
    virtual void PrintInfo() const;
private:
    string name;
    int age;
    int course;
    int group;
};
