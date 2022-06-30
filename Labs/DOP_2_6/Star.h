#pragma once
#include <iostream>
#include <fstream>
using namespace std;
class Star {
public:
    Star();
    explicit Star(string name);
    Star(const Star& star);
    ~Star();
    string GetStarName();
    void SetStarName(string Star_name);
private:
string name_of_star;
};