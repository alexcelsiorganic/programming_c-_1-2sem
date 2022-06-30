#pragma once
#include <iostream>
#include <fstream>
#include "Moon.h"
#include "Planet.h"
#include "Star.h"
using namespace std;
class Galaxy : public Planet, public Star {
public:
Galaxy();
Galaxy(int num);
Galaxy(string name_of_gal, string name_star, string* names_of_planets, int num);
Galaxy(string name_of_gal, string name_star, Planet* planets, int num);
Galaxy(Galaxy& galaxy);
~Galaxy();
void ChangeStar(string name);
friend void AddPlanet(Galaxy & galaxy, Planet &add_planet);
friend void PrintStar(Galaxy & galaxy);
friend void PrintNumOfPlanets(Galaxy& galaxy);
friend void PrintGalaxy(Galaxy& galaxy);
private:
    string name_of_galaxy;
Planet* system_of_planets;
int num_of_planets;
};