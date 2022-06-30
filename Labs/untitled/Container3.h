#pragma once
#include <iostream>
#include <fstream>
#include <string>

using namespace std;

struct Container3 {
    string name;
    int sr_ball;
    void Set_SrBall(int num);
    int Get_SrBall();
    void Set_name(string& name_X);
    string Get_name();
    friend ostream& operator<<(ostream& output, const Container3& cont3);
    friend istream& operator>>(istream& input, Container3& cont3);
};