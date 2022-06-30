#ifndef SET_SET_H
#define SET_SET_H
#include <iostream>
#include <cstring>
#include <fstream>
#include <algorithm>
using namespace std;
template <class T>
 class Set {
 public:

     Set() : size(0) {

         set = new T[size];

     }

     Set(T *a, int size_) : size(size_) {
             set = new T[size];
             for (int i = 0; i < size; i++) {
                 set[i] = a[i];
             }

     }

     Set(const Set<T> &a) : size(a.size) {
         set = new T[size];
         for (int i = 0; i < size; i++) {
             set[i] = a.set[i];
         }
     }
     ~Set() {
         size = 0;
         delete[] set;
     }

     bool CheckDupl(const T *a, int a_size) {
         for (int i = 0; i < Size(a); i++) {
             int count = 0;
             for (int j = 0; j < Size(a); j++) {
                 if (a[i] == a[j] && i != j) {
                     count++;
                 }
                 if (count != 0) {
                     return true;
                 }
             }

         }
     }

     Set<T> &Adds(T symbol) {
         if (CheckDupl(set)) {
             return *this;
         }
         T *temp = new T[size + 1];
         for (int i = 0; i < size; i++) {
             temp[i] = set[i];
         }
         temp[size] = symbol;
         set = temp;
         delete[] temp;
         return *this;
     }


     Set<T> &Rems(T symbol) {
             int pos = -1;
             for (int i = 0; i < size; i++) {
                 if (set[i] == symbol) {
                     pos = i;
                 }
             }
             try {
                 if (pos == -1) {
                     throw -10;
                 }
             }
             catch (int a) {

                 cerr << "Set doesn't contain your symbol!";
                 exit(a);
             }
             T *temp = new T[size - 1];
             for (int i = 0; i < pos; i++) {
                 temp[i] = set[i];
             }
             for (int i = pos + 1; i < size; i++) {
                 temp[i - 1] = set[i];
             }
             set = temp;
             delete[] temp;
             return *this;
         }
         Set<T> &operator=(const Set<T> &a) {
            delete[] set;
             size = a.size;
             set = new T[size];
             for (int i = 0; i < size; i++) {
                 set[i] = a.set[i];
               cout << set[i]  << " " << size << endl;
             }
           return *this;
        }


         friend bool Belongs(const Set<T> &a, T symbol) {
             for (int i = 0; i < a.size; i++) {
                 if (a.set[i] == symbol) {
                     return true;
                 }
             }
             return false;
         }
         friend Set<T> operator&(const Set<T> &a, const Set<T> &b) {
             Set<T> cross;
             int count = 0;
             for (int i = 0; i < a.size; i++) {
                 for (int j = 0; j < b.size; j++) {
                     if (a.set[i] == b.set[j]) {
                         count++;
                     }
                 }
             }
             delete[] cross.set;
             cross.set = new T[count];
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
             return cross;
         }
         friend Set<T> operator^(const Set<T> &a, const Set<T> &b) {
             Set<T> sub;
             Set<T> cross;
             cross = a & b;
             sub.size = a.size - cross.size;
             delete[] sub.set;
             sub.set = new T[sub.size];
             int size_count = 0;
             for (int i = 0; i < a.size; i++) {
                 if (!Belongs(cross, a.set[i])) {
                     sub.set[size_count] = a.set[i];
                     size_count++;
                 }
             }
             return sub;
         }
         friend Set<T> operator|(const Set<T> &a, const Set<T> &b) {

             Set<T> un;
             Set<T> cross;
             cross = a & b;
             un.size = a.size + b.size - cross.size;
             delete[] un.set;
             un.set = new T[un.size];
             int size_count = 0;
             for (int i = 0; i < a.size; i++) {
                 un.set[i] = a.set[i];
                 size_count++;
             }
             for (int i = 0; i < b.size; i++) {
                 if (!Belongs(cross, b.set[i])) {
                     un.set[size_count] = b.set[i];
                     size_count++;
                 }
             }
             return un;
         }
         friend bool operator==(const Set<T> &a, const Set<T> &b) {
             return (a.size == b.size);
         }
         friend bool operator>(const Set<T> &a, const Set<T> &b) {
             return (a.size > b.size);
         }
         friend bool operator<(const Set<T> &a, const Set<T> &b) {
             return (a.size < b.size);
         }
         friend ostream &operator<<(ostream &output, const Set<T> &b) {
             for (int i = 0; i < b.size; i++) {
                 output << b.set[i];
             }
             output << endl;
             return output;
         }
         private:
         T *set;
         int size;
     };
template <>
class Set<char> {
public:

    Set() : size(0) {
        set = new char[size];
    }

    bool CheckDupl(const char* a) {
        for (int i = 0; i < strlen(a); i++) {
            int count = 0;
            for (int j = 0; j < strlen(a); j++) {
                if (a[i] == a[j] && i != j) {
                    count++;
                }
                if (count != 0) {
                    return true;
                }
            }
        }
        return false;
    }

    Set (const char* exp, int size_) : size(strlen(exp)) {

        set = new char[size + 1];
        for (int i = 0; i < size; i++) {
            set[i] = exp[i];
        }
        set[size] = '\0';

    }

    ~Set() {

        size = 0;
        delete[] set;

    }

    Set<char>& operator=(const Set<char>& a) {


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

    Set<char>& Adds(char symbol) {
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


    Set<char>& Rems(char symbol) {
        int pos = -1;
        for (int i = 0; i < size; i++) {
            if (set[i] == symbol) {
                pos = i;
            }
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


    friend Set<char> operator&(const Set<char>& a, const Set<char>& b) {
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


    friend Set<char>  operator^(const Set<char>& a, const Set<char>& b) {
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

    friend bool Belongs(const Set<char>& a, char symbol) {
        for (int i = 0; i < a.size; i++) {
            for (int j = 0; j < a.size; j++) {
                if (a.set[i] == symbol) {
                    return true;
                }
            }
        }
        return false;
    }


    friend Set<char> operator|(const Set<char>& a, const Set<char>& b) {
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
    friend bool operator==(const Set<char>& a, const Set<char>& b) {
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

    friend bool operator>(const Set<char>& a, const Set<char>& b) {
        return (a.size > b.size);
    }



    friend bool operator<(const Set<char>& a, const Set<char>& b) {
        return (a.size < b.size);
    }

    friend ostream& operator<<(ostream& output, const Set<char>& b) {
        for (int i = 0; i < b.size; i++) {
            output << b.set[i];
        }
        output << endl;
        return output;
    }
    private:
        char *set;
        int size;
};
#endif //SET_SET_H
