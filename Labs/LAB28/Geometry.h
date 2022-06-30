#ifndef LAB28_GEOMETRY_H
#define LAB28_GEOMETRY_H

#include <iostream>
#include <string>
#include "Point.h"
#include <windows.h>

class Shape : public Point { //класс многоугольник наследуется от класса точка
public:
    Shape();
    explicit Shape(int a);
    Shape(Point& a, int count_of_sides);
    virtual ~Shape();
    virtual void Shift(double dx, double dy) = 0;//сдвиг фигуры на dx по координате x, на dy по y
    virtual void MoveTo(Point& dot) = 0;
    virtual void Rotate(double angle) = 0;//поворот на angle против часовой стррелки
    virtual void Explode(double k_explode) = 0;
    virtual void Draw(HWND hwnd) = 0;
    virtual bool Show() = 0; //показываем фигуру
    virtual bool Hide() = 0; // прячем фигуру
    virtual bool Check() = 0;
    virtual double CalculateP() = 0;
    virtual double CalculateS() = 0;
    protected:
        Point* arr_of_points;
        int count;
        bool show;
};


#endif //LAB28_GEOMETRY_H
