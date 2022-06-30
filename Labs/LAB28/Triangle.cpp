#include <iostream>
#include <cmath>
#include <time.h>
#include "Triangle.h"
using namespace std;


Triangle::Triangle() : Shape(3) {
    count_angle = 3;
    arr_of_points[0].SetX(200);
    arr_of_points[0].SetY(200);
}


Triangle::Triangle(int size) : Shape(3) {
    count_angle = 3;
    arr_of_points[0].SetX(300);
    arr_of_points[0].SetY(300);
    arr_of_points[2].SetX(arr_of_points[0].GetX() + size);
    arr_of_points[2].SetY(arr_of_points[0].GetY());
    arr_of_points[1].SetX((arr_of_points[0].GetX() + arr_of_points[2].GetX())/2);
    arr_of_points[1].SetY(arr_of_points[0].GetY() - size/2*cos(60*3.14/180));
}


Triangle::Triangle(Point& a1, Point& a2, Point& a3) : Shape(3) {
    count_angle = 3;
    arr_of_points[0].SetX(a1.GetX());
    arr_of_points[0].SetY(a1.GetY());
    arr_of_points[1].SetX(a2.GetX());
    arr_of_points[1].SetY(a2.GetY());
    arr_of_points[2].SetX(a3.GetX());
    arr_of_points[2].SetY(a3.GetY());
}

Triangle::Triangle(int size1, int size2, int size3) {
        int x = 100;
        int y = 200;
        int x1, y1 = 0;
        Point dot1, dot2;
        for (int i_ = 0; i_ < 1000; i_++) {
            for (int j = 0; j < 1000; j++) {
                if (pow(x - i_, 2) + pow(y - j, 2) == pow(size1, 2)) {
                    dot1.SetX(i_);
                    dot1.SetY(j);
                   break;
                }
            }
        }
        for (int i_ = 0; i_ < 1000; i_++) {
            for (int j = 0; j < 1000; j++) {
                if (pow(dot1.GetX() - i_, 2) + pow(dot1.GetY() - j, 2) == pow(size2, 2) &&
                    pow(x - i_, 2) + pow(y - j, 2) == pow(size3, 2)) {
                        dot2.SetX(i_);
                        dot2.SetY(j);
                        break;
                    }
                }
            }
    count_angle = 3;
    arr_of_points[0].SetX(x);
    arr_of_points[0].SetY(y);
    arr_of_points[1].SetX(dot1.GetX());
    arr_of_points[1].SetY(dot1.GetY());
    arr_of_points[2].SetX(dot2.GetX());
    arr_of_points[2].SetY(dot2.GetY());
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


bool Triangle::Show() {
    show = true;
    return show;
}


bool Triangle::Hide() {
    show = false;
    return show;
}


bool Triangle::Check() {
    if (show) {
        return true;
    }
    else {
        return false;
    }

}


void Triangle::Shift(double dx, double dy) {
    for (int i = 0; i < count; i++)
    {
        arr_of_points[i].SetX( arr_of_points[i].GetX()+dx);
        arr_of_points[i].SetY( arr_of_points[i].GetY()+dy);
    }
}



void Triangle::Explode(double k_explode) {
    double angle = abs((arr_of_points[0].GetY() - arr_of_points[1].GetY())/
                       (arr_of_points[1].GetX() - arr_of_points[0].GetX()));
    angle = atan(angle);
    double size1 = sqrt(pow(arr_of_points[0].GetY() - arr_of_points[1].GetY(),2) +
                        pow(arr_of_points[1].GetX() - arr_of_points[0].GetX(),2));
    double size2 = sqrt(pow(arr_of_points[1].GetY() - arr_of_points[2].GetY(),2) +
                        pow(arr_of_points[1].GetX() - arr_of_points[2].GetX(),2));
    double size3 = sqrt(pow(arr_of_points[0].GetY() - arr_of_points[2].GetY(),2) +
                        pow(arr_of_points[0].GetX() - arr_of_points[2].GetX(),2));
    double a1 = size1 * k_explode;
    double a2 = size2 * k_explode;
    double a3 = size3 * k_explode;
    a1= abs(a1 - size1) / 2;
    a2= abs(a2 - size2) / 2;
    a3 = abs(a3 - size3) / 2;
    int n = 1;
    if (k_explode < 1) {
        n = -1;
    }
    arr_of_points[0].SetX( arr_of_points[0].GetX() - (n*a3) + a1*cos(angle));
    arr_of_points[0].SetY(arr_of_points[0].GetY() + (n*a1)*sin(angle));
    arr_of_points[1].SetX(arr_of_points[1].GetX() - n*a2 + a1*cos(angle));
    arr_of_points[1].SetY(arr_of_points[1].GetY() - n*a1*sin(angle));
    arr_of_points[2].SetX(arr_of_points[2].GetX() + n*a2 - a3*cos(angle));
    arr_of_points[2].SetY(arr_of_points[2].GetY() + n*a3 * sin(angle));

}


void Triangle::Rotate(double angle) {
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


void Triangle::MoveTo(Point& dot) {
    arr_of_points[0].SetX(dot.GetX());
    arr_of_points[0].SetY(dot.GetY());
}


double Triangle::CalculateP() {
     double P = 0;
    for (int i = 0; i < 2; i++) {
        P +=  sqrt(pow(arr_of_points[i ].GetX() - arr_of_points[i + 1].GetX(),2) +
                pow(arr_of_points[i].GetY() - arr_of_points[i + 1].GetY(),2));
    }
    P += sqrt(pow(arr_of_points[0].GetX() - arr_of_points[2].GetX(),2) +
             pow(arr_of_points[0].GetY() - arr_of_points[2].GetY(),2));
    return P;
}


double Triangle::CalculateS() {
   double P = this->CalculateP();
   double S = 0;
   P /= 2;
   S = sqrt((P - sqrt(pow(arr_of_points[0].GetX() - arr_of_points[2].GetX(),2) + pow(arr_of_points[0].GetY() - arr_of_points[2].GetY(),2))) *
           (P - sqrt(pow(arr_of_points[1].GetX() - arr_of_points[2].GetX(),2) + pow(arr_of_points[1].GetY() - arr_of_points[2].GetY(),2))) *
           (P - sqrt(pow(arr_of_points[0].GetX() - arr_of_points[1].GetX(),2) + pow(arr_of_points[0].GetY() - arr_of_points[1].GetY(),2))));
    return S;
}


void Triangle::Draw(HWND hwnd) {
    HPEN hPen1, hPen2;
    HDC hdc = GetDC(hwnd);
    RECT rect;
    GetClientRect(hwnd, &rect);
    Rectangle(hdc, rect.right * 7 / 9, rect.top, rect.left * 8 / 9, rect.bottom);
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