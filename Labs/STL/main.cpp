#include <iostream>
//Дан массив, состоящий из целых чисел.
//Напишите программу, которая определяет, есть ли в массиве пара соседних элементов с одинаковыми знаками.
//Входные данные 5 -1 2 -3 5 -6
//Выходные данные No
//
//Вторая задача:Воды слонам!
//Третья задача: Волшебный мост
//Вторая
#include <vector>
using namespace std;

void print_vector(vector<int> &vect) {
    int size_of_vector = 0;
    cout << "Enter the size of your vector!: ";
    cin >> size_of_vector;
    cout << endl;
    cout << "Enter the el of your vector!: ";
    for (int i = 0; i < size_of_vector; i++) {
        int a = 0;
        cin >> a;
        vect.push_back(a);
    }
    cout << endl;
}
bool Neighboor(vector<int>& vect) {
    for (int i = 0; i < vect.size() - 1; i++) {
        if (vect[i] > 0 && vect[i + 1] > 0 || vect[i] < 0 && vect[i + 1] < 0) {
            cout << "Yes!" << vect[i] << " " << vect[i + 1];
            return true;
        }
    }
    cout << "No!";
    return false;
}
void Print2(vector<int>& price) {
    int num_of_days = 0;
    cout << "Enter the num of days: ";
    cin >> num_of_days;
    int a = 0;
    for (int i = 0; i < num_of_days; i++) {
        cin >> a;
       price.push_back(a);
    }
}
int WaterForElephants(vector<int>& price) {
    int max = price[0];
    int min = price[0];
    int num_max = 0;
    int num_min = 0;
    for (int i = 0; i < price.size(); i++) {
        if (price[i] >= max) {
            num_max = i;
            max = price[i];
        }
        else if (price[i] <= min) {
            num_min = i;
            min = price[i];
        }
    }
    if (max == min) {
        cout << 0 << " " << 0;
        return 0;
    }
  if (num_min < num_max) {
      min = price[0];
      for (int i = num_max; i < price.size(); i++) {
          if (price[i] <= min) {
              num_min = i;
              min = price[i];
          }
      }
      cout << num_max << " " << num_min;
      return 1;
  }
  else {
      cout << num_max << " " << num_min;
      return 1;
  }
}
int main() {
//Для задачи 1
//int size_of_vector = 0;
//vector<int> vect;
//print_vector(vect);
//Neighboor(vect);
//Для задачи 2
vector<int> price;
Print2(price);
WaterForElephants(price);
}
