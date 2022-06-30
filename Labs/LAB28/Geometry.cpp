#include <iostream>
#include "time.h"
#include "Geometry.h"
using namespace std;

Shape::Shape() : count(0), show(true) {
    arr_of_points = new Point[0];
}


Shape::Shape (int a) : count(a), show(true) {

    srand(time(NULL));
    arr_of_points = new Point[count];
    arr_of_points[0].SetY(200);
    arr_of_points[0].SetX(200);
    for (int i = 1; i < count; i++) {
        arr_of_points[i].SetY(rand() % 300);
        arr_of_points[i].SetX(rand() % 300);
    }
}


Shape::Shape(Point& a, int b) : count(b), show(true) {
    srand(time(NULL));
    arr_of_points = new Point[count];
    arr_of_points[0].SetY(a.GetY());
    arr_of_points[0].SetX(a.GetX());
    for (int i = 1; i < count; i++) {
        arr_of_points[i].SetY(rand() % 300);
        arr_of_points[i].SetX(rand() % 300);
    }
}

Shape::~Shape() {
    delete[] arr_of_points;
}
