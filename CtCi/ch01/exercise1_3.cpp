/*
 * Cracking the coding interview Edition 6
 * Problem 1.3 URLify --> Replace all the spaces in a string with '%20'. 
 * Assumption : We have enough space to accomodate addition chars
 * Preferebly in place
 */

#include <cstdio>
#include <cstring>

char* URLify(char *str) {
    size_t true_len, all_len;
    true_len = all_len = strlen(str)-1;
    while(str[true_len] == ' ') true_len--;
    for (int i = true_len, j = all_len; i >= 0; i--) {
        if (str[i] == ' ') {
            str[j--] = '0';
            str[j--] = '2';
            str[j--] = '%';
        } else str[j--] = str[i];
    }
}

int main() {
    char str[] = "URLified string :    ";
    URLify(str);
    printf("%s\n", str);
    return 0;
}