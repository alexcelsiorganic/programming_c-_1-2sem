#include <iostream>
class K {
public:
    char* fun(void) {
        return "hello\n";
    }
};
int main(void) {

    K obj, *p;
    p = &obj;
    char*(K::*pf)(void);
    pf=K::fun();
   std::cout << (obj.*pf)();
   std::cout << (p->*pf)();

}