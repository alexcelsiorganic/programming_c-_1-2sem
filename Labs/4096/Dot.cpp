#include "Dot.h"

Dot::Dot(int x, int y, QWidget* parent = 0) : x_dot(x), y_dot(y), QPushButton(parent),
                                                   dot_is_mine(false), dot_value(0) {
setSizePolicy(QSizePolicy::Expanding, QSizePolicy::Expanding);
setFixedSize(20,20);
}

int Dot::Get_Dot_Value() const {
    return dot_value;
}

void Dot::Set_Dot_Value(int new_value) {
    dot_value = new_value;
}

bool Dot::is_Dot_Mine() {
    return dot_is_mine;
}

bool Dot::is_Dot_Open() {
    return dot_open;
}

void Dot::Open_Dot() {
    dot_open = true;
    //функция перересовки окна
}
//функция перересовки окна
void Dot::PaintEvent(QPaintEvent* paint) {
    QPushButton::PaintEvent(paint);
    QPainter paint(this);
    }