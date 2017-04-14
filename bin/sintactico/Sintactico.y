// =================================================================
// Expression compiler
//  LAB 2. Sintactical annalysis
// Simple Compiler  Parser Specification and AST Generation (not yet)
//    
// Angel Alberto Flores Rodríguez
// ==================================================================
%{

import lexico.Lexico;
import asttree.*;
import java.util.List;
import java.util.ArrayList;

%}
//---------------------
//NULL TEXT
//---------------------
%token NULLTEXT
//---------------------
//ERROR
//---------------------
%token ERROR

//---------------------
//LOGICAL EXPRESSIONS
//---------------------
%token EQUAL
%token NOTEQUAL
%token LET
%token GET 
%token AND
%token OR

//---------------------
//VALUES
//---------------------
%token STRINGVALUE
%token INTEGER
%token REAL
%token BOOLEAN
%token TEXT
%token LETTER

//---------------------
//TYPES
//---------------------
%token STRING
%token INT
%token DOUBLE
%token CHAR
%token STRING
%token BOOL
%token VOID
%token STRUCT

//---------------------
//CONTROL
//---------------------
%token MAIN 
%token IF
%token ELSE
%token WHILE
%token ID
%token INPUT
%token PRINT
%token RETURN

//---------------------
//RULES
//---------------------



%left '-' '+'
%left '*' '/' '%'
%left NEG          
%right '^' 
%right ')'
%nonassoc IFX
%nonassoc ELSE

%right '.'
%right INT
%right DOUBLE
%right CHAR
%right STRING
%right BOOL
%right VOID
%right STRUCT
%left var
%left cast
%nonassoc ']'
%nonassoc '['
%right matrix
%left expr







%%


program: 
  definitions functions VOID MAIN '(' ')' '{' instructions '}'      {System.out.println("Reducing MAIN_PROGRAM");
  List<InstructionDefinition> definitions = new ArrayList<InstructionDefinition>();
  List<Instruction> instructions = new ArrayList<Instruction>();
  List<Function> functions = new ArrayList<Function>();
  
  definitions.addAll((List<InstructionDefinition>)$1);
  functions.addAll ((List<Function>)$2);
  instructions.addAll ((List<Instruction>)$8);

  ast = new Program (lexico.getColumn(), lexico.getLine(), definitions, functions, instructions);
  }
;
definitions: 
  /* empty */ {$$ = new ArrayList<InstructionDefinition>();}
  | definitions definition                                          {System.out.println("Reducing global definitions");
  List<InstructionDefinition> definitions = (List<InstructionDefinition>)$1;
  if ($2 instanceof List)
    definitions.addAll((List<InstructionDefinition>) $2);
  else
    definitions.add((InstructionDefinition) $2);
  $$ = definitions;
  }
; 
definition: 
  type vars ';'                                                     {System.out.println("Reducing primary definition");

  if ($2 instanceof List){
    List<RegularExpressionVariable> namesVars = (List<RegularExpressionVariable>)$2;
    List<InstructionDefinition> normalDefinitions = new ArrayList<InstructionDefinition>();
    int index = 0;
    while (index < namesVars.size()){
      normalDefinitions.add(new InstructionDefinition(lexico.getColumn(), lexico.getLine(),(TypeNormal)$1, namesVars.get(index)));
      index++;
    }
    $$ = normalDefinitions;
  }
  else
    $$ = new InstructionDefinition(lexico.getColumn(), lexico.getLine(),(TypeNormal)$1, (RegularExpressionVariable)$2);
  
  }
  | specialTypes {System.out.println("Reducing stecial Type");
  //$$ = new InstructionDefinition(lexico.getColumn(), lexico.getLine(),(TypeSpecial)$1, null);
   
  }
  
;

vars: 
  ID                                                                {System.out.println("Reducing ID");
  $$ = new RegularExpressionVariable (lexico.getColumn(), lexico.getLine(), (String)$1);
  } 
  | vars ',' ID                                                     {System.out.println("Reducing vars");
  List<RegularExpressionVariable> varsList =  new ArrayList<RegularExpressionVariable>();
  if ($3 instanceof List){
    varsList.addAll((List<RegularExpressionVariable>) $3);
    if ($1 instanceof List)
      varsList.addAll((List<RegularExpressionVariable>) $1);
    else
      varsList.add((RegularExpressionVariable) $1);
    }
  else{
    varsList.add(new RegularExpressionVariable (lexico.getColumn(), lexico.getLine(), (String) $3 ));
    if ($1 instanceof List)
      varsList.addAll((List<RegularExpressionVariable>) $1);
    else
      varsList.add((RegularExpressionVariable) $1);
  }
  $$ = varsList;
  }
;
specialTypes:
  STRUCT '{' definitions '}' exp ';'                               {System.out.println("Reducing structure");
  $$ = new InstructionDefinition( lexico.getColumn(), lexico.getLine(), new TypeSpecialStruct (lexico.getColumn(), lexico.getLine(), (List<InstructionDefinition>)$3), (RegularExpressionVariable)$5);
  }
  | type '[' INTEGER ']' ID ';'                                     {System.out.println("Reducing one-Dimension array");
  $$ = new InstructionDefinition (lexico.getColumn(), lexico.getLine(),new TypeSpecialArray (lexico.getColumn(), lexico.getLine(), (TypeNormal) $1, (int) $3), new RegularExpressionVariable (lexico.getColumn(), lexico.getLine(), (String)$5));
  }
  | type '[' INTEGER ']''[' INTEGER ']' ID ';'                      {System.out.println("Reducing two-Dimension array");
  $$ = new InstructionDefinition (lexico.getColumn(), lexico.getLine(), new TypeSpecialMatrix (lexico.getColumn(), lexico.getLine(), (TypeNormal) $1, (int) $3, (int) $6), new RegularExpressionVariable (lexico.getColumn(), lexico.getLine(), (String)$8));
  }
;
type:
  INT                                                               {System.out.println("Reducing INT type");
  $$ = new TypeNormal(lexico.getColumn(), lexico.getLine(), "int");
  }
  | DOUBLE                                                          {System.out.println("Reducing DOUBLE type");
  $$ = new TypeNormal(lexico.getColumn(), lexico.getLine(), "double");
  }
  | CHAR                                                            {System.out.println("Reducing CHAR type");
  $$ = new TypeNormal(lexico.getColumn(), lexico.getLine(), "char");
  }
  | STRING                                                          {System.out.println("Reducing STRING type");
  $$ = new TypeNormal(lexico.getColumn(), lexico.getLine(), "string");
  }
  //| VOID                                                            {System.out.println("Reducing VOID type");}
;
functions:
  /* empty */  {$$ = new ArrayList<Function>();}
  | function functions                                                {System.out.println("Reducing multiple functions");
  List<Function> functions = (List<Function>)$2;
  if ($1 instanceof List){
    functions.addAll ((List<Function>)$1);
  }else{
    functions.add((Function)$1);
  }
  $$ = functions;
  }
;
function: 
  type ID '(' parametersFunction ')' '{' instructions '}'           {System.out.println("Reducing function");
  $$ = new Function (lexico.getColumn(), lexico.getLine(), new InstructionDefinition (lexico.getColumn(), lexico.getLine(), (TypeNormal)$1, new RegularExpressionVariable(lexico.getColumn(), lexico.getLine(), (String)$2)), (List<InstructionDefinition>) $4, (List<Instruction>)$7);
  } 
  
  
  
;

instructions:

  
  instruction                                                       {System.out.println("Reducing single instruction ");
  List<Instruction> instructions = new ArrayList<Instruction>();
  if ($1 instanceof List)
  instructions.addAll((List<Instruction>)$1);
  else
  instructions.add((Instruction)$1);
  $$ = instructions;
  }
  | instructions instruction                                        {System.out.println("Reducing multiple instructions ");
  List<Instruction> instructions = (List<Instruction>)$1;
  if ($2 instanceof List){
    instructions.addAll((List<Instruction>)$2);
  }
  else{
    instructions.add ((Instruction)$2); 
  }
  $$ = instructions;
  }
;

instruction: 
  definition                                                        {System.out.println("Reducing local definitions ");
  }
  | INPUT exp ';'                                                    {System.out.println("Reducing INPUT ");
  $$ = new InstructionInput (lexico.getColumn(), lexico.getLine(), (Expression) $2);
  }
  | PRINT exp ';'                                                    {System.out.println("Reducing PRINT ");
  $$ = new InstructionPrint (lexico.getColumn(), lexico.getLine(), (Expression) $2);
  }
  | exp '=' exp ';'                                                       {System.out.println("Reducing Equality");
  $$ = new InstructionAsignation (lexico.getColumn(), lexico.getLine(), (Expression)$1, (Expression)$3);

  
  }  
  | ID '(' parameters ')' ';'                                       {System.out.println("Reducing function call");
  $$ = new InstructionFunctionCall(lexico.getColumn(), lexico.getLine(), new RegularExpressionVariable (lexico.getColumn(), lexico.getLine(), (String)$1), (List<RegularExpression>)$3);
  }
  | WHILE expCompare spetialStatement                               {System.out.println("Reducing WHILE");
  $$ = new InstructionWhile(lexico.getColumn(), lexico.getLine(), (BinaryExpression) $2, (List<Instruction>)$3);
  }
  | IF expCompare spetialStatement %prec IFX                            {System.out.println("Reducing IF");
  
    $$ = new InstructionIf(lexico.getColumn(), lexico.getLine(), (BinaryExpression)$2, (List<Instruction>)$3, null);
  
  }
  | IF expCompare  spetialStatement ELSE spetialStatement                     {System.out.println("Reducing IF/ELSE");
  $$ = new InstructionIf(lexico.getColumn(), lexico.getLine(), (BinaryExpression)$2, (List<Instruction>)$3, (List<Instruction>)$5);  
  }
  
  | RETURN exp ';'                                                  {System.out.println("Reducing RETURN ");
  $$ = new InstructionReturn(lexico.getColumn(), lexico.getLine(), (Expression)$2);
  }
;

spetialStatement:
  '{' instructions '}'   {System.out.println("Reducing multiple Instructions ");
  $$ = (List<Instruction>) $2;
  }
  | '{' '}'       {System.out.println("Reducing no_instructions ");
  List<Instruction> inst = new ArrayList<Instruction>();
  $$ = inst;
  }
  | instruction   {System.out.println("Reducing single Instructions ");

  List<Instruction> inst = new ArrayList<Instruction>();
  inst.add((Instruction)$1);
  $$ = inst;
  }
;
parametersFunction:
  /* empty */ {
  $$ = new ArrayList<InstructionDefinition>();
  }
  | parameterFunction                                                {System.out.println("Reducing single parameter");
  List<InstructionDefinition> parameters = new ArrayList<InstructionDefinition>();
  parameters.add((InstructionDefinition)$1);
  
  $$ = parameters;
  }
  | parametersFunction ',' parameterFunction                         {System.out.println("Reducing multiple parameters");
  List<InstructionDefinition> parameters = (List<InstructionDefinition>) $1;
  if ($3 instanceof List){
    parameters.addAll((List<InstructionDefinition>)$3);
    }
  else{
    parameters.add((InstructionDefinition)$3);
    }
  $$ = parameters;
  }
;
parameterFunction:
  type ID                                                           {System.out.println("Reducing parameterFunction ");
  $$ = new InstructionDefinition (lexico.getColumn(), lexico.getLine(), (TypeNormal)$1, new RegularExpressionVariable (lexico.getColumn(), lexico.getLine(), (String)$2) );
  }
;
parameters: 
  /* empty */ {$$ = new ArrayList<RegularExpression>();}
  | parameters exps                                                 {System.out.println("Reducing multuple calling-function parameters ");
  List<RegularExpression> expressions = (List<RegularExpression>) $1;
  if ($2 instanceof List)
    expressions.addAll((List<RegularExpression>) $2);
  else
    expressions.add((RegularExpression) $2);
  $$ = expressions;
  }
;
expCompare:
  '(' expComp ')'                                                   {System.out.println("Reducing ExpCompare ");
  $$ = (BinaryExpression) $2;
  }
  |'(' expBin ')'                                                   {System.out.println("Reducing ExpCompare ");
  $$ = (BinaryExpression) $2;
  }
 
; 
exps: 
  exp {
  $$ = (RegularExpression) $1;
  }
  | exps ',' exp {
  List<RegularExpression> list = new ArrayList<RegularExpression>();
  if($3 instanceof List){
    list.addAll((List<RegularExpression>) $1);
  }else{
    list.add((RegularExpression) $3);
  }
  $$ = list;
  }
;
expBin:
  expComp AND expComp                                                     {System.out.println("Reducing AND");
  $$ = new BinaryExpression (lexico.getColumn(), lexico.getLine(), (Expression)$1, (Expression)$3, "&&");
  }
  | expComp OR expComp                                                      {System.out.println("Reducing OR");
  $$ = new BinaryExpression (lexico.getColumn(), lexico.getLine(), (Expression)$1, (Expression)$3, "||");
  }
  | '!' expComp                                                         {System.out.println("Reducing not ");
  $$ = new BinaryExpression (lexico.getColumn(), lexico.getLine(), (Expression)$2, null, "!");
  }
  |
  exp AND exp                                                   {System.out.println("Reducing AND");
  $$ = new BinaryExpression (lexico.getColumn(), lexico.getLine(), (Expression)$1, (Expression)$3, "&&");
  }
  | exp OR exp                                                      {System.out.println("Reducing OR");
  $$ = new BinaryExpression (lexico.getColumn(), lexico.getLine(), (Expression)$1, (Expression)$3, "||");
  }
  | '!' exp                                                         {System.out.println("Reducing not ");
  $$ = new BinaryExpression (lexico.getColumn(), lexico.getLine(), (Expression)$2, null, "!");
  }
  | exp                                                         {System.out.println("Reducing not ");
  $$ = new BinaryExpression (lexico.getColumn(), lexico.getLine(), (Expression)$1, null, "var");
  }
;
expComp: 
  exp EQUAL exp       %prec expr                                              {System.out.println("Reducing EQUAL");
  $$ = new BinaryExpression (lexico.getColumn(), lexico.getLine(), (Expression)$1, (Expression)$3, "==");
  }
  | exp NOTEQUAL exp      %prec expr                                          {System.out.println("Reducing NOTEQUAL");
  $$ = new BinaryExpression (lexico.getColumn(), lexico.getLine(), (Expression)$1, (Expression)$3, "!=");
  }
  | exp LET exp     %prec expr                                                {System.out.println("Reducing LET");
  $$ = new BinaryExpression (lexico.getColumn(), lexico.getLine(), (Expression)$1, (Expression)$3, "<=");
  }
  | exp GET exp     %prec expr                                                {System.out.println("Reducing GET");
  $$ = new BinaryExpression (lexico.getColumn(), lexico.getLine(), (Expression)$1, (Expression)$3, ">=");
  }
  | exp '<' exp          %prec expr                                           {System.out.println("Reducing lesser than");
  $$ = new BinaryExpression (lexico.getColumn(), lexico.getLine(), (Expression)$1, (Expression)$3, "<");
  }
  | exp '>' exp         %prec expr                                            {System.out.println("Reducing greater than ");
  $$ = new BinaryExpression (lexico.getColumn(), lexico.getLine(), (Expression)$1, (Expression)$3, ">");
  }
;

exp:
  exp '+' exp                                                       {System.out.println("Reducing sum");
  $$ = new ArithmeticExpression (lexico.getColumn(), lexico.getLine(), (Expression)$1, (Expression)$3, '+');
  }
  | exp '-' exp                                                     {System.out.println("Reducing substraction");
  $$ = new ArithmeticExpression (lexico.getColumn(), lexico.getLine(), (Expression)$1, (Expression)$3, '-');}
  | exp '*' exp                                                     {System.out.println("Reducing muliplication");
  $$ = new ArithmeticExpression (lexico.getColumn(), lexico.getLine(), (Expression)$1, (Expression)$3, '*');
  }
  | exp '/' exp                                                     {System.out.println("Reducing division");
  $$ = new ArithmeticExpression (lexico.getColumn(), lexico.getLine(), (Expression)$1, (Expression)$3, '/');}
  | exp '%' exp                                                     {System.out.println("Reducing module");
  $$ = new ArithmeticExpression (lexico.getColumn(), lexico.getLine(), (Expression)$1, (Expression)$3, '%');
  }
  | exp '^' exp                                                     {System.out.println("Reducing exponetial");
  $$ = new ArithmeticExpression (lexico.getColumn(), lexico.getLine(), (Expression)$1, (Expression)$3, '^');
  }
  | '(' type ')' exp %prec cast                                                     {System.out.println("Reducing (exp)");
  $$ = new CastExpression (lexico.getColumn(), lexico.getLine(), (TypeNormal)$2, (RegularExpression)$4);
  }
  | ID '(' parameters ')'                                           {System.out.println("Reducing function call exp");
  $$ = new RegularExpressionFunctionRef (lexico.getColumn(), lexico.getLine(), new RegularExpressionVariable (lexico.getColumn(), lexico.getLine(), (String)$1) , (List<RegularExpression>)$3);
  }
  | INTEGER                                                         {System.out.println("Reducing INTEGER value");
  $$ = new RegularExpressionInt(lexico.getColumn(), lexico.getLine(),(int) $1);
  System.out.println("CREATING INTEGER EXP");
  }
  | REAL                                                            {System.out.println("Reducing REAL value");
  $$ = new RegularExpressionReal(lexico.getColumn(), lexico.getLine(),(double) $1);
  }
  | LETTER                                                          {System.out.println("Reducing LETTER value");
  $$ = new RegularExpressionLetter(lexico.getColumn(), lexico.getLine(),(String) $1);
  }
  | STRINGVALUE                                                          {System.out.println("Reducing STRINGVALUE value");
  $$ = new RegularExpressionLetter(lexico.getColumn(), lexico.getLine(),(String) $1);
  }
  | exp '.' ID                                                       {System.out.println("Reducing struct variable ");
  $$ = new RegularExpressionStructRef (lexico.getColumn(), lexico.getLine(),(Expression)$1, new RegularExpressionVariable (lexico.getColumn(), lexico.getLine(), (String)$3));
  }
  | ID                                                              {System.out.println("Reducing ID exp ");
  $$ = new RegularExpressionVariable (lexico.getColumn(), lexico.getLine(), (String)$1);
  }  

  | exp '[' exp ']'                                               {System.out.println("Reducing one-dimension array ");
  $$ = new RegularExpressionArrayRef(lexico.getColumn(), lexico.getLine(),(RegularExpressionVariable)$1 , (RegularExpression) $3);
  } 
  | exp '[' exp ']''[' exp ']'         %prec matrix                       {System.out.println("Reducing two-dimension array ");
  
  $$ = new RegularExpressionMatrixRef(lexico.getColumn(), lexico.getLine(),(RegularExpressionVariable)$1 , (RegularExpression) $3, (RegularExpression) $6);
  } 
;       

%%

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
