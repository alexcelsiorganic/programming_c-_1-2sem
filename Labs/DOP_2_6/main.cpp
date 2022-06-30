#include <iostream>
#include "Galaxy.h"
int main() {
    cout << "Enter the num of planets!" << endl;
    int num;
    cin >> num;
    Galaxy SolarSystem(num);
    PrintGalaxy(SolarSystem);
    Planet earth("Earth");
    AddPlanet(SolarSystem, earth);
    PrintGalaxy(SolarSystem);
    SolarSystem.ChangeStar("Aplha Centauri");
    PrintGalaxy(SolarSystem);
}
