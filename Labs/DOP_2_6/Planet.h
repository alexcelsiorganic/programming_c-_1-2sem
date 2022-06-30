#pragma once
#include <iostream>
#include <fstream>
using namespace std;
class Planet {
public:
    Planet();
    explicit Planet(string name);
    Planet(const Planet& a);
    ~Planet();
    string GetPlanetName();
    void SetPlanetName(string Planet_name);
private:
string name_of_planet;
};