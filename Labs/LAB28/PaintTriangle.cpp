#include <iostream>
#include "PaintTriangle.h"
#include <time.h>
using namespace std;

PaintTriangle::PaintTriangle() : Triangle() {}


PaintTriangle::PaintTriangle(int size) : Triangle(size) {}


void PaintTriangle::Draw(HWND hwnd) {
    HPEN hPen1, hPen2;
    HBRUSH hBrush;
    HDC hdc = GetDC(hwnd);
    RECT rect;
    GetClientRect(hwnd, &rect);
    Rectangle(hdc, rect.right * 7 / 9, rect.top, rect.left * 8 / 9, rect.bottom);
    srand(time(0));
    hBrush = CreateSolidBrush(RGB(rand() % 256, rand() % 256, rand() % 256));
    hPen1 = CreatePen(PS_SOLID, 1, RGB(rand() % 256, rand() % 256, rand() % 256));
    hPen2 = CreatePen(PS_DASH, 0, RGB(rand() % 256, rand() % 256, rand() % 256));
    if (show) {
        int i, j;
        i = arr_of_points[0].GetX();
        j = arr_of_points[0].GetY();
        SelectObject(hdc, hPen1);
        SelectObject(hdc, hBrush);
        MoveToEx(hdc, i, j, NULL);
        for (int i = 1; i < count; i++) {
            LineTo(hdc, arr_of_points[i].GetX(), arr_of_points[i].GetY());
        }
        LineTo(hdc, arr_of_points[0].GetX(), arr_of_points[0].GetY());
        POINT triang[3]= { {(int)arr_of_points[0].GetX(),(int)arr_of_points[0].GetY()},
                           {(int)arr_of_points[1].GetX(),(int)arr_of_points[1].GetY()},
                           {(int)arr_of_points[2].GetX(),(int)arr_of_points[2].GetY()}} ;
        Polygon(hdc, triang, 3);
        ReleaseDC(hwnd, hdc);
        DeleteObject(hPen1);
        DeleteObject(hPen2);
        DeleteObject(hBrush);
    }
}
PaintTriangle::~PaintTriangle() {}
