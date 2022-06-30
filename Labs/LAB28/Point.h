#ifndef LAB28_POINT_H
#define LAB28_POINT_H

#include <iostream>
using namespace std;
class Point {
public:
    Point();
    Point(double a,  double b);
    ~Point();
    Point& operator=(const Point& n);
    friend Point& operator+=(Point& a,const Point& b);
    friend Point& operator-=(Point& a,const Point& b);
    friend Point& operator*=(Point& a,const Point& b);
    friend Point& operator/=(Point& a,const Point& b);

    friend Point& operator+=(Point& a,double b);
    friend Point& operator-=(Point& a,double b);
    friend Point& operator*=(Point& a,double b);
    friend Point& operator/=(Point& a,double b);


    friend Point operator+(const Point& a, const Point&  b);
    friend Point operator-(const Point& a, const Point&  b);
    friend Point operator*(const Point& a, const Point&  b);
    friend Point operator/(const Point& a, const Point&  b);

    friend Point operator+(const Point& a,double b);
    friend Point operator-(const Point& a,double b);
    friend Point operator*(const Point& a,double b);
    friend Point operator/(const Point& a,double b);



    friend Point& operator++(Point& a);
    friend const Point operator++(Point& a,int );
    friend Point& operator--(Point& a);
    friend const Point operator--(Point& a,int );

    friend Point& operator+(Point& a, int );
    friend Point& operator-(Point& a, int );
    friend ostream& operator<<(ostream & output, const Point &a);

    void SetX(double a);
    void SetY(double a);
    double GetX() const;
    double GetY() const;
protected:
    double x;
    double y;
};



#endif //LAB28_POINT_H
