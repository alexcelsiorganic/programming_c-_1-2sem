#include <iostream>
#include "Schoolboy.h"
int main() {
    Student young_man;
    young_man.PrintInfo();
   Schoolboy child;
   child.PrintInfo();
   child.ChangeName("Gena");
   child.ChangeAge(10);
   child.ChangeClass(5);
   child.PrintInfo();
}
