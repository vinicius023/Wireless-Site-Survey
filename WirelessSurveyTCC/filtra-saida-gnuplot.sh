#!/bin/bash

if [ ! -z $1 ]; then
	ARQUIVO="$1"
else
	echo 'USAGE: sh filtra-saida-gnuplot <ARQUIVO IWLIST> <NOME FILTRO> <VALOR FILTRADO>'
	echo 
	echo 'não foi possível realizar a filtragem com o comando ' "\" sh $0 $@\""
	
	
	
	exit 1
	#ARQUIVO="saida_*.txt"
fi

## invoque o scrit passando o filtro da celula, exx.: 
## sh filtra-saidagnuplot.sh "18:8B:9D:69:DC:C6"
if [ ! -z $2 ]; then
	TIPO_FILTRO="$2"
else
	TIPO_FILTRO="."
fi

if [ ! -z $3 ]; then
	VALOR_FILTRO="$3"
else
	VALOR_FILTRO="."
fi


#ls -1 ${ARQUIVO_MEDICAO}* | while read ARQUIVO; do (
#for FILE in saida*.txt; do ( 
(
	
	awk -v valorFiltro="$VALOR_FILTRO" -v tipoFiltro="$TIPO_FILTRO" -v arquivo=$ARQUIVO '
		BEGIN { 
			flag=0; 
			x=0; 
			y=0; 
		}		
		{
			# LOOP para cada linha do arquivo

			if($1 ~ "POSICAO_MEDIDA"){
				//atualiza o valor das variaveis globais X e Y
				x=$2
				y=$3
			}

			# FAZ BACKUP DOS DADOS DA CELULA			
			if($1 ~ "Cell"){
				cell_id = $2
				dados[cell_id]["Address"] = $5				
			}

			if($1 ~ "Channel"){
				split($1,tokens,"Channel:")
				dados[cell_id]["Channel"] = tokens[2] 	
			}

			if($1 ~ "Frequency"){
				split($1,tokens,"Frequency:")
				dados[cell_id]["Frequency"] = tokens[2]	
			}

			if($1 ~ "Quality"){
				split($1,tokens,"Quality=")
				split(tokens[2],tokens,"/")
				dados[cell_id]["Quality"] = tokens[1]	
			}

			if($2 ~ "Signal" && $3 ~ "level"){
				split($3,tokens,"level=")
				dados[cell_id]["Intensity"] = tokens[2]	
			}

			if($1 ~ "ESSID"){
				split($1,tokens,"ESSID:")
				dados[cell_id]["ESSID"] = tokens[2]	
			}

			## AGORA SIM, FILTRAMOS
			# sobe a flag caso tenha encontrado o valor para aquele tipo de filtro 
			# caso nao tenha passado filtro algum, precisa existir ["."] pra não deixar de imprimir
			dados[cell_id]["."] = "."
			
			if( dados[cell_id][tipoFiltro] == valorFiltro ) 
				flag=1; 
			
			if(flag) {
				print x "\t" y "\t" dados[cell_id]["Quality"] "\t" dados[cell_id]["Intensity"] "\t" dados[cell_id]["Frequency"] "\t" dados[cell_id]["Channel"] "\t" dados[cell_id]["Address"] "\t" dados[cell_id]["ESSID"]

				# desce a flag pois nao sei se a proxima celula será a mesma a ser filtrada
				flag=0; 
			} 

		}
		END{}
	' ${ARQUIVO} | uniq #| sort -k 4 -nr 
	
#); done | awk 'BEGIN{ print "#X #Y #QUALITY #INTENSITY #FREQUENCY #CHANNEL #MAC" }{print $0}' > dados-cell.txt
) | tee dados-cell.txt

## rebatizar para dados-medicao.txt
