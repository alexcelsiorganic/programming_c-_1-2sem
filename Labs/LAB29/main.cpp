#include <iostream>
#include <locale.h>
#include "Lab3_STL.h"
using namespace std;

int main() {
vector<int> first;
vector<int> second;
PushBack(first,5);
PushBack(first, 4);
PushBack(first, 7);
PushBack(first, 5);

PushBack(second,5);
PushBack(second,9);
PushBack(second,6);
PushBack(second,17);
PushBack(second,14);

cout << "1 vector" << endl;
PrintVector(first);

cout << "2 vector" << endl;
PrintVector(second);

cout << "Enter the item to erase" << endl;
int n;
cin >> n;
Erase(first, n);
cout << "Result of erase" << endl;
PrintVector(first);

Sort(first);
SortRange(second, 1,3);


cout << "Sorted 1 vector: " << endl;
PrintVector(first);
cout << "Rangesorted 2 vector: " << endl;
PrintVector(second);

cout << "Sum of elements (1 vector): " << endl;
cout << SumOfElements(first) << endl;

cout << "Sum of elements (2vector): " << endl;
cout << SumOfElements(second) << endl;

cout << "Copy 1 vector in 2vector: " << endl;
CopyV1ToV2(first, second);
PrintVector(second);

cout << "Using of iterators" << endl;
UsingOfIterators(second);
    return 0;
}
