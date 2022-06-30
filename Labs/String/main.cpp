#include <iostream>
#include "String.h"
using namespace std;
int main() {
    String a("hello");
    String b("bye");
    String c;
    c = a + b;
//	a.insert(1, b);
    cout << c;
}