#include <iostream>
#include "Square.h"
using namespace std;
Square::Square() :  Geometry_(4) {
    double a = rand()%200;
    arr_of_points[1].SetX(arr_of_points[0].GetX());
    arr_of_points[1].SetY(arr_of_points[0].GetY() + a);
    arr_of_points[2].SetX(arr_of_points[0].GetX() + a);
    arr_of_points[2].SetY(arr_of_points[0].GetY() + a);
    arr_of_points[3].SetY(arr_of_points[0].GetY());
    arr_of_points[3].SetX(arr_of_points[0].GetX() + a);
}
Square::Square(int size) :  Geometry_(4) {
    arr_of_points[1].SetX(arr_of_points[0].GetX());
    arr_of_points[1].SetY(arr_of_points[0].GetY()+ size);
    arr_of_points[2].SetX(arr_of_points[0].GetX() + size);
    arr_of_points[2].SetY(arr_of_points[0].GetY() + size);
    arr_of_points[3].SetY(arr_of_points[0].GetY());
    arr_of_points[3].SetX(arr_of_points[0].GetX() + size);
}
Square::Square(int size, Point& a) :  Geometry_(4) {
    arr_of_points[0].SetX(a.GetX());
    arr_of_points[0].SetY(a.GetY());
    arr_of_points[1].SetX(arr_of_points[0].GetX());
    arr_of_points[1].SetY(arr_of_points[0].GetY()+size);
    arr_of_points[2].SetX(arr_of_points[0].GetX() + size);
    arr_of_points[2].SetY(arr_of_points[0].GetY() + size);
    arr_of_points[3].SetY(arr_of_points[0].GetY());
    arr_of_points[3].SetX(arr_of_points[0].GetX()+size);
}
void Square::Explode(double k) {
    double size = arr_of_points[1].GetY() - arr_of_points[0].GetY();
    double a = size * k;
    a = abs(a - size) / 2;
    int n = 1;
    if(k < 1) {
        n = -1;
    }
    arr_of_points[0].SetX( arr_of_points[0].GetX() - n*a);
    arr_of_points[0].SetY(arr_of_points[0].GetY() - n*a);
    arr_of_points[1].SetX(arr_of_points[1].GetX() - n*a);
    arr_of_points[1].SetY(arr_of_points[1].GetY() + n*a);
    arr_of_points[2].SetX(arr_of_points[2].GetX() + n*a);
    arr_of_points[2].SetY(arr_of_points[2].GetY() + n*a);
    arr_of_points[3].SetY(arr_of_points[3].GetY() - n*a);
    arr_of_points[3].SetX(arr_of_points[3].GetX() + n*a);
}
Square& Square::operator=(const Square& a) {
    if (this != &a) {
        for (int i = 0; i < 4; i++) {
            arr_of_points[i].SetX(a.arr_of_points[i].GetX());
            arr_of_points[i].SetY(a.arr_of_points[i].GetY());
        }
    }
    return *this;
}
Square::~Square(){}