// =================================================================
// LAB 1. Lexical Analysis
// Simple Compiler Scanner Specification
// Angel Alberto Flores Rodríguez
// ==================================================================

package lexico;
// Following line must be commented if we wanted to do a stand alone
// Scanner. Use % standalone option too
import sintactico.Sintactico; // To communicate with Parser
// ==================================================================
%% 
// Options AND Macros Section
// - Name for the generated class
// ==================================================================
// % debug
// %standalone
%byaccj
%class Lexico
%public
%unicode
%line
%column

COMM = "//".*
DIGIT = [0-9]
LETTER = [a-zA-Z]
CHAR = "'"{LETTER}"'"
STRING = \"(.*)(.*)+\"
IDENT = {LETTER}+({LETTER}|{DIGIT})*("_"({LETTER}|{DIGIT})*)?
INTEGER = {DIGIT}+
DOUBLE = {DIGIT}+"."{DIGIT}+
EXP = [Ee]("+"|"-")?[0-9]+
BOOLEAN = "true" | "false"
ENDLINE= \n | \r | \r\n
NULLTEXT = {ENDLINE} | [ \t\f]


%{
// ==================================================================
// Generic object for assignig a semantic value to the token
// ==================================================================
private Object yylval; // use this as Semantic value of the token
// ==================================================================
// public methods for line and column recovering. (Package protected)
// ==================================================================
public int getColumn()
{
return yycolumn+1;
}
public int getLine()
{
return yyline+1;
}
public Object getYylval()
{
return this.yylval;
}
%}


%%
// ====================================================================
// Worthless text
// ====================================================================
{COMM} {  System.out.println("COMMENT: " + yytext() ); }
{ENDLINE} {}
{NULLTEXT} { System.out.println("NULLTEXT: " + yytext() );  }

// ====================================================================
// Language´s Reserved Words
// - Data Types : int, void
// - Reserved words: return, rawinput, print
// ====================================================================
"int" {yylval = yytext(); System.out.println("INT TYPE: " + yytext() );return Sintactico.INT;}
"double" {yylval = yytext(); System.out.println("DOUBLE TYPE: " + yytext() );return Sintactico.DOUBLE;}
"char" {yylval = yytext(); System.out.println("CHAR TYPE: " + yytext() );return Sintactico.CHAR;}
"bool" {yylval = yytext(); System.out.println("BOOLEAN TYPE: " + yytext() );return Sintactico.BOOL;}
"void" {yylval = yytext();System.out.println("VOID TYPE: " + yytext() ); return Sintactico.VOID;}
"struct" {yylval = yytext();System.out.println("STRUCT TYPE: " + yytext() ); return Sintactico.STRUCT;}
"string" {yylval = yytext();System.out.println("STRING TYPE: " + yytext() ); return Sintactico.STRING;}


"main" {yylval = yytext(); System.out.println("RESERVED WORD: " + yytext() ); return Sintactico.MAIN;}
"in" {yylval = yytext(); System.out.println("RESERVED WORD: " + yytext() );return Sintactico.INPUT;}
"out" {yylval = yytext();System.out.println("RESERVED WORD: " + yytext() ); return Sintactico.PRINT;}
"return" {yylval = yytext(); System.out.println("RESERVED WORD: " + yytext() );return Sintactico.RETURN;}

//__
// * Flow Control Reserved words
//__


"if" {yylval = yytext(); System.out.println("IF STATEMENT: " + yytext() );return Sintactico.IF;}
"else" {yylval = yytext(); System.out.println("ELSE STATEMENT: " + yytext() );return Sintactico.ELSE;}
"while" {yylval = yytext(); System.out.println("WHILE STATEMENT: " + yytext() );return Sintactico.WHILE;}

{INTEGER} {yylval = new Integer(yytext()); System.out.println("INTEGER CONSTANT: " + yytext() );return Sintactico.INTEGER;}
{DOUBLE}|{EXP}? {yylval = new Double(yytext()); System.out.println("DOUBLE CONSTANT:" + yytext() );return Sintactico.REAL;}
{DIGIT}+{EXP}? {yylval = new Double(yytext()); System.out.println("DIGIGT CONSTANT: " + yytext() );return Sintactico.REAL;}
{BOOLEAN} {yylval = new Boolean(yytext()); System.out.println("BOOLEAN CONSTANT: " + yytext() );return Sintactico.BOOLEAN;}
{CHAR} {yylval = yytext(); System.out.println("CHAR CONSTANT: " + yytext() );return Sintactico.LETTER;}
{STRING} {yylval = yytext(); System.out.println("STRING CONSTANT: " + yytext() );return Sintactico.STRINGVALUE;}
{IDENT} {yylval = yytext(); System.out.println("IDENTIFIER: " + yytext() );return Sintactico.ID;}

// =====================================================================
// Simple Operators, length >1
// =====================================================================
"==" {yylval = yytext(); System.out.println("OPERATOR: " + yytext() );return Sintactico.EQUAL;}
"!=" {yylval = yytext(); System.out.println("OPERATOR: " + yytext() );return Sintactico.NOTEQUAL;}
"<=" {yylval = yytext(); System.out.println("OPERATOR: " + yytext() );return Sintactico.LET;}
">=" {yylval = yytext(); System.out.println("OPERATOR: " + yytext() );return Sintactico.GET;}
"&&" {yylval = yytext(); System.out.println("OPERATOR: " + yytext() );return Sintactico.AND;}
"||" {yylval = yytext(); System.out.println("OPERATOR: " + yytext() );return Sintactico.OR;}

// =====================================================================
// Single Char Tokens dont need specific definition
// =====================================================================
"!" |
"<" |
">" |
"+" |
"-" |
"*" |
"/" |
"%" |
";" |
"," |
"." |
"=" |
"(" |
")" |
"{" |
"}" |
"'" |
"^" |
"[" |
"]"  {yylval = yytext(); System.out.println("OPERATOR: " + yytext() ); return (int) (yycharat(0));}




// =====================================================================
// Any other thing is an error
// =====================================================================
. { System.err.println ("Scanner Error at Line: "
+ this.getLine() +
" Column: "+getColumn()+":\n\tCharacter \'"+
yycharat(0)+"\' unknown.");
System.err.println("yytext value: " + yytext());
throw new Throwable(); 
}