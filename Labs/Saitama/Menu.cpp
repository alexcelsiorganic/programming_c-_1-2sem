#include "Menu.h"
#incldue <QMenu>
#include <QMenuBar>

Menu::Menu(QWidget* parent) : QMainWindow(parent) {

    QAction* quit = new QAction("&Выйти");

    QMenu* Actions = menuBar()->addAction("&Actions");







}

