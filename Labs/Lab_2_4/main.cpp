#include <iostream>
#pragma comment (lib, "winmm.lib")
#include "Triangle.h"
#include "Square.h"
#include "Paral.h"
#include <windows.h>
#include <string>
#include <ctime>
#pragma warning(suppress : 4996)


using namespace std;

HINSTANCE hInst;
HWND hWnd;
LPCTSTR ClsName = "Geometry";
LPCTSTR WindowCaption = "Geometry graphics";
LRESULT CALLBACK WndProc(HWND hWnd, UINT Msg, WPARAM wParam, LPARAM lParam);
INT WINAPI WinMain(HINSTANCE hInstance, HINSTANCE hPrevInstance,
                   LPSTR lpCmdLine, int nCmdShow)
{
    MSG         Msg;
    WNDCLASSEX  WndClsEx;

    WndClsEx.cbSize = sizeof(WNDCLASSEX);
    WndClsEx.style = CS_HREDRAW | CS_VREDRAW;
    WndClsEx.lpfnWndProc = WndProc;
    WndClsEx.cbClsExtra = NULL;
    WndClsEx.cbWndExtra = NULL;
    WndClsEx.hInstance = hInstance;
    WndClsEx.hIcon = LoadIcon(hInstance, IDI_APPLICATION);
    WndClsEx.hCursor = LoadCursor(NULL, IDC_ARROW);
    WndClsEx.hbrBackground = (HBRUSH)GetStockObject(WHITE_BRUSH);
    WndClsEx.lpszMenuName = NULL;
    WndClsEx.lpszClassName = ClsName;
    WndClsEx.hIconSm = LoadIcon(hInstance, IDI_APPLICATION);

    RegisterClassEx(&WndClsEx);

    hWnd = CreateWindowEx(WS_EX_OVERLAPPEDWINDOW,
                          ClsName,
                          WindowCaption,
                          WS_OVERLAPPEDWINDOW,
                          500,
                          400,
                          640,
                          480,
                          NULL,
                          NULL,
                          hInstance,
                          NULL);

    ShowWindow(hWnd, nCmdShow);
    UpdateWindow(hWnd);

    while (GetMessage(&Msg, NULL, 0, 0))
    {
        TranslateMessage(&Msg);
        DispatchMessage(&Msg);
    }

    return 0;
}

LRESULT CALLBACK WndProc(HWND hwnd, UINT iMsg, WPARAM wParam, LPARAM lParam)
{
    static HWND hListBox;
    static HWND EDIT_1;
    static HWND EDIT_2;
    static HWND EDIT_3;
    static HWND button_1;
    static HWND button_2;
    static HWND button_3;
    RECT         rect;
    HDC          hdc;
    int a1,a2,a3,i;
    double  rotate, explode;
    static char* str1;
    static char* str2;
    static char* str3;
    static char* str4;
    static char* str5;
    static int* array;
    static int uSelect;
    static Square square;
    static int check;
   static Triangle triangle;
    Point b(10,10);
    Point b1(100,235);
    Point b2(300,150);
    static Paral a(20,40, 60);
    PAINTSTRUCT  ps;
    switch (iMsg) {
        case WM_CREATE:
            hListBox = CreateWindow("listbox", NULL,   WS_CHILD | WS_VISIBLE | LBS_STANDARD | LBS_WANTKEYBOARDINPUT, 1000, 30, 75, 50,    hwnd, (HMENU)1, hInst, NULL);
            button_1 = CreateWindow(TEXT("button"), TEXT("Draw"), WS_CHILD | WS_VISIBLE, 0, 0, 0, 0, hwnd, (HMENU)1001, ((LPCREATESTRUCT)lParam)->hInstance, NULL);
            button_2 = CreateWindow(TEXT("button"), TEXT("Hide"), WS_CHILD | WS_VISIBLE | BS_AUTOCHECKBOX, 0, 0, 0, 0, hwnd, (HMENU)2002, ((LPCREATESTRUCT)lParam)->hInstance, NULL);
            EDIT_1 = CreateWindow(TEXT("edit"), NULL, WS_CHILD | WS_VISIBLE | WS_BORDER | ES_LEFT, 0, 0, 0, 0, hwnd, (HMENU)NULL, ((LPCREATESTRUCT)lParam)->hInstance, NULL);
            EDIT_2 = CreateWindow(TEXT("edit"), NULL, WS_CHILD | WS_VISIBLE | WS_BORDER | ES_LEFT, 0, 0, 0, 0, hwnd, (HMENU)NULL, ((LPCREATESTRUCT)lParam)->hInstance, NULL);
            EDIT_3 = CreateWindow(TEXT("edit"), NULL, WS_CHILD | WS_VISIBLE | WS_BORDER | ES_LEFT, 0, 0, 0, 0, hwnd, (HMENU)NULL, ((LPCREATESTRUCT)lParam)->hInstance, NULL);

            SendMessage(hListBox, WM_SETREDRAW, FALSE, 0L);
            SendMessage(hListBox, LB_ADDSTRING, 0,  (LPARAM)(LPSTR)"Triangle");
            SendMessage(hListBox, LB_ADDSTRING, 0, (LPARAM)(LPSTR)"Square");
            SendMessage(hListBox, LB_ADDSTRING, 0,  (LPARAM)(LPSTR)"Paral");
            SendMessage(hListBox, WM_SETREDRAW, TRUE, 0L);
            InvalidateRect(hListBox, NULL, TRUE);
            i = MessageBox(hwnd, "For paral 3 parameters are required", "Warning", MB_OK); // для параллелограмма необходимо вводить 3 параметра

            return 0;
        case WM_SIZE:
            MoveWindow(button_1, 1000, 370, 275, 50, TRUE);
            MoveWindow(button_2, 1100, 30, 70, 20, TRUE);
            MoveWindow(EDIT_1, 1000, 120, 275, 30, TRUE);
            MoveWindow(EDIT_2, 1000, 175, 275, 30, TRUE);
            MoveWindow(EDIT_3, 1000, 230, 275, 30, TRUE);
            return 0;

        case WM_COMMAND:
            if (HIWORD(wParam) == LBN_DBLCLK) {
                uSelect = (int) SendMessage(hListBox, LB_GETCURSEL, 0, 0L);
            }
                if (HIWORD(wParam) == LBN_SELCHANGE) {
                    uSelect = (int) SendMessage(hListBox, LB_GETCURSEL, 0, 0L);
                }
            if(LOWORD(wParam)==2002) {
                HWND hwndCheck = GetDlgItem(hwnd, 2002);
                LRESULT res = SendMessage(hwndCheck, BM_GETCHECK, 0, 0);
                if (res == BST_CHECKED) {
                    SetWindowText(hwnd, "Checked");
                    check = 1;
                }
                if (res == BST_UNCHECKED) {
                    SetWindowText(hwnd, "Unchecked");
                    check  = 0;
                }
//            switch (LOWORD(wParam)) {
//                    case 2002:
//                    switch (HIWORD(wParam)) {
//                        case BN_CLICKED:
//                            check = (int)SendMessage(button_2, BM_SETCHECK, 0, 0L);
//                            break;
//                    }
//                }
            }
            switch(wParam) {
                case 1001:
                    a1 = GetWindowTextLength(EDIT_1);
                    str1 = new char[a1 + 1];
                    array = new int[3];
                    GetWindowText(EDIT_1, str1, a1 + 1);
                    char *end1;
                    array[0] = strtol(str1, &end1, 0);
                    try {
                        if (array[0] < 0) {
                            throw -1;
                        }
                    }
                    catch (int a) {
                        MessageBox(hwnd, "size can't be less than zero!", "error", MB_OK);
                        SendMessage(hwnd, WM_CLOSE, 0, 0);
                    }
                    end1++;
                    array[1] = strtol(str1 = end1, &end1, 0);
                    end1++;
                    array[2] = strtol(str1 = end1, &end1, 0);
                    a2 = GetWindowTextLength(EDIT_2);
                    str2 = new char[a2 + 1];
                    GetWindowText(EDIT_2, str2, a2 + 1);
                    char *end2;
                    rotate = strtol(str2, &end2, 0);
                    a3 = GetWindowTextLength(EDIT_3);
                    str3 = new char[a3 + 1];
                    GetWindowText(EDIT_3, str3, a3 + 1);
                    char *end3;
                    explode = strtol(str3, &end3, 0);
                    try {
                        if (explode < 0) {
                            throw -1;
                        }
                    }
                    catch (int a) {
                        MessageBox(hwnd, "explode can't be less than zero!", "error", MB_OK);
                        SendMessage(hwnd, WM_CLOSE, 0, 0);
                    }
                    if (uSelect == 0) {
                        if (array[0] != 0 && array[1] != 0 && array[2] != 0) {
                            Paral paral(array[0], array[1], array[2]);
                            if (rotate != 0) {
                                paral.Rotate(rotate);
                            }
                            if (explode != 0) {
                                paral.Explode(rotate);
                            }
                            a = paral;
                        }
                        if (check != 1) {
                            a.Draw(hwnd);
                        }
                        else {
                            InvalidateRect(hwnd, NULL, TRUE);
                            UpdateWindow(hwnd);
                        }
                    }
                    if (uSelect == 2) {
                        if (array[0] != 0) {
                            Triangle tr1(array[0]);
                            if (rotate != 0) {
                                tr1.Rotate(rotate);
                            }
                            triangle = tr1;
                        }
                        if (check != 1) {
                            triangle.Draw(hwnd);
                        }
                        else {
                            InvalidateRect(hwnd, NULL, TRUE);
                            UpdateWindow(hwnd);
                        }
                    }
                    if (uSelect == 1) {
                        if (array[0] != 0) {
                            Square sqr(array[0]);
                            if (rotate != 0) {
                                sqr.Rotate(rotate);
                            }
                            if (explode != 0) {
                                sqr.Explode(explode);
                            }
                            square = sqr;
                        } else {
                            if (rotate != 0) {
                                square.Rotate(rotate);
                            }
                            if (explode != 0) {
                                int k;
                                k = MessageBox(hwnd, "For paral 3 parameare required", "Warning",
                                               MB_OK); // для параллелограмма необходимо вводить 3 параметра
                                square.Explode(explode);

                            }
                        }
                        if (check != 1) {
                            square.Draw(hwnd);
                        }
                        else {
                            InvalidateRect(hwnd, NULL, TRUE);
                            UpdateWindow(hwnd);
                        }
                    }
            }
            return 0;
        case WM_PAINT:
            srand(time(0));
            hdc = BeginPaint(hwnd, &ps);
            GetClientRect(hwnd, &rect);
            SetTextColor(hdc, RGB(rand() % 256, rand() % 256, rand() % 256));
            Rectangle(hdc, rect.right * 7 / 9, rect.top , rect.left * 8 / 9, rect.bottom);
            TextOut(hdc, 1000, 100, TEXT("Enter parameters of the figure"), 30); SetTextColor(hdc, RGB(rand() % 256, rand() % 256, rand() % 256));
            TextOut(hdc, 1000, 155, TEXT("Angle"), 5); SetTextColor(hdc, RGB(rand() % 256, rand() % 256, rand() % 256));
            TextOut(hdc, 1000, 210, TEXT("Explode"), 7); SetTextColor(hdc, RGB(rand() % 256, rand() % 256, rand() % 256));
            EndPaint(hwnd, &ps);
            return 0;

        case WM_DESTROY:
            PostQuitMessage(0);
            return 0;
    }
    return DefWindowProc(hwnd, iMsg, wParam, lParam);
}