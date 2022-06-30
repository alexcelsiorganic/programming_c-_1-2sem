#include <Windows.h>
#include <stdlib.h>
#include <string>
#include <clocale>
#pragma comment (lib, "winmm.lib")
#define _CRT_SECURE_NO_WARNINGS
#pragma warning(suppress : 4996)
using namespace std;
HWND hWnd;
LPCTSTR ClsName = "GDIFund";
LPCTSTR WindowCaption = "GDI Fundamentals";
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
LRESULT CALLBACK WndProc(HWND hWnd, UINT Msg, WPARAM wParam, LPARAM lParam) {
    HPEN hPen1;
    HPEN hPen2;
    HPEN hPen3;
    HPEN hPen4;
    HPEN hPen5;
    HPEN hPen6;
    HDC hDC;

    PAINTSTRUCT Ps;
    switch (Msg)
    {
        case WM_PAINT:
            hDC = BeginPaint(hWnd, &Ps);
            hPen1 = CreatePen(PS_SOLID, 3, RGB(0, 0, 0));
            hPen2 = CreatePen(PS_SOLID, 5, RGB(30, 144, 255));
            hPen3 = CreatePen(PS_SOLID, 5, RGB(0, 255, 0));
            hPen4 = CreatePen(PS_SOLID, 3, RGB(255, 140, 0));
            hPen5 = CreatePen(PS_SOLID, 27, RGB(128, 128,128));
            hPen6 = CreatePen(PS_SOLID, 5, RGB(65, 25, 0));
            HBRUSH hBrush;
            HBRUSH hBrush2;
            hBrush = CreateSolidBrush(RGB(240, 255, 255));
            SelectObject(hDC, hBrush);
            SelectObject(hDC, hPen1);
            Ellipse(hDC, 98, 50, 148, 100);//������
            Ellipse(hDC, 83, 100, 163, 180); //������� �����
            Ellipse(hDC, 63, 120, 83, 140); //����� ����
            Ellipse(hDC, 163, 120, 183, 140);//������ ����
            Ellipse(hDC, 50, 180, 200, 330);//������ �����


            SelectObject(hDC, hPen2);
            Ellipse(hDC, 129, 70, 131, 72);
            Ellipse(hDC, 115, 70, 117, 72);


            SelectObject(hDC, hPen3);
            Ellipse(hDC, 122, 139, 124, 141);
            Ellipse(hDC, 124, 254, 126, 256);


            SelectObject(hDC, hPen4);
            Ellipse(hDC, 121, 78, 123, 80);


            SelectObject(hDC, hPen5);
            MoveToEx(hDC, 106, 50, NULL);
            LineTo(hDC, 111, 20);
            MoveToEx(hDC, 111, 20, NULL);
            LineTo(hDC, 131, 20);
            MoveToEx(hDC, 131, 20, NULL);
            LineTo(hDC, 136, 50);
            MoveToEx(hDC, 136, 50, NULL);
            LineTo(hDC, 106, 50);



            SelectObject(hDC, hPen6);
            MoveToEx(hDC, 173, 70, NULL);
            LineTo(hDC, 193, 50);
            MoveToEx(hDC, 173, 70, NULL);
            LineTo(hDC, 173, 50);
            MoveToEx(hDC, 173, 70, NULL);
            LineTo(hDC, 153, 50);
            MoveToEx(hDC, 173, 70, NULL);
            LineTo(hDC, 173, 328);

            EndPaint(hWnd, &Ps);
            break;
        case WM_DESTROY:
            PostQuitMessage(WM_QUIT);
            break;
        default:
            return DefWindowProc(hWnd, Msg, wParam, lParam);
    }
    return 0;
}