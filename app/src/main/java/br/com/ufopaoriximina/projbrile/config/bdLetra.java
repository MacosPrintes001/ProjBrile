package br.com.ufopaoriximina.projbrile.config;

import java.util.Arrays;

public class bdLetra {
    public static String[] letraBD(int[] snap, String flags) {
        int flag = Integer.parseInt(flags);

        int [] a = {1, 0, 0, 0, 0, 0};
        int [] b = {1, 1, 0, 0, 0, 0};
        int [] c = {1, 0, 0, 1, 0, 0};
        int [] d = {1, 0, 0, 1, 1, 0};
        int [] e = {1, 0, 0, 0, 1, 0};
        int [] f = {1, 1, 0, 1, 0, 0};
        int [] g = {1, 1, 0, 1, 1, 0};
        int [] h = {1, 1, 0, 0, 1, 0};
        int [] i = {0, 1, 0, 1, 0, 0};
        int [] j = {0, 1, 0, 1, 1, 0};
        int [] k = {1, 0, 1, 0, 0, 0};
        int [] l = {1, 1, 1, 0, 0, 0};
        int [] m = {1, 0, 1, 1, 0, 0};
        int [] n = {1, 0, 1, 1, 1, 0};
        int [] o = {1, 0, 1, 0, 1, 0};
        int [] p = {1, 1, 1, 1, 0, 0};
        int [] q = {1, 1, 1, 1, 1, 0};
        int [] r = {1, 1, 1, 0, 1, 0};
        int [] s = {0, 1, 1, 1, 0, 0};
        int [] t = {0, 1, 1, 1, 1, 0};
        int [] u = {1, 0, 1, 0, 0, 1};
        int [] v = {1, 1, 1, 0, 0, 1};
        int [] w = {0, 1, 0, 1, 1, 1};
        int [] x = {1, 0, 1, 1, 0, 1};
        int [] y = {1, 0, 1, 1, 1, 1};
        int [] z = {1, 0, 1, 0, 1, 1};
        int [] cedilha ={1, 1, 1, 1, 0, 1};
        int [] espaco = {0, 0, 0, 0, 0, 0};
        int [] ag = {1, 1, 1, 0, 1, 1};
        int [] eg = {1, 1, 1, 1, 1, 1};
        int [] ig = {0, 0, 1, 1, 0, 0};
        int [] og = {0, 0, 1, 1, 0, 1};
        int [] ug = {0, 1, 1, 1, 1, 1};
        int [] acr = {1, 1, 0, 1, 0, 1};
        int [] ecr = {0, 1, 1, 1, 0, 1};
        int [] icr = {1, 0, 0, 1, 0, 1};
        int [] ocr = {0, 1, 0, 1, 1, 1};
        int [] ucr = {1, 0, 0, 0, 1, 1};
        int [] ac = {1, 0, 0, 0, 0, 1};
        int [] ec = {1, 1, 0, 0, 0, 1};
        int [] oc = {1, 0, 0, 1, 1, 1};
        int [] at = {0, 0, 1, 1, 1, 0};
        int [] ot = {0, 1, 0, 1, 0, 1};
        int [] virg  = {0, 1, 0, 0, 0, 0};
        int [] doisp = {0, 1, 0, 0, 1, 0};
        int [] ponto = {0, 0, 1, 0, 0, 0};
        int [] excla = {0, 1, 0, 1, 0, 1};
        int [] inte = {0, 1, 0, 0, 0, 1};
        int [] pontvirg = {0, 1, 1, 0, 0, 0};
        int [] maiuscula = {0, 0, 0, 1, 0, 1};

        int [] abP = {1, 1, 0, 0, 0, 1};
        int [] feP = {0, 0, 1, 1, 1, 0};
        int [] mais = {0, 1, 1, 0, 1, 0};
        int [] hif = {0, 0, 1, 0, 0, 1};
        int [] aster = {0, 1, 1, 0, 0, 1};
        int [] divisao = {0, 1, 0, 0, 1, 1};
        int [] igual = {0, 1, 1, 0, 1, 1};

        String[] letter = new String [2];



        if(Arrays.equals(a,snap)){
            if (flag==1) {
                letter[0]="A";
                flag = 0;
            }else {
                letter[0]="a";}

        }else if(Arrays.equals(b,snap)){
            if (flag==1) {
                letter[0]="B";
                flag=0;
            }else {
                letter[0]="b";}

        }else if(Arrays.equals(c,snap)){
            if (flag==1){
                letter[0]="C";
                flag=0;
            }else
                letter[0]="c";

        }else if(Arrays.equals(d, snap)){
            if (flag==1){
                letter[0]="D";
                flag=0;
            }else
                letter[0]="d";

        }else if(Arrays.equals(e,snap)){
            if (flag==1){
                letter[0]="E";
                flag=0;
            }else
                letter[0]="e";

        }else if(Arrays.equals(f, snap)){
            if (flag==1){
                letter[0]="F";
                flag=0;
            }else
                letter[0]="f";

        }else if(Arrays.equals(g, snap)){
            if (flag==1){
                letter[0]="G";
                flag=0;
            }else
                letter[0]="g";

        }else if(Arrays.equals(h,snap)){
            if (flag==1){
                letter[0]="H";
                flag=0;
            }else
                letter[0]="h";

        }else if(Arrays.equals(i,snap)){
            if (flag==1){
                letter[0]="I";
                flag=0;
            }else
                letter[0]="i";

        }else if(Arrays.equals(j, snap)){
            if (flag==1){
                letter[0]="J";
                flag=0;
            }else
                letter[0]="j";

        }else if(Arrays.equals(k, snap)){
            if (flag==1){
                letter[0]="K";
                flag=0;
            }else
                letter[0]="k";

        }else if(Arrays.equals(l, snap)){
            if (flag==1){
                letter[0]="L";
                flag=0;
            }else
                letter[0]="l";

        }else if(Arrays.equals(m, snap)){
            if (flag==1){
                letter[0]="M";
                flag=0;
            }else
                letter[0]="m";

        }else if(Arrays.equals(n, snap)){
            if (flag==1){
                letter[0]="N";
                flag=0;
            }else
                letter[0]="n";

        }else if(Arrays.equals(o, snap)){
            if (flag==1){
                letter[0]="O";
                flag=0;
            }else
                letter[0]="o";

        }else if(Arrays.equals(p, snap)){
            if (flag==1){
                letter[0]="P";
                flag=0;
            }else
                letter[0]="p";

        }else if(Arrays.equals(q, snap)){
            if (flag==1){
                letter[0]="Q";
                flag=0;
            }else
                letter[0]="q";

        }else if(Arrays.equals(r, snap)){
            if (flag==1){
                letter[0]="R";
                flag=0;
            }else
                letter[0]="r";

        }else if(Arrays.equals(s, snap)){
            if (flag==1){
                letter[0]="S";
                flag=0;
            }else
                letter[0]="s";

        }else if(Arrays.equals(t, snap)){
            if (flag==1){
                letter[0]="T";
                flag=0;
            }else
                letter[0]="t";

        }else if(Arrays.equals(u, snap)){
            if (flag==1){
                letter[0]="U";
                flag=0;
            }else
                letter[0]="u";

        }else if(Arrays.equals(v, snap)){
            if (flag==1){
                letter[0]="V";
                flag=0;
            }else
                letter[0]="v";

        }else if(Arrays.equals(w, snap)){
            if (flag==1){
                letter[0]="W";
                flag=0;
            }else
                letter[0]="w";

        }else if(Arrays.equals(x, snap)){
            if (flag==1){
                letter[0]="X";
                flag=0;
            }else
                letter[0]="x";

        }else if(Arrays.equals(y, snap)){
            if (flag==1){
                letter[0]="Y";
            }else
                letter[0]="y";

        }else if(Arrays.equals(z, snap)){
            if (flag==1){
                letter[0]="Z";
                flag=0;
            }else
                letter[0]="z";

        }else if(Arrays.equals(cedilha, snap)){
            letter[0]="ç";
        }else if(Arrays.equals(espaco, snap)){
            letter[0]=" ";
        }else if(Arrays.equals(ag, snap)){
            letter[0]="á";
        }else if(Arrays.equals(eg, snap)){
            letter[0]="é";
        }else if(Arrays.equals(ig, snap)){
            letter[0]="í";
        }else if(Arrays.equals(og, snap)){
            letter[0]="ó";
        }else if(Arrays.equals(ug, snap)){
            letter[0]="ú";
        }else if(Arrays.equals(acr,snap)){
            letter[0]="à";
        }else if(Arrays.equals(ecr,snap)){
            letter[0]="è";
        }else if(Arrays.equals(icr, snap)){
            letter[0]="ì";
        }else if(Arrays.equals(ocr, snap)){
            letter[0]="ò";
        }else if(Arrays.equals(ucr, snap)){
            letter[0]="ù";
        }else if(Arrays.equals(ac, snap)){
            letter[0]="â";
        }else if(Arrays.equals(ec, snap)){
            letter[0]="ê";
        }else if(Arrays.equals(oc, snap)){
            letter[0]="ô";
        }else if(Arrays.equals(at, snap)){
            letter[0]="ã";
        }else if(Arrays.equals(ot, snap)){
            letter[0]=""; //verificar
        }else if(Arrays.equals(virg, snap)){
            letter[0]=" == ";
        }else if(Arrays.equals(doisp, snap)){
            letter[0]=":";
        }else if(Arrays.equals(ponto, snap)){
            letter[0]=".";
        }else if(Arrays.equals(inte, snap)){
            letter[0]="?";
        }else if(Arrays.equals(excla, snap)){
            letter[0]="!";
        }else if(Arrays.equals(pontvirg, snap)){
            letter[0]=";";
        }else if(Arrays.equals(hif, snap)){
            letter[0]="-";
        }else if(Arrays.equals(abP, snap)){
            letter[0]="(";
        }else if(Arrays.equals(feP, snap)){
            letter[0]="){";
        }else if(Arrays.equals(mais, snap)){
            letter[0]="+";
        }else if(Arrays.equals(aster, snap)){
            letter[0]="*";
        }else if(Arrays.equals(divisao, snap)){
            letter[0]="/";
        }else if(Arrays.equals(igual, snap)){
            letter[0]="=";

        }else if(Arrays.equals(maiuscula, snap)){
            flag=1;
            letter[0]="";
        }else {
            letter[0] = "#";
        }


        letter[1]= String.valueOf(flag);
        return letter;

    }
}
