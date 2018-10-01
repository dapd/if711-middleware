#include <stdio.h>
#include <stdlib.h>
#include <time.h>

char numberStr[5];

void completa_int(int number){
    if((number / 10)==0){
        sprintf(numberStr,"000%d",number);
    }
    else{
        if((number / 100)==0){
            sprintf(numberStr,"00%d",number);
        }
        else{
            if((number / 1000)==0){
                sprintf(numberStr,"0%d",number);
            }
            else{
                sprintf(numberStr,"%d",number);
            }
        }
    }
}

int main(){
    int i = 0, j = 0, random;
    char filename[15];
    FILE *fp;
    srand(time(NULL));
    while(i<100){
        //printf("Antes\n");
        sprintf(filename,"file%d.txt",i);
        //printf("Depois\n");
        fp = fopen(filename,"w");
        while(j<10){
            random = rand()%10000;
            completa_int(random);
            fprintf(fp,"%04d\n",random);
            j++;
        }
        j=0;
        fclose(fp);
        i++;
    }
    return 0;
}