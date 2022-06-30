#ifndef INC_4096_FIELD_H
#define INC_4096_FIELD_H

#include "Dot.h"
#include <QGridLayout>

class Field : public QWidget {

public:
    Field(QWidget* parent = 0);
protected:
    static int field_strings_rows = 10;
    static int count_of_mine = 15;
    bool game_active;
    Dot* game_field[field_strings_rows][field_strings_rows];

protected slots:
void Left_Clicked();

signals:
    void finish();

};

#endif //INC_4096_FIELD_H
