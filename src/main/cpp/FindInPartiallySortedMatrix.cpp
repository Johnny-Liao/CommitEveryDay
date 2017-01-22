#include<iostream>

bool Find(int* matrix, int rows, int cloums, int number)
{
    bool found = false;

    if (matrix != NULL && rows > 0 && cloums > 0)
    {
        int row = 0;
        int cloum = cloums - 1;
        while(row < rows && cloum >= 0) {
            if (matrix[row * cloums + cloum] == number)
            {
                found = true;
				break; 			// forget : find by gdb -- the first time to use it.
            } 
            else if (matrix[row * cloums + cloum] > number)
                -- cloum;
            else
                ++ row;
        }
    }
    return found;
}

void Test(char* testName, int* matrix, int rows, int columns, int number, bool expected)
{
    if(testName != NULL)
        printf("%s begins: ", testName);

    bool result = Find(matrix, rows, columns, number);
    if(result == expected)
        printf("Passed.\n");
    else
        printf("Failed.\n");
}

int main(int argc, char* argv[])
{
    int matrix[][4] = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
    Test("Test1", (int*)matrix, 4, 4, 7, true);
}
