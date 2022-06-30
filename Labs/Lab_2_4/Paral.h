#ifndef PARAL_H
#define PARAL_H
#include <iostream>
#include <string>
#include <fstream>
#include <windows.h>
#include "Geometry_.h"
using namespace std;
class Paral : public Geometry_ {
public:
    Paral();
    Paral(int size1, int size2, double angle);
    virtual ~Paral();
    void Explode(double k);
    void Draw(HWND hwnd);
private:
    int count  = 4;
};
#endif PARAL_H