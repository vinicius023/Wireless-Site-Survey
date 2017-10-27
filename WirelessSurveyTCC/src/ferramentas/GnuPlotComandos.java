package ferramentas;


import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vinicius_023
 */



public class GnuPlotComandos {   
    
    private static final int PONTO = 1;
    private static final int INTENSIDADE = 2;
    private static final int QUALIDADE = 3;
    
    private static void exec(String[] comando) {
        try {
            Process proc = Runtime.getRuntime().exec("/usr/bin/gnuplot");
            OutputStream outputStream = proc.getOutputStream(); //process p
            PrintWriter gp = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
            for (String comando1 : comando) {
                gp.println(comando1);
                gp.flush();
            }
            gp.close();
            
            proc.waitFor();
        } catch (Exception x) {
            System.out.println(x.getMessage());
        }
    }
    
    //public static void plotHeatMap(int LARGURA, int ALTURA, int FILTRO) {
    public static void plotHeatMap(int FILTRO) {
        
        if (FILTRO == PONTO) {
            System.out.println("plotando os pontos da medicao");
            //"set terminal pngcairo transparent enhanced size "+LARGURA*1.326213592+", "+ALTURA*1.542857143+" \n" ,
            String[] scriptPontos = {
                "set terminal pngcairo transparent size 1366, 819 \n" ,
                "set view map\n" ,
                "set pm3d at b map\n" ,
                "set dgrid3d 1000, 600,2\n" ,
                "set xrange [0:1000]\n",
                "set yrange [600:0]\n" ,
                "set palette defined (0 0 0 0.5, 1 0 0 1, 2 0 0.5 1, 3 0 1 1, 4 0.5 1 0.5, 5 1 1 0, 6 1 0.5 0, 7 1 0 0, 8 0.5 0 0)",
                "set output './cache/pontos_medicao.png'\n" ,
                "plot \"dados-cell.txt\" u 1:2 with point pt 7 ps 1 t\"\""+"\n" ,
                "exit"
                    //"plot \"dados-cell.txt\" u 1:2 with lines lt 2 lw 4, \"dados-cell.txt\" u 1:2 with point pt 7 ps 2"+"\n" ,
            };      
            GnuPlotComandos.exec(scriptPontos);
            //plota pontos
        }else if (FILTRO == INTENSIDADE) {
            //"set terminal pngcairo transparent enhanced size "+LARGURA*1.326213592+", "+ALTURA*1.542857143+" \n" ,
            String[] scriptHeatMap = {
                "set terminal pngcairo transparent size 1366, 819 \n" ,
                "set view map\n" ,
                "set pm3d at b map\n" ,
                "set dgrid3d 1000, 600,2\n" ,
                "set xrange [0:1000]\n",
                "set yrange [0:600]\n" ,
                "set output './cache/heatmap_intensidade.png'\n" ,
                "set style fill transparent solid 0.5 noborder \n" ,
                "set palette defined (0 0 0 0.5, 1 0 0 1, 2 0 0.5 1, 3 0 1 1, 4 0.5 1 0.5, 5 1 1 0, 6 1 0.5 0, 7 1 0 0, 8 0.5 0 0)",
                "set pm3d interpolate 0,0",
                "splot \"dados-cell.txt\" u 1:2:4 t\"\""+"\n" ,
                "exit"
            };
            GnuPlotComandos.exec(scriptHeatMap);
        }else{
            //"set terminal pngcairo transparent enhanced size "+LARGURA*1.326213592+", "+ALTURA*1.542857143+" \n" ,
            String[] scriptHeatMap = {
                "set terminal pngcairo transparent size 1366, 819 \n" ,
                "set view map\n" ,
                "set pm3d at b map\n" ,
                "set dgrid3d 1000, 600,2\n" ,
                "set xrange [0:1000]\n",
                "set yrange [0:600]\n" ,
                "set output './cache/heatmap_qualidade.png'\n" ,
                "set style fill transparent solid 0.5 noborder \n" ,
                "set palette defined (0 0 0 0.5, 1 0 0 1, 2 0 0.5 1, 3 0 1 1, 4 0.5 1 0.5, 5 1 1 0, 6 1 0.5 0, 7 1 0 0, 8 0.5 0 0)",
                "set pm3d interpolate 0,0",
                "splot \"dados-cell.txt\" u 1:2:3 t\"\""+"\n" ,
                "exit"
            };
            GnuPlotComandos.exec(scriptHeatMap);
        }  
    }
    
    public static void plotPontosMedicao() {
        plotHeatMap(PONTO);
    }
    
    public static void plotHeatMapIntensidade() {
        plotHeatMap(INTENSIDADE);
    }
    
    public static void plotHeatMapQualidade() {
        plotHeatMap(QUALIDADE);
    }

}
