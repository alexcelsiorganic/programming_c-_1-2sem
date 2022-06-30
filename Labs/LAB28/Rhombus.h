#ifndef LAB28_RHOMBUS_H
#define LAB28_RHOMBUS_H

#include <iostream>
#include <string>
#include <fstream>
#include <windows.h>
#include "Geometry.h"
using namespace std;
class Rhombus : public Shape {
public:
    Rhombus();
    Rhombus(int size1, double angle);
    Rhombus& operator=(const Rhombus& a);
    virtual ~Rhombus();
    virtual void MoveTo(Point& dot);
    virtual void Rotate(double angle);
    virtual void Shift(double dx, double dy);
    virtual bool Show();
    virtual bool Hide();
    virtual void Explode(double k_explode);
    virtual bool Check();
    virtual double CalculateP();
    virtual double CalculateS();
    virtual void Draw(HWND hwnd);
private:
    int count  = 4;
};

#endif //LAB28_RHOMBUS_H
