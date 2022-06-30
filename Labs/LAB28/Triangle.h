#ifndef LAB28_TRIANGLE_H
#define LAB28_TRIANGLE_H
#ifndef TRIANGLE_H
#include <iostream>
#include "Geometry.h"
using namespace std;
class Triangle : public Shape { //класс треугольник наследуется от класса многоугольник
public:
    Triangle();
    explicit Triangle(int size);
    Triangle (int size1, int size2, int size3);
    Triangle(Point& a1, Point& a2, Point& a3);
    Triangle& operator=(const Triangle& a);
    virtual void MoveTo(Point& dot);
    virtual void Rotate(double angle);
    virtual void Shift(double dx, double dy);
    virtual bool Show();
    virtual void Explode(double k_explode);
    virtual bool Hide();
    virtual bool Check();
    virtual double CalculateP();
    virtual double CalculateS();
    virtual void Draw(HWND hwnd);
    ~Triangle();
private:
    int count_angle;
};
#endif TRIANGLE_H
#endif //LAB28_TRIANGLE_H
