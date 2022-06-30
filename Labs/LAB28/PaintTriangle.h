#include <iostream>
#include "Triangle.h"
using namespace std;
class PaintTriangle : public Triangle { //класс треугольник наследуется от класса многоугольник
public:
    PaintTriangle();
    explicit PaintTriangle(int size);
    virtual void Draw(HWND hwnd);
    virtual ~PaintTriangle();
private:
    int count_angle;
};
