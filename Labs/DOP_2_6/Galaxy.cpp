#include "Galaxy.h"
Galaxy::Galaxy() : num_of_planets(0)  {
    name_of_galaxy = "Solar system";
    system_of_planets = new Planet[num_of_planets];
    SetStarName("Sun");
}
Galaxy::Galaxy(int num) : num_of_planets(num) {
    system_of_planets = new Planet[num_of_planets];
    cout << "Enter the name of your galaxy: ";
    cin >> name_of_galaxy;
    cout << endl;
    cout << "Enter the name of star: ";
    string star_name;
    cin >> star_name;
    SetStarName(star_name);
    cout << endl;
    cout << "Enter the planets of your galaxy: ";
    for (int i = 0; i < num_of_planets; i++) {
        string planet_name;
        cin >> planet_name;
        system_of_planets[i].SetPlanetName(planet_name);
    }
    cout << endl;
}
Galaxy::Galaxy(string name_of_gal, string name_star, string* names_of_planets, int num) :  num_of_planets(num) {
    system_of_planets = new Planet[num_of_planets];
    SetStarName(name_star);
    for (int i = 0; i < num_of_planets; i++) {
        system_of_planets[i].SetPlanetName(names_of_planets[i]);
    }
}
Galaxy::Galaxy(string name_of_gal, string name_star, Planet* planet, int num) :  num_of_planets(num) {
    system_of_planets = new Planet[num_of_planets];
    SetStarName(name_star);
    for (int i = 0; i < num_of_planets; i++) {
        system_of_planets[i].SetPlanetName(planet[i].GetPlanetName());
    }
}
Galaxy::Galaxy(Galaxy& galaxy) : num_of_planets(galaxy.num_of_planets) {
    system_of_planets = new Planet[num_of_planets];
    SetStarName(galaxy.GetStarName());
    for (int i = 0; i < num_of_planets; i++) {
        system_of_planets[i].SetPlanetName(galaxy.system_of_planets[i].GetPlanetName());
    }
}

Galaxy::~Galaxy() {
    delete[] system_of_planets;
}


void AddPlanet(Galaxy& galaxy, Planet& add_planet) {
    Planet* planets = new Planet[galaxy.num_of_planets];
    for (int i = 0; i < galaxy.num_of_planets; i++) {
        planets[i].SetPlanetName(galaxy.system_of_planets[i].GetPlanetName());
    }
galaxy.num_of_planets += 1;
delete[] galaxy.system_of_planets;
galaxy.system_of_planets = new Planet[galaxy.num_of_planets];
for (int i = 0; i <galaxy.num_of_planets - 1; i++) {
    galaxy.system_of_planets[i].SetPlanetName(planets[i].GetPlanetName());
}
galaxy.system_of_planets[galaxy.num_of_planets - 1].SetPlanetName(add_planet.GetPlanetName());
}

void PrintStar(Galaxy& galaxy) {
    cout << galaxy.GetStarName() << endl;
}

void PrintNumOfPlanets(Galaxy& galaxy) {
    cout << galaxy.num_of_planets << endl;
}

void Galaxy::ChangeStar(string name) {
    SetStarName(name);
}

void PrintGalaxy(Galaxy& galaxy) {
    cout << "Star: " << galaxy.GetStarName() << endl;
    cout << "Num: " << galaxy.num_of_planets << endl;
    cout << "Planets: " << endl;
    for (int i = 0; i < galaxy.num_of_planets; i++) {
        cout << i + 1 << ": " << galaxy.system_of_planets[i].GetPlanetName() << " ";
    }
}

