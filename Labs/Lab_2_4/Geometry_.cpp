#include <iostream>
#include "Geometry_.h"
#include <windows.h>
#include <ctime>
#include <cmath>
using namespace std;
Geometry_::Geometry_() : count(0), show(true) {
    arr_of_points = new Point[0];
}
Geometry_::Geometry_ (int a) : count(a), show(true) {
    srand(time(NULL));
    arr_of_points = new Point[count];
    arr_of_points[0].SetY(200);
    arr_of_points[0].SetX(200);
    for (int i = 1; i < count; i++) {
        arr_of_points[i].SetY(rand() % 300);
        arr_of_points[i].SetX(rand() % 300);
    }
}
Geometry_::Geometry_(Point& a, int b) : count(b), show(true) {
    srand(time(NULL));
    arr_of_points = new Point[count];
    arr_of_points[0].SetY(a.GetY());
    arr_of_points[0].SetX(a.GetX());
    for (int i = 1; i < count; i++) {
        arr_of_points[i].SetY(rand() % 300);
        arr_of_points[i].SetX(rand() % 300);
    }
}
Geometry_::~Geometry_() {
    delete[] arr_of_points;
}
bool Geometry_::Show() {
    show = true;
    return show;
}
bool Geometry_::Hide() {
    show = false;
    return show;
}
bool Geometry_::Check() {
    if (show) {
        return true;
    }
    else {
        return false;
    }

}
void Geometry_::Shift(double dx, double dy) {
    for (int i = 0; i < count; i++)
    {
        arr_of_points[i].SetX( arr_of_points[i].GetX()+dx);
        arr_of_points[i].SetY( arr_of_points[i].GetY()+dy);
    }
}
void Explode(int k) {}
void Geometry_::Rotate(double angle) {
    Point av;

    double sum1 = 0;
    double sum2 = 0;
    for (int i = 0; i < count; i++) {
        sum1 += arr_of_points[i].GetX();
        sum2 += arr_of_points[i].GetY();
    }
    av.SetX(sum1/count);
    av.SetY(sum2/count);
    for (int i = 0; i < count; i++) {
        arr_of_points[i].SetX( av.GetX() + (av.GetX()-arr_of_points[i].GetX()) * cos(angle*3.1415926535 / 180 ) - (av.GetY()- arr_of_points[i].GetY()) * sin(angle*3.1415926535/180));
        arr_of_points[i].SetY(av.GetY() + (av.GetX()-arr_of_points[i].GetX()) * sin(angle*3.1415926535 /180) +(av.GetY()- arr_of_points[i].GetY()) * cos(angle*3.1415926535/180));
    }
}
void Geometry_::MoveTo(Point& dot) {
    arr_of_points[0].SetX(dot.GetX());
    arr_of_points[0].SetY(dot.GetY());
}
void Geometry_::Draw(HWND hwnd) {
    HPEN        hPen1, hPen2;
    HDC         hdc =  GetDC(hwnd);
    RECT        rect;
    GetClientRect(hwnd, &rect);
    Rectangle(hdc, rect.right * 7 / 9, rect.top , rect.left * 8 / 9, rect.bottom);
    srand(time(0));
    hPen1 = CreatePen(PS_SOLID, 1, RGB(rand() % 256, rand() % 256, rand() % 256));
    hPen2 = CreatePen(PS_DASH, 0, RGB(rand() % 256, rand() % 256, rand() % 256));
    if (show) {
        int i, j;
        i = arr_of_points[0].GetX();
        j = arr_of_points[0].GetY();
        SelectObject(hdc, hPen1);
        MoveToEx(hdc, i, j, NULL);
        for (int i = 1; i < count; i++) {
            LineTo(hdc, arr_of_points[i].GetX(), arr_of_points[i].GetY());
        }
        LineTo(hdc, arr_of_points[0].GetX(), arr_of_points[0].GetY());
        ReleaseDC(hwnd, hdc);
        DeleteObject(hPen1);
        DeleteObject(hPen2);
    }
}