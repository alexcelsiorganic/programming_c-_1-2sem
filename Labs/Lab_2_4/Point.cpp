#include <iostream>
#include "Point.h"
#include <fstream>
using namespace std;
Point::Point():x(0), y(0){}
Point::Point(double  a, double b): x(a), y(b){}
Point::~Point(){}
Point& operator+=(Point& a,const Point& b)
{
    a.x += b.x;
    a.y += b.y;
    return a;
}
Point& operator+=(Point& a, double b)
{
    a.x += b;
    return a;
}



Point& operator-=(Point& a,const Point& b)
{
    a.x -= b.x;
    a.y -= b.y;
    return a;
}
Point& operator-=(Point& a, double b)
{
    a.x -= b;
    return a;
}


Point& operator*=(Point& a,const Point& b)
{
    a.x *= b.x;
    a.y *= b.y;
    return a;
}
Point& operator*=(Point& a, double b)
{
    a.x *= b;
    a.y *= b;
    return a;
}


Point& operator/=(Point& a,const Point& b)
{
    a.x /= b.x;
    a.y /= b.y;
    return a;
}
Point& operator/=(Point& a, double b)
{
    a.x /= b;
    return a;
}


Point operator+(const Point& a, const Point& b)
{
    return Point(a.x + b.x, a.y + b.y);
}
Point operator-(const Point& a, const Point& b)
{
    return Point(a.x - b.x, a.y - b.y);
}

Point operator*(const Point& a, const Point& b)
{
    return Point(a.x * b.x, a.y * b.y);
}

Point operator/(const Point& a, const Point& b)
{
    return Point(a.x / b.x, a.y / b.y);
}

Point operator+(const Point& a, double b)
{
    return Point(a.x + b, a.y);
}
Point operator-(const Point& a, double b)
{
    return Point(a.x - b, a.y);
}
Point operator*(const Point& a, double b)
{
    return Point(a.x * b, a.y * b);
}

Point operator/(const Point& a, double b)
{
    return Point(a.x / b, a.y / b);
}



Point& operator++(Point& point)
{
    point.x +=1;
    return point;
}
const Point operator++(Point& point, int)
{
    Point old_point(point);
    point.x++;
    return old_point;
}


Point& operator--(Point& point)
{
    point.x -=1;
    return point;
}
const Point operator--(Point& point, int)
{
    Point old_point(point);
    point.x--;
    return old_point;
}


Point& operator+(Point& a, int )
{
    return a;
}
Point& operator-(Point& a, int )
{
    a.x *= -1;
    a.y *= -1;
    return a;
}

ostream& operator<<(ostream& output, const Point& a)
{
    output  <<"("<< a.x << ", " << a.y <<")";
    return output;
}
Point& Point::operator=(const Point& n)
{
    if (this != &n)
    {
        x =n.x;
        y = n.y;
    }
    return *this;
}
void Point::SetX(double a) {
    x = a;
}
void Point::SetY(double a) {
    y = a;
}
double Point::GetX() const {
    return x;
}
double Point::GetY() const  {
    return y;
}


