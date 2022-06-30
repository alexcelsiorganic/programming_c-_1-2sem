#include <iostream>
#include "Container.h"

using namespace std;

int main() {
    ifstream input;
    input.open("Lab7.txt");
    cout << "Hello, World!" << endl;
    Container<Container1> Students;
    input >> Students;
    return 0;
}
