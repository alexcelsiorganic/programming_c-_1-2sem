#include "Schoolboy.h"
Schoolboy::Schoolboy() :  class_(1) {
 SetName("Sasha");
 SetAge(6);
}

Schoolboy::Schoolboy(string name_schoolboy, int age_schoolboy, int class_1) : class_(class_1) {
    SetName(name_schoolboy);
    SetAge(age_schoolboy);
}

Schoolboy::Schoolboy(string name_schoolboy) : class_(1) {
    SetName(name_schoolboy);
    SetAge(6);
}

Schoolboy::Schoolboy(const Schoolboy& another) : class_(another.class_) {
    SetName(another.GetName());
    SetAge(another.GetAge());
}
Schoolboy::~Schoolboy(){}
void Schoolboy::PrintInfo() const {
    cout << "Name: " << GetName() << endl;
    cout << "Age: " << GetAge() << endl;
    cout << "Class: " << class_ << endl;
}
void Schoolboy::ChangeName(string new_name) {
    SetName(new_name);
}
void Schoolboy::ChangeAge(int new_age) {
    SetAge(new_age);
}
void Schoolboy::ChangeClass(int new_class) {
    class_ = new_class;
}
