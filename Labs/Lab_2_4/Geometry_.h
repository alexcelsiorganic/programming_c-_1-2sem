#ifndef GEOMETRY_H
#define GEOMETRY_H
#include <iostream>
#include <string>
#include "Point.h"
#include <fstream>
#include <windows.h>
using namespace std;
class Geometry_ : public Point { //класс многоугольник наследуется от класса точка
public:
    Geometry_();
    Geometry_(int a);
    Geometry_(Point& a, int b);
    virtual ~Geometry_();
    void Shift(double dx, double dy);//сдвиг фигуры на dx по координате x, на dy по y
    void MoveTo(Point& dot);
    void Rotate(double angle);//поворот на angle против часовой стррелки
    void Draw(HWND hwnd);
    bool Show(); //показываем фигуру
    bool Hide(); // прячем фигуру
    bool Check();
protected:
    Point* arr_of_points;
    int count;
    bool show;
};
#endif GEOMETRY_H