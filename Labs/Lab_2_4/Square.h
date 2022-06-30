#ifndef SQUARE_H
#define SQUARE_H
#include <iostream>
#include <string>
#include <fstream>
#include "Geometry_.h"
using namespace std;
class Square : public Geometry_ {
public:
    Square();
    Square(int size);
    Square(int size, Point& a);
    Square& operator=(const Square& a);
    virtual ~Square();
    void Explode(double k);
private:
    int count  = 4;
};
#endif SQUARE_H