#ifndef INC_4096_DOT_H
#define INC_4096_DOT_H

#include <iostream>
#include <QApplication>
#include <QPushButton>

using namespace std;

class Dot : public QPushButton {
public:
    Dot(int x, int y, QWidget* parent = 0);
     int Get_Dot_Value() const;
     void Set_Dot_Value(int new_value);
     bool is_Dot_Mine();
     void Set_Mine();
     bool is_Dot_Open();
     void Open_Dot();
signals:
    void left_click();
    void  right_click();
protected:
    int x_dot;
    int y_dot;
    bool dot_is_mine;
    bool dot_open;
    int dot_value;
    virtual void PaintEvent(QPaintEvent* paint);
    virtual void MouseRelease(QMouseEvent* release);
};

#endif //INC_4096_DOT_H
