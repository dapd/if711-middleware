#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main(){
    int i = 0, j = 0;
    char filename[15];
    FILE *fp;
    srand(time(NULL));
    while(i<100){
        //printf("Antes\n");
        sprintf(filename,"file%d.txt",i);
        //printf("Depois\n");
        fp = fopen(filename,"w");
        while(j<10){
            fprintf(fp,"%d\n",rand()%10000);
            j++;
        }
        j=0;
        fclose(fp);
        i++;
    }
    return 0;
}