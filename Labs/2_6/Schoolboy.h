#pragma once
#include <iostream>
#include <fstream>
#include <string>
#include "Student.h"
using namespace std;

class Schoolboy : public Student {
public:
    Schoolboy();
    Schoolboy(string name, int age, int class_);
    explicit Schoolboy(string name_schoolboy);
    Schoolboy(const Schoolboy& another);
    void ChangeName(string new_name);
    void ChangeAge(int new_age);
    void ChangeClass(int new_class);
    ~Schoolboy();
    void PrintInfo() const;
private:
    int class_;
};
