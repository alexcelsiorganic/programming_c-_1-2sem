#include <iostream>
#include <algorithm>
#include <set>
#include <numeric>
#include <vector>
#include <cmath>
/* .
 * Дан массив, состоящий из целых чисел.
 * Напишите программу, которая определяет, есть ли в массиве пара соседних элементов с одинаковыми знаками.
 */
using namespace std;
/*  Тесты:
 * Напишите программу, которая определяет, есть ли в массиве пара соседних элементов с одинаковыми знаками.
 */
int main() {
int n;
vector<int> solution;
cout << "Enter the num of elements: "  << endl;
cin >> n;
cout << "Enter the elements of multiset: " << endl;
for (int i = 0; i < n; i++) {
    int el;
    cin >> el;
    solution.push_back(el);
}
auto first = solution.begin();
auto second = solution.begin();
second++;
while (second != solution.end()) {
    if (*first < 0 && *second < 0 || *first > 0 && *second > 0) {
        cout << "Yes!" << endl;
        return 0;
    }
    else {
        second++;
        first++;
    }
}
cout << "No!" << endl;
return 0;
}