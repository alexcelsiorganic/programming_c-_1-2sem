#pragma once
#include <iostream>
#include <fstream>
#include <string>

using namespace std;

truct Container2 {
    string name;
    string space;
    void Set_name(string& name_X);
    string Get_name();
    friend ostream& operator<<(ostream& output, const Container2& cont2);
    friend istream& operator>>(istream& input, Container2& cont2);
};