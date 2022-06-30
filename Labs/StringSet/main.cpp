#include <iostream>
#include "String.h"
#include "Set.h"
#include <string>

using namespace std;


int main() {

    String str("hello");
    String x = reverse(str);
    cout << x;
    str = str + x;
    cout << str;
    MakePalindrom(x);
    cout << x;
    string str_ = StrToS(str);
    Set ex(str_);
    cout << ex;

    return 0;
}
