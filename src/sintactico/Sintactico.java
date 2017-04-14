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
public final static short ERROR=258;
public final static short EQUAL=259;
public final static short NOTEQUAL=260;
public final static short LET=261;
public final static short GET=262;
public final static short AND=263;
public final static short OR=264;
public final static short STRINGVALUE=265;
public final static short INTEGER=266;
public final static short REAL=267;
public final static short BOOLEAN=268;
public final static short TEXT=269;
public final static short LETTER=270;
public final static short STRING=271;
public final static short INT=272;
public final static short DOUBLE=273;
public final static short CHAR=274;
public final static short BOOL=275;
public final static short VOID=276;
public final static short STRUCT=277;
public final static short MAIN=278;
public final static short IF=279;
public final static short ELSE=280;
public final static short WHILE=281;
public final static short ID=282;
public final static short INPUT=283;
public final static short PRINT=284;
public final static short RETURN=285;
public final static short NEG=286;
public final static short IFX=287;
public final static short var=288;
public final static short cast=289;
public final static short matrix=290;
public final static short expr=291;
public final static short YYERRCODE=256;
final static short yylhs[] = {                           -1,
    0,    1,    1,    4,    4,    6,    6,    7,    7,    7,
    5,    5,    5,    5,    2,    2,    9,    3,    3,   11,
   11,   11,   11,   11,   11,   11,   11,   11,   14,   14,
   14,   10,   10,   10,   15,   12,   12,   13,   13,   16,
   16,   18,   18,   18,   18,   18,   18,   18,   17,   17,
   17,   17,   17,   17,    8,    8,    8,    8,    8,    8,
    8,    8,    8,    8,    8,    8,    8,    8,    8,    8,
};
final static short yylen[] = {                            2,
    9,    0,    2,    3,    1,    1,    3,    6,    6,    9,
    1,    1,    1,    1,    0,    2,    8,    1,    2,    1,
    3,    3,    4,    5,    3,    3,    5,    3,    3,    2,
    1,    0,    1,    3,    2,    0,    2,    3,    3,    1,
    3,    3,    3,    2,    3,    3,    2,    1,    3,    3,
    3,    3,    3,    3,    3,    3,    3,    3,    3,    3,
    4,    4,    1,    1,    1,    1,    3,    1,    4,    7,
};
final static short yydefred[] = {                         2,
    0,    0,   14,   11,   12,   13,    0,    0,    3,    0,
    5,    0,    2,    0,    0,    0,    0,   16,    0,    0,
    0,    0,    0,    4,    0,    0,    0,    0,    0,    0,
    0,   33,    0,    7,   66,   63,   64,   65,    0,    0,
    0,    6,    0,   35,    0,    0,    0,    0,   36,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    8,    0,
    0,   34,    9,    0,    0,    0,    0,    0,    0,    0,
    0,    0,   67,    0,    0,    0,    0,    0,    0,    0,
    0,   20,    0,   18,    0,    0,   62,    0,    0,    0,
    0,    0,    0,    0,   36,    0,    0,    0,    1,   19,
    0,   17,    0,    0,    0,    0,    0,    0,    0,    0,
   31,    0,   25,    0,   21,   22,   28,    0,   10,    0,
    0,    0,   44,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   38,   39,   30,    0,    0,    0,   23,
   70,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   42,   43,   29,   27,   24,
};
final static short yydgoto[] = {                          1,
    2,    8,   81,   82,   28,   17,   11,   83,   12,   31,
   84,   65,   93,  112,   32,   89,  108,  109,
};
final static short yysindex[] = {                         0,
    0, -132,    0,    0,    0,    0, -115, -257,    0,  -89,
    0,  -72,    0, -242,    5, -212,  -15,    0, -199, -107,
   44,  -72,   -2,    0, -175,    5,  151,  -87,   68, -172,
   -9,    0,  -85,    0,    0,    0,    0,    0,   71,  -72,
  645,    0,   -8,    0,   -6,  -72,   54, -152,    0,   77,
  151,  151,  151,  151,  151,  151, -163,  151,    0,  318,
  318,    0,    0,   33,  103,  151,  300,  300,  -30,  -30,
  -30,  -30,    0,  664,   96,   96,   98,  151,  151,  151,
  158,    0,  671,    0,  179, -136,    0,  869,  104,   56,
   64,  -33,  211,  211,    0,  724,  754,  761,    0,    0,
  151,    0,  112,  151,  151,  151,  603,  -40,  121,  234,
    0, -108,    0,  349,    0,    0,    0,  831,    0,  869,
  838,  -32,    0,  151,  151,  151,  151,  151,  151,  151,
  151,  151,  151,    0,    0,    0,  263,  211,  114,    0,
    0,  869,  869,  869,  869,  869,  869,  869,  869,  -32,
    0,    0,    0,    0,    0,
};
final static short yyrindex[] = {                         0,
    0,  -97,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  -97,    0,    0,   26,    0,    0,    0,    0,    0,
    0,   49,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  -20,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  564,  577,   61,   90,
  116,  145,    0,    0,    0,    0,  849,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   -7,  362,    6,
   35,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  139,    0,    0,    0,
    0,  289,    0,    0,    0,    0,    0,    0,    0,   48,
    0,  140,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  856,    0,
    0,  -38,  -10,   14,   16,  155,  162,   22,   28,    0,
    0,    0,    0,    0,    0,
};
final static short yygindex[] = {                         0,
  195,  198,  -52,   18,  172,    0,    0,  620,    0,    0,
   31,  118,  135,  -82,  168,    0,  -46,    0,
};
final static int YYTABLESIZE=963;
final static short yytable[] = {                        106,
  134,   16,   49,   16,   55,   48,   40,   13,   85,   53,
   52,  113,   51,   57,   54,   57,   68,   27,   14,    9,
   68,   68,   68,   68,   68,   68,   68,  130,   25,  131,
   50,   45,   40,   40,   46,   21,   40,    9,   68,   68,
   68,   68,   61,   24,   22,   61,   61,   61,   61,   61,
   61,   61,   61,   23,   51,  154,   52,  137,   58,  123,
   58,   56,   53,   56,   61,   61,   61,   61,   54,    6,
   68,   69,   68,   68,   69,   69,   69,   69,   69,   69,
   69,   69,   26,   29,    6,  151,  152,   41,   41,   32,
   33,   41,   32,   69,   69,   69,   69,   57,   61,   61,
   57,   57,   57,   57,   57,   57,   34,   57,   43,   44,
   49,  100,   63,   64,   60,  100,   61,   66,   73,   57,
   57,   57,   57,  111,  111,   86,   58,   69,   69,   58,
   58,   58,   58,   58,   58,   92,   58,   95,    3,    4,
    5,    6,   40,   87,    7,  103,   58,  104,   58,   58,
   58,   58,   59,   57,  105,   59,   59,   59,   59,   59,
   59,  135,   59,    3,    4,    5,    6,  100,  111,    7,
  119,  138,  155,   10,   59,   59,   59,   59,   15,   48,
   47,   60,   58,   19,   60,   60,   60,   60,   60,   60,
   40,   60,   15,   30,   42,   45,   47,   40,    3,    4,
    5,    6,   46,   60,   60,   60,   60,   20,   59,   18,
   94,   50,  114,   62,    0,    0,    0,   30,   40,    0,
    0,    0,  132,  133,   49,   49,  124,  125,  126,  127,
    0,   35,   36,   37,    0,    0,   38,   60,   68,   68,
   68,   68,   68,   68,   68,   68,   68,    0,   39,   68,
   40,    0,   50,   50,    0,    0,    0,   40,   40,   40,
    0,   68,   40,    0,   61,   61,   61,   61,   61,   61,
   61,   61,   61,   40,   40,   61,   51,   51,   52,   52,
    0,    0,   99,    0,   53,   53,    0,   61,    0,    0,
   54,   54,    0,   69,   69,   69,   69,   69,   69,   69,
   69,   69,   40,  102,   69,    0,    0,    0,    0,    0,
    0,    0,   41,   41,   41,    0,   69,   41,    0,   57,
   57,   57,   57,   57,   57,   57,   57,   57,   26,   41,
   57,    0,    0,  110,    0,    0,   55,    0,    0,    0,
    0,   53,   57,    0,    0,   57,   54,    0,   58,   58,
   58,   58,   58,   58,   58,   58,   58,   40,  136,   58,
    0,    0,    0,    0,    0,    0,    0,   35,   36,   37,
    0,   58,   38,    0,   59,   59,   59,   59,   59,   59,
   59,   59,   59,    0,   39,   59,    0,  153,   40,  139,
   58,    0,    0,   56,    0,    0,    0,   59,    0,    0,
    0,   37,   37,   60,   60,   60,   60,   60,   60,   60,
   60,   60,    0,   26,   60,   35,   36,   37,    0,    0,
   38,    0,   35,   36,   37,    0,   60,   38,    3,    4,
    5,    6,   39,    0,    7,    0,   75,    0,   76,   77,
   78,   79,   80,   35,   36,   37,    0,    0,   38,    3,
    4,    5,    6,    0,    0,    7,    0,   75,    0,   76,
   77,   78,   79,   80,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,   35,   36,   37,    0,    0,
   38,    3,    4,    5,    6,    0,    0,    7,    0,   75,
    0,   76,   77,   78,   79,   80,    0,    0,   35,   36,
   37,    0,    0,   38,    3,    4,    5,    6,    0,    0,
    7,    0,   75,    0,   76,   77,   78,   79,   80,    0,
    0,    0,    0,    0,    0,    0,    0,   35,   36,   37,
    0,    0,   38,    3,    4,    5,    6,    0,    0,    7,
    0,   75,    0,   76,   77,   78,   79,   80,    0,    0,
    0,    0,    0,   26,   26,   26,    0,    0,   26,   26,
   26,   26,   26,    0,    0,   26,    0,   26,    0,   26,
   26,   26,   26,   26,    0,    0,    0,    0,    0,    0,
    0,    0,   35,   36,   37,    0,    0,   38,    3,    4,
    5,    6,    0,    0,    7,    0,   75,    0,   76,   77,
   78,   79,   80,   56,   56,    0,   56,   56,   56,    0,
    0,    0,    0,   35,   36,   37,   55,   55,   38,   55,
   55,   55,   56,   56,   56,   56,   37,   37,   37,    0,
   39,   37,    0,    0,    0,   55,   55,   55,   55,   55,
    0,    0,    0,   37,   53,   52,   41,   51,   57,   54,
    0,    0,    0,    0,    0,    0,   56,    0,    0,    0,
    0,    0,  130,    0,  131,    0,    0,    0,    0,   55,
   67,   68,   69,   70,   71,   72,    0,   74,    0,    0,
    0,   55,    0,    0,   88,   90,   53,   52,    0,   51,
   57,   54,    0,   58,    0,    0,   56,   96,   97,   98,
   55,    0,    0,   59,    0,   53,   52,   55,   51,   57,
   54,  107,   53,   52,    0,   51,   57,   54,    0,    0,
  118,    0,    0,  120,  121,  122,    0,    0,    0,    0,
    0,  101,    0,   88,    0,   58,    0,    0,   56,    0,
    0,    0,    0,  142,  143,  144,  145,  146,  147,  148,
  149,  150,  150,    0,   58,    0,   91,   56,    0,    0,
   55,   58,    0,    0,   56,   53,   52,    0,   51,   57,
   54,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  115,    0,    0,    0,    0,    0,    0,    0,
   55,    0,    0,    0,    0,   53,   52,   55,   51,   57,
   54,    0,   53,   52,    0,   51,   57,   54,    0,    0,
    0,    0,  116,    0,   58,    0,    0,   56,    0,  117,
    0,    0,   56,   56,   56,   56,   56,   56,   56,   56,
   56,    0,    0,   56,    0,   55,   55,   55,   55,   55,
   55,   55,   55,   55,   58,   56,   55,   56,    0,    0,
    0,   58,    0,    0,   56,    0,    0,    0,   55,    0,
    0,  124,  125,  126,  127,  128,  129,   55,    0,    0,
    0,    0,   53,   52,   55,   51,   57,   54,    0,   53,
   52,    0,   51,   57,   54,   68,    0,    0,    0,  140,
   68,   68,   62,   68,   68,   68,    0,   62,   62,    0,
   62,   62,   62,    0,    0,   55,    0,    0,    0,   68,
   53,   52,    0,   51,   57,   54,   62,    0,    0,    0,
    0,   58,    0,    0,   56,    0,    0,    0,   58,    0,
  141,   56,    0,    0,    0,    0,    0,    0,    0,   68,
    0,    0,   68,    0,    0,    0,   62,    0,    0,   62,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   58,
    0,    0,   56,
};
final static short yycheck[] = {                         33,
   41,   91,   41,   91,   37,   91,   40,  123,   61,   42,
   43,   94,   45,   46,   47,   46,   37,  125,  276,    2,
   41,   42,   43,   44,   45,   46,   47,   60,   44,   62,
   41,   41,   40,   41,   44,  278,   44,   20,   59,   60,
   61,   62,   37,   59,   40,   40,   41,   42,   43,   44,
   45,   46,   47,  266,   41,  138,   41,  110,   91,  106,
   91,   94,   41,   94,   59,   60,   61,   62,   41,   44,
   91,   37,   93,   94,   40,   41,   42,   43,   44,   45,
   46,   47,  282,   40,   59,  132,  133,   40,   41,   41,
   93,   44,   44,   59,   60,   61,   62,   37,   93,   94,
   40,   41,   42,   43,   44,   45,  282,   47,   41,  282,
   40,   81,   59,  266,  123,   85,  123,   41,  282,   59,
   60,   61,   62,   93,   94,   93,   37,   93,   94,   40,
   41,   42,   43,   44,   45,   40,   47,   40,  271,  272,
  273,  274,   40,   41,  277,  282,   91,   44,   59,   60,
   61,   62,   37,   93,   91,   40,   41,   42,   43,   44,
   45,   41,   47,  271,  272,  273,  274,  137,  138,  277,
   59,  280,   59,    2,   59,   60,   61,   62,  276,   41,
   41,   37,   93,   12,   40,   41,   42,   43,   44,   45,
   40,   47,  282,   22,  282,   41,  282,   40,  271,  272,
  273,  274,   41,   59,   60,   61,   62,   13,   93,   12,
   76,   40,   95,   46,   -1,   -1,   -1,   46,   40,   -1,
   -1,   -1,  263,  264,  263,  264,  259,  260,  261,  262,
   -1,  265,  266,  267,   -1,   -1,  270,   93,  259,  260,
  261,  262,  263,  264,  265,  266,  267,   -1,  282,  270,
   40,   -1,  263,  264,   -1,   -1,   -1,  265,  266,  267,
   -1,  282,  270,   -1,  259,  260,  261,  262,  263,  264,
  265,  266,  267,   40,  282,  270,  263,  264,  263,  264,
   -1,   -1,  125,   -1,  263,  264,   -1,  282,   -1,   -1,
  263,  264,   -1,  259,  260,  261,  262,  263,  264,  265,
  266,  267,   40,  125,  270,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,  265,  266,  267,   -1,  282,  270,   -1,  259,
  260,  261,  262,  263,  264,  265,  266,  267,   40,  282,
  270,   -1,   -1,  123,   -1,   -1,   37,   -1,   -1,   -1,
   -1,   42,  282,   -1,   -1,   46,   47,   -1,  259,  260,
  261,  262,  263,  264,  265,  266,  267,   40,  125,  270,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,  265,  266,  267,
   -1,  282,  270,   -1,  259,  260,  261,  262,  263,  264,
  265,  266,  267,   -1,  282,  270,   -1,  125,   40,   41,
   91,   -1,   -1,   94,   -1,   -1,   -1,  282,   -1,   -1,
   -1,   40,   41,  259,  260,  261,  262,  263,  264,  265,
  266,  267,   -1,  125,  270,  265,  266,  267,   -1,   -1,
  270,   -1,  265,  266,  267,   -1,  282,  270,  271,  272,
  273,  274,  282,   -1,  277,   -1,  279,   -1,  281,  282,
  283,  284,  285,  265,  266,  267,   -1,   -1,  270,  271,
  272,  273,  274,   -1,   -1,  277,   -1,  279,   -1,  281,
  282,  283,  284,  285,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,  265,  266,  267,   -1,   -1,
  270,  271,  272,  273,  274,   -1,   -1,  277,   -1,  279,
   -1,  281,  282,  283,  284,  285,   -1,   -1,  265,  266,
  267,   -1,   -1,  270,  271,  272,  273,  274,   -1,   -1,
  277,   -1,  279,   -1,  281,  282,  283,  284,  285,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,  265,  266,  267,
   -1,   -1,  270,  271,  272,  273,  274,   -1,   -1,  277,
   -1,  279,   -1,  281,  282,  283,  284,  285,   -1,   -1,
   -1,   -1,   -1,  265,  266,  267,   -1,   -1,  270,  271,
  272,  273,  274,   -1,   -1,  277,   -1,  279,   -1,  281,
  282,  283,  284,  285,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,  265,  266,  267,   -1,   -1,  270,  271,  272,
  273,  274,   -1,   -1,  277,   -1,  279,   -1,  281,  282,
  283,  284,  285,   40,   41,   -1,   43,   44,   45,   -1,
   -1,   -1,   -1,  265,  266,  267,   40,   41,  270,   43,
   44,   45,   59,   60,   61,   62,  265,  266,  267,   -1,
  282,  270,   -1,   -1,   -1,   59,   60,   61,   62,   37,
   -1,   -1,   -1,  282,   42,   43,   27,   45,   46,   47,
   -1,   -1,   -1,   -1,   -1,   -1,   93,   -1,   -1,   -1,
   -1,   -1,   60,   -1,   62,   -1,   -1,   -1,   -1,   93,
   51,   52,   53,   54,   55,   56,   -1,   58,   -1,   -1,
   -1,   37,   -1,   -1,   65,   66,   42,   43,   -1,   45,
   46,   47,   -1,   91,   -1,   -1,   94,   78,   79,   80,
   37,   -1,   -1,   59,   -1,   42,   43,   37,   45,   46,
   47,   92,   42,   43,   -1,   45,   46,   47,   -1,   -1,
  101,   -1,   -1,  104,  105,  106,   -1,   -1,   -1,   -1,
   -1,   61,   -1,  114,   -1,   91,   -1,   -1,   94,   -1,
   -1,   -1,   -1,  124,  125,  126,  127,  128,  129,  130,
  131,  132,  133,   -1,   91,   -1,   93,   94,   -1,   -1,
   37,   91,   -1,   -1,   94,   42,   43,   -1,   45,   46,
   47,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   59,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   37,   -1,   -1,   -1,   -1,   42,   43,   37,   45,   46,
   47,   -1,   42,   43,   -1,   45,   46,   47,   -1,   -1,
   -1,   -1,   59,   -1,   91,   -1,   -1,   94,   -1,   59,
   -1,   -1,  259,  260,  261,  262,  263,  264,  265,  266,
  267,   -1,   -1,  270,   -1,  259,  260,  261,  262,  263,
  264,  265,  266,  267,   91,  282,  270,   94,   -1,   -1,
   -1,   91,   -1,   -1,   94,   -1,   -1,   -1,  282,   -1,
   -1,  259,  260,  261,  262,  263,  264,   37,   -1,   -1,
   -1,   -1,   42,   43,   37,   45,   46,   47,   -1,   42,
   43,   -1,   45,   46,   47,   37,   -1,   -1,   -1,   59,
   42,   43,   37,   45,   46,   47,   -1,   42,   43,   -1,
   45,   46,   47,   -1,   -1,   37,   -1,   -1,   -1,   61,
   42,   43,   -1,   45,   46,   47,   61,   -1,   -1,   -1,
   -1,   91,   -1,   -1,   94,   -1,   -1,   -1,   91,   -1,
   93,   94,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   91,
   -1,   -1,   94,   -1,   -1,   -1,   91,   -1,   -1,   94,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   91,
   -1,   -1,   94,
};
final static short YYFINAL=1;
final static short YYMAXTOKEN=291;
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
null,null,null,null,null,null,null,null,null,"NULLTEXT","ERROR","EQUAL",
"NOTEQUAL","LET","GET","AND","OR","STRINGVALUE","INTEGER","REAL","BOOLEAN",
"TEXT","LETTER","STRING","INT","DOUBLE","CHAR","BOOL","VOID","STRUCT","MAIN",
"IF","ELSE","WHILE","ID","INPUT","PRINT","RETURN","NEG","IFX","var","cast",
"matrix","expr",
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
"parameters : parameters exps",
"expCompare : '(' expComp ')'",
"expCompare : '(' expBin ')'",
"exps : exp",
"exps : exps ',' exp",
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

//#line 455 "sintactico.y"

// =================================================
// Interface  to the Lexical analyzer
// =================================================
private Lexico lexico;
public AST ast;



// =================================================
//  Invocation to the scanner
// =================================================
private int yylex () throws Exception 
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
    throw new Exception();
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
//#line 570 "Sintactico.java"
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
int yyparse() throws Exception
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
//#line 108 "sintactico.y"
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
//#line 121 "sintactico.y"
{yyval = new ArrayList<InstructionDefinition>();}
break;
case 3:
//#line 122 "sintactico.y"
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
//#line 132 "sintactico.y"
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
//#line 148 "sintactico.y"
{System.out.println("Reducing stecial Type");
  /*$$ = new InstructionDefinition(lexico.getColumn(), lexico.getLine(),(TypeSpecial)$1, null);*/
   
  }
break;
case 6:
//#line 156 "sintactico.y"
{System.out.println("Reducing ID");
  yyval = new RegularExpressionVariable (lexico.getColumn(), lexico.getLine(), (String)val_peek(0));
  }
break;
case 7:
//#line 159 "sintactico.y"
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
//#line 179 "sintactico.y"
{System.out.println("Reducing structure");
  yyval = new InstructionDefinition( lexico.getColumn(), lexico.getLine(), new TypeSpecialStruct (lexico.getColumn(), lexico.getLine(), (List<InstructionDefinition>)val_peek(3)), (RegularExpressionVariable)val_peek(1));
  }
break;
case 9:
//#line 182 "sintactico.y"
{System.out.println("Reducing one-Dimension array");
  yyval = new InstructionDefinition (lexico.getColumn(), lexico.getLine(),new TypeSpecialArray (lexico.getColumn(), lexico.getLine(), (TypeNormal) val_peek(5), (int) val_peek(3)), new RegularExpressionVariable (lexico.getColumn(), lexico.getLine(), (String)val_peek(1)));
  }
break;
case 10:
//#line 185 "sintactico.y"
{System.out.println("Reducing two-Dimension array");
  yyval = new InstructionDefinition (lexico.getColumn(), lexico.getLine(), new TypeSpecialMatrix (lexico.getColumn(), lexico.getLine(), (TypeNormal) val_peek(8), (int) val_peek(6), (int) val_peek(3)), new RegularExpressionVariable (lexico.getColumn(), lexico.getLine(), (String)val_peek(1)));
  }
break;
case 11:
//#line 190 "sintactico.y"
{System.out.println("Reducing INT type");
  yyval = new TypeNormal(lexico.getColumn(), lexico.getLine(), "int");
  }
break;
case 12:
//#line 193 "sintactico.y"
{System.out.println("Reducing DOUBLE type");
  yyval = new TypeNormal(lexico.getColumn(), lexico.getLine(), "double");
  }
break;
case 13:
//#line 196 "sintactico.y"
{System.out.println("Reducing CHAR type");
  yyval = new TypeNormal(lexico.getColumn(), lexico.getLine(), "char");
  }
break;
case 14:
//#line 199 "sintactico.y"
{System.out.println("Reducing STRING type");
  yyval = new TypeNormal(lexico.getColumn(), lexico.getLine(), "string");
  }
break;
case 15:
//#line 205 "sintactico.y"
{yyval = new ArrayList<Function>();}
break;
case 16:
//#line 206 "sintactico.y"
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
//#line 217 "sintactico.y"
{System.out.println("Reducing function");
  yyval = new Function (lexico.getColumn(), lexico.getLine(), new InstructionDefinition (lexico.getColumn(), lexico.getLine(), (TypeNormal)val_peek(7), new RegularExpressionVariable(lexico.getColumn(), lexico.getLine(), (String)val_peek(6))), (List<InstructionDefinition>) val_peek(4), (List<Instruction>)val_peek(1));
  }
break;
case 18:
//#line 228 "sintactico.y"
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
//#line 236 "sintactico.y"
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
//#line 249 "sintactico.y"
{System.out.println("Reducing local definitions ");
  }
break;
case 21:
//#line 251 "sintactico.y"
{System.out.println("Reducing INPUT ");
  yyval = new InstructionInput (lexico.getColumn(), lexico.getLine(), (Expression) val_peek(1));
  }
break;
case 22:
//#line 254 "sintactico.y"
{System.out.println("Reducing PRINT ");
  yyval = new InstructionPrint (lexico.getColumn(), lexico.getLine(), (Expression) val_peek(1));
  }
break;
case 23:
//#line 257 "sintactico.y"
{System.out.println("Reducing Equality");
  yyval = new InstructionAsignation (lexico.getColumn(), lexico.getLine(), (Expression)val_peek(3), (Expression)val_peek(1));

  
  }
break;
case 24:
//#line 262 "sintactico.y"
{System.out.println("Reducing function call");
  yyval = new InstructionFunctionCall(lexico.getColumn(), lexico.getLine(), new RegularExpressionVariable (lexico.getColumn(), lexico.getLine(), (String)val_peek(4)), (List<RegularExpression>)val_peek(2));
  }
break;
case 25:
//#line 265 "sintactico.y"
{System.out.println("Reducing WHILE");
  yyval = new InstructionWhile(lexico.getColumn(), lexico.getLine(), (BinaryExpression) val_peek(1), (List<Instruction>)val_peek(0));
  }
break;
case 26:
//#line 268 "sintactico.y"
{System.out.println("Reducing IF");
  
    yyval = new InstructionIf(lexico.getColumn(), lexico.getLine(), (BinaryExpression)val_peek(1), (List<Instruction>)val_peek(0), null);
  
  }
break;
case 27:
//#line 273 "sintactico.y"
{System.out.println("Reducing IF/ELSE");
  yyval = new InstructionIf(lexico.getColumn(), lexico.getLine(), (BinaryExpression)val_peek(3), (List<Instruction>)val_peek(2), (List<Instruction>)val_peek(0));  
  }
break;
case 28:
//#line 277 "sintactico.y"
{System.out.println("Reducing RETURN ");
  yyval = new InstructionReturn(lexico.getColumn(), lexico.getLine(), (Expression)val_peek(1));
  }
break;
case 29:
//#line 283 "sintactico.y"
{System.out.println("Reducing multiple Instructions ");
  yyval = (List<Instruction>) val_peek(1);
  }
break;
case 30:
//#line 286 "sintactico.y"
{System.out.println("Reducing no_instructions ");
  List<Instruction> inst = new ArrayList<Instruction>();
  yyval = inst;
  }
break;
case 31:
//#line 290 "sintactico.y"
{System.out.println("Reducing single Instructions ");

  List<Instruction> inst = new ArrayList<Instruction>();
  inst.add((Instruction)val_peek(0));
  yyval = inst;
  }
break;
case 32:
//#line 298 "sintactico.y"
{
  yyval = new ArrayList<InstructionDefinition>();
  }
break;
case 33:
//#line 301 "sintactico.y"
{System.out.println("Reducing single parameter");
  List<InstructionDefinition> parameters = new ArrayList<InstructionDefinition>();
  parameters.add((InstructionDefinition)val_peek(0));
  
  yyval = parameters;
  }
break;
case 34:
//#line 307 "sintactico.y"
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
//#line 319 "sintactico.y"
{System.out.println("Reducing parameterFunction ");
  yyval = new InstructionDefinition (lexico.getColumn(), lexico.getLine(), (TypeNormal)val_peek(1), new RegularExpressionVariable (lexico.getColumn(), lexico.getLine(), (String)val_peek(0)) );
  }
break;
case 36:
//#line 324 "sintactico.y"
{yyval = new ArrayList<RegularExpression>();}
break;
case 37:
//#line 325 "sintactico.y"
{System.out.println("Reducing multuple calling-function parameters ");
  List<RegularExpression> expressions = (List<RegularExpression>) val_peek(1);
  if (val_peek(0) instanceof List)
    expressions.addAll((List<RegularExpression>) val_peek(0));
  else
    expressions.add((RegularExpression) val_peek(0));
  yyval = expressions;
  }
break;
case 38:
//#line 335 "sintactico.y"
{System.out.println("Reducing ExpCompare ");
  yyval = (BinaryExpression) val_peek(1);
  }
break;
case 39:
//#line 338 "sintactico.y"
{System.out.println("Reducing ExpCompare ");
  yyval = (BinaryExpression) val_peek(1);
  }
break;
case 40:
//#line 344 "sintactico.y"
{
  yyval = (RegularExpression) val_peek(0);
  }
break;
case 41:
//#line 347 "sintactico.y"
{
  List<RegularExpression> list = new ArrayList<RegularExpression>();
  if(val_peek(0) instanceof List){
    list.addAll((List<RegularExpression>) val_peek(2));
  }else{
    list.add((RegularExpression) val_peek(0));
  }
  yyval = list;
  }
break;
case 42:
//#line 358 "sintactico.y"
{System.out.println("Reducing AND");
  yyval = new BinaryExpression (lexico.getColumn(), lexico.getLine(), (Expression)val_peek(2), (Expression)val_peek(0), "&&");
  }
break;
case 43:
//#line 361 "sintactico.y"
{System.out.println("Reducing OR");
  yyval = new BinaryExpression (lexico.getColumn(), lexico.getLine(), (Expression)val_peek(2), (Expression)val_peek(0), "||");
  }
break;
case 44:
//#line 364 "sintactico.y"
{System.out.println("Reducing not ");
  yyval = new BinaryExpression (lexico.getColumn(), lexico.getLine(), (Expression)val_peek(0), null, "!");
  }
break;
case 45:
//#line 368 "sintactico.y"
{System.out.println("Reducing AND");
  yyval = new BinaryExpression (lexico.getColumn(), lexico.getLine(), (Expression)val_peek(2), (Expression)val_peek(0), "&&");
  }
break;
case 46:
//#line 371 "sintactico.y"
{System.out.println("Reducing OR");
  yyval = new BinaryExpression (lexico.getColumn(), lexico.getLine(), (Expression)val_peek(2), (Expression)val_peek(0), "||");
  }
break;
case 47:
//#line 374 "sintactico.y"
{System.out.println("Reducing not ");
  yyval = new BinaryExpression (lexico.getColumn(), lexico.getLine(), (Expression)val_peek(0), null, "!");
  }
break;
case 48:
//#line 377 "sintactico.y"
{System.out.println("Reducing not ");
  yyval = new BinaryExpression (lexico.getColumn(), lexico.getLine(), (Expression)val_peek(0), null, "var");
  }
break;
case 49:
//#line 382 "sintactico.y"
{System.out.println("Reducing EQUAL");
  yyval = new BinaryExpression (lexico.getColumn(), lexico.getLine(), (Expression)val_peek(2), (Expression)val_peek(0), "==");
  }
break;
case 50:
//#line 385 "sintactico.y"
{System.out.println("Reducing NOTEQUAL");
  yyval = new BinaryExpression (lexico.getColumn(), lexico.getLine(), (Expression)val_peek(2), (Expression)val_peek(0), "!=");
  }
break;
case 51:
//#line 388 "sintactico.y"
{System.out.println("Reducing LET");
  yyval = new BinaryExpression (lexico.getColumn(), lexico.getLine(), (Expression)val_peek(2), (Expression)val_peek(0), "<=");
  }
break;
case 52:
//#line 391 "sintactico.y"
{System.out.println("Reducing GET");
  yyval = new BinaryExpression (lexico.getColumn(), lexico.getLine(), (Expression)val_peek(2), (Expression)val_peek(0), ">=");
  }
break;
case 53:
//#line 394 "sintactico.y"
{System.out.println("Reducing lesser than");
  yyval = new BinaryExpression (lexico.getColumn(), lexico.getLine(), (Expression)val_peek(2), (Expression)val_peek(0), "<");
  }
break;
case 54:
//#line 397 "sintactico.y"
{System.out.println("Reducing greater than ");
  yyval = new BinaryExpression (lexico.getColumn(), lexico.getLine(), (Expression)val_peek(2), (Expression)val_peek(0), ">");
  }
break;
case 55:
//#line 403 "sintactico.y"
{System.out.println("Reducing sum");
  yyval = new ArithmeticExpression (lexico.getColumn(), lexico.getLine(), (Expression)val_peek(2), (Expression)val_peek(0), '+');
  }
break;
case 56:
//#line 406 "sintactico.y"
{System.out.println("Reducing substraction");
  yyval = new ArithmeticExpression (lexico.getColumn(), lexico.getLine(), (Expression)val_peek(2), (Expression)val_peek(0), '-');}
break;
case 57:
//#line 408 "sintactico.y"
{System.out.println("Reducing muliplication");
  yyval = new ArithmeticExpression (lexico.getColumn(), lexico.getLine(), (Expression)val_peek(2), (Expression)val_peek(0), '*');
  }
break;
case 58:
//#line 411 "sintactico.y"
{System.out.println("Reducing division");
  yyval = new ArithmeticExpression (lexico.getColumn(), lexico.getLine(), (Expression)val_peek(2), (Expression)val_peek(0), '/');}
break;
case 59:
//#line 413 "sintactico.y"
{System.out.println("Reducing module");
  yyval = new ArithmeticExpression (lexico.getColumn(), lexico.getLine(), (Expression)val_peek(2), (Expression)val_peek(0), '%');
  }
break;
case 60:
//#line 416 "sintactico.y"
{System.out.println("Reducing exponetial");
  yyval = new ArithmeticExpression (lexico.getColumn(), lexico.getLine(), (Expression)val_peek(2), (Expression)val_peek(0), '^');
  }
break;
case 61:
//#line 419 "sintactico.y"
{System.out.println("Reducing (exp)");
  yyval = new CastExpression (lexico.getColumn(), lexico.getLine(), (TypeNormal)val_peek(2), (RegularExpression)val_peek(0));
  }
break;
case 62:
//#line 422 "sintactico.y"
{System.out.println("Reducing function call exp");
  yyval = new RegularExpressionFunctionRef (lexico.getColumn(), lexico.getLine(), new RegularExpressionVariable (lexico.getColumn(), lexico.getLine(), (String)val_peek(3)) , (List<RegularExpression>)val_peek(1));
  }
break;
case 63:
//#line 425 "sintactico.y"
{System.out.println("Reducing INTEGER value");
  yyval = new RegularExpressionInt(lexico.getColumn(), lexico.getLine(),(int) val_peek(0));
  System.out.println("CREATING INTEGER EXP");
  }
break;
case 64:
//#line 429 "sintactico.y"
{System.out.println("Reducing REAL value");
  yyval = new RegularExpressionReal(lexico.getColumn(), lexico.getLine(),(double) val_peek(0));
  }
break;
case 65:
//#line 432 "sintactico.y"
{System.out.println("Reducing LETTER value");
  yyval = new RegularExpressionLetter(lexico.getColumn(), lexico.getLine(),(String) val_peek(0));
  }
break;
case 66:
//#line 435 "sintactico.y"
{System.out.println("Reducing STRINGVALUE value");
  yyval = new RegularExpressionLetter(lexico.getColumn(), lexico.getLine(),(String) val_peek(0));
  }
break;
case 67:
//#line 438 "sintactico.y"
{System.out.println("Reducing struct variable ");
  yyval = new RegularExpressionStructRef (lexico.getColumn(), lexico.getLine(),(Expression)val_peek(2), new RegularExpressionVariable (lexico.getColumn(), lexico.getLine(), (String)val_peek(0)));
  }
break;
case 68:
//#line 441 "sintactico.y"
{System.out.println("Reducing ID exp ");
  yyval = new RegularExpressionVariable (lexico.getColumn(), lexico.getLine(), (String)val_peek(0));
  }
break;
case 69:
//#line 445 "sintactico.y"
{System.out.println("Reducing one-dimension array ");
  yyval = new RegularExpressionArrayRef(lexico.getColumn(), lexico.getLine(),(RegularExpressionVariable)val_peek(3) , (RegularExpression) val_peek(1));
  }
break;
case 70:
//#line 448 "sintactico.y"
{System.out.println("Reducing two-dimension array ");
  
  yyval = new RegularExpressionMatrixRef(lexico.getColumn(), lexico.getLine(),(RegularExpressionVariable)val_peek(6) , (RegularExpression) val_peek(4), (RegularExpression) val_peek(1));
  }
break;
//#line 1219 "Sintactico.java"
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
 * @throws Exception 
 */
public void run() throws Exception
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
