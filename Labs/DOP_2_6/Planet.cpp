#include "Planet.h"
Planet::Planet() {
    name_of_planet = "Earth";
}
Planet::Planet(string name) {
    name_of_planet = name;
}
Planet::Planet(const Planet& star) {
    name_of_planet = star.name_of_planet;
}
Planet::~Planet(){}
string Planet::GetPlanetName() {
    return name_of_planet;
}
void Planet::SetPlanetName(string planet_name) {
    name_of_planet = planet_name;
}