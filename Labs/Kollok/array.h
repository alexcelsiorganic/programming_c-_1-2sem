#include <iostream>
#include <string>
#include <fstream>
using namespace std;
class array
{
public:
    array();
    array(const int n);
    array(const array& a);
    ~array();
    int& operator[](const int index);
    friend array& operator+(const array& a, const array& ba);
    friend array& operator-(const array& a, const array& ba);
    friend ostream& operator<<(ostream& output, const array& a);
    friend istream& operator>>(istream& output, array& a);
    friend array& operator+(const array& a, const array& ba);
    friend array& operator+(const array& a, const array& ba);
private:
    int* arr;
    int size;
};