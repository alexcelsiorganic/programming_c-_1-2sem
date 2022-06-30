#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

class compare {
public:
    bool operator() (int a, int b) {
        if (a % 2 == 0 && b % 2 != 0) {
            return true;
        }
        if (a % 2 == 0 && b % 2 == 0) {
            return a > b;
        }
        return false;
    }
};


int main() {

    priority_queue<int, vector<int>, compare> pQ;
    pQ.emplace(5);
    pQ.emplace(6);
    pQ.emplace(7);
    pQ.emplace(8);
    pQ.emplace(9);
    pQ.emplace(10);
    pQ.emplace(20);
    vector<int> new_vector;
    while (!pQ.empty()) {
        new_vector.push_back(pQ.top());
        pQ.pop();
    }
    int num = 7;
    auto it = find(new_vector.begin(), new_vector.end(), 7);
    new_vector.erase(it);
    for (auto i : new_vector) {
        pQ.push(i);
    }

    while (!pQ.empty()) {
        cout << pQ.top() << " ";
        pQ.pop();
    }
    return 0;
}
