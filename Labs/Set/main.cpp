#include <iostream>
#include "Set.h"
#include <string>
using namespace std;
int main() {

    int bs[3] = {1,9,10};
    int as[6] = {1,9,10,5,6,7};
    Set<int> a(bs,3);
    Set<int> b(as,6);

    Set<int> c = a^b;
    cout << c;
    return 0;

}
