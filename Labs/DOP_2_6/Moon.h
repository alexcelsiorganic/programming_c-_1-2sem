#pragma once
#include <iostream>
#include <fstream>
#include "Planet.h"
using namespace std;
class Moon {
public:

    string GetMoonName();
    void SetMoonName(string Moon_name);
private:
    string name_of_moon;
};