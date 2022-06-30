#ifndef TRIANGLE_H

#define TRIANGLE_H

#include <iostream>
#include "Geometry_.h"
using namespace std;
class Triangle : public Geometry_ { //класс треугольник наследуется от класса многоугольник
public:
    Triangle();
    explicit Triangle(int size);
    Triangle(Point& a1, Point& a2, Point& a3);
    Triangle& operator=(const Triangle& a);
    virtual ~Triangle();
private:
    int count_angle;
};
#endif TRIANGLE_H