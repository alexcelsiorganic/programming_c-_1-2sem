#include "Star.h"
Star::Star() {
name_of_star = "Sun";
}
Star::Star(string name) {
    name_of_star = name;
}
Star::Star(const Star& star) {
    name_of_star = star.name_of_star;
}
Star::~Star(){}
string Star::GetStarName() {
    return name_of_star;
}
void Star::SetStarName(string star_name) {
name_of_star = star_name;
}