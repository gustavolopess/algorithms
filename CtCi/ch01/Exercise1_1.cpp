#include <cstdio>


bool is_unique(char *str) {
    // assume that string chars fit in ascii table
    int idx = 0, c;
    long long first_half = 0, second_half = 0, checker;
    while (c = str[idx++]) {
        if (c < 64) {
            checker = first_half;
            first_half |= (1 << c);
        } else {
            c %= 64;
            checker = second_half;
            second_half |= (1 << c);
        }
        if (checker & (1 << c)) return false;
    }
    return true;
}


int main() {
    char str[30];
    scanf("%s", str);
    printf(is_unique(str) ? "true\n" : "false\n");

    return 0;
}