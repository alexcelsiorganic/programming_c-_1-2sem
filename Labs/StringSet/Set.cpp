#define _CRT_SECURE_NO_WARNINGS
/*
 * Ввести строку перевернуть,
 * сделать палиндром и убрать дубли и упорядочить,
 * используя свой классы string Set
 */
#include <iostream>
#include <string>
#include <algorithm>
#include "Set.h"
using namespace std;
Set::Set() : size(0) {

    set = new char[size];

}

int CountChar (const char* a,char a_char) {
    int count = 0;
    for (int i = 0; i < strlen(a); i++) {
        if (a[i] == a_char) {
            count++;
        }
    }
    return count;
}


Set::Set(char* exp) {
   int size_ = strlen(exp);
  for (int i = 0; i < size_ - 1; i++) {
      for (int j = i  + 1; j < size_; j++) {
          if (exp[i] == exp[j]) {
              for (int k = j; k < size_; k++) {
                  if (k != size_) {
                      exp[k] = exp[k + 1];
                      size_--;
                  }
              }
              if (exp[i] == exp[j]) {
                  j--;
              }
          }
      }
  }
  size = size_;
  set = new char[size_ + 1];
   for (int i  = 0; i < size_; i++) {
       set[i] = exp[i];
   }
   set[size_] = '\0';
}


Set::Set(const Set& a) : size(a.size) {

    set = new char[size + 1];
    for (int i = 0; i < size; i++) {
        set[i] = a.set[i];
    }
    set[size] = '\0';

}


Set::~Set() {

    size = 0;
    delete[] set;

}

Set& Set::operator=(const Set& a) {
    if (this != &a) {
        delete[] set;
        size = a.size;
        set = new char[size + 1];
        for (int i = 0; i < size; i++) {
            set[i] = a.set[i];
        }
        set[size] = '\0';
    }
    return *this;
}
Set::Set(string a){
    int size_ = a.length();
    for (int i = 0; i < size_ - 1; i++) {
        for (int j = i  + 1; j < size_; j++) {
            if (a[i] == a[j]) {
                for (int k = j; k < size_; k++) {
                    if (k != size_) {
                        a[k] = a[k + 1];
                        size_--;
                    }
                }
                if (a[i] == a[j]) {
                    j--;
                }
            }
        }
    }
    set = new char[size_ + 1];
    size = size_;
    for (int i  = 0; i < size_; i++) {
        set[i] = a[i];
    }
    set[size_] = '\0';
}

Set& Set::Adds(char symbol) {
    if (Belongs(*this, symbol)) {
        return *this;
    }
    char* temp = new char[size + 2];
    for (int i = 0; i < size; i++) {
        temp[i] = set[i];
    }
    temp[size] = symbol;
    temp[size + 1] = '\0';
    delete[] set;
    set = new char[size + 2];
    size = size + 1;
    for (int i = 0; i < size; i++) {
        set[i] = temp[i];
    }
    delete[] temp;
    return *this;
}


Set& Set::Rems(char symbol) {
    int pos = -1;
    for (int i = 0; i < size; i++) {
        if (set[i] == symbol) {
            pos = i;
        }
    }
    try {
        if (pos == -1) {
            throw SetException("Set doesn't contain your symbol!");
            return *this;
        }
    }
    catch (SetException& exception)
    {
        cerr << "An set exception occurred (" << exception.getError() << ")\n";
    }
    char* temp = new char[size];
    for (int i = 0; i < pos; i++) {
        temp[i] = set[i];
    }
    for (int i = pos + 1; i < size; i++) {
        temp[i - 1] = set[i];
    }
    temp[size - 1] = '\0';
    size = size - 1;
    delete[] set;
    set = new char[size];
    for (int i = 0; i < size; i++) {
        set[i] = temp[i];
    }
    delete[] temp;
    return *this;
}


Set operator&(const Set& a, const Set& b) {
    Set cross;
    int count = 0;
    for (int i = 0; i < a.size; i++) {
        for (int j = 0; j < b.size; j++) {
            if (a.set[i] == b.set[j]) {
                count++;
            }
        }
    }
    delete[] cross.set;
    cross.set = new char[count + 1];
    cross.size = count;
    int cross_counter = 0;
    for (int i = 0; i < a.size; i++) {
        for (int j = 0; j < b.size; j++) {
            if (a.set[i] == b.set[j]) {
                cross.set[cross_counter] = a.set[i];
                cross_counter++;
            }
        }
    }
    cross.set[count] = '\0';
    return cross;
}


Set operator^(const Set& a, const Set& b) {
    Set sub;
    Set cross;
    cross = a & b;
    sub.size = a.size - cross.size;
    delete[] sub.set;
    sub.set = new char[sub.size + 1];
    int count_sub = 0;
    for (int i = 0; i < a.size; i++) {
        if (!Belongs(cross, a.set[i])) {
            sub.set[count_sub] = a.set[i];
            count_sub++;
        }
    }
    sub.set[sub.size] = '\0';
    return sub;
}

bool Belongs(const Set& a, char symbol) {
    for (int i = 0; i < a.size; i++) {
        for (int j = 0; j < a.size; j++) {
            if (a.set[i] == symbol) {
                return true;
            }
        }
    }
    return false;
}


Set operator|(const Set& a, const Set& b) {
    Set un;
    Set cross;
    cross = a & b;
    un.size = a.size + b.size - cross.size;
    delete[] un.set;
    un.set = new char[un.size + 1];
    for (int i = 0; i < a.size; i++) {
        un.set[i] = a.set[i];
    }
    for (int i = 0; i < b.size; i++) {
        if (Belongs(cross, b.set[i])) {}
        else {
            un.set[i] = b.set[i];
        }
    }
    un.set[un.size] = '\0';
    return un;
}
bool operator==(const Set& a, const Set& b) {
    if (a.size != b.size) {
        return false;
    }
    else {
        for (int i = 0; i < a.size; i++) {
            if (a.set[i] != b.set[i]) {
                return false;
            }
        }
        return true;
    }
}

bool operator>(const Set& a, const Set& b) {
    return (a.size > b.size);
}



bool operator<(const Set& a, const Set& b) {
    return (a.size < b.size);
}

ostream& operator<<(ostream& output, const Set& b) {
    for (int i = 0; i < b.size; i++) {
        output << b.set[i];
    }
    output << endl;
    return output;
}