//### This file created by BYACC 1.8(/Java extension  1.1)
//### Java capabilities added 7 Jan 97, Bob Jamison
//### Updated : 27 Nov 97  -- Bob Jamison, Joe Nieten
//###           01 Jan 98  -- Bob Jamison -- fixed generic semantic constructor
//###           01 Jun 99  -- Bob Jamison -- added Runnable support
//###           06 Aug 00  -- Bob Jamison -- made state variables class-global
//###           03 Jan 01  -- Bob Jamison -- improved flags, tracing
//###           16 May 01  -- Bob Jamison -- added custom stack sizing
//### Please send bug reports to rjamison@lincom-asg.com
//### static char yysccsid[] = "@(#)yaccpar	1.8 (Berkeley) 01/20/90";



package sintactico;



//#line 9 "sintactico.y"

import lexico.Lexico;
import asttree.*;
import java.util.List;
import java.util.ArrayList;

//#line 22 "Sintactico.java"




/**
 * Encapsulates yacc() parser functionality in a Java
 *        class for quick code development
 */
public class Sintactico
{

boolean yydebug;        //do I want debug output?
int yynerrs;            //number of errors so far
int yyerrflag;          //was there an error?
int yychar;             //the current working character

//########## MESSAGES ##########
//###############################################################
// method: debug
//###############################################################
void debug(String msg)
{
  if (yydebug)
    System.out.println(msg);
}

//########## STATE STACK ##########
final static int YYSTACKSIZE = 500;  //maximum stack size
int statestk[],stateptr;           //state stack
int stateptrmax;                     //highest index of stackptr
int statemax;                        //state when highest index reached
//###############################################################
// methods: state stack push,pop,drop,peek
//###############################################################
void state_push(int state)
{
  if (stateptr>=YYSTACKSIZE)         //overflowed?
    return;
  statestk[++stateptr]=state;
  if (stateptr>statemax)
    {
    statemax=state;
    stateptrmax=stateptr;
    }
}
int state_pop()
{
  if (stateptr<0)                    //underflowed?
    return -1;
  return statestk[stateptr--];
}
void state_drop(int cnt)
{
int ptr;
  ptr=stateptr-cnt;
  if (ptr<0)
    return;
  stateptr = ptr;
}
int state_peek(int relative)
{
int ptr;
  ptr=stateptr-relative;
  if (ptr<0)
    return -1;
  return statestk[ptr];
}
//###############################################################
// method: init_stacks : allocate and prepare stacks
//###############################################################
boolean init_stacks()
{
  statestk = new int[YYSTACKSIZE];
  stateptr = -1;
  statemax = -1;
  stateptrmax = -1;
  val_init();
  return true;
}
//###############################################################
// method: dump_stacks : show n levels of the stacks
//###############################################################
void dump_stacks(int count)
{
int i;
  System.out.println("=index==state====value=     s:"+stateptr+"  v:"+valptr);
  for (i=0;i<count;i++)
    System.out.println(" "+i+"    "+statestk[i]+"      "+valstk[i]);
  System.out.println("======================");
}


//########## SEMANTIC VALUES ##########
//## **user defined:Object
String   yytext;//user variable to return contextual strings
Object yyval; //used to return semantic vals from action routines
Object yylval;//the 'lval' (result) I got from yylex()
Object valstk[];
int valptr;
//###############################################################
// methods: value stack push,pop,drop,peek.
//###############################################################
void val_init()
{
  valstk=new Object[YYSTACKSIZE];
  yyval=new Object();
  yylval=new Object();
  valptr=-1;
}
void val_push(Object val)
{
  if (valptr>=YYSTACKSIZE)
    return;
  valstk[++valptr]=val;
}
Object val_pop()
{
  if (valptr<0)
    return null;
  return valstk[valptr--];
}
void val_drop(int cnt)
{
int ptr;
  ptr=valptr-cnt;
  if (ptr<0)
    return;
  valptr = ptr;
}
Object val_peek(int relative)
{
int ptr;
  ptr=valptr-relative;
  if (ptr<0)
    return null;
  return valstk[ptr];
}
//#### end semantic value section ####
public final static short NULLTEXT=257;
public final static short EQUAL=258;
public final static short NOTEQUAL=259;
public final static short LET=260;
public final static short GET=261;
public final static short AND=262;
public final static short OR=263;
public final static short STRINGVALUE=264;
public final static short INTEGER=265;
public final static short REAL=266;
public final static short BOOLEAN=267;
public final static short TEXT=268;
public final static short LETTER=269;
public final static short STRING=270;
public final static short INT=271;
public final static short DOUBLE=272;
public final static short CHAR=273;
public final static short BOOL=274;
public final static short VOID=275;
public final static short STRUCT=276;
public final static short MAIN=277;
public final static short IF=278;
public final static short ELSE=279;
public final static short WHILE=280;
public final static short ID=281;
public final static short INPUT=282;
public final static short PRINT=283;
public final static short RETURN=284;
public final static short NEG=285;
public final static short IFX=286;
public final static short var=287;
public final static short cast=288;
public final static short matrix=289;
public final static short expr=290;
public final static short YYERRCODE=256;
final static short yylhs[] = {                           -1,
    0,    1,    1,    4,    4,    6,    6,    7,    7,    7,
    5,    5,    5,    5,    2,    2,    9,    3,    3,   11,
   11,   11,   11,   11,   11,   11,   11,   11,   14,   14,
   14,   10,   10,   10,   15,   12,   12,   13,   13,   17,
   17,   17,   17,   17,   17,   17,   16,   16,   16,   16,
   16,   16,    8,    8,    8,    8,    8,    8,    8,    8,
    8,    8,    8,    8,    8,    8,    8,    8,
};
final static short yylen[] = {                            2,
    9,    0,    2,    3,    1,    1,    3,    6,    6,    9,
    1,    1,    1,    1,    0,    2,    8,    1,    2,    1,
    3,    3,    4,    5,    3,    3,    5,    3,    3,    2,
    1,    0,    1,    3,    2,    0,    2,    3,    3,    3,
    3,    2,    3,    3,    2,    1,    3,    3,    3,    3,
    3,    3,    3,    3,    3,    3,    3,    3,    4,    4,
    1,    1,    1,    1,    3,    1,    4,    7,
};
final static short yydefred[] = {                         2,
    0,    0,   14,   11,   12,   13,    0,    0,    3,    0,
    5,    0,    2,    0,    0,    0,    0,   16,    0,    0,
    0,    0,    0,    4,    0,    0,    0,    0,    0,    0,
    0,   33,    0,    7,   64,   61,   62,   63,    0,    0,
    0,    6,    0,   35,    0,    0,    0,    0,   36,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    8,    0,
    0,   34,    9,    0,    0,    0,    0,    0,    0,    0,
    0,    0,   65,    0,    0,    0,    0,    0,    0,    0,
    0,   20,    0,   18,    0,    0,   60,    0,    0,    0,
    0,    0,    0,   36,    0,    0,    0,    1,   19,    0,
   17,    0,    0,    0,    0,    0,    0,    0,   31,    0,
   25,    0,   21,   22,   28,    0,   10,    0,    0,   42,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   38,   39,   30,    0,    0,    0,   23,   68,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   40,   41,   29,
   27,   24,
};
final static short yydgoto[] = {                          1,
    2,    8,   81,   82,   28,   17,   11,   83,   12,   31,
   84,   65,   92,  110,   32,  106,  107,
};
final static short yysindex[] = {                         0,
    0, -232,    0,    0,    0,    0,  -81, -229,    0,  -86,
    0, -156,    0, -217,   24, -194,  -16,    0, -201, -123,
   45, -156,   -3,    0, -187,   24,  120,  -85,   54, -182,
   18,    0,  -83,    0,    0,    0,    0,    0,   60, -156,
  -28,    0,  -22,    0,   -2, -156,   50, -158,    0,   79,
  120,  120,  120,  120,  120,  120, -159,  120,    0,   99,
   99,    0,    0,   34,  -40,  120,   46,   46,  -42,  -42,
  -42,  -42,    0,  -21,   85,   85,   88,  120,  120,  120,
  -27,    0,  -10,    0,   -6, -152,    0,   87,   42,   43,
  -33,   15,   15,    0,   32,  125,  516,    0,    0,  120,
    0,   76,  120,  120,  425,    6,  100,   36,    0, -137,
    0,  -31,    0,    0,    0,  545,    0,   11,  466,    0,
  120,  120,  120,  120,  120,  120,  120,  120,  120,  120,
    0,    0,    0,   57,   15,   86,    0,    0,  674,  674,
  674,  674,  674,  674,  674,  674,  466,    0,    0,    0,
    0,    0,
};
final static short yyrindex[] = {                         0,
    0, -129,    0,    0,    0,    0,    0,    0,    0,    0,
    0, -129,    0,    0,  -14,    0,    0,    0,    0,    0,
    0,   67,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  132,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  477,  486,  397,  404,
  432,  439,    0,    0,    0,    0,  667,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  -29,  168,  361,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,  110,    0,    0,    0,    0,   78,
    0,    0,    0,    0,    0,    0,    0,    0,  111,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  717,    0,    0,   20,   27,
   41,   48,   54,  113,   62,   69,    0,    0,    0,    0,
    0,    0,
};
final static short yygindex[] = {                         0,
  142,  144,  -58,    9,   84,  -45,    0,  547,    0,    0,
   51,   63,   82,  -70,  117,  -17,    0,
};
final static int YYTABLESIZE=811;
final static short yytable[] = {                        104,
   87,   27,   85,   57,   16,   16,   40,   48,   55,  136,
    9,   37,   40,   53,   52,   55,   51,   57,   54,   88,
   53,   52,  111,   51,   57,   54,   55,   25,    9,    6,
   59,   53,   52,   40,   51,   57,   54,    3,    4,    5,
    6,   13,   24,    7,    6,   14,  131,   55,   58,  134,
  100,   56,   53,   52,   40,   51,   57,   54,   45,   21,
   47,   46,   58,   22,  151,   56,   88,   48,   55,   58,
   23,   90,   56,   53,   52,   40,   51,   57,   54,   26,
   58,   49,   55,   56,   29,   10,  120,   53,   50,   33,
  113,   57,   54,   34,   43,   19,   40,   98,   44,   49,
   60,   58,   51,  138,   56,   30,   64,   32,   63,   52,
   32,  148,  149,    3,    4,    5,    6,   26,  101,   66,
   61,   73,   58,   50,   91,   56,   86,   94,  102,   30,
   25,   99,   58,  103,  117,   99,   58,  108,   40,   56,
  132,  135,  109,  109,  152,   15,    3,    4,    5,    6,
   46,   45,    7,   44,   20,   18,  112,   93,    0,   40,
  133,   55,   62,    0,    0,    0,   53,   52,   66,   51,
   57,   54,   66,   66,   66,    0,   66,   66,   66,    0,
    0,  150,    0,  114,   99,  109,    0,    0,    0,    0,
   66,   66,   66,   66,   15,   42,    0,   47,    0,    0,
    0,    0,   26,    0,   59,    0,    0,    0,   59,   59,
   59,    0,   59,   59,   59,   58,    0,    0,   56,    0,
    0,    0,   66,    0,   66,   66,   59,   59,   59,   59,
   35,   36,   37,    0,    0,   38,   35,   36,   37,    0,
   42,   38,    3,    4,    5,    6,    0,   39,    7,   42,
   75,   37,   76,   77,   78,   79,   80,   35,   36,   37,
   59,   59,   38,    3,    4,    5,    6,  129,  130,    7,
    0,   75,    0,   76,   77,   78,   79,   80,   35,   36,
   37,   47,   47,   38,    3,    4,    5,    6,   48,   48,
    7,    0,   75,    0,   76,   77,   78,   79,   80,   35,
   36,   37,   49,   49,   38,    3,    4,    5,    6,   50,
   50,    7,    0,   75,    0,   76,   77,   78,   79,   80,
   35,   36,   37,   51,   51,   38,    3,    4,    5,    6,
   52,   52,    7,    0,   75,    0,   76,   77,   78,   79,
   80,   26,   26,   26,    0,    0,   26,   26,   26,   26,
   26,    0,    0,   26,    0,   26,    0,   26,   26,   26,
   26,   26,   35,   36,   37,    0,    0,   38,    3,    4,
    5,    6,    0,    0,    7,    0,   75,    0,   76,   77,
   78,   79,   80,   35,   36,   37,    0,    0,   38,   66,
   66,   66,   66,   66,   66,    0,    0,   67,    0,    0,
   39,   67,   67,   67,    0,   67,   67,   67,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   67,
   67,   67,   67,    0,    0,   59,   59,   59,   59,   59,
   59,    0,    0,   55,    0,    0,    0,   55,   55,   55,
   56,   55,    0,   55,   56,   56,   56,    0,   56,    0,
   56,    0,    0,   67,   67,   55,   55,   55,   55,    0,
    0,   55,   56,   56,   56,   56,   53,   52,   57,   51,
   57,   54,   57,   57,   57,   58,   57,    0,   57,   58,
   58,   58,    0,   58,  127,   58,  128,    0,    0,   55,
   57,   57,   57,   57,    0,    0,   56,   58,   58,   58,
   58,    0,   55,    0,    0,    0,    0,   53,   52,    0,
   51,   57,   54,    0,    0,   58,    0,   54,   56,   54,
    0,   54,    0,    0,   57,  127,   53,  128,   53,    0,
   53,   58,    0,    0,    0,   54,   54,   54,   54,    0,
    0,    0,    0,    0,   53,   53,   53,   53,    0,    0,
    0,    0,   55,    0,    0,    0,   58,   53,   52,   56,
   51,   57,   54,    0,    0,    0,    0,    0,    0,   54,
    0,    0,    0,   41,  115,    0,    0,    0,   53,    0,
    0,   55,    0,    0,    0,    0,   53,   52,    0,   51,
   57,   54,    0,    0,    0,    0,    0,   67,   68,   69,
   70,   71,   72,  137,   74,    0,   58,    0,    0,   56,
    0,    0,   89,    0,    0,    0,    0,    0,   67,   67,
   67,   67,   67,   67,   95,   96,   97,    0,    0,    0,
    0,    0,    0,    0,    0,   58,    0,  105,   56,    0,
    0,    0,    0,    0,    0,    0,  116,    0,    0,  118,
  119,    0,    0,    0,   55,   55,   55,   55,   55,   55,
    0,   56,   56,   56,   56,   56,   56,  139,  140,  141,
  142,  143,  144,  145,  146,  147,  147,    0,    0,    0,
    0,    0,  121,  122,  123,  124,  125,  126,    0,   57,
   57,   57,   57,   57,   57,    0,   58,   58,   58,   58,
   58,   58,    0,   66,    0,    0,    0,    0,   66,   66,
   55,   66,   66,   66,    0,   53,   52,    0,   51,   57,
   54,    0,    0,  121,  122,  123,  124,   66,    0,    0,
    0,    0,    0,    0,   54,   54,   54,   54,   54,   54,
    0,    0,    0,   53,   53,   53,   53,   53,   53,    0,
    0,    0,    0,   60,    0,    0,    0,   66,   60,   60,
   66,   60,   60,   60,   58,    0,    0,   56,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   60,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   60,    0,    0,
   60,
};
final static short yycheck[] = {                         33,
   41,  125,   61,   46,   91,   91,   40,   91,   37,   41,
    2,   41,   40,   42,   43,   37,   45,   46,   47,   65,
   42,   43,   93,   45,   46,   47,   37,   44,   20,   44,
   59,   42,   43,   40,   45,   46,   47,  270,  271,  272,
  273,  123,   59,  276,   59,  275,   41,   37,   91,  108,
   61,   94,   42,   43,   40,   45,   46,   47,   41,  277,
   41,   44,   91,   40,  135,   94,  112,   41,   37,   91,
  265,   93,   94,   42,   43,   40,   45,   46,   47,  281,
   91,   41,   37,   94,   40,    2,  104,   42,   41,   93,
   59,   46,   47,  281,   41,   12,   40,  125,  281,   40,
  123,   91,   41,   93,   94,   22,  265,   41,   59,   41,
   44,  129,  130,  270,  271,  272,  273,   40,  125,   41,
  123,  281,   91,   40,   40,   94,   93,   40,  281,   46,
   44,   81,   91,   91,   59,   85,   91,  123,   40,   94,
   41,  279,   92,   93,   59,  275,  270,  271,  272,  273,
   41,   41,  276,   41,   13,   12,   94,   76,   -1,   40,
  125,   37,   46,   -1,   -1,   -1,   42,   43,   37,   45,
   46,   47,   41,   42,   43,   -1,   45,   46,   47,   -1,
   -1,  125,   -1,   59,  134,  135,   -1,   -1,   -1,   -1,
   59,   60,   61,   62,  281,  281,   -1,  281,   -1,   -1,
   -1,   -1,  125,   -1,   37,   -1,   -1,   -1,   41,   42,
   43,   -1,   45,   46,   47,   91,   -1,   -1,   94,   -1,
   -1,   -1,   91,   -1,   93,   94,   59,   60,   61,   62,
  264,  265,  266,   -1,   -1,  269,  264,  265,  266,   -1,
  281,  269,  270,  271,  272,  273,   -1,  281,  276,  281,
  278,  281,  280,  281,  282,  283,  284,  264,  265,  266,
   93,   94,  269,  270,  271,  272,  273,  262,  263,  276,
   -1,  278,   -1,  280,  281,  282,  283,  284,  264,  265,
  266,  262,  263,  269,  270,  271,  272,  273,  262,  263,
  276,   -1,  278,   -1,  280,  281,  282,  283,  284,  264,
  265,  266,  262,  263,  269,  270,  271,  272,  273,  262,
  263,  276,   -1,  278,   -1,  280,  281,  282,  283,  284,
  264,  265,  266,  262,  263,  269,  270,  271,  272,  273,
  262,  263,  276,   -1,  278,   -1,  280,  281,  282,  283,
  284,  264,  265,  266,   -1,   -1,  269,  270,  271,  272,
  273,   -1,   -1,  276,   -1,  278,   -1,  280,  281,  282,
  283,  284,  264,  265,  266,   -1,   -1,  269,  270,  271,
  272,  273,   -1,   -1,  276,   -1,  278,   -1,  280,  281,
  282,  283,  284,  264,  265,  266,   -1,   -1,  269,  258,
  259,  260,  261,  262,  263,   -1,   -1,   37,   -1,   -1,
  281,   41,   42,   43,   -1,   45,   46,   47,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   59,
   60,   61,   62,   -1,   -1,  258,  259,  260,  261,  262,
  263,   -1,   -1,   37,   -1,   -1,   -1,   41,   42,   43,
   37,   45,   -1,   47,   41,   42,   43,   -1,   45,   -1,
   47,   -1,   -1,   93,   94,   59,   60,   61,   62,   -1,
   -1,   37,   59,   60,   61,   62,   42,   43,   37,   45,
   46,   47,   41,   42,   43,   37,   45,   -1,   47,   41,
   42,   43,   -1,   45,   60,   47,   62,   -1,   -1,   93,
   59,   60,   61,   62,   -1,   -1,   93,   59,   60,   61,
   62,   -1,   37,   -1,   -1,   -1,   -1,   42,   43,   -1,
   45,   46,   47,   -1,   -1,   91,   -1,   41,   94,   43,
   -1,   45,   -1,   -1,   93,   60,   41,   62,   43,   -1,
   45,   93,   -1,   -1,   -1,   59,   60,   61,   62,   -1,
   -1,   -1,   -1,   -1,   59,   60,   61,   62,   -1,   -1,
   -1,   -1,   37,   -1,   -1,   -1,   91,   42,   43,   94,
   45,   46,   47,   -1,   -1,   -1,   -1,   -1,   -1,   93,
   -1,   -1,   -1,   27,   59,   -1,   -1,   -1,   93,   -1,
   -1,   37,   -1,   -1,   -1,   -1,   42,   43,   -1,   45,
   46,   47,   -1,   -1,   -1,   -1,   -1,   51,   52,   53,
   54,   55,   56,   59,   58,   -1,   91,   -1,   -1,   94,
   -1,   -1,   66,   -1,   -1,   -1,   -1,   -1,  258,  259,
  260,  261,  262,  263,   78,   79,   80,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   91,   -1,   91,   94,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,  100,   -1,   -1,  103,
  104,   -1,   -1,   -1,  258,  259,  260,  261,  262,  263,
   -1,  258,  259,  260,  261,  262,  263,  121,  122,  123,
  124,  125,  126,  127,  128,  129,  130,   -1,   -1,   -1,
   -1,   -1,  258,  259,  260,  261,  262,  263,   -1,  258,
  259,  260,  261,  262,  263,   -1,  258,  259,  260,  261,
  262,  263,   -1,   37,   -1,   -1,   -1,   -1,   42,   43,
   37,   45,   46,   47,   -1,   42,   43,   -1,   45,   46,
   47,   -1,   -1,  258,  259,  260,  261,   61,   -1,   -1,
   -1,   -1,   -1,   -1,  258,  259,  260,  261,  262,  263,
   -1,   -1,   -1,  258,  259,  260,  261,  262,  263,   -1,
   -1,   -1,   -1,   37,   -1,   -1,   -1,   91,   42,   43,
   94,   45,   46,   47,   91,   -1,   -1,   94,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   61,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   91,   -1,   -1,
   94,
};
final static short YYFINAL=1;
final static short YYMAXTOKEN=290;
final static String yyname[] = {
"end-of-file",null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,"'!'",null,null,null,"'%'",null,null,"'('","')'","'*'","'+'",
"','","'-'","'.'","'/'",null,null,null,null,null,null,null,null,null,null,null,
"';'","'<'","'='","'>'",null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,"'['",null,"']'","'^'",null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,"'{'",null,"'}'",null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,"NULLTEXT","EQUAL","NOTEQUAL",
"LET","GET","AND","OR","STRINGVALUE","INTEGER","REAL","BOOLEAN","TEXT","LETTER",
"STRING","INT","DOUBLE","CHAR","BOOL","VOID","STRUCT","MAIN","IF","ELSE",
"WHILE","ID","INPUT","PRINT","RETURN","NEG","IFX","var","cast","matrix","expr",
};
final static String yyrule[] = {
"$accept : program",
"program : definitions functions VOID MAIN '(' ')' '{' instructions '}'",
"definitions :",
"definitions : definitions definition",
"definition : type vars ';'",
"definition : specialTypes",
"vars : ID",
"vars : vars ',' ID",
"specialTypes : STRUCT '{' definitions '}' exp ';'",
"specialTypes : type '[' INTEGER ']' ID ';'",
"specialTypes : type '[' INTEGER ']' '[' INTEGER ']' ID ';'",
"type : INT",
"type : DOUBLE",
"type : CHAR",
"type : STRING",
"functions :",
"functions : function functions",
"function : type ID '(' parametersFunction ')' '{' instructions '}'",
"instructions : instruction",
"instructions : instructions instruction",
"instruction : definition",
"instruction : INPUT exp ';'",
"instruction : PRINT exp ';'",
"instruction : exp '=' exp ';'",
"instruction : ID '(' parameters ')' ';'",
"instruction : WHILE expCompare spetialStatement",
"instruction : IF expCompare spetialStatement",
"instruction : IF expCompare spetialStatement ELSE spetialStatement",
"instruction : RETURN exp ';'",
"spetialStatement : '{' instructions '}'",
"spetialStatement : '{' '}'",
"spetialStatement : instruction",
"parametersFunction :",
"parametersFunction : parameterFunction",
"parametersFunction : parametersFunction ',' parameterFunction",
"parameterFunction : type ID",
"parameters :",
"parameters : parameters vars",
"expCompare : '(' expComp ')'",
"expCompare : '(' expBin ')'",
"expBin : expComp AND expComp",
"expBin : expComp OR expComp",
"expBin : '!' expComp",
"expBin : exp AND exp",
"expBin : exp OR exp",
"expBin : '!' exp",
"expBin : exp",
"expComp : exp EQUAL exp",
"expComp : exp NOTEQUAL exp",
"expComp : exp LET exp",
"expComp : exp GET exp",
"expComp : exp '<' exp",
"expComp : exp '>' exp",
"exp : exp '+' exp",
"exp : exp '-' exp",
"exp : exp '*' exp",
"exp : exp '/' exp",
"exp : exp '%' exp",
"exp : exp '^' exp",
"exp : '(' type ')' exp",
"exp : ID '(' parameters ')'",
"exp : INTEGER",
"exp : REAL",
"exp : LETTER",
"exp : STRINGVALUE",
"exp : exp '.' ID",
"exp : ID",
"exp : exp '[' exp ']'",
"exp : exp '[' exp ']' '[' exp ']'",
};

//#line 435 "sintactico.y"

// =================================================
// Interface  to the Lexical analyzer
// =================================================
private Lexico lexico;
public AST ast;



// =================================================
//  Invocation to the scanner
// =================================================
private int yylex () 
{
    int token=0;
    try { 
			token=lexico.yylex();
			this.yylval = lexico.getYylval(); 
		} catch(Throwable e) 
	{
	    System.err.println ("Lexical error in line "
		+ lexico.getLine()+ " and column "
		+lexico.getColumn()+":\n\t"+e); 
    }
    return token;
}
// =================================================
//  Syntax error handler
// =================================================
public void yyerror (String error) 
{
    System.err.println ("Syntax error in line " 
	+ lexico.getLine()
	+ " and column "+lexico.getColumn()+":\n\t"+error);
}
// =================================================
// * Constructor
// =================================================
public Sintactico(Lexico lexico) 
{
	this.lexico = lexico;
	
}
//#line 535 "Sintactico.java"
//###############################################################
// method: yylexdebug : check lexer state
//###############################################################
void yylexdebug(int state,int ch)
{
String s=null;
  if (ch < 0) ch=0;
  if (ch <= YYMAXTOKEN) //check index bounds
     s = yyname[ch];    //now get it
  if (s==null)
    s = "illegal-symbol";
  debug("state "+state+", reading "+ch+" ("+s+")");
}





//The following are now global, to aid in error reporting
int yyn;       //next next thing to do
int yym;       //
int yystate;   //current parsing state from state table
String yys;    //current token string


//###############################################################
// method: yyparse : parse input and execute indicated items
//###############################################################
int yyparse()
{
boolean doaction;
  init_stacks();
  yynerrs = 0;
  yyerrflag = 0;
  yychar = -1;          //impossible char forces a read
  yystate=0;            //initial state
  state_push(yystate);  //save it
  while (true) //until parsing is done, either correctly, or w/error
    {
    doaction=true;
    if (yydebug) debug("loop"); 
    //#### NEXT ACTION (from reduction table)
    for (yyn=yydefred[yystate];yyn==0;yyn=yydefred[yystate])
      {
      if (yydebug) debug("yyn:"+yyn+"  state:"+yystate+"  yychar:"+yychar);
      if (yychar < 0)      //we want a char?
        {
        yychar = yylex();  //get next token
        if (yydebug) debug(" next yychar:"+yychar);
        //#### ERROR CHECK ####
        if (yychar < 0)    //it it didn't work/error
          {
          yychar = 0;      //change it to default string (no -1!)
          if (yydebug)
            yylexdebug(yystate,yychar);
          }
        }//yychar<0
      yyn = yysindex[yystate];  //get amount to shift by (shift index)
      if ((yyn != 0) && (yyn += yychar) >= 0 &&
          yyn <= YYTABLESIZE && yycheck[yyn] == yychar)
        {
        if (yydebug)
          debug("state "+yystate+", shifting to state "+yytable[yyn]);
        //#### NEXT STATE ####
        yystate = yytable[yyn];//we are in a new state
        state_push(yystate);   //save it
        val_push(yylval);      //push our lval as the input for next rule
        yychar = -1;           //since we have 'eaten' a token, say we need another
        if (yyerrflag > 0)     //have we recovered an error?
           --yyerrflag;        //give ourselves credit
        doaction=false;        //but don't process yet
        break;   //quit the yyn=0 loop
        }

    yyn = yyrindex[yystate];  //reduce
    if ((yyn !=0 ) && (yyn += yychar) >= 0 &&
            yyn <= YYTABLESIZE && yycheck[yyn] == yychar)
      {   //we reduced!
      if (yydebug) debug("reduce");
      yyn = yytable[yyn];
      doaction=true; //get ready to execute
      break;         //drop down to actions
      }
    else //ERROR RECOVERY
      {
      if (yyerrflag==0)
        {
        yyerror("syntax error");
        yynerrs++;
        }
      if (yyerrflag < 3) //low error count?
        {
        yyerrflag = 3;
        while (true)   //do until break
          {
          if (stateptr<0)   //check for under & overflow here
            {
            yyerror("stack underflow. aborting...");  //note lower case 's'
            return 1;
            }
          yyn = yysindex[state_peek(0)];
          if ((yyn != 0) && (yyn += YYERRCODE) >= 0 &&
                    yyn <= YYTABLESIZE && yycheck[yyn] == YYERRCODE)
            {
            if (yydebug)
              debug("state "+state_peek(0)+", error recovery shifting to state "+yytable[yyn]+" ");
            yystate = yytable[yyn];
            state_push(yystate);
            val_push(yylval);
            doaction=false;
            break;
            }
          else
            {
            if (yydebug)
              debug("error recovery discarding state "+state_peek(0)+" ");
            if (stateptr<0)   //check for under & overflow here
              {
              yyerror("Stack underflow. aborting...");  //capital 'S'
              return 1;
              }
            state_pop();
            val_pop();
            }
          }
        }
      else            //discard this token
        {
        if (yychar == 0)
          return 1; //yyabort
        if (yydebug)
          {
          yys = null;
          if (yychar <= YYMAXTOKEN) yys = yyname[yychar];
          if (yys == null) yys = "illegal-symbol";
          debug("state "+yystate+", error recovery discards token "+yychar+" ("+yys+")");
          }
        yychar = -1;  //read another
        }
      }//end error recovery
    }//yyn=0 loop
    if (!doaction)   //any reason not to proceed?
      continue;      //skip action
    yym = yylen[yyn];          //get count of terminals on rhs
    if (yydebug)
      debug("state "+yystate+", reducing "+yym+" by rule "+yyn+" ("+yyrule[yyn]+")");
    if (yym>0)                 //if count of rhs not 'nil'
      yyval = val_peek(yym-1); //get current semantic value
    switch(yyn)
      {
//########## USER-SUPPLIED ACTIONS ##########
case 1:
//#line 104 "sintactico.y"
{System.out.println("Reducing MAIN_PROGRAM");
  List<InstructionDefinition> definitions = new ArrayList<InstructionDefinition>();
  List<Instruction> instructions = new ArrayList<Instruction>();
  List<Function> functions = new ArrayList<Function>();
  
  definitions.addAll((List<InstructionDefinition>)val_peek(8));
  functions.addAll ((List<Function>)val_peek(7));
  instructions.addAll ((List<Instruction>)val_peek(1));

  ast = new Program (lexico.getColumn(), lexico.getLine(), definitions, functions, instructions);
  }
break;
case 2:
//#line 117 "sintactico.y"
{yyval = new ArrayList<InstructionDefinition>();}
break;
case 3:
//#line 118 "sintactico.y"
{System.out.println("Reducing global definitions");
  List<InstructionDefinition> definitions = (List<InstructionDefinition>)val_peek(1);
  if (val_peek(0) instanceof List)
    definitions.addAll((List<InstructionDefinition>) val_peek(0));
  else
    definitions.add((InstructionDefinition) val_peek(0));
  yyval = definitions;
  }
break;
case 4:
//#line 128 "sintactico.y"
{System.out.println("Reducing primary definition");

  if (val_peek(1) instanceof List){
    List<RegularExpressionVariable> namesVars = (List<RegularExpressionVariable>)val_peek(1);
    List<InstructionDefinition> normalDefinitions = new ArrayList<InstructionDefinition>();
    int index = 0;
    while (index < namesVars.size()){
      normalDefinitions.add(new InstructionDefinition(lexico.getColumn(), lexico.getLine(),(TypeNormal)val_peek(2), namesVars.get(index)));
      index++;
    }
    yyval = normalDefinitions;
  }
  else
    yyval = new InstructionDefinition(lexico.getColumn(), lexico.getLine(),(TypeNormal)val_peek(2), (RegularExpressionVariable)val_peek(1));
  
  }
break;
case 5:
//#line 144 "sintactico.y"
{System.out.println("Reducing stecial Type");
  /*$$ = new InstructionDefinition(lexico.getColumn(), lexico.getLine(),(TypeSpecial)$1, null);*/
   
  }
break;
case 6:
//#line 152 "sintactico.y"
{System.out.println("Reducing ID");
  yyval = new RegularExpressionVariable (lexico.getColumn(), lexico.getLine(), (String)val_peek(0));
  }
break;
case 7:
//#line 155 "sintactico.y"
{System.out.println("Reducing vars");
  List<RegularExpressionVariable> varsList =  new ArrayList<RegularExpressionVariable>();
  if (val_peek(0) instanceof List){
    varsList.addAll((List<RegularExpressionVariable>) val_peek(0));
    if (val_peek(2) instanceof List)
      varsList.addAll((List<RegularExpressionVariable>) val_peek(2));
    else
      varsList.add((RegularExpressionVariable) val_peek(2));
    }
  else{
    varsList.add(new RegularExpressionVariable (lexico.getColumn(), lexico.getLine(), (String) val_peek(0) ));
    if (val_peek(2) instanceof List)
      varsList.addAll((List<RegularExpressionVariable>) val_peek(2));
    else
      varsList.add((RegularExpressionVariable) val_peek(2));
  }
  yyval = varsList;
  }
break;
case 8:
//#line 175 "sintactico.y"
{System.out.println("Reducing structure");
  yyval = new InstructionDefinition( lexico.getColumn(), lexico.getLine(), new TypeSpecialStruct (lexico.getColumn(), lexico.getLine(), (List<InstructionDefinition>)val_peek(3)), (RegularExpressionVariable)val_peek(1));
  }
break;
case 9:
//#line 178 "sintactico.y"
{System.out.println("Reducing one-Dimension array");
  yyval = new InstructionDefinition (lexico.getColumn(), lexico.getLine(),new TypeSpecialArray (lexico.getColumn(), lexico.getLine(), (TypeNormal) val_peek(5), (int) val_peek(3)), new RegularExpressionVariable (lexico.getColumn(), lexico.getLine(), (String)val_peek(1)));
  }
break;
case 10:
//#line 181 "sintactico.y"
{System.out.println("Reducing two-Dimension array");
  yyval = new InstructionDefinition (lexico.getColumn(), lexico.getLine(), new TypeSpecialMatrix (lexico.getColumn(), lexico.getLine(), (TypeNormal) val_peek(8), (int) val_peek(6), (int) val_peek(3)), new RegularExpressionVariable (lexico.getColumn(), lexico.getLine(), (String)val_peek(1)));
  }
break;
case 11:
//#line 186 "sintactico.y"
{System.out.println("Reducing INT type");
  yyval = new TypeNormal(lexico.getColumn(), lexico.getLine(), "int");
  }
break;
case 12:
//#line 189 "sintactico.y"
{System.out.println("Reducing DOUBLE type");
  yyval = new TypeNormal(lexico.getColumn(), lexico.getLine(), "double");
  }
break;
case 13:
//#line 192 "sintactico.y"
{System.out.println("Reducing CHAR type");
  yyval = new TypeNormal(lexico.getColumn(), lexico.getLine(), "char");
  }
break;
case 14:
//#line 195 "sintactico.y"
{System.out.println("Reducing STRING type");
  yyval = new TypeNormal(lexico.getColumn(), lexico.getLine(), "string");
  }
break;
case 15:
//#line 201 "sintactico.y"
{yyval = new ArrayList<Function>();}
break;
case 16:
//#line 202 "sintactico.y"
{System.out.println("Reducing multiple functions");
  List<Function> functions = (List<Function>)val_peek(0);
  if (val_peek(1) instanceof List){
    functions.addAll ((List<Function>)val_peek(1));
  }else{
    functions.add((Function)val_peek(1));
  }
  yyval = functions;
  }
break;
case 17:
//#line 213 "sintactico.y"
{System.out.println("Reducing function");
  yyval = new Function (lexico.getColumn(), lexico.getLine(), new InstructionDefinition (lexico.getColumn(), lexico.getLine(), (TypeNormal)val_peek(7), new RegularExpressionVariable(lexico.getColumn(), lexico.getLine(), (String)val_peek(6))), (List<InstructionDefinition>) val_peek(4), (List<Instruction>)val_peek(1));
  }
break;
case 18:
//#line 224 "sintactico.y"
{System.out.println("Reducing single instruction ");
  List<Instruction> instructions = new ArrayList<Instruction>();
  if (val_peek(0) instanceof List)
  instructions.addAll((List<Instruction>)val_peek(0));
  else
  instructions.add((Instruction)val_peek(0));
  yyval = instructions;
  }
break;
case 19:
//#line 232 "sintactico.y"
{System.out.println("Reducing multiple instructions ");
  List<Instruction> instructions = (List<Instruction>)val_peek(1);
  if (val_peek(0) instanceof List){
    instructions.addAll((List<Instruction>)val_peek(0));
  }
  else{
    instructions.add ((Instruction)val_peek(0)); 
  }
  yyval = instructions;
  }
break;
case 20:
//#line 245 "sintactico.y"
{System.out.println("Reducing local definitions ");
  }
break;
case 21:
//#line 247 "sintactico.y"
{System.out.println("Reducing INPUT ");
  yyval = new InstructionInput (lexico.getColumn(), lexico.getLine(), (Expression) val_peek(1));
  }
break;
case 22:
//#line 250 "sintactico.y"
{System.out.println("Reducing INPUT ");
  yyval = new InstructionPrint (lexico.getColumn(), lexico.getLine(), (Expression) val_peek(1));
  }
break;
case 23:
//#line 253 "sintactico.y"
{System.out.println("Reducing Equality");
  yyval = new InstructionAsignation (lexico.getColumn(), lexico.getLine(), (Expression)val_peek(3), (Expression)val_peek(1));

  
  }
break;
case 24:
//#line 258 "sintactico.y"
{System.out.println("Reducing function call");
  yyval = new InstructionFunctionCall(lexico.getColumn(), lexico.getLine(), new RegularExpressionVariable (lexico.getColumn(), lexico.getLine(), (String)val_peek(4)), (List<CallParameter>)val_peek(2));
  }
break;
case 25:
//#line 261 "sintactico.y"
{System.out.println("Reducing WHILE");
  yyval = new InstructionWhile(lexico.getColumn(), lexico.getLine(), (BinaryExpression) val_peek(1), (List<Instruction>)val_peek(0));
  }
break;
case 26:
//#line 264 "sintactico.y"
{System.out.println("Reducing IF");
  
    yyval = new InstructionIf(lexico.getColumn(), lexico.getLine(), (BinaryExpression)val_peek(1), (List<Instruction>)val_peek(0), null);
  
  }
break;
case 27:
//#line 269 "sintactico.y"
{System.out.println("Reducing IF/ELSE");
  yyval = new InstructionIf(lexico.getColumn(), lexico.getLine(), (BinaryExpression)val_peek(3), (List<Instruction>)val_peek(2), (List<Instruction>)val_peek(0));  
  }
break;
case 28:
//#line 273 "sintactico.y"
{System.out.println("Reducing RETURN ");
  yyval = new InstructionReturn(lexico.getColumn(), lexico.getLine(), (Expression)val_peek(1));
  }
break;
case 29:
//#line 279 "sintactico.y"
{System.out.println("Reducing multiple Instructions ");
  yyval = (List<Instruction>) val_peek(1);
  }
break;
case 30:
//#line 282 "sintactico.y"
{System.out.println("Reducing no_instructions ");}
break;
case 31:
//#line 283 "sintactico.y"
{System.out.println("Reducing single Instructions ");

  List<Instruction> inst = new ArrayList<Instruction>();
  inst.add((Instruction)val_peek(0));
  yyval = inst;
  }
break;
case 32:
//#line 291 "sintactico.y"
{
  yyval = new ArrayList<InstructionDefinition>();
  }
break;
case 33:
//#line 294 "sintactico.y"
{System.out.println("Reducing single parameter");
  List<InstructionDefinition> parameters = new ArrayList<InstructionDefinition>();
  parameters.add((InstructionDefinition)val_peek(0));
  
  yyval = parameters;
  }
break;
case 34:
//#line 300 "sintactico.y"
{System.out.println("Reducing multiple parameters");
  List<InstructionDefinition> parameters = (List<InstructionDefinition>) val_peek(2);
  if (val_peek(0) instanceof List){
    parameters.addAll((List<InstructionDefinition>)val_peek(0));
    }
  else{
    parameters.add((InstructionDefinition)val_peek(0));
    }
  yyval = parameters;
  }
break;
case 35:
//#line 312 "sintactico.y"
{System.out.println("Reducing parameterFunction ");
  yyval = new InstructionDefinition (lexico.getColumn(), lexico.getLine(), (TypeNormal)val_peek(1), new RegularExpressionVariable (lexico.getColumn(), lexico.getLine(), (String)val_peek(0)) );
  }
break;
case 36:
//#line 317 "sintactico.y"
{yyval = new ArrayList<RegularExpressionVariable>();}
break;
case 37:
//#line 318 "sintactico.y"
{System.out.println("Reducing multuple calling-function parameters ");
  List<RegularExpressionVariable> expressions = (List<RegularExpressionVariable>) val_peek(1);
  if (val_peek(0) instanceof List)
    expressions.addAll((List<RegularExpressionVariable>) val_peek(0));
  else
    expressions.add((RegularExpressionVariable) val_peek(0));
  yyval = expressions;
  }
break;
case 38:
//#line 328 "sintactico.y"
{System.out.println("Reducing ExpCompare ");
  yyval = (BinaryExpression) val_peek(1);
  }
break;
case 39:
//#line 331 "sintactico.y"
{System.out.println("Reducing ExpCompare ");
  yyval = (BinaryExpression) val_peek(1);
  }
break;
case 40:
//#line 338 "sintactico.y"
{System.out.println("Reducing AND");
  yyval = new BinaryExpression (lexico.getColumn(), lexico.getLine(), (Expression)val_peek(2), (Expression)val_peek(0), "&&");
  }
break;
case 41:
//#line 341 "sintactico.y"
{System.out.println("Reducing OR");
  yyval = new BinaryExpression (lexico.getColumn(), lexico.getLine(), (Expression)val_peek(2), (Expression)val_peek(0), "||");
  }
break;
case 42:
//#line 344 "sintactico.y"
{System.out.println("Reducing not ");
  yyval = new BinaryExpression (lexico.getColumn(), lexico.getLine(), (Expression)val_peek(0), null, "!");
  }
break;
case 43:
//#line 348 "sintactico.y"
{System.out.println("Reducing AND");
  yyval = new BinaryExpression (lexico.getColumn(), lexico.getLine(), (Expression)val_peek(2), (Expression)val_peek(0), "&&");
  }
break;
case 44:
//#line 351 "sintactico.y"
{System.out.println("Reducing OR");
  yyval = new BinaryExpression (lexico.getColumn(), lexico.getLine(), (Expression)val_peek(2), (Expression)val_peek(0), "||");
  }
break;
case 45:
//#line 354 "sintactico.y"
{System.out.println("Reducing not ");
  yyval = new BinaryExpression (lexico.getColumn(), lexico.getLine(), (Expression)val_peek(0), null, "!");
  }
break;
case 46:
//#line 357 "sintactico.y"
{System.out.println("Reducing not ");
  yyval = new BinaryExpression (lexico.getColumn(), lexico.getLine(), (Expression)val_peek(0), null, "var");
  }
break;
case 47:
//#line 362 "sintactico.y"
{System.out.println("Reducing EQUAL");
  yyval = new BinaryExpression (lexico.getColumn(), lexico.getLine(), (Expression)val_peek(2), (Expression)val_peek(0), "==");
  }
break;
case 48:
//#line 365 "sintactico.y"
{System.out.println("Reducing NOTEQUAL");
  yyval = new BinaryExpression (lexico.getColumn(), lexico.getLine(), (Expression)val_peek(2), (Expression)val_peek(0), "!=");
  }
break;
case 49:
//#line 368 "sintactico.y"
{System.out.println("Reducing LET");
  yyval = new BinaryExpression (lexico.getColumn(), lexico.getLine(), (Expression)val_peek(2), (Expression)val_peek(0), "<=");
  }
break;
case 50:
//#line 371 "sintactico.y"
{System.out.println("Reducing GET");
  yyval = new BinaryExpression (lexico.getColumn(), lexico.getLine(), (Expression)val_peek(2), (Expression)val_peek(0), ">=");
  }
break;
case 51:
//#line 374 "sintactico.y"
{System.out.println("Reducing lesser than");
  yyval = new BinaryExpression (lexico.getColumn(), lexico.getLine(), (Expression)val_peek(2), (Expression)val_peek(0), "<");
  }
break;
case 52:
//#line 377 "sintactico.y"
{System.out.println("Reducing greater than ");
  yyval = new BinaryExpression (lexico.getColumn(), lexico.getLine(), (Expression)val_peek(2), (Expression)val_peek(0), ">");
  }
break;
case 53:
//#line 383 "sintactico.y"
{System.out.println("Reducing sum");
  yyval = new ArithmeticExpression (lexico.getColumn(), lexico.getLine(), (Expression)val_peek(2), (Expression)val_peek(0), '+');
  }
break;
case 54:
//#line 386 "sintactico.y"
{System.out.println("Reducing substraction");
  yyval = new ArithmeticExpression (lexico.getColumn(), lexico.getLine(), (Expression)val_peek(2), (Expression)val_peek(0), '-');}
break;
case 55:
//#line 388 "sintactico.y"
{System.out.println("Reducing muliplication");
  yyval = new ArithmeticExpression (lexico.getColumn(), lexico.getLine(), (Expression)val_peek(2), (Expression)val_peek(0), '*');
  }
break;
case 56:
//#line 391 "sintactico.y"
{System.out.println("Reducing division");
  yyval = new ArithmeticExpression (lexico.getColumn(), lexico.getLine(), (Expression)val_peek(2), (Expression)val_peek(0), '/');}
break;
case 57:
//#line 393 "sintactico.y"
{System.out.println("Reducing module");
  yyval = new ArithmeticExpression (lexico.getColumn(), lexico.getLine(), (Expression)val_peek(2), (Expression)val_peek(0), '%');
  }
break;
case 58:
//#line 396 "sintactico.y"
{System.out.println("Reducing exponetial");
  yyval = new ArithmeticExpression (lexico.getColumn(), lexico.getLine(), (Expression)val_peek(2), (Expression)val_peek(0), '^');
  }
break;
case 59:
//#line 399 "sintactico.y"
{System.out.println("Reducing (exp)");
  yyval = new CastExpression (lexico.getColumn(), lexico.getLine(), (TypeNormal)val_peek(2), (RegularExpression)val_peek(0));
  }
break;
case 60:
//#line 402 "sintactico.y"
{System.out.println("Reducing function call exp");
  yyval = new RegularExpressionFunctionRef (lexico.getColumn(), lexico.getLine(), new RegularExpressionVariable (lexico.getColumn(), lexico.getLine(), (String)val_peek(3)) , (List<Expression>)val_peek(1));
  }
break;
case 61:
//#line 405 "sintactico.y"
{System.out.println("Reducing INTEGER value");
  yyval = new RegularExpressionInt(lexico.getColumn(), lexico.getLine(),(int) val_peek(0));
  System.out.println("CREATING INTEGER EXP");
  }
break;
case 62:
//#line 409 "sintactico.y"
{System.out.println("Reducing REAL value");
  yyval = new RegularExpressionReal(lexico.getColumn(), lexico.getLine(),(double) val_peek(0));
  }
break;
case 63:
//#line 412 "sintactico.y"
{System.out.println("Reducing LETTER value");
  yyval = new RegularExpressionLetter(lexico.getColumn(), lexico.getLine(),(String) val_peek(0));
  }
break;
case 64:
//#line 415 "sintactico.y"
{System.out.println("Reducing STRINGVALUE value");
  yyval = new RegularExpressionLetter(lexico.getColumn(), lexico.getLine(),(String) val_peek(0));
  }
break;
case 65:
//#line 418 "sintactico.y"
{System.out.println("Reducing struct variable ");
  yyval = new RegularExpressionStructRef (lexico.getColumn(), lexico.getLine(),(Expression)val_peek(2), new RegularExpressionVariable (lexico.getColumn(), lexico.getLine(), (String)val_peek(0)));
  }
break;
case 66:
//#line 421 "sintactico.y"
{System.out.println("Reducing ID exp ");
  yyval = new RegularExpressionVariable (lexico.getColumn(), lexico.getLine(), (String)val_peek(0));
  }
break;
case 67:
//#line 425 "sintactico.y"
{System.out.println("Reducing one-dimension array ");
  yyval = new RegularExpressionArrayRef(lexico.getColumn(), lexico.getLine(),(RegularExpressionVariable)val_peek(3) , (RegularExpression) val_peek(1));
  }
break;
case 68:
//#line 428 "sintactico.y"
{System.out.println("Reducing two-dimension array ");
  
  yyval = new RegularExpressionMatrixRef(lexico.getColumn(), lexico.getLine(),(RegularExpressionVariable)val_peek(6) , (RegularExpression) val_peek(4), (RegularExpression) val_peek(1));
  }
break;
//#line 1163 "Sintactico.java"
//########## END OF USER-SUPPLIED ACTIONS ##########
    }//switch
    //#### Now let's reduce... ####
    if (yydebug) debug("reduce");
    state_drop(yym);             //we just reduced yylen states
    yystate = state_peek(0);     //get new state
    val_drop(yym);               //corresponding value drop
    yym = yylhs[yyn];            //select next TERMINAL(on lhs)
    if (yystate == 0 && yym == 0)//done? 'rest' state and at first TERMINAL
      {
      debug("After reduction, shifting from state 0 to state "+YYFINAL+"");
      yystate = YYFINAL;         //explicitly say we're done
      state_push(YYFINAL);       //and save it
      val_push(yyval);           //also save the semantic value of parsing
      if (yychar < 0)            //we want another character?
        {
        yychar = yylex();        //get next character
        if (yychar<0) yychar=0;  //clean, if necessary
        if (yydebug)
          yylexdebug(yystate,yychar);
        }
      if (yychar == 0)          //Good exit (if lex returns 0 ;-)
         break;                 //quit the loop--all DONE
      }//if yystate
    else                        //else not done yet
      {                         //get next state and push, for next yydefred[]
      yyn = yygindex[yym];      //find out where to go
      if ((yyn != 0) && (yyn += yystate) >= 0 &&
            yyn <= YYTABLESIZE && yycheck[yyn] == yystate)
        yystate = yytable[yyn]; //get new state
      else
        yystate = yydgoto[yym]; //else go to new defred
      debug("after reduction, shifting from state "+state_peek(0)+" to state "+yystate+"");
      state_push(yystate);     //going again, so push state & val...
      val_push(yyval);         //for next action
      }
    }//main loop
  return 0;//yyaccept!!
}
//## end of method parse() ######################################



//## run() --- for Thread #######################################
/**
 * A default run method, used for operating this parser
 * object in the background.  It is intended for extending Thread
 * or implementing Runnable.  Turn off with -Jnorun .
 */
public void run()
{
  yyparse();
}
//## end of method run() ########################################



//## Constructors ###############################################
/**
 * Default constructor.  Turn off with -Jnoconstruct .

 */
public Sintactico()
{
  //nothing to do
}


/**
 * Create a parser, setting the debug to true or false.
 * @param debugMe true for debugging, false for no debug.
 */
public Sintactico(boolean debugMe)
{
  yydebug=debugMe;
}
//###############################################################



}
//################### END OF CLASS ##############################
