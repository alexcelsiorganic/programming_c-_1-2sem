#include "Field .h"
#include <time.h>

Field::Field(QWidget* parent) :  QWidget(parent) {
//srand(time(0));
//int counter = 0;
//for (int i = 0; i < field_strings_rows; i++)
game_active = true;
QGridLayout* layout = new QGridLayout(this);
for(int i = 0; i < field_strings_rows; i++) {
    for(int j = 0; j < field_strings_rows; j++) {
        game_field[i][j] = new Dot(i, j, this);
        layout = addWidget(game_field[i][j], i , j, 1, 1);
        connect(game_field[i][j], SIGNAL(left_click()), this, SLOT(Left_Clicked));
    }
}
while (counter < 10) {



}
 }







}