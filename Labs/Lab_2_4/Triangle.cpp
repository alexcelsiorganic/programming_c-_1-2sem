#include <iostream>
#include <cmath>
#include "Triangle.h"
using namespace std;
Triangle::Triangle() : Geometry_(3) {
    count_angle = 3;
    arr_of_points[0].SetX(200);
    arr_of_points[0].SetY(200);
}
Triangle::Triangle(int size) : Geometry_(3) {
    count_angle = 3;
    arr_of_points[0].SetX(300);
    arr_of_points[0].SetY(300);
    arr_of_points[2].SetX(arr_of_points[0].GetX() + size);
    arr_of_points[2].SetY(arr_of_points[0].GetY());
    arr_of_points[1].SetX((arr_of_points[0].GetX() + arr_of_points[2].GetX())/2);
    arr_of_points[1].SetY(arr_of_points[0].GetY() - size/2*cos(60*3.14/180));
}
Triangle::Triangle(Point& a1, Point& a2, Point& a3) : Geometry_(3) {
    count_angle = 3;
    arr_of_points[0].SetX(a1.GetX());
    arr_of_points[0].SetY(a1.GetY());
    arr_of_points[1].SetX(a2.GetX());
    arr_of_points[1].SetY(a2.GetY());
    arr_of_points[2].SetX(a3.GetX());
    arr_of_points[2].SetY(a3.GetY());
}
Triangle& Triangle::operator=(const Triangle& a) {
    if (this != &a) {
        for (int i = 0; i < 3; i++) {
            arr_of_points[i].SetX(a.arr_of_points[i].GetX());
            arr_of_points[i].SetY(a.arr_of_points[i].GetY());
        }
    }
    return *this;
}
Triangle::~Triangle(){}