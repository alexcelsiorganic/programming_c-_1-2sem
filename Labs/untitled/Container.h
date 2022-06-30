#pragma once
#include <iostream>
#include <fstream>
#include <string>

using namespace std;

struct Container1 {
    string name;
    int sr_ball;
    void Set_SrBall(int num) {
        sr_ball = num;
    }
    int Get_SrBall() {
        return sr_ball;
    }
    void Set_name(string& name_X) {
        name = name_X;
    }
    string Get_name() {
        return name;
    }
    friend ostream& operator<<(ostream& output, const Container1& cont1) {
        output << "Name: " << cont1.name << endl;
        output << "Sredniy Ball: " << cont1.sr_ball << endl;
        return output;
    }
    friend istream& operator>>(istream& input, Container1& cont1) {
        input >> cont1.name;
        input >> cont1.sr_ball;
        return input;
    }
};

struct Container2 {
    string name;
    string space;
    void Set_Space(string space1) {
      space = space1;
    }
    string Get_Space() {
        return space;
    }
    void Set_name(string& name_X) {
        name = name_X;
    }
    string Get_name() {
        return name;
    }
    friend ostream& operator<<(ostream& output, const Container2& cont2) {
        output << "Name: " << cont2.name << endl;
        output << "Space: " << cont2.space << endl;
        return output;
    }
    friend istream& operator>>(istream& input, Container2& cont2) {
        input >> cont2.name;
        input >> cont2.space;
        return input;
    }
};

struct Container3 {
    string name;
    int sr_ball;
    void Set_SrBall(int num) {
        sr_ball = num;
    }
    int Get_SrBall() {
        return sr_ball;
    }
    void Set_name(string& name_X) {
        name = name_X;
    }
    string Get_name() {
        return name;
    }
};

template <class T>
class Container {
public:
    Container() : count(0) {
        array = new T[count];
    }
    explicit Container(int size) : count(size) {
        array = new T[count];
    }
    Container(const Container<T>& cont) : count(cont.count) {
        array = new T[count];
        for (int i = 0; i < count; i++) {
            array[i] = cont.array[i];
        }
    }
    ~Container() {
        delete[] array;
    }
    T operator[] (const int index) {
        return array[index];
    }
    friend ostream& operator<<(ostream& output, const Container<T>& cont) {
        for (int i = 0; i < cont.count; i++) {
            output << cont.array[i] << endl;
        }
        return output;
    }

    friend istream& operator>>(istream& input, Container<T>& cont) {
        string a;
        int counter = 0;
        while (input) {
            input >> a;
            counter++;
        }
        counter /= 2;
        delete[] cont.array;
        cont.count = counter;
        input.seekg(0);
        cont.array = new T[cont.count];
        for (int i = 0; i < cont.count; i++) {
         input >> cont[i];
        }
        return input;
    }
    Container<Container3> great_stud(Container<Container1>& cont1, Container<Container2>& cont2) {
        Container<Container3> stud(cont2.count);
        int k = 0;
        for (int i = 0; i < cont1.count; i++) {
            for (int j = 0; j < cont2.count; j++) {
                if (cont1[i].name == cont2[j].name) {
                    stud[k].name = cont1[i].name;
                    stud[k].Set_SrBall(cont1[i].Get_SrBall());
                    k++;
                }
            }
        }
        return stud;
    }
private:
    int count;
T* array;
};

