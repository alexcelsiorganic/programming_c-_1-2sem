#ifndef LAB29_SET_H
#define LAB29_SET_H

#include <iostream>
#include <set>
#include <multiset>
#include <map>
#include <algorithm>

using namespace std;


 int DelAndMax(int* array, const int size) {
    set<int> set_solve;
    for (int i = 0; i < size; i++) {
        set_solve.insert(array[i]);
    }
    auto it = max_element(set_solve);
    delete[] array;
    return *it;
 }

 void MinAndCountMin(int *array, const int size) {
     multiset<int> multiset_solve;
     for (int i = 0; i < size; i++) {
         multiset_solve.insert(array[i]);
     }
     auto it = min_element(set_solve);
     int count_min = count_if(multiset_solve.begin(), multiset_solve.end(), *it);
     cout << "Min: " << *it << endl;
     cout << "Count min: " << count_min << endl;
 }

 void RepeatEachOther(int *array, int size, const int index) {
     vector<int> ar;
     for (int i = 0; i < size; i++) {
         ar.push_back(array[i]);
     }
     map<int,int> counters;
     for (int number : ar) {
         ++counters[number];
     }
     for (auto i : counters) {
         cout <<  i.first << " " << i.second << endl;
     }
 }




#endif //LAB29_SET_H
