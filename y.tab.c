#ifndef lint
static char yysccsid[] = "@(#)yaccpar	1.8 (Berkeley) 01/20/90";
#endif
#define YYBYACC 1
#line 9 "src/sintactico/sintactico.y"

import lexico.Lexico;
import asttree.*;
import java.util.List;
import java.util.ArrayList;

#line 13 "y.tab.c"
#define NULLTEXT 257
#define EQUAL 258
#define NOTEQUAL 259
#define LET 260
#define GET 261
#define AND 262
#define OR 263
#define STRINGVALUE 264
#define INTEGER 265
#define REAL 266
#define BOOLEAN 267
#define TEXT 268
#define LETTER 269
#define STRING 270
#define INT 271
#define DOUBLE 272
#define CHAR 273
#define BOOL 274
#define VOID 275
#define STRUCT 276
#define MAIN 277
#define IF 278
#define ELSE 279
#define WHILE 280
#define ID 281
#define INPUT 282
#define PRINT 283
#define RETURN 284
#define NEG 285
#define IFX 286
#define var 287
#define cast 288
#define matrix 289
#define expr 290
#define YYERRCODE 256
short yylhs[] = {                                        -1,
    0,    1,    1,    4,    4,    6,    6,    7,    7,    7,
    5,    5,    5,    5,    2,    2,    9,    3,    3,   11,
   11,   11,   11,   11,   11,   11,   11,   11,   14,   14,
   14,   10,   10,   10,   15,   12,   12,   13,   13,   17,
   17,   17,   17,   17,   17,   17,   16,   16,   16,   16,
   16,   16,    8,    8,    8,    8,    8,    8,    8,    8,
    8,    8,    8,    8,    8,    8,    8,    8,
};
short yylen[] = {                                         2,
    9,    0,    2,    3,    1,    1,    3,    6,    6,    9,
    1,    1,    1,    1,    0,    2,    8,    1,    2,    1,
    3,    3,    4,    5,    3,    3,    5,    3,    3,    2,
    1,    0,    1,    3,    2,    0,    2,    3,    3,    3,
    3,    2,    3,    3,    2,    1,    3,    3,    3,    3,
    3,    3,    3,    3,    3,    3,    3,    3,    4,    4,
    1,    1,    1,    1,    3,    1,    4,    7,
};
short yydefred[] = {                                      2,
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
short yydgoto[] = {                                       1,
    2,    8,   81,   82,   28,   17,   11,   83,   12,   31,
   84,   65,   92,  110,   32,  106,  107,
};
short yysindex[] = {                                      0,
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
short yyrindex[] = {                                      0,
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
short yygindex[] = {                                      0,
  142,  144,  -58,    9,   84,  -45,    0,  547,    0,    0,
   51,   63,   82,  -70,  117,  -17,    0,
};
#define YYTABLESIZE 811
short yytable[] = {                                     104,
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
short yycheck[] = {                                      33,
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
#define YYFINAL 1
#ifndef YYDEBUG
#define YYDEBUG 0
#endif
#define YYMAXTOKEN 290
#if YYDEBUG
char *yyname[] = {
"end-of-file",0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
"'!'",0,0,0,"'%'",0,0,"'('","')'","'*'","'+'","','","'-'","'.'","'/'",0,0,0,0,0,
0,0,0,0,0,0,"';'","'<'","'='","'>'",0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,"'['",0,"']'","'^'",0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,"'{'",0,"'}'",0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,"NULLTEXT","EQUAL","NOTEQUAL","LET",
"GET","AND","OR","STRINGVALUE","INTEGER","REAL","BOOLEAN","TEXT","LETTER",
"STRING","INT","DOUBLE","CHAR","BOOL","VOID","STRUCT","MAIN","IF","ELSE",
"WHILE","ID","INPUT","PRINT","RETURN","NEG","IFX","var","cast","matrix","expr",
};
char *yyrule[] = {
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
#endif
#ifndef YYSTYPE
typedef int YYSTYPE;
#endif
#define yyclearin (yychar=(-1))
#define yyerrok (yyerrflag=0)
#ifdef YYSTACKSIZE
#ifndef YYMAXDEPTH
#define YYMAXDEPTH YYSTACKSIZE
#endif
#else
#ifdef YYMAXDEPTH
#define YYSTACKSIZE YYMAXDEPTH
#else
#define YYSTACKSIZE 500
#define YYMAXDEPTH 500
#endif
#endif
int yydebug;
int yynerrs;
int yyerrflag;
int yychar;
short *yyssp;
YYSTYPE *yyvsp;
YYSTYPE yyval;
YYSTYPE yylval;
short yyss[YYSTACKSIZE];
YYSTYPE yyvs[YYSTACKSIZE];
#define yystacksize YYSTACKSIZE
#line 435 "src/sintactico/sintactico.y"

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
#line 461 "y.tab.c"
#define YYABORT goto yyabort
#define YYACCEPT goto yyaccept
#define YYERROR goto yyerrlab
int
yyparse()
{
    register int yym, yyn, yystate;
#if YYDEBUG
    register char *yys;
    extern char *getenv();

    if (yys = getenv("YYDEBUG"))
    {
        yyn = *yys;
        if (yyn >= '0' && yyn <= '9')
            yydebug = yyn - '0';
    }
#endif

    yynerrs = 0;
    yyerrflag = 0;
    yychar = (-1);

    yyssp = yyss;
    yyvsp = yyvs;
    *yyssp = yystate = 0;

yyloop:
    if (yyn = yydefred[yystate]) goto yyreduce;
    if (yychar < 0)
    {
        if ((yychar = yylex()) < 0) yychar = 0;
#if YYDEBUG
        if (yydebug)
        {
            yys = 0;
            if (yychar <= YYMAXTOKEN) yys = yyname[yychar];
            if (!yys) yys = "illegal-symbol";
            printf("yydebug: state %d, reading %d (%s)\n", yystate,
                    yychar, yys);
        }
#endif
    }
    if ((yyn = yysindex[yystate]) && (yyn += yychar) >= 0 &&
            yyn <= YYTABLESIZE && yycheck[yyn] == yychar)
    {
#if YYDEBUG
        if (yydebug)
            printf("yydebug: state %d, shifting to state %d (%s)\n",
                    yystate, yytable[yyn],yyrule[yyn]);
#endif
        if (yyssp >= yyss + yystacksize - 1)
        {
            goto yyoverflow;
        }
        *++yyssp = yystate = yytable[yyn];
        *++yyvsp = yylval;
        yychar = (-1);
        if (yyerrflag > 0)  --yyerrflag;
        goto yyloop;
    }
    if ((yyn = yyrindex[yystate]) && (yyn += yychar) >= 0 &&
            yyn <= YYTABLESIZE && yycheck[yyn] == yychar)
    {
        yyn = yytable[yyn];
        goto yyreduce;
    }
    if (yyerrflag) goto yyinrecovery;
#ifdef lint
    goto yynewerror;
#endif
yynewerror:
    yyerror("syntax error");
#ifdef lint
    goto yyerrlab;
#endif
yyerrlab:
    ++yynerrs;
yyinrecovery:
    if (yyerrflag < 3)
    {
        yyerrflag = 3;
        for (;;)
        {
            if ((yyn = yysindex[*yyssp]) && (yyn += YYERRCODE) >= 0 &&
                    yyn <= YYTABLESIZE && yycheck[yyn] == YYERRCODE)
            {
#if YYDEBUG
                if (yydebug)
                    printf("yydebug: state %d, error recovery shifting\
 to state %d\n", *yyssp, yytable[yyn]);
#endif
                if (yyssp >= yyss + yystacksize - 1)
                {
                    goto yyoverflow;
                }
                *++yyssp = yystate = yytable[yyn];
                *++yyvsp = yylval;
                goto yyloop;
            }
            else
            {
#if YYDEBUG
                if (yydebug)
                    printf("yydebug: error recovery discarding state %d\n",
                            *yyssp);
#endif
                if (yyssp <= yyss) goto yyabort;
                --yyssp;
                --yyvsp;
            }
        }
    }
    else
    {
        if (yychar == 0) goto yyabort;
#if YYDEBUG
        if (yydebug)
        {
            yys = 0;
            if (yychar <= YYMAXTOKEN) yys = yyname[yychar];
            if (!yys) yys = "illegal-symbol";
            printf("yydebug: state %d, error recovery discards token %d (%s)\n",
                    yystate, yychar, yys);
        }
#endif
        yychar = (-1);
        goto yyloop;
    }
yyreduce:
#if YYDEBUG
    if (yydebug)
        printf("yydebug: state %d, reducing by rule %d (%s)\n",
                yystate, yyn, yyrule[yyn]);
#endif
    yym = yylen[yyn];
    yyval = yyvsp[1-yym];
    switch (yyn)
    {
case 1:
#line 104 "src/sintactico/sintactico.y"
{System.out.println("Reducing MAIN_PROGRAM");
  List<InstructionDefinition> definitions = new ArrayList<InstructionDefinition>();
  List<Instruction> instructions = new ArrayList<Instruction>();
  List<Function> functions = new ArrayList<Function>();
  
  definitions.addAll((List<InstructionDefinition>)yyvsp[-8]);
  functions.addAll ((List<Function>)yyvsp[-7]);
  instructions.addAll ((List<Instruction>)yyvsp[-1]);

  ast = new Program (lexico.getColumn(), lexico.getLine(), definitions, functions, instructions);
  }
break;
case 2:
#line 117 "src/sintactico/sintactico.y"
{yyval = new ArrayList<InstructionDefinition>();}
break;
case 3:
#line 118 "src/sintactico/sintactico.y"
{System.out.println("Reducing global definitions");
  List<InstructionDefinition> definitions = (List<InstructionDefinition>)yyvsp[-1];
  if (yyvsp[0] instanceof List)
    definitions.addAll((List<InstructionDefinition>) yyvsp[0]);
  else
    definitions.add((InstructionDefinition) yyvsp[0]);
  yyval = definitions;
  }
break;
case 4:
#line 128 "src/sintactico/sintactico.y"
{System.out.println("Reducing primary definition");

  if (yyvsp[-1] instanceof List){
    List<RegularExpressionVariable> namesVars = (List<RegularExpressionVariable>)yyvsp[-1];
    List<InstructionDefinition> normalDefinitions = new ArrayList<InstructionDefinition>();
    int index = 0;
    while (index < namesVars.size()){
      normalDefinitions.add(new InstructionDefinition(lexico.getColumn(), lexico.getLine(),(TypeNormal)yyvsp[-2], namesVars.get(index)));
      index++;
    }
    yyval = normalDefinitions;
  }
  else
    yyval = new InstructionDefinition(lexico.getColumn(), lexico.getLine(),(TypeNormal)yyvsp[-2], (RegularExpressionVariable)yyvsp[-1]);
  
  }
break;
case 5:
#line 144 "src/sintactico/sintactico.y"
{System.out.println("Reducing stecial Type");
  /*$$ = new InstructionDefinition(lexico.getColumn(), lexico.getLine(),(TypeSpecial)$1, null);*/
   
  }
break;
case 6:
#line 152 "src/sintactico/sintactico.y"
{System.out.println("Reducing ID");
  yyval = new RegularExpressionVariable (lexico.getColumn(), lexico.getLine(), (String)yyvsp[0]);
  }
break;
case 7:
#line 155 "src/sintactico/sintactico.y"
{System.out.println("Reducing vars");
  List<RegularExpressionVariable> varsList =  new ArrayList<RegularExpressionVariable>();
  if (yyvsp[0] instanceof List){
    varsList.addAll((List<RegularExpressionVariable>) yyvsp[0]);
    if (yyvsp[-2] instanceof List)
      varsList.addAll((List<RegularExpressionVariable>) yyvsp[-2]);
    else
      varsList.add((RegularExpressionVariable) yyvsp[-2]);
    }
  else{
    varsList.add(new RegularExpressionVariable (lexico.getColumn(), lexico.getLine(), (String) yyvsp[0] ));
    if (yyvsp[-2] instanceof List)
      varsList.addAll((List<RegularExpressionVariable>) yyvsp[-2]);
    else
      varsList.add((RegularExpressionVariable) yyvsp[-2]);
  }
  yyval = varsList;
  }
break;
case 8:
#line 175 "src/sintactico/sintactico.y"
{System.out.println("Reducing structure");
  yyval = new InstructionDefinition( lexico.getColumn(), lexico.getLine(), new TypeSpecialStruct (lexico.getColumn(), lexico.getLine(), (List<InstructionDefinition>)yyvsp[-3]), (RegularExpressionVariable)yyvsp[-1]);
  }
break;
case 9:
#line 178 "src/sintactico/sintactico.y"
{System.out.println("Reducing one-Dimension array");
  yyval = new InstructionDefinition (lexico.getColumn(), lexico.getLine(),new TypeSpecialArray (lexico.getColumn(), lexico.getLine(), (TypeNormal) yyvsp[-5], (int) yyvsp[-3]), new RegularExpressionVariable (lexico.getColumn(), lexico.getLine(), (String)yyvsp[-1]));
  }
break;
case 10:
#line 181 "src/sintactico/sintactico.y"
{System.out.println("Reducing two-Dimension array");
  yyval = new InstructionDefinition (lexico.getColumn(), lexico.getLine(), new TypeSpecialMatrix (lexico.getColumn(), lexico.getLine(), (TypeNormal) yyvsp[-8], (int) yyvsp[-6], (int) yyvsp[-3]), new RegularExpressionVariable (lexico.getColumn(), lexico.getLine(), (String)yyvsp[-1]));
  }
break;
case 11:
#line 186 "src/sintactico/sintactico.y"
{System.out.println("Reducing INT type");
  yyval = new TypeNormal(lexico.getColumn(), lexico.getLine(), "int");
  }
break;
case 12:
#line 189 "src/sintactico/sintactico.y"
{System.out.println("Reducing DOUBLE type");
  yyval = new TypeNormal(lexico.getColumn(), lexico.getLine(), "double");
  }
break;
case 13:
#line 192 "src/sintactico/sintactico.y"
{System.out.println("Reducing CHAR type");
  yyval = new TypeNormal(lexico.getColumn(), lexico.getLine(), "char");
  }
break;
case 14:
#line 195 "src/sintactico/sintactico.y"
{System.out.println("Reducing STRING type");
  yyval = new TypeNormal(lexico.getColumn(), lexico.getLine(), "string");
  }
break;
case 15:
#line 201 "src/sintactico/sintactico.y"
{yyval = new ArrayList<Function>();}
break;
case 16:
#line 202 "src/sintactico/sintactico.y"
{System.out.println("Reducing multiple functions");
  List<Function> functions = (List<Function>)yyvsp[0];
  if (yyvsp[-1] instanceof List){
    functions.addAll ((List<Function>)yyvsp[-1]);
  }else{
    functions.add((Function)yyvsp[-1]);
  }
  yyval = functions;
  }
break;
case 17:
#line 213 "src/sintactico/sintactico.y"
{System.out.println("Reducing function");
  yyval = new Function (lexico.getColumn(), lexico.getLine(), new InstructionDefinition (lexico.getColumn(), lexico.getLine(), (TypeNormal)yyvsp[-7], new RegularExpressionVariable(lexico.getColumn(), lexico.getLine(), (String)yyvsp[-6])), (List<InstructionDefinition>) yyvsp[-4], (List<Instruction>)yyvsp[-1]);
  }
break;
case 18:
#line 224 "src/sintactico/sintactico.y"
{System.out.println("Reducing single instruction ");
  List<Instruction> instructions = new ArrayList<Instruction>();
  if (yyvsp[0] instanceof List)
  instructions.addAll((List<Instruction>)yyvsp[0]);
  else
  instructions.add((Instruction)yyvsp[0]);
  yyval = instructions;
  }
break;
case 19:
#line 232 "src/sintactico/sintactico.y"
{System.out.println("Reducing multiple instructions ");
  List<Instruction> instructions = (List<Instruction>)yyvsp[-1];
  if (yyvsp[0] instanceof List){
    instructions.addAll((List<Instruction>)yyvsp[0]);
  }
  else{
    instructions.add ((Instruction)yyvsp[0]); 
  }
  yyval = instructions;
  }
break;
case 20:
#line 245 "src/sintactico/sintactico.y"
{System.out.println("Reducing local definitions ");
  }
break;
case 21:
#line 247 "src/sintactico/sintactico.y"
{System.out.println("Reducing INPUT ");
  yyval = new InstructionInput (lexico.getColumn(), lexico.getLine(), (Expression) yyvsp[-1]);
  }
break;
case 22:
#line 250 "src/sintactico/sintactico.y"
{System.out.println("Reducing INPUT ");
  yyval = new InstructionPrint (lexico.getColumn(), lexico.getLine(), (Expression) yyvsp[-1]);
  }
break;
case 23:
#line 253 "src/sintactico/sintactico.y"
{System.out.println("Reducing Equality");
  yyval = new InstructionAsignation (lexico.getColumn(), lexico.getLine(), (Expression)yyvsp[-3], (Expression)yyvsp[-1]);

  
  }
break;
case 24:
#line 258 "src/sintactico/sintactico.y"
{System.out.println("Reducing function call");
  yyval = new InstructionFunctionCall(lexico.getColumn(), lexico.getLine(), new RegularExpressionVariable (lexico.getColumn(), lexico.getLine(), (String)yyvsp[-4]), (List<CallParameter>)yyvsp[-2]);
  }
break;
case 25:
#line 261 "src/sintactico/sintactico.y"
{System.out.println("Reducing WHILE");
  yyval = new InstructionWhile(lexico.getColumn(), lexico.getLine(), (BinaryExpression) yyvsp[-1], (List<Instruction>)yyvsp[0]);
  }
break;
case 26:
#line 264 "src/sintactico/sintactico.y"
{System.out.println("Reducing IF");
  
    yyval = new InstructionIf(lexico.getColumn(), lexico.getLine(), (BinaryExpression)yyvsp[-1], (List<Instruction>)yyvsp[0], null);
  
  }
break;
case 27:
#line 269 "src/sintactico/sintactico.y"
{System.out.println("Reducing IF/ELSE");
  yyval = new InstructionIf(lexico.getColumn(), lexico.getLine(), (BinaryExpression)yyvsp[-3], (List<Instruction>)yyvsp[-2], (List<Instruction>)yyvsp[0]);  
  }
break;
case 28:
#line 273 "src/sintactico/sintactico.y"
{System.out.println("Reducing RETURN ");
  yyval = new InstructionReturn(lexico.getColumn(), lexico.getLine(), (Expression)yyvsp[-1]);
  }
break;
case 29:
#line 279 "src/sintactico/sintactico.y"
{System.out.println("Reducing multiple Instructions ");
  yyval = (List<Instruction>) yyvsp[-1];
  }
break;
case 30:
#line 282 "src/sintactico/sintactico.y"
{System.out.println("Reducing no_instructions ");}
break;
case 31:
#line 283 "src/sintactico/sintactico.y"
{System.out.println("Reducing single Instructions ");

  List<Instruction> inst = new ArrayList<Instruction>();
  inst.add((Instruction)yyvsp[0]);
  yyval = inst;
  }
break;
case 32:
#line 291 "src/sintactico/sintactico.y"
{
  yyval = new ArrayList<InstructionDefinition>();
  }
break;
case 33:
#line 294 "src/sintactico/sintactico.y"
{System.out.println("Reducing single parameter");
  List<InstructionDefinition> parameters = new ArrayList<InstructionDefinition>();
  parameters.add((InstructionDefinition)yyvsp[0]);
  
  yyval = parameters;
  }
break;
case 34:
#line 300 "src/sintactico/sintactico.y"
{System.out.println("Reducing multiple parameters");
  List<InstructionDefinition> parameters = (List<InstructionDefinition>) yyvsp[-2];
  if (yyvsp[0] instanceof List){
    parameters.addAll((List<InstructionDefinition>)yyvsp[0]);
    }
  else{
    parameters.add((InstructionDefinition)yyvsp[0]);
    }
  yyval = parameters;
  }
break;
case 35:
#line 312 "src/sintactico/sintactico.y"
{System.out.println("Reducing parameterFunction ");
  yyval = new InstructionDefinition (lexico.getColumn(), lexico.getLine(), (TypeNormal)yyvsp[-1], new RegularExpressionVariable (lexico.getColumn(), lexico.getLine(), (String)yyvsp[0]) );
  }
break;
case 36:
#line 317 "src/sintactico/sintactico.y"
{yyval = new ArrayList<RegularExpressionVariable>();}
break;
case 37:
#line 318 "src/sintactico/sintactico.y"
{System.out.println("Reducing multuple calling-function parameters ");
  List<RegularExpressionVariable> expressions = (List<RegularExpressionVariable>) yyvsp[-1];
  if (yyvsp[0] instanceof List)
    expressions.addAll((List<RegularExpressionVariable>) yyvsp[0]);
  else
    expressions.add((RegularExpressionVariable) yyvsp[0]);
  yyval = expressions;
  }
break;
case 38:
#line 328 "src/sintactico/sintactico.y"
{System.out.println("Reducing ExpCompare ");
  yyval = (BinaryExpression) yyvsp[-1];
  }
break;
case 39:
#line 331 "src/sintactico/sintactico.y"
{System.out.println("Reducing ExpCompare ");
  yyval = (BinaryExpression) yyvsp[-1];
  }
break;
case 40:
#line 338 "src/sintactico/sintactico.y"
{System.out.println("Reducing AND");
  yyval = new BinaryExpression (lexico.getColumn(), lexico.getLine(), (Expression)yyvsp[-2], (Expression)yyvsp[0], "&&");
  }
break;
case 41:
#line 341 "src/sintactico/sintactico.y"
{System.out.println("Reducing OR");
  yyval = new BinaryExpression (lexico.getColumn(), lexico.getLine(), (Expression)yyvsp[-2], (Expression)yyvsp[0], "||");
  }
break;
case 42:
#line 344 "src/sintactico/sintactico.y"
{System.out.println("Reducing not ");
  yyval = new BinaryExpression (lexico.getColumn(), lexico.getLine(), (Expression)yyvsp[0], null, "!");
  }
break;
case 43:
#line 348 "src/sintactico/sintactico.y"
{System.out.println("Reducing AND");
  yyval = new BinaryExpression (lexico.getColumn(), lexico.getLine(), (Expression)yyvsp[-2], (Expression)yyvsp[0], "&&");
  }
break;
case 44:
#line 351 "src/sintactico/sintactico.y"
{System.out.println("Reducing OR");
  yyval = new BinaryExpression (lexico.getColumn(), lexico.getLine(), (Expression)yyvsp[-2], (Expression)yyvsp[0], "||");
  }
break;
case 45:
#line 354 "src/sintactico/sintactico.y"
{System.out.println("Reducing not ");
  yyval = new BinaryExpression (lexico.getColumn(), lexico.getLine(), (Expression)yyvsp[0], null, "!");
  }
break;
case 46:
#line 357 "src/sintactico/sintactico.y"
{System.out.println("Reducing not ");
  yyval = new BinaryExpression (lexico.getColumn(), lexico.getLine(), (Expression)yyvsp[0], null, "var");
  }
break;
case 47:
#line 362 "src/sintactico/sintactico.y"
{System.out.println("Reducing EQUAL");
  yyval = new BinaryExpression (lexico.getColumn(), lexico.getLine(), (Expression)yyvsp[-2], (Expression)yyvsp[0], "==");
  }
break;
case 48:
#line 365 "src/sintactico/sintactico.y"
{System.out.println("Reducing NOTEQUAL");
  yyval = new BinaryExpression (lexico.getColumn(), lexico.getLine(), (Expression)yyvsp[-2], (Expression)yyvsp[0], "!=");
  }
break;
case 49:
#line 368 "src/sintactico/sintactico.y"
{System.out.println("Reducing LET");
  yyval = new BinaryExpression (lexico.getColumn(), lexico.getLine(), (Expression)yyvsp[-2], (Expression)yyvsp[0], "<=");
  }
break;
case 50:
#line 371 "src/sintactico/sintactico.y"
{System.out.println("Reducing GET");
  yyval = new BinaryExpression (lexico.getColumn(), lexico.getLine(), (Expression)yyvsp[-2], (Expression)yyvsp[0], ">=");
  }
break;
case 51:
#line 374 "src/sintactico/sintactico.y"
{System.out.println("Reducing lesser than");
  yyval = new BinaryExpression (lexico.getColumn(), lexico.getLine(), (Expression)yyvsp[-2], (Expression)yyvsp[0], "<");
  }
break;
case 52:
#line 377 "src/sintactico/sintactico.y"
{System.out.println("Reducing greater than ");
  yyval = new BinaryExpression (lexico.getColumn(), lexico.getLine(), (Expression)yyvsp[-2], (Expression)yyvsp[0], ">");
  }
break;
case 53:
#line 383 "src/sintactico/sintactico.y"
{System.out.println("Reducing sum");
  yyval = new ArithmeticExpression (lexico.getColumn(), lexico.getLine(), (Expression)yyvsp[-2], (Expression)yyvsp[0], '+');
  }
break;
case 54:
#line 386 "src/sintactico/sintactico.y"
{System.out.println("Reducing substraction");
  yyval = new ArithmeticExpression (lexico.getColumn(), lexico.getLine(), (Expression)yyvsp[-2], (Expression)yyvsp[0], '-');}
break;
case 55:
#line 388 "src/sintactico/sintactico.y"
{System.out.println("Reducing muliplication");
  yyval = new ArithmeticExpression (lexico.getColumn(), lexico.getLine(), (Expression)yyvsp[-2], (Expression)yyvsp[0], '*');
  }
break;
case 56:
#line 391 "src/sintactico/sintactico.y"
{System.out.println("Reducing division");
  yyval = new ArithmeticExpression (lexico.getColumn(), lexico.getLine(), (Expression)yyvsp[-2], (Expression)yyvsp[0], '/');}
break;
case 57:
#line 393 "src/sintactico/sintactico.y"
{System.out.println("Reducing module");
  yyval = new ArithmeticExpression (lexico.getColumn(), lexico.getLine(), (Expression)yyvsp[-2], (Expression)yyvsp[0], '%');
  }
break;
case 58:
#line 396 "src/sintactico/sintactico.y"
{System.out.println("Reducing exponetial");
  yyval = new ArithmeticExpression (lexico.getColumn(), lexico.getLine(), (Expression)yyvsp[-2], (Expression)yyvsp[0], '^');
  }
break;
case 59:
#line 399 "src/sintactico/sintactico.y"
{System.out.println("Reducing (exp)");
  yyval = new CastExpression (lexico.getColumn(), lexico.getLine(), (TypeNormal)yyvsp[-2], (RegularExpression)yyvsp[0]);
  }
break;
case 60:
#line 402 "src/sintactico/sintactico.y"
{System.out.println("Reducing function call exp");
  yyval = new RegularExpressionFunctionRef (lexico.getColumn(), lexico.getLine(), new RegularExpressionVariable (lexico.getColumn(), lexico.getLine(), (String)yyvsp[-3]) , (List<Expression>)yyvsp[-1]);
  }
break;
case 61:
#line 405 "src/sintactico/sintactico.y"
{System.out.println("Reducing INTEGER value");
  yyval = new RegularExpressionInt(lexico.getColumn(), lexico.getLine(),(int) yyvsp[0]);
  System.out.println("CREATING INTEGER EXP");
  }
break;
case 62:
#line 409 "src/sintactico/sintactico.y"
{System.out.println("Reducing REAL value");
  yyval = new RegularExpressionReal(lexico.getColumn(), lexico.getLine(),(double) yyvsp[0]);
  }
break;
case 63:
#line 412 "src/sintactico/sintactico.y"
{System.out.println("Reducing LETTER value");
  yyval = new RegularExpressionLetter(lexico.getColumn(), lexico.getLine(),(String) yyvsp[0]);
  }
break;
case 64:
#line 415 "src/sintactico/sintactico.y"
{System.out.println("Reducing STRINGVALUE value");
  yyval = new RegularExpressionLetter(lexico.getColumn(), lexico.getLine(),(String) yyvsp[0]);
  }
break;
case 65:
#line 418 "src/sintactico/sintactico.y"
{System.out.println("Reducing struct variable ");
  yyval = new RegularExpressionStructRef (lexico.getColumn(), lexico.getLine(),(Expression)yyvsp[-2], new RegularExpressionVariable (lexico.getColumn(), lexico.getLine(), (String)yyvsp[0]));
  }
break;
case 66:
#line 421 "src/sintactico/sintactico.y"
{System.out.println("Reducing ID exp ");
  yyval = new RegularExpressionVariable (lexico.getColumn(), lexico.getLine(), (String)yyvsp[0]);
  }
break;
case 67:
#line 425 "src/sintactico/sintactico.y"
{System.out.println("Reducing one-dimension array ");
  yyval = new RegularExpressionArrayRef(lexico.getColumn(), lexico.getLine(),(RegularExpressionVariable)yyvsp[-3] , (RegularExpression) yyvsp[-1]);
  }
break;
case 68:
#line 428 "src/sintactico/sintactico.y"
{System.out.println("Reducing two-dimension array ");
  
  yyval = new RegularExpressionMatrixRef(lexico.getColumn(), lexico.getLine(),(RegularExpressionVariable)yyvsp[-6] , (RegularExpression) yyvsp[-4], (RegularExpression) yyvsp[-1]);
  }
break;
#line 1082 "y.tab.c"
    }
    yyssp -= yym;
    yystate = *yyssp;
    yyvsp -= yym;
    yym = yylhs[yyn];
    if (yystate == 0 && yym == 0)
    {
#if YYDEBUG
        if (yydebug)
            printf("yydebug: after reduction, shifting from state 0 to\
 state %d\n", YYFINAL);
#endif
        yystate = YYFINAL;
        *++yyssp = YYFINAL;
        *++yyvsp = yyval;
        if (yychar < 0)
        {
            if ((yychar = yylex()) < 0) yychar = 0;
#if YYDEBUG
            if (yydebug)
            {
                yys = 0;
                if (yychar <= YYMAXTOKEN) yys = yyname[yychar];
                if (!yys) yys = "illegal-symbol";
                printf("yydebug: state %d, reading %d (%s)\n",
                        YYFINAL, yychar, yys);
            }
#endif
        }
        if (yychar == 0) goto yyaccept;
        goto yyloop;
    }
    if ((yyn = yygindex[yym]) && (yyn += yystate) >= 0 &&
            yyn <= YYTABLESIZE && yycheck[yyn] == yystate)
        yystate = yytable[yyn];
    else
        yystate = yydgoto[yym];
#if YYDEBUG
    if (yydebug)
        printf("yydebug: after reduction, shifting from state %d \
to state %d\n", *yyssp, yystate);
#endif
    if (yyssp >= yyss + yystacksize - 1)
    {
        goto yyoverflow;
    }
    *++yyssp = yystate;
    *++yyvsp = yyval;
    goto yyloop;
yyoverflow:
    yyerror("yacc stack overflow");
yyabort:
    return (1);
yyaccept:
    return (0);
}
