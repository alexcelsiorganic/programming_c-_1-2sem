#include <iostream>
#include "String.h"
using namespace std;
int main() {
    String a("hello");
    String b("bye");
    String c(b);
    c += a;
    cout << c;
    cout << "Palindrom? " << Palindrom(c) << endl;
    Insert_Word(c, a , "LAB_2_5");
    cout << "insert: " << c;
    c.erase(a);
    cout << "erase: " << c;
    Replace_word(c, "LAB_2_5", "world");
    Replace_word(c, b, "hello");
    cout << "remplace: " << c;
    Swap_2_word(c, a, "world");
    cout << "swap: "  << c;
    String sort("hello my game");
    Sort(sort);
    cout << sort << endl;
    cout << "sort: " << sort;
}