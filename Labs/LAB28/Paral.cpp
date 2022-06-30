#include <iostream>
#include <cmath>
#include <time.h>
#include "Rhombus.h"


using namespace std;


Rhombus::Rhombus() :  Shape(4) {
    srand(time(NULL));
    double a = rand()% 200 + 50;
    double b= rand()% 200 + 50;
    double angle = rand()%90;
    arr_of_points[1].SetX(arr_of_points[0].GetX() + a*sin(angle*3.14/180));
    arr_of_points[1].SetY(arr_of_points[0].GetY() - a*cos(angle*3.14/180));
    arr_of_points[2].SetY(arr_of_points[0].GetY());
    arr_of_points[2].SetX(arr_of_points[0].GetX() + b);
    arr_of_points[3].SetX(arr_of_points[1].GetX() + b);
    arr_of_points[3].SetY(arr_of_points[1].GetY());
}


Rhombus::Rhombus(int size1,  double angle) :  Shape(4) {
    arr_of_points[1].SetX(arr_of_points[0].GetX() + size1*cos(angle*3.1415926535/180));
    arr_of_points[1].SetY(arr_of_points[0].GetY() - size1*sin(angle*3.1415926535/180));
    arr_of_points[2].SetY(arr_of_points[0].GetY());
    arr_of_points[2].SetX(arr_of_points[0].GetX() + size1);
    arr_of_points[3].SetX(arr_of_points[1].GetX() + size1);
    arr_of_points[3].SetY(arr_of_points[1].GetY());
}


void Rhombus::Explode(double k) {
    double angle = abs((arr_of_points[0].GetY() - arr_of_points[1].GetY())/
                   (arr_of_points[1].GetX() - arr_of_points[0].GetX()));
    angle = atan(angle);
    double size1 = sqrt(pow(arr_of_points[0].GetY() - arr_of_points[1].GetY(),2) +
                        pow(arr_of_points[1].GetX() - arr_of_points[0].GetX(),2));
    double size2 = arr_of_points[3].GetX() - arr_of_points[0].GetX();
    double a1 = size1 * k;
    double a2 = size2 * k;
    a1= abs(a1 - size1) / 2;
    a2= abs(a2 - size2) / 2;
    int n = 1;
    if (k < 1) {
        n = -1;
    }
    arr_of_points[0].SetX( arr_of_points[0].GetX() - (n*a2) + a1*cos(angle));
    arr_of_points[0].SetY(arr_of_points[0].GetY() + (n*a1)*sin(angle));
    arr_of_points[1].SetX(arr_of_points[1].GetX() - n*a2 + a1*cos(angle));
    arr_of_points[1].SetY(arr_of_points[1].GetY() - n*a1*sin(angle));
    arr_of_points[2].SetX(arr_of_points[2].GetX() + n*a2 - a1*cos(angle));
    arr_of_points[2].SetY(arr_of_points[2].GetY() + n*a1 * sin(angle));
    arr_of_points[3].SetY(arr_of_points[3].GetY() - n*a1*sin(angle));
    arr_of_points[3].SetX(arr_of_points[3].GetX() + n*a2- a1*cos(angle));
}

Rhombus& Rhombus::operator=(const Rhombus& a) {
    if (this != &a) {
        for (int i = 0; i < 4; i++) {
            arr_of_points[i].SetX(a.arr_of_points[i].GetX());
            arr_of_points[i].SetY(a.arr_of_points[i].GetY());
        }
    }
    return *this;
}

void Rhombus::Rotate(double angle) {
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
        arr_of_points[i].SetY(av.GetY() + (av.GetX()-arr_of_points[i].GetX()) * sin(angle*3.1415926535 /180) + (av.GetY()- arr_of_points[i].GetY()) * cos(angle*3.1415926535/180));
    }
}


void Rhombus::MoveTo(Point& dot) {
    arr_of_points[0].SetX(dot.GetX());
    arr_of_points[0].SetY(dot.GetY());
}


double Rhombus::CalculateP() {
    double P = 0;
    for (int i = 0; i < 3; i++) {
        P +=  sqrt(pow(arr_of_points[i + 1].GetX() - arr_of_points[i + 1].GetX(),2) +
                   pow(arr_of_points[i + 1].GetY() - arr_of_points[i + 1].GetY(),2));
    }
    P += sqrt(pow(arr_of_points[0].GetX() - arr_of_points[2].GetX(),2) +
              pow(arr_of_points[0].GetY() - arr_of_points[2].GetY(),2));
    return P;
}


double Rhombus::CalculateS() {
    double S1 = 0;
    double S2 = 0;
    for (int i = 0; i < 3; i++) {
        S1 += arr_of_points[i].GetX()*arr_of_points[i + 1].GetY();
        S2 += arr_of_points[i + 1].GetX()*arr_of_points[i].GetY();
    }
    S1 += arr_of_points[3].GetX()*arr_of_points[0].GetY();
    S2 += arr_of_points[0].GetX() * arr_of_points[3].GetY();
    double S = S1 - S2;
    S /= 2;
    return S;
}


void Rhombus::Draw(HWND hwnd) {
    HPEN        hPen1, hPen2;
    HDC         hdc ;
    RECT        rect;
    hdc = GetDC(hwnd);
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
        for (int i = 0; i < count; i++) {
            LineTo(hdc, arr_of_points[i].GetX(), arr_of_points[i].GetY());
        }
        LineTo(hdc, arr_of_points[0].GetX(), arr_of_points[0].GetY());
        MoveToEx(hdc, arr_of_points[2].GetX(), arr_of_points[2].GetY(), NULL);
        LineTo(hdc, arr_of_points[0].GetX(), arr_of_points[0].GetY());
        MoveToEx(hdc, arr_of_points[1].GetX(), arr_of_points[1].GetY(), NULL);
        LineTo(hdc, arr_of_points[3].GetX(), arr_of_points[3].GetY());
        ReleaseDC(hwnd, hdc);
        DeleteObject(hPen1);
        DeleteObject(hPen2);
    }
}


bool Rhombus::Show() {
    show = true;
    return show;
}


bool Rhombus::Hide() {
    show = false;
    return show;
}


bool Rhombus::Check() {
    if (show) {
        return true;
    }
    else {
        return false;
    }

}


void Rhombus::Shift(double dx, double dy) {
    for (int i = 0; i < count; i++)
    {
        arr_of_points[i].SetX( arr_of_points[i].GetX()+dx);
        arr_of_points[i].SetY( arr_of_points[i].GetY()+dy);
    }
}

Rhombus::~Rhombus(){}
