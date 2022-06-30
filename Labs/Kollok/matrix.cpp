#include <iostream>
#include <fstream>
#include <time.h>
#include "array.h"
using namespace std;
array::array()
{
arr = nullptr;
size = 0;
}
array::array(const int n)
{
    srand(time(NULL));
arr = new int[n];
for (int i = 0; i < n; i++)
{
    arr[i] = rand()%20;

}
}
array::array(const array& a)
{
 arr = a;
}
array::~array()
{
    delete[] arr;
}
ostream& operator>>(ostream& output, array& a)
{
    for (int i = 0; i < a; i++)
    {
        output << a[i];
    }
}
istream& operator>>(istream& input, array& a)
{
    for (int i = 0; i < a.size; i++)
    {
        input >> a[i];
    }
    return input;

}