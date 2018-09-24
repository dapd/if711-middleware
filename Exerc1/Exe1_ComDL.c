#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <omp.h>
#include <string.h>
#include <algorithm>

int main(int argc, char const *argv[]){
	int num_items = 5, num_rounds = 50, num_cashiers = 3, i, j, k, tid, qtd_itens, itens[num_items];
	omp_lock_t lck[num_items];
	bool valid = false;
	using namespace std;
	//Inicializando variáveis de lock
	for(i=0;i<num_items;i++)
	{
		omp_init_lock(&lck[i]);
	}

	//Loop para quantidade de rodadas de vendas
	for(i=0;i<num_rounds;i++)
	{
		printf("\nINICIO ROUND %d\n", i+1);
		//Definindo regiao paralela
		// omp_set_num_threads(num_cashiers);
		#pragma omp parallel num_threads(num_cashiers) shared(lck) private(tid,j,k,valid,qtd_itens,itens)
		{
			tid = omp_get_thread_num(); //Obtendo numero da thread
			srand(int(time(NULL)) ^ (tid*(i+1)));
			qtd_itens = 1 + rand()%num_items; //Obtendo quantidade de itens no caixa
			for(j=0;j<qtd_itens;j++)
			{
				do
				{
					valid = true;
					itens[j] = rand()%num_items;
					for(k=0;k<j;k++)
					{
						if(itens[k]==itens[j]) valid = false; //Verificar se escolheu item diferente dos anteriores
					}
				}
				while(!valid);
			}
			
			//passa o vetor de itens ser ordenacao, ocasionalmente ocorrera algum deadlock
			#pragma omp critical //zona critica inserida para evitar que a impressao dos itens seja feita de forma misturada
			{
				printf("CAIXA %d ->", tid);
				for (int q = 0; q < qtd_itens; ++q)
				{
					printf(" %d", itens[q]);
				}
				printf("\n");
			}
			#pragma omp barrier //evita que threads fora do critical interfiram na saida da impressao dos itens
			//Obtendo locks
			for (j = 0; j < qtd_itens; ++j)
			{
				while (!omp_test_lock( &lck[ itens[j] ] )) {
					printf("\nThread %d esperando lock %d\n",tid,itens[j]);
					// sleep_mili(2000);
				}
				printf("\nThread %d adquiriu lock %d\n",tid,itens[j]);
				// for (int q = 0; q < 99999; ++q);
			}
			//Liberando locks
			for(j=0;j<qtd_itens;j++){
				printf("\nThread %d liberou lock %d\n",tid,itens[j]);
				omp_unset_lock( &lck[ itens[j] ] );
			}
			//Espera todas as threads
			#pragma omp barrier
		}
		printf("\nFIM ROUND %d\n", i+1);
	}
	printf("\nFIM EXECUCAO\n");
	return 0;
}