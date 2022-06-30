#include "Lab3_STL.h"

void PushBack(vector<int>&a, int num) {
    a.push_back(num);
}


void Push(vector<int>& a, int num, int index) {
    vector<int>::iterator it = a.begin();
    a.insert(it + index, num);
}


void Erase(vector<int> &a, int num) {
    auto it = remove_if(a.begin(), a.end(),
                        [num](int a) {
                            return (a == num);
                        });
    a.erase(it, a.end());
}


void Change(vector<int>& a, int old_value, int new_value) {
    for (auto i : a) {
        if (i == old_value) {
            i = new_value;
        }
    }
}

void Dupl(vector<int>& a) { //удаление дублей
    sort(a.begin(), a.end());
    auto it = unique(a.begin(), a.end());
    a.erase(it, a.end());
}


void Sort(vector<int>& a) {
    sort(a.begin(), a.end());
}


void SortRange(vector<int>& a, int startSort , int endSort) {
    vector <int>::iterator it_start = a.begin();
    stable_sort(it_start + startSort, it_start +  endSort);
}


void BinarySearch(vector<int> &a, int find_value) {
    cout << boolalpha;
    sort(a.begin(), a.end());
    auto it = binary_search(a.begin(), a.end(), find_value);
    cout << it << endl;
}


void SearchV1InV2(vector<int> a, vector<int> b) {
    auto res = search(a.begin(), a.end(), b.begin(), b.end());
    if (res != a.end()) {
        cout << *res << endl;
    }
}


void CopyV1ToV2(vector<int>& a1, vector<int>& a2) {
    copy(a1.begin(), a1.end(), std::back_inserter(a2));
}


void UniqueVectors(vector<int>& a1, vector<int>& a2) {
    copy(a1.begin(), a1.end(), std::back_inserter(a2));
}


int SumOfElements(vector<int>& a) {
    int sum = accumulate(a.begin(), a.end(), 0);
    return sum;
}


void UsingOfIterators(vector<int>& a) {
    auto it = rbegin(a);
    while (it != rend(a)) {
        cout << *it << " ";
        it++;
    }
}

void PrintVector(vector<int>& a) {
    copy(a.begin(), a.end(), ostream_iterator<int>(cout, " "));
    cout << endl;
}
